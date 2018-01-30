package reward.biz;

import java.util.Vector;

import reward.entity.Record;

public interface RecordBiz {
	Vector<Record> listRecordBycontest(String contest);
	
	boolean updateRecord(Record record);
}
