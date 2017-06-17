package dao;

import java.util.List;

import modelos.Vacaciones;

public interface DAOVacaciones {

	public boolean create(Vacaciones v);
	public Vacaciones read(String palabra);
	public boolean update(Vacaciones v);
	public boolean delete(int id);
	public List<Vacaciones> listar();
	public List<Vacaciones> listarByIdFormacion(int idFormacion);
}
