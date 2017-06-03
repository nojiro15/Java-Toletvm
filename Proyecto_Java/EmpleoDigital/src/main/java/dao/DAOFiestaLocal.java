package dao;

import java.util.List;

import modelos.FiestaLocal;


public interface DAOFiestaLocal {

	public boolean create(FiestaLocal l);
	public FiestaLocal read(String palabra);
	public boolean update(FiestaLocal l);
	public boolean delete(int idMunicipio);
	public List<FiestaLocal> listar();
}
