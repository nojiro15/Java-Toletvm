package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import modelos.Comunidad;

public class DAOComunidadImpl implements DAOComunidad {

	private class ComunidadRowMapper implements RowMapper<Comunidad>{
		
		public Comunidad mapRow(ResultSet rs, int numRow) throws SQLException{
			 return new Comunidad(
					 rs.getInt("id"),
					 rs.getString("comunidad"),
					 rs.getString("slug"));
		}
	}
	
	
	DataSource dataSource;


	public DataSource getDataSource() {
		return dataSource;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * Modelo con el que se lee los datos en la BBDD con el identificador de la comunidad
	 */
	public Comunidad read(int id){
		
		String sql="select id,comunidad,slug from comunidades where id=?";
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		Comunidad c=jdbc.queryForObject(sql, new Object[]{id},new ComunidadRowMapper());
		
		return c;
		
	}
	
	/**
	 * Modelo con que se crea un array para mostrar la lista comunidades por comunidad
	 */
	
	public List<Comunidad> listar(){
		
		String sql="select id,comunidad,slug from comunidades order by comunidad asc";
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		List<Comunidad> lista=jdbc.query(sql, new ComunidadRowMapper());
		
		return lista;
	}
	/**
	 * Modelo que crea un arraylist para mostrar la listas de comunidades por letras.
	 */
	
	public List<Comunidad> listar(String letra){
		
		String sql="select id,comunidad,slug from comunidades where slug like ?%";
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		List<Comunidad> lista=jdbc.query(sql, new ComunidadRowMapper());
		
		return lista;
	}
}
