package reward.biz;

import java.util.Vector;

import reward.entity.Record;
import reward.entity.Teamer;

public interface TeamerBiz {
	public Vector<Teamer> listTeamerByRecord(Vector<Record> records);
	public int changeOjUrl(String username, String sicnuoj, String codeforce, String atcoder);
	public Teamer getTeamerByUsername(String username);
	public int updateTeamerInfo(Teamer teamer);
	public int addTeamer(Teamer teamer);
	public int deleteTeamer(String username);

}
