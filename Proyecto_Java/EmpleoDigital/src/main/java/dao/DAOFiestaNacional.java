package dao;

import java.util.List;

import modelos.FiestaNacional;



public interface DAOFiestaNacional {

	public boolean create(FiestaNacional n);
	public FiestaNacional read(String palabra);
	public boolean update(FiestaNacional n);
	public boolean delete(String nombre);
	public List<FiestaNacional> listar();
}
