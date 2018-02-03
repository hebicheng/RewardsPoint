package reward.dao;

import java.util.Vector;

import reward.entity.Teamer;

public interface TeamerDao {
	public Teamer findTeamerByName(String name);
	public Vector<Teamer> getAllTeamers();

	public int modifyPointByName(String name, double score);
	public Double getPointByName(String name);
	public Teamer findTeamerLoginInfoByUsername(String username);
	public int countUserByUsername(String username);
	public String getTeamerNameByUsername(String username);
	public int ChangePassword(String username, String password);

}
