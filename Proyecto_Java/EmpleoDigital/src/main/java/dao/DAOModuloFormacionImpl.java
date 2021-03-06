package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import modelos.ModuloFormacion;
import modelos.Modulo.Bloque;

public class DAOModuloFormacionImpl implements DAOModuloFormacion{

	private class ModuloFormacionRowMapper implements RowMapper<ModuloFormacion>{
		public ModuloFormacion mapRow(ResultSet rs, int numRow) throws SQLException{
			Bloque bloque = null; //Variable de tipo enum que se introducir� en el objeto Modulo
			int b = rs.getInt("bloque"); //Recogemos el n�mero que aparece en la base de datos en el campo 'bloque'
			 			
			if(b == 0){
				bloque = Bloque.TRONCAL;
			}else if(b == 1){
				bloque = Bloque.METODO;
			}else if(b == 2){
				bloque = Bloque.SUMA;
			}
			
			return new ModuloFormacion(
					rs.getInt("id"),
					rs.getString("nombre"),
					rs.getInt("jornadas"),
					rs.getInt("horas"),
					rs.getInt("horas_tutorias"), 
					bloque,					
					rs.getInt("id_formacion"),
					rs.getInt("orden"),
					rs.getDate("fecha_inicio"));
		}
	}
	/**
	 * DataSource
	 */
	private DataSource dataSource;
	/**
	 * Get DataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}
	/**
	 * Set DataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public boolean create(ModuloFormacion mf) {
		String sql = "insert ignore into formaciones_modulos(id_formacion, id_modulo, orden, fecha_inicio)"
				+ " values(?,?,?,?)";
		
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		int n = jdbc.update(sql, new Object[]{
				mf.getIdFormacion(),
				mf.getId(),
				mf.getOrden(),
				mf.getFechaInicio()});
		
		return n>0;
	}

	public List<ModuloFormacion> read(String palabra) {
		String sql = "select * from formaciones_modulos as fm"
				+ " join modulos as m "
				+ "on (fm.id_modulo = m.id) where nombre like ?";
		List<ModuloFormacion> lista;
		
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		lista = jdbc.query(sql, 
				new Object[]{"%" + palabra +"%"},
				new ModuloFormacionRowMapper());
		return lista;
	}

	public boolean update(ModuloFormacion mf) {
		String sql = "update formaciones_modulos set "
				+ "orden = ?, "
				+ "fecha_inicio = ? "
				+ "where id_formacion = ? and id_modulo = ?";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		int n = jdbc.update(sql,
				new Object[]{mf.getOrden(),
						mf.getFechaInicio().getTime(),
						mf.getIdFormacion(),
						mf.getId()});
		return n > 0;
	}

	public boolean delete(ModuloFormacion mf) {
		String sql = "delete from formaciones_modulos where id_formacion = ? and id_modulo = ?";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		int n = jdbc.update(sql, new Object[]{
				mf.getIdFormacion(), mf.getId()});
		
		return n > 0;
	}

	public List<ModuloFormacion> listar() {
		String sql = "select * from formaciones_modulos as fm"
				+ " join modulos as m"
				+ " on (fm.id_modulo = m.id)"
				+ " order by nombre";
		List<ModuloFormacion> lista;
		
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		lista = jdbc.query(sql, new ModuloFormacionRowMapper());
		return lista;
	}

	public List<ModuloFormacion> listarByIdFormacion(int idFormacion){
		List<ModuloFormacion> lista;
		
		String sql = "select fm.*, m.*"
				+ "from formaciones as f "
					+ "join formaciones_modulos as fm "
						+ "on (fm.id_formacion = f.id) "
					+ "join modulos as m "
						+ "on(fm.id_modulo = m.id) "
				+ "where f.id = ? order by fm.orden";
		
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		lista = jdbc.query(sql, new Object[]{idFormacion} , new ModuloFormacionRowMapper());
		
		return lista;
	}
	
	public List<ModuloFormacion> listarByBloque(int bloque) {
		String sql = "select * from formaciones_modulos as fm"
				+ " join modulos as m "
				+ "on (fm.id_modulo = m.id)"
				+ " where bloque = ? "
				+ "order by m.nombre";
		List<ModuloFormacion> lista;
		
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		lista = jdbc.query(sql, new Object[]{bloque} , new ModuloFormacionRowMapper());
		return lista;
	}
}
