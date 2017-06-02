package dao;

import java.util.List;

import modelos.FiestaRegional;



public interface DAOFiestaRegional {

	public boolean create(FiestaRegional r);
	public FiestaRegional read(String palabra);
	public boolean update(FiestaRegional r);
	public boolean delete(String nombre);
	public List<FiestaRegional> listar();
}
