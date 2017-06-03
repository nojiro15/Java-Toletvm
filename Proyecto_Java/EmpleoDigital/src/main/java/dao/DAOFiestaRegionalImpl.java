package dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import modelos.FiestaRegional;



public class DAOFiestaRegionalImpl implements DAOFiestaRegional{

	private class FiestaRegionalRowMapper implements RowMapper<FiestaRegional>{
		
		public FiestaRegional mapRow(ResultSet rs,int numRow) throws SQLException{
			FiestaRegional r=new FiestaRegional(
					rs.getString("nombre"),
					new java.util.Date(rs.getDate("fecha").getTime()),
					rs.getInt("idComunidad"));		
	
			return r;
		}	
	}
	
	
	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	public boolean create(FiestaRegional r){
				
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		String sql="insert into fiesta_regional (nombre,fecha,id_comunidad) values (?,?,?)";
	
		int n=jdbc.update(sql,new Object[]{r.getNombre(),r.getFecha().getTime(),r.getIdComunidad()});
		
		return n>0;		
	}
	
	
	public FiestaRegional read(String palabra){
				
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		String sql="select * from fiesta_regional like ?";
	
		FiestaRegional r=jdbc.queryForObject(sql, new Object[]{"%"+palabra+"%"},new FiestaRegionalRowMapper()); 
		return r;
	}
	
	
	public boolean update(FiestaRegional r) {
		String sql="update fiesta_regional set "
				+ "fecha=?,"
				+ "id_comunidad=?"
				+ "where nombre=? ";
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		int n=jdbc.update(sql,
				new Object[]{
						new java.sql.Date(r.getFecha().getTime()),
						r.getIdComunidad(),
						r.getNombre(),});
		return n>0;
	}
	
	
	public boolean delete(String nombre){
		boolean r=false;
		
		String sql="delete * from fiesta_regional where nombre=?";
				
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		int n=jdbc.update(sql,new Object[]{nombre});
		r=n>0;
		
		return r;
	}
	
	
	public List<FiestaRegional> listar(){
		List<FiestaRegional> lista;
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		String sql="select * from fiesta_regional";
		
		lista=jdbc.query(sql,new FiestaRegionalRowMapper());
		
		return lista;
	}
	
}
