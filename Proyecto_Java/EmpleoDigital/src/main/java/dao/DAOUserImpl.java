package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import modelos.User;

public class DAOUserImpl implements DAOUser{

	
	class UserRowMapper implements RowMapper<User>{
		
		public User mapRow(ResultSet rs, int numRow) throws SQLException{
			
			User e=new User(rs.getString("username"),User.Authority.valueOf(rs.getString("authority")));
			
			return e;
		}
	}
	
	private DataSource dataSource;
	
	
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public boolean recordPassword(String username,String password){
		
		ShaPasswordEncoder cod=new ShaPasswordEncoder(256);
		password=cod.encodePassword(password, username);
		
		String sql="update users set password=? where username=?";
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		int n=jdbc.update(sql,new Object[]{password,username});
		
		
		
		return n>0;
		
		
	}
	
	
	public boolean create(User u, String password){
		
		ShaPasswordEncoder cod=new ShaPasswordEncoder(256);
		password=cod.encodePassword(password, u.getUsername());
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		String sql="insert into users (username,password,enabled) values (?,?,1)";
		
		jdbc.update(sql,new Object[]{u.getUsername(),password});
		
		sql="insert into authorities (username,authority) values (?,?)";
		
		int r=jdbc.update(sql,new Object[]{u.getUsername(),u.getAuthority().name()});
	
		return r>0;
	}
	
	public boolean delete(String username){
		
		String sql="delete from users where username=?";
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		int n=jdbc.update(sql,new Object[]{username});
		
		return n>0;
	}
	
	public boolean update(User u){
		
		String sql="update authorities set authority=? where username=?";
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		int p=jdbc.update(sql,new Object[]{u.getAuthority().name()});
		
		return p>0;
	}
	
	public User read(String username){
		User u=null;
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		String sql="select username,authorities where username=?";
		
		u=jdbc.queryForObject(sql, new Object[]{username},new UserRowMapper());
	
		return u;
	
	}
	
	public List<User> listar(){
		
		List<User> lista=new ArrayList<User>();
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		String sql="select usernmae,authority from authorities order by username asc";
		
		lista=jdbc.query(sql, new UserRowMapper());
		
		return lista;
	}
}
