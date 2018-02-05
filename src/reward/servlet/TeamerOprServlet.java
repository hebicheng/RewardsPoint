package reward.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reward.biz.ListTeamerBiz;
import reward.biz.impl.ListTeamerBizImpl;
import reward.entity.Teamer;

/**
 * Servlet implementation class TeamerOprServlet
 */
@WebServlet("/TeamerOprServlet")
public class TeamerOprServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamerOprServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();  
		if(session.getAttribute("type") == null){
			response.sendRedirect("admin");
			return;
		}
		if((int)session.getAttribute("type") != 0){
			session.invalidate();
			response.sendRedirect("admin");
			return;
		}
		ListTeamerBiz teamerBiz = new ListTeamerBizImpl();
		Vector<Teamer> teamers = teamerBiz.ListAllTeamers();
		request.setAttribute("teamers", teamers);
		request.getRequestDispatcher("teamer.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
