package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getSqlConn() throws SQLException{
		Connection conn = null;
		String strConnection = "jdbc:sqlserver://DESKTOP-LFS7BB2;databaseName=QuanLyBDS;user=sa;password=Sa123456;";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(strConnection);
		} catch (ClassNotFoundException ex) {
			System.out.println("Cannot find jdbc driver for SQL Server");
		} 
		return conn;
	}
	
	public static void closeQuietly(Connection conn) {
	       try {
	           conn.close();
	       } catch (Exception e) {
	       }
	   }
	 
	   public static void rollbackQuietly(Connection conn) {
	       try {
	           conn.rollback();
	       } catch (Exception e) {
	       }
	   }
	
//	   public static void main(String[] args) {
//		try {
//			System.out.println(new DBUtil().getSqlConn());
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
}
