package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.PostDTO;
import Jdbc.PostImpl;

/**
 * Servlet implementation class Post_servlet
 */
@WebServlet("/Post_servlet")
public class Post_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Post_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;chartset=UTF-8");
		String Cid = null;
		Cid = request.getParameter("Cid");
		PostImpl dao = new PostImpl();
		List<PostDTO> list = null;
		if (Cid == null) {
			list = dao.getAllPost();
		}
		else {
			list = dao.getAllPostByCategoryId(Cid);
		}
		request.setAttribute("list",list);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
