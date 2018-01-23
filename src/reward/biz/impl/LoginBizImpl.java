package reward.biz.impl;

import reward.biz.LoginBiz;
import reward.dao.AdminDao;
import reward.dao.impl.AdminDaoImpl;
import reward.entity.Admin;

public class LoginBizImpl implements LoginBiz{

	AdminDao adminDao = new AdminDaoImpl();
	@Override
	public int login(String username, String password) {
		if (adminDao.countUserByUsername(username) < 1){
			return -1;
		}
		Admin admin = adminDao.findAdminbyUsername(username);
		if(admin.getPassword().equals(password)){
			return 0;
		}
		return 1;
	}

}
