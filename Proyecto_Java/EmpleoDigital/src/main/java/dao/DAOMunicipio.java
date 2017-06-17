package dao;

import java.util.List;

import modelos.Municipio;

public interface DAOMunicipio {
	
	public Municipio read(int idMunicipio);
	public Municipio readByIdFormacion(int idFormacion);
	public List<Municipio> listar();
	public List<Municipio> listar(String letra);
	public List<Municipio> listarPorProvincias(int idProvincia);
	
}
