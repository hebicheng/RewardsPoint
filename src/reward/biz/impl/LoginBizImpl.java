package reward.biz.impl;

import reward.biz.CreateMD5Password;
import reward.biz.LoginBiz;
import reward.dao.AdminDao;
import reward.dao.TeamerDao;
import reward.dao.impl.AdminDaoImpl;
import reward.dao.impl.TeamerDaoImpl;
import reward.entity.Admin;
import reward.entity.Teamer;

public class LoginBizImpl implements LoginBiz{

	TeamerDao teamerDao = new TeamerDaoImpl();
	AdminDao adminDao = new AdminDaoImpl();
	CreateMD5Password createMD5Password = new CreateMD5PasswordImpl();
	@Override
	public int login(String username, String password) {
		if (teamerDao.countUserByUsername(username) < 1){
			return -1;
		}
		Teamer teamer = teamerDao.findTeamerLoginInfoByUsername(username);
		password = createMD5Password.CreatePassword(password);
		if(teamer.getPassword().equals(password)){
			return 0;
		}
		return 1;
	}
	@Override
	public int adminLogin(String username, String password) {
		if (adminDao.countUserByUsername(username) < 1){
			return -1;
		}
		Admin admin = adminDao.findAdminbyUsername(username);
		if(admin.getPassword().equals(password)){
			return 0;
		}
		return 1;
	}
	@Override
	public String getNameByUsername(String username) {
		return teamerDao.getTeamerNameByUsername(username);
	}

}
