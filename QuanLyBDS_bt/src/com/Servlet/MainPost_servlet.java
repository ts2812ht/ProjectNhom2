package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.PostDTO;
import Jdbc.PostImpl;

/**
 * Servlet implementation class MainPost_servlet
 */
@WebServlet("/MainPost_servlet")
public class MainPost_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPost_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;chartset=UTF-8");
		String Pid = null;
		Pid = request.getParameter("Pid");
		PostImpl dao = new PostImpl();
		PostDTO post = dao.getPostById(Pid);

		request.setAttribute("post",post);
		request.getRequestDispatcher("/Mainpost.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
