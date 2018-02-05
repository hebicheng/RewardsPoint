package reward.dao;

import reward.entity.PartitionPoint;

public interface PartitionPointDao {
	public int countByUsername(String username);
	public PartitionPoint findByUsername(String username);
	public int insert(PartitionPoint PPoint);
	public int update(PartitionPoint PPoint);
	public int deleteTeamerPartitionPoint(String username);
}
