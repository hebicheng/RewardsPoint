package reward.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reward.biz.RecordBiz;
import reward.biz.impl.RecordBizImpl;
import reward.dao.ContestDao;
import reward.dao.impl.ContestDaoImpl;
import reward.entity.Contest;
import reward.entity.Record;

/**
 * Servlet implementation class AdminContestServlet
 */
@WebServlet("/AdminContestServlet")
public class AdminContestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminContestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("AdminContestServlet:");
		
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		ContestDao contestDao = new ContestDaoImpl();
		Contest contest = contestDao.findContestById(id);
		if(contest == null) {
			System.out.println("没找到比赛");
		}
		RecordBiz recordBiz = new RecordBizImpl();
		Vector<Record> data = recordBiz.listRecordBycontest(contest.getName());
		if (data!= null){
			request.setAttribute("data", data);
		}
		request.setAttribute("contest", contest);
		request.getRequestDispatcher("auth/adminContest.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
