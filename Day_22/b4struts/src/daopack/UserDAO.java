package daopack;

import java.util.Set;

import javax.servlet.ServletContext;

public interface UserDAO {
	public UserDTO findById(int uid);
	public Set<UserDTO> findAll();
	public int insertUser(UserDTO userDTO);
	public int deleteUser(int uid);
	public int updateUser(UserDTO userDTO);
	public UserDTO findByName(String uname);
	public void setServCtx(ServletContext ctx);
}
