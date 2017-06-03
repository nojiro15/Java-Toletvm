package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import modelos.Vacaciones;

public class DAOVacacionesImpl implements DAOVacaciones{

	private class VacacionesRowMapper implements RowMapper<Vacaciones>{
		
		public Vacaciones mapRow(ResultSet rs,int numRow) throws SQLException{
			Vacaciones v=new Vacaciones(
					rs.getInt("id"),
					rs.getString("asunto"),
					new java.util.Date(rs.getDate("fechaInicio").getTime()),
					new java.util.Date(rs.getDate("fechaFin").getTime()),
					rs.getInt("idFormacion"));			
	
			return v;
		}	
	}
	
	
	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	public boolean create(Vacaciones v){
				
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		String sql="insert into vacaciones (asunto,fecha_inicio,fecha_fin,formacion) values (?,?,?,?)";
	
		int n=jdbc.update(sql,new Object[]{v.getAsunto(),v.getFechaInicio().getTime(),v.getFechaFin().getTime(),v.getIdFormacion()});
		
		return n>0;		
	}
	
	
	public Vacaciones read(String palabra){
				
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		String sql="select * from vacaciones like ?";
	
		Vacaciones v=jdbc.queryForObject(sql, new Object[]{"%"+palabra+"%"},new VacacionesRowMapper()); 
		return v;
	}
	
	
	public boolean update(Vacaciones v) {
		String sql="update vacaciones set "
				+ "asunto=?,"
				+ "fecha_inicio=?, "
				+ "fecha_fin=?, "
				+ "where formacion=? ";
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		int n=jdbc.update(sql,
				new Object[]{
						v.getAsunto(),
						new java.sql.Date(v.getFechaInicio().getTime()),
						new java.sql.Date(v.getFechaFin().getTime()),
						v.getIdFormacion()});
		return n>0;
	}
	
	
	public boolean delete(int id){
		boolean r=false;
		
		String sql="delete * from vacaciones where asunto=?";
				
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		int n=jdbc.update(sql,new Object[]{id});
		r=n>0;
		
		return r;
	}
	
	public List<Vacaciones> listar(){
		List<Vacaciones> lista;
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		String sql="select * from vacaciones";
		
		lista=jdbc.query(sql,new VacacionesRowMapper());
		
		return lista;
	}
}
