package reward.dao;

import reward.entity.PartitionPoint;
import reward.entity.Record;

public interface PartitionPointDao {
	public int countByUsername(String username);
	public int insert(PartitionPoint PPoint);
	public int update(PartitionPoint PPoint);
}
