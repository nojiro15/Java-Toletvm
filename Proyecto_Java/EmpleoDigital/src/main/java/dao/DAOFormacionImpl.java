package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import modelos.Formacion;

@Service
public class DAOFormacionImpl implements DAOFormacion{
	
	private class FormacionRowMapper implements RowMapper<Formacion>{
		public Formacion mapRow(ResultSet rs, int numRow) throws SQLException{
			return new Formacion(
					rs.getInt("id"),
					rs.getString("nombre"),
					rs.getDate("fecha_inicio"),
					rs.getInt("id_municipio"));
		}
	}

	private DataSource dataSource;
	//Get DataSource
	public DataSource getDataSource() {
		return dataSource;
	}
	//Set DataSource
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public DAOFormacionImpl(){}
	
	//Crear nueva formacion en la base de datos
	public boolean create(final Formacion f){
		
		System.out.println(dataSource);
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		final String sql = "insert ignore into formaciones(nombre, fecha_inicio, id_municipio)"
				+ " values(?,?,?)";
		
		final java.sql.Date fechaInicio=new java.sql.Date(f.getFechaInicio().getTime());
		
		
		GeneratedKeyHolder kh=new GeneratedKeyHolder();
		int n = jdbc.update(new PreparedStatementCreator(){

			public java.sql.PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement statement =con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, f.getNombre());
				statement.setDate(2,fechaInicio);
				statement.setInt(3, f.getIdMunicipio());
				return statement;
			}
				
		},kh
		);
		f.setId(kh.getKey().intValue());
		return n > 0;		
	}


	//Leer o buscar Formaciones por palabras
	public List<Formacion> read(String palabra) {
		String sql = "select * from formaciones where nombre like ?";
		List<Formacion> lista;
		
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		lista = jdbc.query(sql,new Object[]{"%" + palabra + "%"} ,new FormacionRowMapper());
		
		return lista;
	}
	
	public Formacion readById(int id){
		Formacion formacion = null; 
		String sql = "select * from formaciones where id = ?";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		formacion = jdbc.queryForObject(sql, new Object[]{id}, new FormacionRowMapper());
		
		return formacion;
	}

	//Modificar Formaciones existentes
	public boolean update(Formacion f) {
		String sql = "UPDATE formaciones"
				+ " SET nombre = ?, "
				+ "fecha_inicio = ?, "
				+ "id_municipio = ? "
				+ "WHERE formaciones.id = ?";

		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		int n = jdbc.update(sql, 
				new Object[]{
						f.getNombre(),
						f.getFechaInicio(),
						f.getIdMunicipio(),
						f.getId()});
		return n > 0;
	}

	//Borrar Formaciones existentes 
	public boolean delete(Formacion f) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		String sql = "delete from formaciones where id = ?";
		
		int n = jdbc.update(sql,
				new Object[]{f.getId()});
		return n > 0;
	}
	
	//Listar las formaciones
	public List<Formacion> listar() {
		String sql = "select * from formaciones order by fecha_inicio";
		List<Formacion> lista;
		
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		lista = jdbc.query(sql, new FormacionRowMapper());
		
		return lista;
	}

}
