package reward.biz;

import java.util.Vector;

import reward.entity.Record;
import reward.entity.Teamer;

public interface RecordBiz {
	Vector<Record> listRecordBycontest(String contest);
	
	boolean updateRecord(Record record);
	
	double getPointByTeamer(Teamer teamer);
	
	int getNumByContest(String contest);
}
