package reward.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import reward.dao.AdminDao;
import reward.dao.BaseDao;
import reward.dao.RSProcessor;
import reward.entity.Admin;

public class AdminDaoImpl extends BaseDao implements AdminDao {

	@Override
	public Admin findAdminbyUsername(String username) {
		String sql = "select * from admin where username = ?";
		Object[] params = { username };

		RSProcessor findAdminbyUsernameProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				Admin admin = null;

				if (rs != null) {
					if (rs.next()) {
						String username = rs.getString("username");
						String password = rs.getString("password");
						admin = new Admin(username, password);
					}
				}

				return admin;

			}
		};

		return (Admin) this.executeQuery(findAdminbyUsernameProcessor, sql, params);
	}

	@Override
	public int countUserByUsername(String username) {
		String sql = "select count(*) as user_count from admin where username=?";
		Object[] params = {username};
		
		RSProcessor countUserByNameProcessor = new RSProcessor(){

			public Object process(ResultSet rs) throws SQLException {
				int count = 0;
				if(rs != null) {
					if(rs.next()) {
						System.out.println("########");
						count = rs.getInt("user_count");
						System.out.println(count);
					}
				}
				
				return new Integer(count);
			}

		};
		
		return (Integer)this.executeQuery(countUserByNameProcessor, sql, params);
	}

}
