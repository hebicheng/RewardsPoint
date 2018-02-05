package reward.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reward.biz.TeamerBiz;
import reward.biz.impl.TeamerBizImpl;

/**
 * Servlet implementation class DeleteTeamerServlet
 */
@WebServlet("/DeleteTeamerServlet")
public class DeleteTeamerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTeamerServlet() {
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
		if(session.getAttribute("type") == null){
			response.sendRedirect("admin");
			return;
		}
		if((int)session.getAttribute("type") != 0){
			session.invalidate();
			response.sendRedirect("admin");
			return;
		}
		String username = request.getParameter("delete_username");
		
		TeamerBiz teamerBiz = new TeamerBizImpl();
		teamerBiz.deleteTeamer(username);
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
