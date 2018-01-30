package reward.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reward.biz.RecordBiz;
import reward.biz.impl.RecordBizImpl;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String teamer = request.getParameter("teamer");
		String contest = request.getParameter("contest");
		int id = Integer.parseInt(request.getParameter("id"));
		int ac = Integer.parseInt(request.getParameter("ac"));
		int rank = Integer.parseInt(request.getParameter("rank"));
		int onlyAC = Integer.parseInt(request.getParameter("onlyAC"));
		int fb = Integer.parseInt(request.getParameter("fb"));
		System.out.println("UpdateRecordServlet");
		Record record = new Record(teamer, contest, ac, rank, onlyAC, fb);
		RecordBiz recordBiz = new RecordBizImpl();
		recordBiz.updateRecord(record);
		response.sendRedirect("ac?id="+id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
