package dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
					rs.getDate("fecha"),
					rs.getInt("id_comunidad"));		
	
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
		
		String sql="insert ignore into fiesta_regional (nombre,fecha,id_comunidad) values (?,?,?)";
	
		int n=jdbc.update(sql,new Object[]{r.getNombre(),r.getFecha(),r.getIdComunidad()});
		
		return n>0;		
	}
	
	
	public FiestaRegional read(Date fecha){
				
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		String sql="select * from fiesta_regional where fecha = ?";
	
		FiestaRegional r=jdbc.queryForObject(sql, new Object[]{fecha},new FiestaRegionalRowMapper()); 
		return r;
	}
	
	
	public boolean update(FiestaRegional r, Date fechaOriginal) {
		String sql="update fiesta_regional set "
				+ "nombre = ?, "
				+ "fecha=?, "
				+ "id_comunidad= ? "
				+ "where fecha=? ";
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		int n=jdbc.update(sql,
				new Object[]{
						r.getNombre(),
						r.getFecha(),
						r.getIdComunidad(),
						fechaOriginal});
		return n>0;
	}
	
	
	public boolean delete(Date fecha){
		boolean r=false;
		
		String sql="delete fr.* from fiesta_regional as fr where fecha = ?";
				
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		int n=jdbc.update(sql,new Object[]{fecha});
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
	
	
	
	public List<FiestaRegional> listarByIdFormacion(int idFormacion){
		List<FiestaRegional> lista;
		String sql = "select fr.* "
				+ "from formaciones as f "
					+ "join municipios as mun "
						+ "on (f.id_municipio = mun.id) "
					+ "join provincias as pro "
						+ "on(mun.id_provincia=pro.id) "
					+ "join comunidades as com "
						+ "on(pro.id_comunidad = com.id) "
					+ "join fiesta_regional as fr "
						+ "on(fr.id_comunidad=com.id) "
				+ "where f.id = ?";
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		lista = jdbc.query(sql, new Object[]{idFormacion}, new FiestaRegionalRowMapper());	
		
		return lista;
	}
}
