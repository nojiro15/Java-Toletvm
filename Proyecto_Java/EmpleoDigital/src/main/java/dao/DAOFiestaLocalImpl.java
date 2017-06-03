package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
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
					new java.util.Date(rs.getDate("fecha").getTime()),
					rs.getInt("idMunicipio"));			
	
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
		
		String sql="insert into fiesta_local (nombre,fecha,id_municipio) values (?,?,?)";
	
		int n=jdbc.update(sql,new Object[]{l.getNombre(),l.getFecha().getTime(),l.getIdMunicipio()});
		
		return n>0;		
	}
	
	
	public FiestaLocal read(String palabra){
				
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		String sql="select * from fiesta_local like ?";
	
		FiestaLocal l=jdbc.queryForObject(sql, new Object[]{"%"+palabra+"%"},new FiestaLocalRowMapper()); 
		return l;
	}
	
	
	public boolean update(FiestaLocal l) {
		String sql="update fiesta_local set "
				+ "fecha=?,"
				+ "idMunicipio=?, "
				+ "where nombre=? ";
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		int n=jdbc.update(sql,
				new Object[]{
						l.getNombre(),
						new java.sql.Date(l.getFecha().getTime()),
						l.getIdMunicipio()});
		return n>0;
	}
	
	
	public boolean delete(int idMunicipio){
		boolean r=false;
		
		String sql="delete * from fiesta_local where nombre=?";
				
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		int n=jdbc.update(sql,new Object[]{idMunicipio});
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
}
