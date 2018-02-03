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
import reward.biz.impl.RecordBizImpl;
import reward.dao.ContestDao;
import reward.dao.impl.ContestDaoImpl;
import reward.entity.Contest;
import reward.entity.Record;

/**
 * Servlet implementation class MineRecordServlet
 */
@WebServlet("/MineRecordServlet")
public class MineRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MineRecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();  
		if(session.getAttribute("type") == null){
			response.sendRedirect("login");
			return;
		}
		
		RecordBiz recordBiz = new RecordBizImpl();
		Vector<Record> data = recordBiz.getRecordsByUsername((String) session.getAttribute("username"));
		if (data!= null){
			request.setAttribute("data", data);
		}
		request.getRequestDispatcher("mine.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
