package reward.biz;

import java.util.Vector;

import reward.entity.Contest;
import reward.entity.Record;

public interface RecordBiz {
	Vector<Record> listRecordByContest(Contest contest);

	Vector<Record> getRecordsByUsername(String username);

	boolean updateTrainContestRecord(Record record, int num);

	boolean updatePersonContest(Record record);
	
	boolean updatePracticePoint(Record record);
	
	boolean updateAttendancePoint(Record record);

	// double getPointByTeamer(Teamer teamer);

	int getNumByContest(String contest);
}
