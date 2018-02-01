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
						teamer = new Teamer(name, grade,point);
					}
				}

				return teamer;

			}
		};

		return (Teamer) this.executeQuery(findTeamerByNameProcessor, sql, params);
	}

	@Override
	public Vector<Teamer> getAllTeamers() {
		String sql = "select * from teamer order by point desc";
		Object[] params = { };

		RSProcessor getAllUsersProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				Vector<Teamer> teamers = new Vector<Teamer>();

				while (rs.next()) {
					
					
					String name = rs.getString("name");
					int grade = rs.getInt("grade");
					double point = rs.getDouble("point");
					String sicnuoj = rs.getString("sicnuoj");
				 	String cf = rs.getString("cf");
					String atcoder = rs.getString("atcoder");
					Teamer teamer = new Teamer(name, grade,sicnuoj,cf,atcoder,point);
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

}
