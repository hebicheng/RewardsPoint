package reward.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reward.dao.ContestDao;
import reward.dao.impl.ContestDaoImpl;
import reward.entity.Contest;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String userName = (String)session.getAttribute("admin");
		// 用户名失效
		if(userName == null) {
			response.sendRedirect("login");
			return ;
		}
		ContestDao contestDao = new ContestDaoImpl();
		Vector<Contest> data = contestDao.getAllContests();
		if (data!= null){
			request.setAttribute("contests", data);
//			request.getRequestDispatcher("contest.jsp").forward(request, response);
//			return;
		}
//		ListTeamerBiz listTeamerBiz = new ListTeamerBizImpl();
//		Vector<Teamer> teamers = listTeamerBiz.ListAllTeamers();
//		request.setAttribute("teamers", teamers);
//		if (name == null) {
//			request.setAttribute("selectteamer", teamers.firstElement());
//		}else{
//			Teamer teamer = new TeamerDaoImpl().findTeamerByName(name);
//			request.setAttribute("selectteamer", teamer);
//		}
		
		request.getRequestDispatcher("auth/admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
