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
 * Servlet implementation class SearchPost_servlet
 */
@WebServlet("/SearchPost")
public class SearchPost_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPost_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String Cate_id,String Dist_id,String PriceL,String PriceH,String AreaL,String AreaH
		String Cate_id = request.getParameter("Category_search");
		String Dist_id = request.getParameter("District_search");
		String PriceL = request.getParameter("PriceLow_search");
		String PriceH = request.getParameter("PriceHigh_search");
		String AreaL = request.getParameter("AreaLow_search");
		String AreaH = request.getParameter("AreaHigh_search");
		
		PostImpl dao = new PostImpl();
		List<PostDTO> list = null;
		
		
		list = dao.searchPost(Cate_id, Dist_id, PriceL, PriceH, AreaL, AreaH);
		
		request.setAttribute("list",list);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
