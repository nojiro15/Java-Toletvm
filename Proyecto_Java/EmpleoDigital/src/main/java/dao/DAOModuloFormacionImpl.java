package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import modelos.Formacion;
import modelos.ModuloFormacion;
import modelos.Modulo.Bloque;

public class DAOModuloFormacionImpl implements DAOModuloFormacion{

	private class ModuloFormacionRowMapper implements RowMapper<ModuloFormacion>{
		public ModuloFormacion mapRow(ResultSet rs, int numRow) throws SQLException{
			Bloque bloque = null; //Variable de tipo enum que se introducirá en el objeto Modulo
			int b = rs.getInt("bloque"); //Recogemos el número que aparece en la base de datos en el campo 'bloque'
			 			
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
					rs.getInt("horasTutorias"), 
					bloque,					
					rs.getInt("id_formacion"),
					rs.getInt("orden"),
					rs.getDate("fecha_inicio")) ;
		}
	}
	
	public boolean create(ModuloFormacion mf) {
		String sql = "";
		return false;
	}

	public List<ModuloFormacion> read(String palabra) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(ModuloFormacion mf) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(ModuloFormacion mf) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<ModuloFormacion> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
