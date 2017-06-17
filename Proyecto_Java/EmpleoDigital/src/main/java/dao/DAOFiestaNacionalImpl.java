package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import modelos.FiestaNacional;


public class DAOFiestaNacionalImpl implements DAOFiestaNacional{

private class FiestaNacionalRowMapper implements RowMapper<FiestaNacional>{
		
		public FiestaNacional mapRow(ResultSet rs,int numRow) throws SQLException{
			FiestaNacional n=new FiestaNacional(
					rs.getString("nombre"),
					rs.getDate("fecha"));		
	
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
		
		String sql="insert ignore into fiesta_nacional (fecha,nombre) values (?,?)";
	
		int m=jdbc.update(sql,new Object[]{n.getFecha(),n.getNombre()});
		
		return m>0;		
	}
	
	
	public FiestaNacional read(Date fecha){
				
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		String sql="select * from fiesta_nacional where fecha = ?";
	
		FiestaNacional n=jdbc.queryForObject(sql, new Object[]{fecha},new FiestaNacionalRowMapper()); 
		return n;
	}
	
	
	public boolean update(FiestaNacional n, Date fechaOriginal) {
		String sql="update fiesta_nacional set "
				+ "fecha = ?, nombre = ? "
				+ "where fecha = ?";
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		int m=jdbc.update(sql,
				new Object[]{						
						n.getFecha(),
						n.getNombre(),
						fechaOriginal});
		return m>0;
	}
	
	
	public boolean delete(Date fecha){
		boolean r=false;
		
		String sql="delete fn.* from fiesta_nacional as fn where fecha=?";
				
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		int m=jdbc.update(sql,new Object[]{fecha});
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
