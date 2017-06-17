package dao;

import java.util.List;

import modelos.Provincia;



public interface DAOProvincia {

	public Provincia read(int comunidadId);
	public Provincia readByIdFormacion(int idFormacion);

	public List<Provincia> listar();
	public List<Provincia> listar(String letra);
	public List<Provincia> listarPorComunidad(int id);
}
