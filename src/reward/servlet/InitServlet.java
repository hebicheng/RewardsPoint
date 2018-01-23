package reward.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import reward.dao.BaseDao;

@SuppressWarnings("serial")
public class InitServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext context = config.getServletContext();
		String sqlDialect = context.getInitParameter("sql_dialect");
		BaseDao.sqlDialect = sqlDialect;
	
		String dataSource = context.getInitParameter("data_source");
		BaseDao.dataSource = dataSource;
		
	}
	
}
