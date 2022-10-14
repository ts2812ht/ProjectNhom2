package Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dto.UserDTO;


public class UserImpl {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	public UserDTO getUserLogin(String username,String password){

		UserDTO user = new UserDTO();
		String query = "select * from users where username = ? and password = ?";
		try {
			conn = new Jdbc.DBUtil().getSqlConn();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = 	new UserDTO(rs.getInt("id"),
						rs.getString("name"),
						rs.getString("username"),
						rs.getString("email"),
						rs.getString("password"),
						rs.getInt("type"),
						rs.getString("phone"),
						rs.getString("avatar"),
						rs.getInt("tinhtrang"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}
//	private int id;
//	private String name;
//	private String username;
//	private String email;
//	private String password;
//	private int type;
//	private String phone;
//	private String avatar;
//	private int tinhtrang;


	public boolean kiemtraemail(String email) {
		String query = "select * from users where email ='" + email + "' ";
		try {
			conn = new Jdbc.DBUtil().getSqlConn();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

        return false;
	}


	public boolean kiemtra(String username) {
        String query = "select * from users where username='" + username + "' ";
		try {
			conn = new Jdbc.DBUtil().getSqlConn();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
        return false;
	}
	
	
	public void register(UserDTO user) {
        String query = "INSERT INTO users (name, username,email,password,phone) VALUES\r\n"
        		+ "(N'" + user.getName() + "', ?,?,?,?)";
		try {
			conn = new Jdbc.DBUtil().getSqlConn();
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getPhone());
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Loi " + ex.getMessage());
		}
	}
	
	//sửa user by Id
	public void updateUser(int id,String name,String email, String password,String phone,String image) {
        String query = "UPDATE users\r\n"
        		+ "SET name = N'"+ name +"', email= ?, password = ?, phone =?,avatar = ?\r\n"
        		+ "WHERE id = ?;";
		try {
			conn = new Jdbc.DBUtil().getSqlConn();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, phone);
			ps.setString(4, image);
			ps.setInt(5, id);
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Loi " + ex.getMessage());
		}
	}
	
	
	
//	public static void main(String[] args) {
//	PostImpl dao = new PostImpl();
//	List<PostDTO> list = dao.searchPost("1","","","","","");
//	for (PostDTO o : list) {
//		System.out.println(o);
//	}
//}
	
//	public static void main(String[] args) {
//	UserImpl dao = new UserImpl();
//	UserDTO user = dao.getUserLogin("t","1");
//	System.out.println(user);
//	}
	
//	public static void main(String[] args) {
//	UserImpl dao = new UserImpl();
//	UserDTO user = new UserDTO("Wcaca","ts1","asd","1","asd","");
//	dao.register(user);
//	}
	
//	public static void main(String[] args) {
//	UserImpl dao = new UserImpl();
//	dao.updateUser("5", "Alfred Schmidt", "Frankfurt", "2", "0123456", "nope.jsp");
//	}
}
