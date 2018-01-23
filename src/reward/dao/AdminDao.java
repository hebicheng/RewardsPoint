package reward.dao;

import reward.entity.Admin;

public interface AdminDao {
	public Admin findAdminbyUsername(String username);
	public int countUserByUsername(String username);
}
