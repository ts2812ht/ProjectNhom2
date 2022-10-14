package Servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.UserDTO;
import Jdbc.UserImpl;

/**
 * Servlet implementation class Register_servlet
 */
@WebServlet("/Register_servlet")
public class Register_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String url = "";
        UserDTO user = new UserDTO();		//new user
        
        String mauEmail = "^[\\w-_.]{5,15}+\\@[\\w&&[^0-9]]{5,8}+\\.com+$";
        String mauPass = "^([\\w_\\.!@#$%^&*()([A-Z])]+){8,31}$";
        String maudienthoai = "^[0]([0-9]{9,10})$";
        Pattern pattern = Pattern.compile(mauEmail);
        
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String phone = request.getParameter("phone");
        String repass = request.getParameter("repass");
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        Matcher matcheremail = pattern.matcher(email);
        Matcher matcherpass = Pattern.compile(mauPass).matcher(email);
        Matcher matcherdienthoai = Pattern.compile(maudienthoai).matcher(phone);
        

        UserImpl usersDAO = new UserImpl();		//Open implement ->SQL
        
        if (	  usersDAO.kiemtra(username)
        		| usersDAO.kiemtraemail(email)
                | pass.length() < 8
                | !repass.equals(pass)
                | username.length() < 5 | username.length() > 15
//                | !matcheremail.matches()
//                | !matcherpass.matches()
//                | !matcherdienthoai.matches()
                ) 
        	{
            if (usersDAO.kiemtraemail(email)) {
                request.setAttribute("error", "Email Đã Tồn Tại!,Vui Lòng Sử Dụng Email Khác");
            }
            if (pass.length() < 8) {
                request.setAttribute("error2", "Độ Dài Mật Khẩu Lớn Hơn 8 Ký Tự");
            }
            if (!repass.equals(pass)) {
                request.setAttribute("error3", "Mật Khẩu Nhập Lại Bị Sai");
            }
            if ( usersDAO.kiemtra(username)) {
                request.setAttribute("error4", "Tên đăng nhập Đã Tồn Tại!,Vui Lòng Sử Dụng tên đăng nhập Khác");
            }
            
            url = "/RegisterForm.jsp";
//            if (!matcheremail.matches()) {
//                request.setAttribute("error4", "Sai Định Dạng Email/Gmail");
//            }
//            if (!matcherpass.matches()) {
//                request.setAttribute("error5", "Mật khẩu chứa ít nhất 1 từ Hoa,1 từ thường,kèm 1 kí tự đặc biệt,Độ dài lớn hơn 8");
//            }
//            if (!matcherdienthoai.matches()) {
//                request.setAttribute("error6", "Sai Định Dạng Điện Thoại,gồm 10 hoặc 11 số và bắt đầu từ số 0");
//            }
        } else {
//            user.setHovaten(request.getParameter("name"));
//            user.setUserEmail(request.getParameter("email"));
//            user.setUserName(request.getParameter("username"));
//            user.setUserPass(request.getParameter("pass"));
//            user.setSdt(request.getParameter("phone"));
            user = new UserDTO(name,username,email,pass,phone,"");
            usersDAO.register(user);
            url = request.getContextPath() +"/Post_servlet";
        }
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
        
   }

}
