package Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
//	private int id;
//	private String title;
//	private String description;
//	private int price;
//	private int area;
//	private int count_view;
//	private String address;
//	private String latlng;
//	private String images;
//	private String user_id;
//	private String category_id;
//	private String district_id;
//	private String approve;
//	private String create_at;
//	public static void main(String[] args) {
//		PostImpl dao = new PostImpl();
//		List<PostDTO> list = dao.getAllPost();
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
}
