package dao;

import java.util.List;

import modelos.User;

public interface DAOUser {

	
	public boolean recordPassword(String username, String password);
	public boolean create(User u,String password);
	public User read(String username);
	public List<User> listar();
	public boolean delete(String username);
	public boolean update(User u);
}
