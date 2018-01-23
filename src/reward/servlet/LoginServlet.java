package reward.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reward.biz.LoginBiz;
import reward.biz.impl.LoginBizImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String username = request.getParameter("userName");
		String password = request.getParameter("pwd");
		LoginBiz loginBiz = new LoginBizImpl();
		int status = loginBiz.login(username, password);
		if(status == 0){
			session.setAttribute("admin", "ONSTATUS");
			response.sendRedirect("opr.jsp");
			return;
		}else if(status == -1){
			request.setAttribute("message", "用户不存在");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}else {
			request.setAttribute("message", "密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
