package reward.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import reward.dao.BaseDao;
import reward.dao.RSProcessor;
import reward.dao.RecordDao;
import reward.entity.Record;

public class RecordDaoImpl extends BaseDao implements RecordDao {

	@Override
	public Record findRecordByTeamerAndContest(String name, String contest) {
		String sql = "select * from record where teamer = ? and contest = ?";
		Object[] params = { name };

		RSProcessor findTeamerByNameProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				Record record = null;

				if (rs != null) {
					if (rs.next()) {
						String teamer = rs.getString("teamer");
						String contest = rs.getString("contest");
						int ac = rs.getInt("ac");
						int rank = rs.getInt("rank");
						int onlyAC = rs.getInt("onlyAC");
						int fb = rs.getInt("fb");
						
						record = new Record(teamer, contest, ac, rank, onlyAC, fb);
					}
				}

				return record;
			}
		};

		return (Record) this.executeQuery(findTeamerByNameProcessor, sql, params);
	}

	@Override
	public int insert(Record record) {
		String sql = "insert record (teamer, contest, ac, rank, onlyAC, fb) values(?,?,?,?,?,?)";
		Object[] params = { record.getTeamer(), record.getContest(), record.getAc(),
				record.getRank(), record.getOnlyAC(), record.getFb()};
		return this.executeUpdate(sql, params);
	}

	@Override
	public int update(Record record) {
		String sql = "update record set ac=?,rank=?,onlyAC=?, fb=? where teamer=? and contest=?";
		Object[] params = { record.getAc(), record.getRank(), record.getOnlyAC(),
				 record.getFb(), record.getTeamer(), record.getContest() };
		return this.executeUpdate(sql, params);
	}

	@Override
	public int delete(Record record) {
		String sql = "delete from record where teamer=? and contest=?";
		Object[] params = { record.getTeamer(), record.getContest() };
		return this.executeUpdate(sql, params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vector<Record> findRecordsByTeamer(String name) {
		String sql = "select * from record where teamer = ?";
		Object[] params = { name };

		RSProcessor getAllUsersProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				Vector<Record> records = new Vector<Record>();

				while (rs.next()) {
					String teamer = rs.getString("teamer");
					String contest = rs.getString("contest");
					int ac = rs.getInt("ac");
					int rank = rs.getInt("rank");
					int onlyAC = rs.getInt("onlyAC");
					int fb = rs.getInt("fb");
					
					Record record = new Record(teamer, contest, ac, rank, onlyAC, fb);
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
