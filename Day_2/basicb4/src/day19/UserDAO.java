package day19;

import java.util.List;

public interface UserDAO {
	
	public UserDAO findByID(Integer userid);
	public List<UserDAO> findAll();
	public int insertItem(UserDAO userDAO);
	public int updateItem(UserDAO userDAO);
	public int deleteItemByID(Integer userid);
	public int deleteItemByDTO(UserDAO userDAO);
	
}

