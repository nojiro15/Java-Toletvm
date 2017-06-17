package dao;

import java.util.Date;
import java.util.List;

import modelos.FiestaRegional;
import modelos.Provincia;



public interface DAOFiestaRegional {

	public boolean create(FiestaRegional r);
	public FiestaRegional read(Date fecha);
	public boolean update(FiestaRegional r, Date fechaOriginal);
	public boolean delete(Date fecha);
	public List<FiestaRegional> listar();
	public List<FiestaRegional> listarByIdFormacion(int idFormacion);

}
