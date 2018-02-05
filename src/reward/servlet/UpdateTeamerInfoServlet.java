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
import reward.dao.TeamerDao;
import reward.dao.impl.TeamerDaoImpl;
import reward.entity.Teamer;

/**
 * Servlet implementation class UpdateTeamerInfoServlet
 */
@WebServlet("/UpdateTeamerInfoServlet")
public class UpdateTeamerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTeamerInfoServlet() {
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
		CreateMD5Password createMD5Password = new CreateMD5PasswordImpl();
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		int grade = Integer.parseInt(request.getParameter("grade"));
		String password = request.getParameter("password");
		String sicnuoj = request.getParameter("sicnuoj");
		String codeforces = request.getParameter("codeforces");
		String atcoder = request.getParameter("atcoder");
		TeamerBiz teamerBiz = new TeamerBizImpl();
		TeamerDao teamerDao = new TeamerDaoImpl();
		Teamer teamer = null;
		System.out.println(username);
		if(password.trim().equals("")){
			System.out.println(username);
			 password = teamerDao.findTeamerLoginInfoByUsername(username).getPassword();
		}else {
			password = createMD5Password.CreatePassword(password);
		}
		teamer = new Teamer(username, password, name, grade, sicnuoj, codeforces, atcoder);
		
		teamerBiz.updateTeamerInfo(teamer);
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
