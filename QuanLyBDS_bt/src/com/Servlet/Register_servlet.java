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
                request.setAttribute("error", "Email ???? T???n T???i!,Vui L??ng S??? D???ng Email Kh??c");
            }
            if (request.getParameter("pass").length() < 8) {
                request.setAttribute("error2", "????? D??i M???t Kh???u L???n H??n 8 K?? T???");
            }
            if (!request.getParameter("repass").equals(request.getParameter("pass"))) {
                request.setAttribute("error3", "M???t Kh???u Nh???p L???i B??? Sai");
            }
            if ( usersDAO.kiemtra(username)) {
                request.setAttribute("error4", "T??n ????ng nh???p ???? T???n T???i!,Vui L??ng S??? D???ng t??n ????ng nh???p Kh??c");
            }
            
            url = "/RegisterForm.jsp";
//            if (!matcheremail.matches()) {
//                request.setAttribute("error4", "Sai ?????nh D???ng Email/Gmail");
//            }
//            if (!matcherpass.matches()) {
//                request.setAttribute("error5", "M???t kh???u ch???a ??t nh???t 1 t??? Hoa,1 t??? th?????ng,k??m 1 k?? t??? ?????c bi???t,????? d??i l???n h??n 8");
//            }
//            if (!matcherdienthoai.matches()) {
//                request.setAttribute("error6", "Sai ?????nh D???ng ??i???n Tho???i,g???m 10 ho???c 11 s??? v?? b???t ?????u t??? s??? 0");
//            }
        } else {
//            user.setHovaten(request.getParameter("name"));
//            user.setUserEmail(request.getParameter("email"));
//            user.setUserName(request.getParameter("username"));
//            user.setUserPass(request.getParameter("pass"));
//            user.setSdt(request.getParameter("phone"));
            user = new UserDTO(name,username,email,pass,phone,"");
            usersDAO.register(user);
            url = "Post_servlet";
        }
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
        
   }

}
