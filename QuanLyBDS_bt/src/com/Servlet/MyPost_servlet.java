package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dto.PostDTO;
import Dto.UserDTO;
import Jdbc.PostImpl;

/**
 * Servlet implementation class MyPost_servlet
 */
@WebServlet("/MyPost_servlet")
public class MyPost_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPost_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;chartset=UTF-8");
		
		HttpSession session = request.getSession();
		UserDTO User = (UserDTO) session.getAttribute("user");  
		
		PostImpl dao = new PostImpl();
		
		List<PostDTO> list = null;
		
		list = dao.getAllPostbyUserId(User.getId());
		
		request.setAttribute("list",list);
		request.getRequestDispatcher("/MyPost.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
