package reward.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reward.biz.RecordBiz;
import reward.biz.TeamerBiz;
import reward.biz.impl.RecordBizImpl;
import reward.biz.impl.TeamerBizImpl;
import reward.dao.ContestDao;
import reward.dao.impl.ContestDaoImpl;
import reward.entity.Contest;
import reward.entity.Record;
import reward.entity.Teamer;

/**
 * Servlet implementation class AdminContestServlet
 */
@WebServlet("/AdminContestServlet")
public class ContestDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContestDetailServlet() {
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
			response.sendRedirect("login");
			return;
		}
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		ContestDao contestDao = new ContestDaoImpl();
		Contest contest = contestDao.findContestById(id);
		if(contest == null) {
			System.out.println("Contest not find.");
		}
		RecordBiz recordBiz = new RecordBizImpl();
		Vector<Record> records = recordBiz.listRecordByContest(contest);
		if (records!= null){
			TeamerBiz teamerBiz = new TeamerBizImpl();
			Vector<Teamer> teamers = teamerBiz.listTeamerByRecord(records);
			request.setAttribute("data", records);
			request.setAttribute("teamers", teamers);
		}
		request.setAttribute("contest", contest);
		request.getRequestDispatcher("contestdetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
