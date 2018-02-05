package reward.biz.impl;

import java.util.Vector;

import reward.biz.CreateMD5Password;
import reward.biz.TeamerBiz;
import reward.dao.PartitionPointDao;
import reward.dao.RecordDao;
import reward.dao.TeamerDao;
import reward.dao.impl.PartitionPointDaoImpl;
import reward.dao.impl.RecordDaoImpl;
import reward.dao.impl.TeamerDaoImpl;
import reward.entity.Record;
import reward.entity.Teamer;

public class TeamerBizImpl implements TeamerBiz {

	private TeamerDao teamerDao = new TeamerDaoImpl(); 
	CreateMD5Password createMD5Password = new CreateMD5PasswordImpl();
	RecordDao recordDao = new RecordDaoImpl();
	PartitionPointDao partitionPointDao = new PartitionPointDaoImpl();
	
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
	@Override
	public int updateTeamerInfo(Teamer teamer) {
		teamerDao.updateTeamerInfo(teamer);
		return 0;
	}
	@Override
	public int addTeamer(Teamer teamer) {
		int count = teamerDao.countUserByUsername(teamer.getUsername());
		if(count>0){
			return 1;
		}
		teamer.setPassword(createMD5Password.CreatePassword(teamer.getPassword()));
		teamerDao.addteamer(teamer);
		return 0;
	}
	@Override
	public int deleteTeamer(String username) {
		partitionPointDao.deleteTeamerPartitionPoint(username);
		recordDao.deleteTeamerRecord(username);
		teamerDao.deleteTeamer(username);
		return 0;
	}

}
