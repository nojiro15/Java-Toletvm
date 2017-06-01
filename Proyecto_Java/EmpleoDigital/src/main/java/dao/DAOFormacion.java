package dao;

import java.util.List;

import modelos.Formacion;


public interface DAOFormacion {
	
	public boolean create(Formacion f);
	public List<Formacion> read(String palabra);
	public boolean update(Formacion f);
	public boolean delete(Formacion f);
	public List<Formacion> listar();
	
}
