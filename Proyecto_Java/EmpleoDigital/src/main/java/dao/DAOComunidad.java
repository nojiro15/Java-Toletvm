package dao;

import java.util.List;

import modelos.Comunidad;

public interface DAOComunidad {

	public Comunidad read(int id);
	public List<Comunidad> listar();
	public List<Comunidad> listar(String letra);
}
