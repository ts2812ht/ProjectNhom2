package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dto.UserDTO;
import Jdbc.UserImpl;

/**
 * Servlet implementation class Login_servlet
 */
@WebServlet("/Login")
public class Login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_servlet() {
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
		response.setContentType("text/html;chartset=UTF-8");
		String username, password;
		username = request.getParameter("uname");
		password = request.getParameter("psw");

		UserImpl dao = new UserImpl();
		UserDTO user = dao.getUserLogin(username,password);
		
		if (user.getUsername() == null) {
			response.sendRedirect(request.getContextPath() + "/LoginForm.jsp");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath() +"/Post_servlet");
		}
	}

}
