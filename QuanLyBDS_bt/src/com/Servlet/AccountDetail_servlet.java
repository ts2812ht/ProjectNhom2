package Servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Dto.UserDTO;
import Jdbc.UserImpl;

/**
 * Servlet implementation class AccountDetail_servlet
 */
@WebServlet("/Update_Acc")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
			maxFileSize = 1024 * 1024 * 10, // 10MB
			maxRequestSize = 1024 * 1024 * 50) // 50MB
public class AccountDetail_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountDetail_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/Post_servlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
		
		try {
//			Part filePart = request.getPart("image");						//Lấy part của hình ảnh:Part filePart = request.getPart("hinhanh");
			String name = request.getParameter("name");
			String pass = request.getParameter("pass");
			String repass = request.getParameter("repass");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			
			if (!repass.equals(pass)) {
				request.setAttribute("error", "Mật Khẩu Nhập Lại Bị Sai");
				request.getRequestDispatcher("/AccountDetail.jsp").forward(request, response);
				return;
			} else if (pass.length() < 8) {
				request.setAttribute("error", "Độ Dài Mật Khẩu Lớn Hơn 8 Ký Tự");
				request.getRequestDispatcher("/AccountDetail.jsp").forward(request, response);
				return;
			} else {

				HttpSession session = request.getSession();
				UserDTO C_user = (UserDTO) session.getAttribute("user");  
				UserImpl dao = new UserImpl();
				
				//tạo thư mục lưu cho account
				String idForder = "\\id"+ String.valueOf(C_user.getId());
				//Đường dẫn tới thư mục cần lưu
				String fullSavePath = "D:\\Pro\\JavaOne\\QuanLyBDS_bt\\WebContent\\images\\users" 
								+ File.separator + idForder;
				// Tạo thư mục nếu nó không tồn tại.
				File fileSaveDir = new File(fullSavePath);
				if (!fileSaveDir.exists()) {
	               fileSaveDir.mkdir();
				}
				
				String avatar = null;
				
				for (Part part : request.getParts()) {
		               String fileName = extractFileName(part);
		               if (fileName != null && fileName.length() > 0) {
		                   String filePath = fullSavePath + File.separator + fileName;
		                   part.write(filePath);
		                   avatar = "images/users/" + idForder + "/" + fileName;
		               }
		           }
				if (avatar == null) {
					avatar = C_user.getAvatar();
				}
				
//				String fileName = extractFileName(filePart);					//Lấy tên file			
//		        filePart.write(fullSavePath + File.separator + fileName);		//ghi: part.write(string của đường dẫn + tên file)
		        
		        dao.updateUser(C_user.getId(), name, email, pass, phone, avatar);
			}
	    	   
	           
	           
	           
	           // Danh mục các phần đã upload lên (Có thể là nhiều file).
//	           for (Part part : request.getParts()) {
//	               String fileName = extractFileName(part);
//	               if (fileName != null && fileName.length() > 0) {
//	                   // Ghi vào file.
//	                   part.write(fullSavePath + File.separator + fileName);
//	               }
//	           }
	       } catch (Exception e) {
	           e.printStackTrace();
	           request.setAttribute("errorMessage", "Error: " + e.getMessage());
	           RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/uploadFile.jsp");
	           dispatcher.forward(request, response);
	       }
		
		request.setAttribute("success","Thanh cong");
		request.getRequestDispatcher("/AccountDetail.jsp").forward(request, response);
	}
	
	private String extractFileName(Part part) {
	       // form-data; name="file"; filename="C:\file1.zip"
	       // form-data; name="file"; filename="C:\Note\file2.zip"
	       String contentDisp = part.getHeader("content-disposition");
	       String[] items = contentDisp.split(";");
	       for (String s : items) {
	           if (s.trim().startsWith("filename")) {
	               // C:\file1.zip
	               // C:\Note\file2.zip
	               String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
	               clientFileName = clientFileName.replace("\\", "/");
	               int i = clientFileName.lastIndexOf('/');
	               // file1.zip
	               // file2.zip
	               return clientFileName.substring(i + 1);
	           }
	       }
	       return null;
	   }

}
