package reward.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import reward.dao.BaseDao;
import reward.dao.RSProcessor;
import reward.dao.TeamerDao;
import reward.entity.Teamer;

public class TeamerDaoImpl extends BaseDao implements TeamerDao {

	@Override
	public Teamer findTeamerByName(String name) {
		String sql = "select * from teamer where name = ?";
		Object[] params = { name };

		RSProcessor findTeamerByNameProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				Teamer teamer = null;

				if (rs != null) {
					if (rs.next()) {
						String name = rs.getString("name");
						int grade = rs.getInt("grade");
						double point = rs.getInt("point");
						String cf = rs.getString("cf");
						String atcoder = rs.getString("atcoder");
						String sicnuoj = rs.getString("sicnuoj");
						teamer = new Teamer(name, grade, point,sicnuoj, cf, atcoder);
					}
				}

				return teamer;

			}
		};

		return (Teamer) this.executeQuery(findTeamerByNameProcessor, sql, params);
	}

	@Override
	public Teamer findTeamerByUsername(String name) {
		String sql = "select * from teamer where username = ?";
		Object[] params = { name };

		RSProcessor findTeamerByNameProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				Teamer teamer = null;

				if (rs != null) {
					if (rs.next()) {
						String name = rs.getString("name");
						int grade = rs.getInt("grade");
						double point = rs.getInt("point");
						String cf = rs.getString("cf");
						String atcoder = rs.getString("atcoder");
						String sicnuoj = rs.getString("sicnuoj");
						teamer = new Teamer(name, grade, point,sicnuoj, cf, atcoder);
					}
				}

				return teamer;

			}
		};

		return (Teamer) this.executeQuery(findTeamerByNameProcessor, sql, params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vector<Teamer> getAllTeamers() {
		String sql = "select * from teamer order by point desc";
		Object[] params = {};

		RSProcessor getAllUsersProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				Vector<Teamer> teamers = new Vector<Teamer>();

				while (rs.next()) {

					String username = rs.getString("username");
					String name = rs.getString("name");
					int grade = rs.getInt("grade");
					double point = rs.getDouble("point");
					String sicnuoj = rs.getString("sicnuoj");
					String cf = rs.getString("cf");
					String atcoder = rs.getString("atcoder");
					Teamer teamer = new Teamer(username, name, grade, sicnuoj, cf, atcoder, point);
					teamers.add(teamer);
				}
				return teamers;
			}
		};

		return (Vector<Teamer>) this.executeQuery(getAllUsersProcessor, sql, params);
	}

	@Override
	public int modifyPointByName(String name, double score) {
		String sql = "update teamer set point=? where name=?";
		Object[] params = { score, name };
		return this.executeUpdate(sql, params);
	}

	@Override
	public int modifyPointByUsername(String name, double score) {
		String sql = "update teamer set point=? where username=?";
		Object[] params = { score, name };
		return this.executeUpdate(sql, params);
	}

	@Override
	public Double getPointByName(String name) {
		String sql = "select point from teamer where name=?";
		Object[] params = { name };

		RSProcessor getPointByNameProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				double point = 0;
				if (rs != null) {
					if (rs.next()) {
						point = rs.getDouble("point");
					}
				}
				return point;
			}
		};

		return (Double) this.executeQuery(getPointByNameProcessor, sql, params);
	}

	@Override
	public Teamer findTeamerLoginInfoByUsername(String username) {
		String sql = "select * from teamer where username = ?";
		Object[] params = { username };

		RSProcessor findAdminbyUsernameProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				Teamer teamer = null;

				if (rs != null) {
					if (rs.next()) {
						String username = rs.getString("username");
						String password = rs.getString("password");
						teamer = new Teamer(username, password);
					}
				}

				return teamer;

			}
		};

		return (Teamer) this.executeQuery(findAdminbyUsernameProcessor, sql, params);
	}

	@Override
	public int countUserByUsername(String username) {
		String sql = "select count(*) as user_count from teamer where username=?";
		Object[] params = { username };

		RSProcessor countUserByNameProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				int count = 0;
				if (rs != null) {
					if (rs.next()) {
						System.out.println("########");
						count = rs.getInt("user_count");
						System.out.println(count);
					}
				}

				return new Integer(count);
			}

		};

		return (Integer) this.executeQuery(countUserByNameProcessor, sql, params);
	}

	@Override
	public String getTeamerNameByUsername(String username) {
		String sql = "select name from teamer where username=?";
		Object[] params = { username };

		RSProcessor getPointByNameProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				String name = null;
				if (rs != null) {
					if (rs.next()) {
						name = rs.getString("name");
					}
				}
				return name;
			}
		};

		return (String) this.executeQuery(getPointByNameProcessor, sql, params);
	}

	@Override
	public int ChangePassword(String username, String password) {
		String sql = "update teamer set password=? where username=?";
		Object[] params = { password, username };
		return this.executeUpdate(sql, params);

	}

	@Override
	public int changeOjUrl(String username, String sicnuoj, String codeforce, String atcoder) {
		String sql = "update teamer set sicnuoj=?, cf=?, atcoder=? where username=?";
		Object[] params = { sicnuoj, codeforce, atcoder, username};
		return this.executeUpdate(sql, params);
	}

	@Override
	public int updateTeamerInfo(Teamer teamer) {
		String sql = "update teamer set password=?, name=?, grade=?,sicnuoj=?, cf=?, atcoder=? where username=?";
		Object[] params = { teamer.getPassword(), teamer.getName(), teamer.getGrade(), teamer.getSicnuoj(), teamer.getCf(), teamer.getAtcoder(), teamer.getUsername()};
		return this.executeUpdate(sql, params);
	}

}
