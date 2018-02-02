package reward.biz;

public interface LoginBiz {
	public int login(String username, String password);
	public int adminLogin(String username, String password);
	public String getNameByUsername(String username);
}
