package dao;

import java.util.List;

import modelos.Modulo;

public interface DAOModulo {
	
	public boolean create(Modulo m);
	public List<Modulo> read(String palabra);
	public boolean update(Modulo m);
	public boolean delete(Modulo m);
	public List<Modulo> listar();
	
}