package reward.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import reward.dao.BaseDao;
import reward.dao.ContestDao;
import reward.dao.RSProcessor;
import reward.entity.Contest;

public class ContestDaoImpl extends BaseDao implements ContestDao {

	@Override
	public Contest findContestByName(String name) {
		String sql = "select * from contest where name = ?";
		Object[] params = { name };

		RSProcessor findTeamerByNameProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				Contest contest = null;

				if (rs != null) {
					if (rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String content = rs.getString("content");
						String type = rs.getString("type");
						int weight = rs.getInt("weight");
						Date time = rs.getDate("time");
						String oj = rs.getString("oj");
						String url = rs.getString("url");
						contest = new Contest(id, name, content, type, weight, time, oj, url);
					}
				}

				return contest;

			}
		};

		return (Contest) this.executeQuery(findTeamerByNameProcessor, sql, params);
	}

	@Override
	public Contest findContestById(int id) {
		String sql = "select * from contest where id = ?";
		Object[] params = { id };

		RSProcessor findTeamerByNameProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				Contest contest = null;

				if (rs != null) {
					if (rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String content = rs.getString("content");
						String type = rs.getString("type");
						int weight = rs.getInt("weight");
						Date time = rs.getDate("time");
						String oj = rs.getString("oj");
						String url = rs.getString("url");
						contest = new Contest(id, name, content, type, weight, time, oj, url);
					}
				}

				return contest;

			}
		};

		return (Contest) this.executeQuery(findTeamerByNameProcessor, sql, params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vector<Contest> getAllContests() {
		String sql = "select * from contest order by time desc";
		Object[] params = {};

		RSProcessor getAllUsersProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				Vector<Contest> contests = new Vector<Contest>();

				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String content = rs.getString("content");
					String type = rs.getString("type");
					int weight = rs.getInt("weight");
					Date time = rs.getDate("time");
					String oj = rs.getString("oj");
					String url = rs.getString("url");
					Contest contest = new Contest(id, name, content, type, weight, time, oj, url);
					contests.add(contest);
				}
				return contests;
			}
		};

		return (Vector<Contest>) this.executeQuery(getAllUsersProcessor, sql, params);
	}

	@Override
	public int insert(Contest contest) {
		String sql = "insert contest (name, content, type, weight, time, oj, url) values(?,?,?,?,?,?,?)";
		Object[] params = { contest.getName(), contest.getContent(), contest.getType(), contest.getWeight(),
				contest.getTime(), contest.getOj(), contest.getUrl() };
		return this.executeUpdate(sql, params);
	}

}
