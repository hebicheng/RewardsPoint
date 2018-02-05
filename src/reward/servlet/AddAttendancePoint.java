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
 * Servlet implementation class AddAttendancePoint
 */
@WebServlet(name = "AddAttendancePointServlet", urlPatterns = { "/AddAttendancePoint" })
public class AddAttendancePoint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAttendancePoint() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		int rating = Integer.parseInt(request.getParameter("attendancepoint"));
		RecordBiz recordBiz = new RecordBizImpl();
		Record record = new Record(username, 4, rating, new CurrentTime().getDateString());
		record.setContest("attendance");
		recordBiz.updateAttendancePoint(record);
		response.sendRedirect("teamer");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
