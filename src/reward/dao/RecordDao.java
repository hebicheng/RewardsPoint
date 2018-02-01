package reward.dao;

import java.util.Vector;

import reward.entity.Record;

public interface RecordDao {
	public Record findRecordByTeamerAndContest(String name, String contest);
	public Vector<Record> findRecordsByTeamer(String name);
	
	public int insert(Record record);
	public int update(Record record);
	public int delete(Record record);
	
	public int countRecordByContest(String contest);
}
