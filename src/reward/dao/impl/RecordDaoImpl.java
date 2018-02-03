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
						String name = rs.getString("name");
						String contest = rs.getString("contest");
						int ac = rs.getInt("ac");
						int rank = rs.getInt("rank");
						int onlyAC = rs.getInt("onlyAC");
						int fb = rs.getInt("fb");
						String updateTime = rs.getString("updateTime");
						record = new Record(username, name, contest, ac, rank, onlyAC, fb, updateTime);
					}
				}

				return record;
			}
		};

		return (Record) this.executeQuery(findTeamerByNameProcessor, sql, params);
	}

	@Override
	public int insert(Record record) {
		String sql = "insert record (username, name, contest, ac, rank, onlyAC, fb, updateTime) values(?,?,?,?,?,?,?,?)";
		Object[] params = { record.getUsername(),record.getName(), record.getContest(), record.getAc(),
				record.getRank(), record.getOnlyAC(), record.getFb(), new CurrentTime().getDateString()};
		return this.executeUpdate(sql, params);
	}

	@Override
	public int update(Record record) {
		String sql = "update record set ac=?,rank=?,onlyAC=?, fb=?, updateTime=? where username=? and contest=?";
		Object[] params = { record.getAc(), record.getRank(), record.getOnlyAC(),record.getFb(), 
							new CurrentTime().getDateString(), record.getUsername(), record.getContest() };
		return this.executeUpdate(sql, params);
	}

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
					String name = rs.getString("name");
					String contest = rs.getString("contest");
					int ac = rs.getInt("ac");
					int rank = rs.getInt("rank");
					int onlyAC = rs.getInt("onlyAC");
					int fb = rs.getInt("fb");
					String updateTime = rs.getString("updateTime");
					
					Record record = new Record(username, name, contest, ac, rank, onlyAC, fb, updateTime);
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

}
