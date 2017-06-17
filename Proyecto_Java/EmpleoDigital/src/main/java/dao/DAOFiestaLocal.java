package dao;

import java.util.Date;
import java.util.List;

import modelos.FiestaLocal;


public interface DAOFiestaLocal {

	public boolean create(FiestaLocal l);
	public FiestaLocal read(Date fecha);
	public boolean update(FiestaLocal l, Date fechaOriginal);
	public boolean delete(Date fecha);
	public List<FiestaLocal> listar();
	public List<FiestaLocal> listarByIdFormacion(int idFormacion);

}
