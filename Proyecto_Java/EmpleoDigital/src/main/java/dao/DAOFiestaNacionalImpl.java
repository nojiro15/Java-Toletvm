package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import modelos.FiestaNacional;


public class DAOFiestaNacionalImpl implements DAOFiestaNacional{

private class FiestaNacionalRowMapper implements RowMapper<FiestaNacional>{
		
		public FiestaNacional mapRow(ResultSet rs,int numRow) throws SQLException{
			FiestaNacional n=new FiestaNacional(
					new java.util.Date(rs.getDate("fecha").getTime()),
					rs.getString("nombre"));		
	
			return n;
		}	
	}
	
	
	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	public boolean create(FiestaNacional n){
				
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		String sql="insert into fiesta_nacional (fecha,nombre) values (?,?)";
	
		int m=jdbc.update(sql,new Object[]{n.getFecha().getTime(),n.getNombre()});
		
		return m>0;		
	}
	
	
	public FiestaNacional read(String palabra){
				
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		String sql="select * from fiesta_nacional like ?";
	
		FiestaNacional n=jdbc.queryForObject(sql, new Object[]{"%"+palabra+"%"},new FiestaNacionalRowMapper()); 
		return n;
	}
	
	
	public boolean update(FiestaNacional n) {
		String sql="update fiesta_nacional set "
				+ "fecha=?,"
				+ "where nombre=? ";
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		int m=jdbc.update(sql,
				new Object[]{						
						new java.sql.Date(n.getFecha().getTime()),
						n.getNombre(),});
		return m>0;
	}
	
	
	public boolean delete(String nombre){
		boolean r=false;
		
		String sql="delete * from fiesta_nacional where nombre=?";
				
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		int m=jdbc.update(sql,new Object[]{nombre});
		r=m>0;
		
		return r;
	}
	
	
	public List<FiestaNacional> listar(){
		List<FiestaNacional> lista;
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		String sql="select * from fiesta_nacional";
		
		lista=jdbc.query(sql,new FiestaNacionalRowMapper());
		
		return lista;
	}
	
}
