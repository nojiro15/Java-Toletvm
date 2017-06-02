package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import modelos.Modulo;
import modelos.Modulo.Bloque;

public class DAOModuloImpl implements DAOModulo{
	
	private class ModuloRowMapper implements RowMapper<Modulo>{
		public Modulo mapRow(ResultSet rs, int numRow) throws SQLException{
			Bloque bloque = null; //Variable de tipo enum que se introducirá en el objeto Modulo
			int b = rs.getInt("bloque"); //Recogemos el número que aparece en la base de datos en el campo 'bloque'
			 			
			if(b == 0){
				bloque = Bloque.TRONCAL;
			}else if(b == 1){
				bloque = Bloque.METODO;
			}else if(b == 2){
				bloque = Bloque.SUMA;
			}
			
			return new Modulo(
					rs.getInt("id"),
					rs.getString("nombre"),
					rs.getInt("jornadas"),
					rs.getInt("horas"),
					rs.getInt("horasTutorias"), 
					bloque);
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
	
	public boolean create(Modulo m) {
		String sql = "insert into modulos(nombre, jornadas, horas, horasTutorias, bloque)"
				+ " values(?,?,?,?)";
		int bloqueDB = 0;
		if(m.getBloque() == Bloque.TRONCAL){
			bloqueDB = 0;
		}else if(m.getBloque() == Bloque.METODO){
			bloqueDB = 1;
		}else if(m.getBloque() == Bloque.SUMA){
			bloqueDB = 2;
		}
		
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		int n = jdbc.update(sql,
				new Object[]{
						m.getNombre(),
						m.getJornadas(),
						m.getHoras(),
						m.getHorasTutorias(),
						bloqueDB});
		return n > 0;
	}

	public List<Modulo> read(String palabra) {
		String sql = "select * from modulos where nombre like ?";
		List<Modulo> lista;
		
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		lista = jdbc.query(sql, 
				new Object[]{"%" + palabra +"%"},
				new ModuloRowMapper());
		return lista;
	}

	public boolean update(Modulo m) {
		String sql = "update modulos set "
				+ "nombre = ?, "
				+ "jornadas = ?, "
				+ "horas = ? ,"
				+ "horas_tutorias = ?, "
				+ "bloque = ?"
				+ " where id = ?";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		int bloqueDB = 0;
		if(m.getBloque() == Bloque.TRONCAL){
			bloqueDB = 0;
		}else if(m.getBloque() == Bloque.METODO){
			bloqueDB = 1;
		}else if(m.getBloque() == Bloque.SUMA){
			bloqueDB = 2;
		}
		
		int n = jdbc.update(sql, 
				new Object[]{
						m.getNombre(),
						m.getJornadas(),
						m.getHoras(),
						m.getHorasTutorias(),
						bloqueDB,
						m.getId()});
		return n > 0;
	}

	public boolean delete(Modulo m) {
		String sql = "delete from modulos where id = ?";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		int n = jdbc.update(sql, new Object[]{m.getId()});
		
		return n > 0;
	}

	public List<Modulo> listar() {
		String sql = "select * from modulos order by bloque";
		List<Modulo> lista;
		
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		lista = jdbc.query(sql, new ModuloRowMapper());
		return lista;
	}

}
