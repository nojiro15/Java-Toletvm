package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import modelos.Provincia;

public class DAOProvinciaImpl implements DAOProvincia{

	
	private class ProvinciaRowMapper implements RowMapper<Provincia>{
		
		public Provincia mapRow(ResultSet rs, int numRow) throws SQLException{
			
			return new Provincia(
					rs.getInt("id"),
					rs.getString("slug"),
					rs.getString("provincia"),
					rs.getInt("id_comunidad"));
		}
	}
	

	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Provincia read(int IdComunidad){
			
			String sql="select id,provincia,slug from provincias where id_comunidad = ?";
			
			JdbcTemplate jdbc=new JdbcTemplate(dataSource);
			
			Provincia p=jdbc.queryForObject(sql, new Object[]{IdComunidad},new ProvinciaRowMapper());
			
			return p;
		}
	public Provincia readByIdFormacion(int idFormacion){
		Provincia provincia = null;
		String sql = "select p.* "
				+ "from formaciones as f "
					+ "join municipios as mun "
						+ "on (f.id_municipio = mun.id) "
					+ "join provincias as p "
						+ "on (mun.id_provincia = p.id) "
				+ "where f.id = ?";
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);

		provincia = jdbc.queryForObject(sql, new Object[]{idFormacion}, new ProvinciaRowMapper());
		
		return provincia;
	}
	
	/**
	 * Modelo con que se crea un array para mostrar la lista de provincias por con orden id
	 */
	
	public List<Provincia> listar(){
		
		String sql="select id,provincia,slug,id_comunidad from provincias order by provincia asc";
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		List<Provincia> lista=jdbc.query(sql,new ProvinciaRowMapper());
		
		return lista;
	}
	
	/**
	 * Modelo que crea un arraylist para mostra la listas por letras.
	 */
	public List<Provincia> listar(String letra){
		
		String sql="select * from provincias where slug like ?"; 
	
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		List<Provincia> lista=jdbc.query(sql, new Object[]{letra + "%"}, new ProvinciaRowMapper());
		
		return lista;
	}
	
	public List<Provincia> listarPorComunidad(int id){
		
		String sql="select * from provincias where id_comunidad = ?"; 
	
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		List<Provincia> lista=jdbc.query(sql, new Object[]{id}, new ProvinciaRowMapper());
		
		return lista;
	}
}


