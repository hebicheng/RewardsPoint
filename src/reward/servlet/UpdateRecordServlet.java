package reward.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reward.biz.RecordBiz;
import reward.biz.impl.RecordBizImpl;
import reward.dao.ContestDao;
import reward.dao.impl.ContestDaoImpl;
import reward.entity.Contest;
import reward.entity.CurrentTime;
import reward.entity.Record;

/**
 * Servlet implementation class UpdateRecordServlet
 */
@WebServlet("/UpdateRecordServlet")
public class UpdateRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateRecordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if (session.getAttribute("type") == null) {
			response.sendRedirect("login");
			return;
		}
		String username = request.getParameter("username");
		int id = Integer.parseInt(request.getParameter("id"));
		ContestDao contestDao = new ContestDaoImpl();
		Contest contest = contestDao.findContestById(id);
		int type = contest.getType();
		RecordBiz recordBiz = new RecordBizImpl();
		if (type == 0) {
			System.out.println("trainContest:");
			int ac = Integer.parseInt(request.getParameter("ac"));
			int rank = Integer.parseInt(request.getParameter("rank"));
			int onlyAC = Integer.parseInt(request.getParameter("onlyAC"));
			int fb = Integer.parseInt(request.getParameter("fb"));
			int num = contest.getNum();
			Record record = new Record(username, contest.getName(), ac, rank, onlyAC, fb, new CurrentTime().getDateString());
			recordBiz.updateTrainContestRecord(record, num);
		} else {
			System.out.println("personContests:");
			int rating = Integer.parseInt(request.getParameter("rating"));
			Record record;
			if (contest.getOj().equals("codeforces")) {
				record = new Record(username, contest.getName(), 1, rating, new CurrentTime().getDateString());
			} else {
				record = new Record(username, contest.getName(), 2, rating, new CurrentTime().getDateString());
			}
			recordBiz.updatePersonContest(record);
		}
		response.sendRedirect("contest?id=" + id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
