package dao;

import java.util.List;

import modelos.ModuloFormacion;

public interface DAOModuloFormacion{
	
	public boolean create(ModuloFormacion mf);
	public List<ModuloFormacion> read(String palabra);
	public boolean update(ModuloFormacion mf);
	public boolean delete(ModuloFormacion mf);
	public List<ModuloFormacion> listar();

}
