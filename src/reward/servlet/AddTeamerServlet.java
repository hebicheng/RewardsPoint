package reward.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reward.biz.CreateMD5Password;
import reward.biz.TeamerBiz;
import reward.biz.impl.CreateMD5PasswordImpl;
import reward.biz.impl.TeamerBizImpl;
import reward.entity.Teamer;

/**
 * Servlet implementation class AddTeamerServlet
 */
@WebServlet("/AddTeamerServlet")
public class AddTeamerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeamerServlet() {
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
		String username = request.getParameter("add_username");
		String name = request.getParameter("add_name");
		int grade = Integer.parseInt(request.getParameter("add_grade"));
		String password = request.getParameter("add_password");
		String sicnuoj = request.getParameter("add_sicnuoj");
		String codeforces = request.getParameter("add_codeforces");
		String atcoder = request.getParameter("add_atcoder");
		TeamerBiz teamerBiz = new TeamerBizImpl();
		Teamer teamer = new Teamer(username, password, name,grade,sicnuoj,codeforces,atcoder);
		teamerBiz.addTeamer(teamer);
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
