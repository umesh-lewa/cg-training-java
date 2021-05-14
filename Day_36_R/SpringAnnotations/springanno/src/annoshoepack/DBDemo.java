package annoshoepack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class DBDemo {
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void test1() throws Exception{
		JdbcTemplate jdbcTemplate=new JdbcTemplate(getDataSource());
		
		int count=jdbcTemplate.queryForInt("select count(*) from users");
		
		System.out.println("No rows...:"+count);
		
		String uname=jdbcTemplate.queryForObject("select uname from users where uid=1",String.class);
		System.out.println("The name of uid 1 is..:"+uname);
		
		uname=jdbcTemplate.queryForObject("select uname from users where uid=?", new Object[] {2},String.class);
		
		System.out.println("The name of uid 2...:"+uname);
		
		UserDTO userDTO=jdbcTemplate.queryForObject("select * from users where uid=?", 
										new Object[] {3},new MyRowMapper());
		System.out.println(userDTO);
		
		List<UserDTO> list=jdbcTemplate.query("select * from users",new MyRowMapper());
		for(UserDTO user:list) {
			System.out.println(user);
		}
		
		//try for update method
		
		
		
	}
	public void test2() {
		NamedParameterJdbcTemplate namedJdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
		String sql="select upass from users where uname=:username";
		SqlParameterSource myParameters=new MapSqlParameterSource("username","ramu");
		
		String upass=namedJdbcTemplate.queryForObject(sql, myParameters, String.class);
		
		System.out.println("The password of ramu is....:"+upass);
		
		
	}
}
class MyRowMapper implements RowMapper<UserDTO>{
	@Override
	public UserDTO mapRow(ResultSet rs, int arg1) throws SQLException {
		UserDTO userDTO =new UserDTO();
		userDTO.setUid(rs.getInt(1));
		userDTO.setUname(rs.getString(2));
		userDTO.setUpass(rs.getString(3));
		userDTO.setFlag(rs.getInt(4));
		return userDTO;
	}
}
class UserDTO{
	private int uid,flag;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	private String uname,upass;
	@Override
	public String toString() {
		return "UserDTO [uid=" + uid + ", flag=" + flag + ", uname=" + uname + ", upass=" + upass + "]";
	}
	
}