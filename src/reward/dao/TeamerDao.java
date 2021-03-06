package reward.dao;

import java.util.Vector;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

import reward.entity.Teamer;

public interface TeamerDao {
	public Teamer findTeamerByName(String name);
	public Teamer findTeamerByUsername(String name);
	public Vector<Teamer> getAllTeamers();

	public int modifyPointByName(String name, double score);
	public int modifyPointByUsername(String name, double score);
	public Double getPointByName(String name);
	public Teamer findTeamerLoginInfoByUsername(String username);
	public int countUserByUsername(String username);
	public String getTeamerNameByUsername(String username);
	public int ChangePassword(String username, String password);
	public int changeOjUrl(String username, String sicnuoj, String codeforce, String atcoder);
	public int updateTeamerInfo(Teamer teamer);
	public int addteamer(Teamer teamer);
	public int deleteTeamer(String username);
}
