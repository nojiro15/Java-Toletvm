package dao;

import java.util.List;

import modelos.Municipio;

public interface DAOMunicipio {
	
	public Municipio read(int provinciaId);
	public List<Municipio> listar();
	public List<Municipio> listar(String letra);
	
}
