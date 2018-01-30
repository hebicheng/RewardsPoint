package reward.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reward.dao.ContestDao;
import reward.dao.impl.ContestDaoImpl;
import reward.entity.Contest;

/**
 * Servlet implementation class CreateContestServlet
 */
@WebServlet("/CreateContestServlet")
public class CreateContestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateContestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("cName");
		if(name == null || name.trim().equals("")) {
			request.setAttribute("message", "文件夹名不能为空");
			request.getRequestDispatcher("admin").forward(request, response);
			return;
		}
		String content = request.getParameter("cContent");
		String type = "训练赛";
		String weightString = request.getParameter("cWeight");
		int weight = Integer.parseInt(weightString);
		String oj = request.getParameter("cOj");
		String url = request.getParameter("cUrl");
		Date time = new Date();
		
		Contest contest = new Contest(name, content, type, weight, time, oj, url);
		ContestDao contestDao = new ContestDaoImpl();
		contestDao.insert(contest);
		response.sendRedirect("admin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
