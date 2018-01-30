package reward.dao;

import java.util.Vector;

import reward.entity.Contest;

public interface ContestDao {
	public Contest findContestByName(String name);
	public Contest findContestById(int id);
	public Vector<Contest> getAllContests();

	// 添加比赛
	public int insert(Contest contest);
}
