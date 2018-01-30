package reward.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reward.biz.ListTeamerBiz;
import reward.biz.impl.ListTeamerBizImpl;
import reward.entity.Teamer;

/**
 * Servlet implementation class List
 */
@WebServlet("/List")
public class ListTeamerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTeamerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ListTeamerBiz listTeamerBiz = new ListTeamerBizImpl();
		Vector<Teamer> data = listTeamerBiz.ListAllTeamers();
		if (data!= null){
			request.setAttribute("data", data);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		return;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
