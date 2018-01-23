package reward.dao;

import java.util.Vector;

import reward.entity.Teamer;

public interface TeamerDao {
	public Teamer findTeamerByName(String name);
	public Vector<Teamer> getAllTeamers();

	public int modifyPointByName(String name, double score);
	public Double getPointByName(String name);

}
