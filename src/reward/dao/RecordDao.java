package reward.dao;

import reward.entity.Record;

public interface RecordDao {
	public Record findRecordByTeamer(String name);
	
	public int insert(Record record);
	public int update(Record record);
	public int delete(Record record);
}
