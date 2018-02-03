package reward.biz.impl;

import reward.biz.ChangePasswordBiz;
import reward.biz.CreateMD5Password;
import reward.dao.TeamerDao;
import reward.dao.impl.TeamerDaoImpl;

public class ChangePasswordBizImpl implements ChangePasswordBiz {
	TeamerDao teamerDao = new TeamerDaoImpl();
	CreateMD5Password createMD5Password = new CreateMD5PasswordImpl();
	@Override
	public int changePassword(String username, String password) {
		password = createMD5Password.CreatePassword(password);
		if(teamerDao.ChangePassword(username, password)>0){
			return 0;
		}
		return 1;
		
	}
	

}
