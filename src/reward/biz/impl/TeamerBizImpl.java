package reward.biz.impl;

import java.util.Vector;

import reward.biz.TeamerBiz;
import reward.dao.TeamerDao;
import reward.dao.impl.TeamerDaoImpl;
import reward.entity.Record;
import reward.entity.Teamer;

public class TeamerBizImpl implements TeamerBiz {

	private TeamerDao teamerDao = new TeamerDaoImpl(); 
	@Override
	public Vector<Teamer> listTeamerByRecord(Vector<Record> records) {
		Vector<Teamer> teamers = new Vector<>();
		for(Record record:records) {
			Teamer teamer = teamerDao.findTeamerByUsername(record.getUsername());
			teamers.add(teamer);
		}
		return teamers;
	}
	@Override
	public int changeOjUrl(String username, String sicnuoj, String codeforce, String atcoder) {
		teamerDao.changeOjUrl(username, sicnuoj, codeforce, atcoder);
		return 0;
	}
	@Override
	public Teamer getTeamerByUsername(String username) {
		Teamer teamer = teamerDao.findTeamerByUsername(username);
		return teamer;
	}

}
