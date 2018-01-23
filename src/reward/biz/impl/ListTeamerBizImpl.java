package reward.biz.impl;

import java.util.Vector;

import reward.biz.ListTeamerBiz;
import reward.dao.TeamerDao;
import reward.dao.impl.TeamerDaoImpl;
import reward.entity.Teamer;

public class ListTeamerBizImpl implements ListTeamerBiz {
	TeamerDao teamerDao = new TeamerDaoImpl();
	@Override
	public Vector<Teamer> ListAllTeamers() {
		
		// TODO Auto-generated method stub
		return teamerDao.getAllTeamers();
	}

}
