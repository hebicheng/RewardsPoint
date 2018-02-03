package reward.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import reward.dao.BaseDao;
import reward.dao.PartitionPointDao;
import reward.dao.RSProcessor;
import reward.entity.PartitionPoint;

public class PartitionPointDaoImpl extends BaseDao implements PartitionPointDao {

	@Override
	public int countByUsername(String username) {
		String sql = "select count(*) as pp_count from partition_point where username=?";
		Object[] params = {username};
		
		RSProcessor countUserByNameProcessor = new RSProcessor(){

			public Object process(ResultSet rs) throws SQLException {
				int count = 0;
				if(rs != null) {
					if(rs.next()) {
						System.out.println("########");
						count = rs.getInt("pp_count");
						System.out.println(count);
					}
				}
				
				return new Integer(count);
			}

		};
		
		return (Integer)this.executeQuery(countUserByNameProcessor, sql, params);
	}

	@Override
	public int insert(PartitionPoint PPoint) {
		String sql = "insert partition_point (username, trainContest, personContest, solveProblem, attendance) values(?,?,?,?,?)";
		Object[] params = { PPoint.getUsername(), PPoint.getTrainContest(), PPoint.getPersonContest(), PPoint.getSolveProblem(), PPoint.getAttendance()};
		return this.executeUpdate(sql, params);
	}

	@Override
	public int update(PartitionPoint PPoint) {
		String sql = "update partition_point set trainContest=?,personContest=?, solveProblem=?, attendance=? where username=?";
		Object[] params = { PPoint.getTrainContest(), PPoint.getPersonContest(), PPoint.getSolveProblem(), PPoint.getAttendance(), PPoint.getUsername() };
		return this.executeUpdate(sql, params);
	}

	@Override
	public PartitionPoint findByUsername(String username) {
		String sql = "select * from partition_point where username = ?";
		Object[] params = { username };

		RSProcessor findPartitionPointbyUsernameProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				PartitionPoint partitionPoint = null;

				if (rs != null) {
					if (rs.next()) {
						String username = rs.getString("username");
						double trainContest = rs.getDouble("trainContest");
						double personContest = rs.getDouble("personContest");
						double solveProblem = rs.getDouble("solveProblem");
						double attendance = rs.getDouble("attendance");
						partitionPoint = new PartitionPoint(username, trainContest, personContest, solveProblem, attendance);
					}
				}

				return partitionPoint;

			}
		};

		return (PartitionPoint) this.executeQuery(findPartitionPointbyUsernameProcessor, sql, params);
	}


	

}
