package day19;

import java.util.List;

public interface UserDAO {
	
	public UserDTO findByID(Integer userid);
	public List<UserDTO> findAll();
	public int insertItem(UserDTO userDTO);
	public int updateItem(UserDTO userDTO);
	public int deleteItemByID(Integer userid);
	public int deleteItemByDTO(UserDTO userDTO);
	
}

