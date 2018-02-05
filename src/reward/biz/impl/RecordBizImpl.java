package reward.biz.impl;

import java.util.Vector;

import reward.biz.PartitionPointBiz;
import reward.biz.RecordBiz;
import reward.dao.RecordDao;
import reward.dao.TeamerDao;
import reward.dao.impl.RecordDaoImpl;
import reward.dao.impl.TeamerDaoImpl;
import reward.entity.Contest;
import reward.entity.Record;
import reward.entity.Teamer;

public class RecordBizImpl implements RecordBiz {
	private RecordDao recordDao = new RecordDaoImpl();

	@Override
	public Vector<Record> listRecordByContest(Contest contest) {
		Vector<Record> records = new Vector<Record>();
		TeamerDao teamerDao = new TeamerDaoImpl();
		Vector<Teamer> teamers = teamerDao.getAllTeamers();
		for (Teamer teamer : teamers) {
			Record record = recordDao.findRecordByTeamerAndContest(teamer.getUsername(), contest.getName());
			if (record == null) {
				record = new Record(teamer.getUsername(), contest.getName());
				if (contest.getOj().equals("codeforces")) {
					record.setType(1);
				} else if (contest.getOj().equals("AtCoder")) {
					record.setType(2);
				}
				records.add(0, record);
			} else {
				if (contest.getType() == 0) {
					record.calcScore(contest.getNum());
				} else {
					record.calcScore();
				}
				records.add(record);
			}
		}
		return records;
	}

	@Override
	public boolean updateTrainContestRecord(Record record, int num) {
		Record oldRecord = recordDao.findRecordByTeamerAndContest(record.getUsername(), record.getContest());

		recordDao.deleteRecordByTeamerAndContest(record.getUsername(), record.getContest());

		record.calcScore(num);
		double newPoint = record.getScore();
		double oldPoint;
		if (oldRecord == null) {
			oldPoint = 0;
		} else {
			oldRecord.calcScore(num);
			oldPoint = oldRecord.getScore();
		}
		double dPoint = newPoint - oldPoint;
		PartitionPointBiz pBiz = new PartitionPointBizImpl();
		double nowPoint = pBiz.updateTrainContest(record.getUsername(), dPoint);
		record.setNowPoint(nowPoint);
		recordDao.insert(record);
		return true;
	}

	@Override
	public boolean updatePersonContest(Record record) {
		Record oldRecord = recordDao.findRecordByTeamerAndContest(record.getUsername(), record.getContest());

		recordDao.deleteRecordByTeamerAndContest(record.getUsername(), record.getContest());

		record.calcScore();
		double newPoint = record.getScore();
		double oldPoint;
		if (oldRecord == null) {
			oldPoint = 0;
		} else {
			oldRecord.calcScore();
			oldPoint = oldRecord.getScore();
		}
		double dPoint = newPoint - oldPoint;
		PartitionPointBiz pBiz = new PartitionPointBizImpl();
		double nowPoint = pBiz.updatePersonContest(record.getUsername(), dPoint);
		record.setNowPoint(nowPoint);
		recordDao.insert(record);
		return true;
	}

	@Override
	public int getNumByContest(String contest) {
		return recordDao.countRecordByContest(contest);
	}

	@Override
	public Vector<Record> getRecordsByUsername(String username) {
		return recordDao.getRecordsByUsername(username);
	}

	@Override
	public boolean updatePracticePoint(Record record) {
		record.calcScore();
		double dPoint = record.getScore();
		PartitionPointBiz pBiz = new PartitionPointBizImpl();
		double nowPoint = pBiz.updateSolveProblem(record.getUsername(), dPoint);
		record.setNowPoint(nowPoint);
		recordDao.insert(record);
		return true;
	}

	@Override
	public boolean updateAttendancePoint(Record record) {
		record.calcScore();
		double dPoint = record.getScore();
		PartitionPointBiz pBiz = new PartitionPointBizImpl();
		double nowPoint = pBiz.updateAttendance(record.getUsername(), dPoint);
		record.setNowPoint(nowPoint);
		recordDao.insert(record);
		return true;
	}

}
