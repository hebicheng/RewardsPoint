package reward.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reward.biz.ChangePasswordBiz;
import reward.biz.TeamerBiz;
import reward.biz.impl.ChangePasswordBizImpl;
import reward.biz.impl.TeamerBizImpl;
import reward.dao.TeamerDao;
import reward.dao.impl.TeamerDaoImpl;

/**
 * Servlet implementation class ChangeOjUrlServlet
 */
@WebServlet("/ChangeOjUrlServlet")
public class ChangeOjUrlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeOjUrlServlet() {
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
			response.sendRedirect("login");
			return;
		}
		String username = (String) session.getAttribute("username");
		String sicnuoj = request.getParameter("sicnuoj");
		String codeforces = request.getParameter("codeforces");
		String atcoder = request.getParameter("atcoder");
		TeamerBiz teamerBiz = new TeamerBizImpl();

		int status = teamerBiz.changeOjUrl(username, sicnuoj, codeforces, atcoder);
		if(status == 0){
			request.setAttribute("curlmessage", "Saved.");
		}
		request.getRequestDispatcher("account").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
