package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import modelos.FiestaLocal;

public class DAOFiestaLocalImpl implements DAOFiestaLocal{

private class FiestaLocalRowMapper implements RowMapper<FiestaLocal>{
		
		public FiestaLocal mapRow(ResultSet rs,int numRow) throws SQLException{
			FiestaLocal l=new FiestaLocal(
					rs.getString("nombre"),
					rs.getDate("fecha"),
					rs.getInt("id_municipio"));			
	
			return l;
		}	
	}
	
	
	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	public boolean create(FiestaLocal l){
				
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		String sql="insert ignore into fiesta_local (nombre,fecha,id_municipio) values (?,?,?)";
	
		int n=jdbc.update(sql,new Object[]{l.getNombre(),l.getFecha(),l.getIdMunicipio()});
		
		return n>0;		
	}
	
	
	public FiestaLocal read(Date fecha){
				
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		String sql="select * from fiesta_local where fecha = ?";
	
		FiestaLocal l=jdbc.queryForObject(sql, new Object[]{fecha},new FiestaLocalRowMapper()); 
		return l;
	}
	
	
	public boolean update(FiestaLocal l, Date fechaOriginal) {
		String sql="update fiesta_local set "
				+ "nombre = ?, "
				+ "fecha=?, "
				+ "id_municipio= ? "
				+ "where fecha=? ";
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		int n=jdbc.update(sql,
				new Object[]{
						l.getNombre(),
						l.getFecha(),
						l.getIdMunicipio(),
						fechaOriginal});
		return n>0;
	}
	
	
	public boolean delete(Date fecha){
		boolean r=false;
		
		String sql="delete fl.* from fiesta_local as fl where fecha=?";
				
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		int n=jdbc.update(sql,new Object[]{fecha});
		r=n>0;
		
		return r;
	}
	
	public List<FiestaLocal> listar(){
		List<FiestaLocal> lista;
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		String sql="select * from fiesta_local";
		
		lista=jdbc.query(sql,new FiestaLocalRowMapper());
		
		return lista;
	}

	public List<FiestaLocal> listarByIdFormacion(int idFormacion) {
		List<FiestaLocal> lista;
		String sql = "select fl.* "
				+ "from formaciones as f "
					+ "join municipios as mun "
						+ "on (f.id_municipio = mun.id) "
					+ "join fiesta_local as fl "
						+ "on(fl.id_municipio = mun.id) "
				+ "where f.id = ?";
		
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		lista = jdbc.query(sql, new Object[]{idFormacion}, new FiestaLocalRowMapper());
		
		return lista;
	}
	
	
}
