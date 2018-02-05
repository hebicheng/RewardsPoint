package reward.servlet;

import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		String name = request.getParameter("cName");
		if(name == null || name.trim().equals("")) {
			request.setAttribute("message", "文件夹名不能为空");
			request.getRequestDispatcher("admin").forward(request, response);
			return;
		}
		String content = request.getParameter("cContent");
		int type = Integer.parseInt(request.getParameter("cType"));
		int weight = 1;
		String cTime = request.getParameter("cTime");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    ParsePosition pos = new ParsePosition(0);
	    Date time = formatter.parse(cTime, pos);
		String oj, url;
		int num;
		if(type == 0) {
			String weightString = request.getParameter("cWeight");
			weight = Integer.parseInt(weightString);
			oj = request.getParameter("cOj");
			url = request.getParameter("cUrl");
			num = Integer.parseInt(request.getParameter("cNum"));
		} else {
			oj = request.getParameter("cOJ");
			if(oj.equals("codeforces")) {
				url = "http://codeforces.com/";
			} else {
				url = "http://atcoder.jp/";
			}
			num = 0;
		}
		Contest contest = new Contest(name, content, type, weight, time, oj, url, num);
		ContestDao contestDao = new ContestDaoImpl();
		contestDao.insert(contest);
		response.sendRedirect("Contests");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
