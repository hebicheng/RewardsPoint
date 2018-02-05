package reward.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import reward.dao.BaseDao;
import reward.dao.RSProcessor;
import reward.dao.RecordDao;
import reward.entity.CurrentTime;
import reward.entity.Record;

public class RecordDaoImpl extends BaseDao implements RecordDao {

	@Override
	public Record findRecordByTeamerAndContest(String username, String contest) {
		String sql = "select * from record where username = ? and contest = ?";
		Object[] params = { username, contest };

		RSProcessor findTeamerByNameProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				Record record = null;

				if (rs != null) {
					if (rs.next()) {
						String username = rs.getString("username");
						String contest = rs.getString("contest");
						int rating = rs.getInt("rating");
						int ac = rs.getInt("ac");
						int rank = rs.getInt("rank");
						int onlyAC = rs.getInt("onlyAC");
						int fb = rs.getInt("fb");
						int type = rs.getInt("type");
						String updateTime = rs.getString("updateTime");
						double nowPoint = rs.getDouble("nowPoint");
						record = new Record(username, contest, type, ac, rank, onlyAC, fb, rating, updateTime, nowPoint);
					}
				}

				return record;
			}
		};

		return (Record) this.executeQuery(findTeamerByNameProcessor, sql, params);
	}

	@Override
	public int insert(Record record) {
		String sql = "insert record (username, contest, type, ac, rank, onlyAC, fb, rating, updateTime, nowPoint) values(?,?,?,?,?,?,?,?,?,?)";
		Object[] params = { record.getUsername(), record.getContest(), record.getType(), record.getAc(), record.getRank(),
				record.getOnlyAC(), record.getFb(), record.getRating(), new CurrentTime().getDateString(), record.getNowPoint() };
		return this.executeUpdate(sql, params);
	}

//	@Override
//	public int update(Record record) {
//		String sql = "update record set ac=?,rank=?,onlyAC=?, fb=?, updateTime=? where username=? and contest=?";
//		Object[] params = { record.getAc(), record.getRank(), record.getOnlyAC(), record.getFb(),
//				new CurrentTime().getDateString(), record.getUsername(), record.getContest() };
//		return this.executeUpdate(sql, params);
//	}

	@Override
	public int deleteRecordByTeamerAndContest(String userName, String contest) {
		String sql = "delete from record where username=? and contest=?";
		Object[] params = { userName, contest };
		return this.executeUpdate(sql, params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vector<Record> findRecordsByTeamer(String username) {
		String sql = "select * from record where username = ?";
		Object[] params = { username };

		RSProcessor getAllUsersProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				Vector<Record> records = new Vector<Record>();

				while (rs.next()) {
					String username = rs.getString("username");
					String contest = rs.getString("contest");
					int rating = rs.getInt("rating");
					int ac = rs.getInt("ac");
					int rank = rs.getInt("rank");
					int onlyAC = rs.getInt("onlyAC");
					int fb = rs.getInt("fb");
					int type = rs.getInt("type");
					String updateTime = rs.getString("updateTime");
					double nowPoint = rs.getDouble("nowPoint");
					Record record = new Record(username, contest, type, ac, rank, onlyAC, fb, rating, updateTime, nowPoint);
					records.add(record);
				}
				return records;
			}
		};

		return (Vector<Record>) this.executeQuery(getAllUsersProcessor, sql, params);
	}

	@Override
	public int countRecordByContest(String contest) {
		String sql = "select count(*) as record_count from record where contest=?";
		Object[] params = { contest };

		RSProcessor countUserByNameProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				int count = 0;
				if (rs != null) {
					if (rs.next()) {
						count = rs.getInt("record_count");
					}
				}

				return new Integer(count);
			}

		};

		return (Integer) this.executeQuery(countUserByNameProcessor, sql, params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vector<Record> getRecordsByUsername(String username) {
		String sql = "select * from record where username = ? order by updateTime,nowPoint desc";
		Object[] params = { username };

		RSProcessor getAllUsersProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				Vector<Record> records = new Vector<Record>();

				while (rs.next()) {
					String username = rs.getString("username");
					String contest = rs.getString("contest");
					int rating = rs.getInt("rating");
					int ac = rs.getInt("ac");
					int rank = rs.getInt("rank");
					int onlyAC = rs.getInt("onlyAC");
					int fb = rs.getInt("fb");
					int type = rs.getInt("type");
					String updateTime = rs.getString("updateTime");
					double nowPoint = rs.getDouble("nowPoint");
					Record record = new Record(username, contest, type, ac, rank, onlyAC, fb, rating, updateTime, nowPoint);
					records.add(record);
				}
				return records;
			}
		};

		return (Vector<Record>) this.executeQuery(getAllUsersProcessor, sql, params);
	}

	@Override
	public int deleteTeamerRecord(String username) {
		String sql = "delete from record where username=?";
		Object[] params = { username };
		return this.executeUpdate(sql, params);
	}

}
