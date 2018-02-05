package reward.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reward.biz.RecordBiz;
import reward.biz.impl.RecordBizImpl;
import reward.entity.CurrentTime;
import reward.entity.Record;

/**
 * Servlet implementation class AddDailyPracticePoint
 */
@WebServlet(name = "AddDailyPracticePointServlet", urlPatterns = { "/AddDailyPracticePoint" })
public class AddDailyPracticePoint extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDailyPracticePoint() {
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
		String username = request.getParameter("username");
		int rating = Integer.parseInt(request.getParameter("dppoint"));
		RecordBiz recordBiz = new RecordBizImpl();
		Record record = new Record(username, 3, rating, new CurrentTime().getDateString());
		record.setContest("DailyPractice");
		recordBiz.updatePracticePoint(record);
		response.sendRedirect("teamer");
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
