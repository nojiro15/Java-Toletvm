package dao;

import java.util.Date;
import java.util.List;

import modelos.FiestaNacional;



public interface DAOFiestaNacional {

	public boolean create(FiestaNacional n);
	public FiestaNacional read(Date fecha);
	public boolean update(FiestaNacional n,Date fechaOriginal);
	public boolean delete(Date fecha);
	public List<FiestaNacional> listar();
}
