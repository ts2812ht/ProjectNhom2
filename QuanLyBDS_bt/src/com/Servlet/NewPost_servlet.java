package Servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Dto.PostDTO;
import Dto.UserDTO;
import Jdbc.PostImpl;
import Jdbc.UserImpl;;

/**
 * Servlet implementation class NewPost_servlet
 */
@WebServlet("/NewPost_servlet")
public class NewPost_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPost_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String url = "";
        
        String name = request.getParameter("name");
        String title = request.getParameter("Title");
        String category = request.getParameter("Category");
        String district = request.getParameter("District");
        String phuongxa = request.getParameter("Phuongxa");
        String address = request.getParameter("Address");
        String price = request.getParameter("Price");
        String description = request.getParameter("Description");
        String area = request.getParameter("Area");
        String phone = request.getParameter("Phone");
//        "ts1",		//title
//		"asd",		//description
//		20000,		//price
//		20,			//area
//		"asd",		//address
//		"images/test1.jpg",			//images
//		"1",		//user_id
//		"1",		//category_id
//		"",			//district_id
//		"",			//phuongxa_id
//		"0123456");	//phone

//        

        HttpSession session = request.getSession();
		UserDTO User = (UserDTO) session.getAttribute("user");  
		
		//tạo thư mục lưu cho account
		String idForder = "\\id"+ String.valueOf(User.getId());
		//Đường dẫn tới thư mục cần lưu
		String fullSavePath = "D:\\Pro\\JavaOne\\QuanLyBDS_bt\\WebContent\\images\\post" 
						+ File.separator + idForder;
		// Tạo thư mục nếu nó không tồn tại.
		File fileSaveDir = new File(fullSavePath);
		if (!fileSaveDir.exists()) {
           fileSaveDir.mkdir();
		}
		
		String post_image = null;
		
		for (Part part : request.getParts()) {
               String fileName = extractFileName(part);
               if (fileName != null && fileName.length() > 0) {
                   String filePath = fullSavePath + File.separator + fileName;
                   part.write(filePath);
                   post_image = "images/users/" + idForder + "/" + fileName;
               }
           }
		if (post_image == null) {
			post_image = "images/test1.jpg";
		}
    	try {
        	PostImpl dao = new PostImpl();
        	PostDTO post = new PostDTO(
        						title,		//title
        						description,		//description
        						Integer.parseInt(price),		//price
        						Integer.parseInt(area),			//area
        						address,		//address
        						post_image,			//images
        						String.valueOf(User.getId()),		//user_id
        						category,		//category_id
        						district,			//district_id
        						phuongxa,			//phuongxa_id
        						phone);	//phone
    		dao.NewPost(post);
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    	}
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
        
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
