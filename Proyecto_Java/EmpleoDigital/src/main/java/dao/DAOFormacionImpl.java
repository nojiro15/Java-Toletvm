package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import modelos.Formacion;

@Service
public class DAOFormacionImpl implements DAOFormacion{
	
	private class FormacionRowMapper implements RowMapper<Formacion>{
		public Formacion mapRow(ResultSet rs, int numRow) throws SQLException{
			return new Formacion(
					rs.getInt("id"),
					rs.getString("nombre"),
					rs.getDate("fechaInicio"));
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
	public boolean create(Formacion f) {
		String sql = "insert into formaciones(nombre, fecha_inicio)"
				+ " values(?,?,?)";
		
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		int n = jdbc.update(sql,
				new Object[]{
						f.getNombre(),
						f.getFechaInicio()});
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

	//Modificar Formaciones existentes
	public boolean update(Formacion f) {
		String sql = "update formaciones set "
				+ "nombre = ?, "
				+ "fecha_inicio = ? "
				+ "where id = ?";
		
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		int n = jdbc.update(sql, 
				new Object[]{
						f.getNombre(),
						f.getFechaInicio(),
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
		String sql = "select * from formaciones order by nombre";
		List<Formacion> lista;
		
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		lista = jdbc.query(sql, new FormacionRowMapper());
		
		return lista;
	}



}
