package reward.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reward.dao.impl.TeamerDaoImpl;
import reward.entity.Teamer;

/**
 * Servlet implementation class ReducePointServlet
 */
@WebServlet("/ReducePointServlet")
public class ReducePointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReducePointServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("oprname");
		String point = request.getParameter("score");
		TeamerDaoImpl teamerDaoImpl = new TeamerDaoImpl();
		double oldPoint = teamerDaoImpl.getPointByName(name);
		double newpoint =  oldPoint - Double.parseDouble(point);
		teamerDaoImpl.modifyPointByName(name, newpoint);
		request.setAttribute("remessage", "Saved");
		Teamer teamer = teamerDaoImpl.findTeamerByName(name);
		request.setAttribute("selectteamer", teamer);
		request.getRequestDispatcher("admin?name="+ name).forward(request, response);
		return ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
