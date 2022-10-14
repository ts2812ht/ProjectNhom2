package Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dto.PostDTO;

public class PostImpl {
	

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//Hiển thị tất cả Post
	public List<PostDTO> getAllPost(){

		List<PostDTO> list = new ArrayList<>();
		String query = "select * from post";
		try {
			conn = new Jdbc.DBUtil().getSqlConn();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new PostDTO(
						rs.getInt("id"),
						rs.getString("title"),
						rs.getString("description"),
						rs.getInt("price"),
						rs.getInt("area"),
						rs.getInt("count_view"),
						rs.getString("address"),
						rs.getString("latlng"),
						rs.getString("images"),
						rs.getString("user_id"),
						rs.getString("category_id"),
						rs.getString("district_id"),
						rs.getString("approve"),
						rs.getString("create_at")));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	
	
	//Hiển thị theo Category
	public List<PostDTO> getAllPostByCategoryId(String cid){


		List<PostDTO> list = new ArrayList<>();
		String query = "select * from post where category_id = ?";
		try {
			conn = new Jdbc.DBUtil().getSqlConn();
			ps = conn.prepareStatement(query);
			ps.setString(1, cid);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new PostDTO(
						rs.getInt("id"),
						rs.getString("title"),
						rs.getString("description"),
						rs.getInt("price"),
						rs.getInt("area"),
						rs.getInt("count_view"),
						rs.getString("address"),
						rs.getString("latlng"),
						rs.getString("images"),
						rs.getString("user_id"),
						rs.getString("category_id"),
						rs.getString("district_id"),
						rs.getString("approve"),
						rs.getString("create_at")));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	
	//Chi tiết 1 bài đăng
	public PostDTO getPostById(String cid){

		PostDTO post = new PostDTO();
		String query = "select * from post where id = ?";
		try {
			conn = new Jdbc.DBUtil().getSqlConn();
			ps = conn.prepareStatement(query);
			ps.setString(1, cid);
			rs = ps.executeQuery();
			while (rs.next()) {
				post = 	new PostDTO(rs.getInt("id"),
						rs.getString("title"),
						rs.getString("description"),
						rs.getInt("price"),
						rs.getInt("area"),
						rs.getInt("count_view"),
						rs.getString("address"),
						rs.getString("latlng"),
						rs.getString("images"),
						rs.getString("user_id"),
						rs.getString("category_id"),
						rs.getString("district_id"),
						rs.getString("approve"),
						rs.getString("create_at"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return post;
	}
	
	//Tìm kiếm bài đăng theo category/vị trí/giá/diện tích
	public List<PostDTO> searchPost(String Cate_id,String Dist_id,String PriceL,String PriceH,String AreaL,String AreaH){

		if (Cate_id != "") {
			Cate_id = " and category_id = " + Cate_id;
		} 
		
		if (Dist_id != "") {
			Dist_id =" and district_id = " + Dist_id;
		} 
		
		if (PriceL == "") {
			PriceL = "0";
		} 
		
		if (PriceH == "") {
			PriceH = "999999999999";
		} 
		
		if (AreaL == "") {
			AreaL = "0";
		} 
		
		if (AreaH == "") {
			AreaH = "9999999";
		} 
		
		
		List<PostDTO> list = new ArrayList<>();
		String query = "select * from post where  price >= ? and price <= ? and area >= ? and area <= ?" + Cate_id + Dist_id;
		try {
			conn = new Jdbc.DBUtil().getSqlConn();
			ps = conn.prepareStatement(query);
			ps.setString(1, PriceL);
			ps.setString(2, PriceH);
			ps.setString(3, AreaL);
			ps.setString(4, AreaH);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new PostDTO(
						rs.getInt("id"),
						rs.getString("title"),
						rs.getString("description"),
						rs.getInt("price"),
						rs.getInt("area"),
						rs.getInt("count_view"),
						rs.getString("address"),
						rs.getString("latlng"),
						rs.getString("images"),
						rs.getString("user_id"),
						rs.getString("category_id"),
						rs.getString("district_id"),
						rs.getString("approve"),
						rs.getString("create_at")));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<PostDTO> getAllPostbyUserId(int id) {
		List<PostDTO> list = new ArrayList<>();
		String query = "select * from post where user_id = ?";
		try {
			conn = new Jdbc.DBUtil().getSqlConn();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new PostDTO(
						rs.getInt("id"),
						rs.getString("title"),
						rs.getString("description"),
						rs.getInt("price"),
						rs.getInt("area"),
						rs.getInt("count_view"),
						rs.getString("address"),
						rs.getString("latlng"),
						rs.getString("images"),
						rs.getString("user_id"),
						rs.getString("category_id"),
						rs.getString("district_id"),
						rs.getString("approve"),
						rs.getString("create_at")));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	
	//Tạo post mới
	public void NewPost(PostDTO post) throws SQLException  {
		String query = "INSERT INTO post (title , description, price, area,  address, images, \r\n"
				+ "					user_id, category_id, district_id,phuongxa_id, phone,approve) VALUES\r\n"
				+ "			(N'"+post.getTitle()+"', N'"+post.getDescription()+"',?,?,N'"+post.getAddress()+"',?,?,?,?,?,?,1)";
		try {
			conn = new Jdbc.DBUtil().getSqlConn();
			ps = conn.prepareStatement(query);
			ps.setInt(1, post.getPrice());
			ps.setInt(2, post.getArea());
			ps.setString(3, post.getImages());
			ps.setString(4, post.getUser_id());
			ps.setString(5, post.getCategory_id());
			ps.setString(6, post.getDistrict_id());
			ps.setString(7, post.getPhuongxa_id());
			ps.setString(8, post.getPhone());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

//		INSERT INTO post (title , description, price, area, count_view, address, images, 
//				user_id, category_id, district_id, phone,approve) VALUES
//		(N'Phòng mới', N'Phòng description',1800,20,0,N'47 Đường Cầu Giấy','images/test1.jpg',
//				1,1,6,'0915016124',1)
	}

//	public static void main(String[] args) {
//		PostImpl dao = new PostImpl();
//		List<PostDTO> list = dao.getAllPostbyUserId(1);
//		for (PostDTO o : list) {
//			System.out.println(o);
//		}
//	}
//	
//	public static void main(String[] args) {
//		PostImpl dao = new PostImpl();
//		List<PostDTO> list = dao.searchPost("1","","","","","");
//		for (PostDTO o : list) {
//			System.out.println(o);
//		}
//	}

//	public static void main(String[] args) {
//	PostImpl dao = new PostImpl();
//	PostDTO post = new PostDTO(
//						"Nôp",		//title
//						"asd",		//description
//						20000,		//price
//						20,			//area
//						"asd",		//address
//						"images/test1.jpg",			//images
//						"1",		//user_id
//						"1",		//category_id
//						"1",			//district_id
//						"",			//phuongxa_id
//						"0123456");			//phone
//								
//	try {
//		dao.NewPost(post);
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	}


}
