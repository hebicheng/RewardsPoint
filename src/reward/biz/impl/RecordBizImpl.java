package reward.biz.impl;

import java.text.DecimalFormat;
import java.util.Vector;

import reward.biz.RecordBiz;
import reward.dao.PartitionPointDao;
import reward.dao.RecordDao;
import reward.dao.TeamerDao;
import reward.dao.impl.PartitionPointDaoImpl;
import reward.dao.impl.RecordDaoImpl;
import reward.dao.impl.TeamerDaoImpl;
import reward.entity.CurrentTime;
import reward.entity.PartitionPoint;
import reward.entity.Record;
import reward.entity.Teamer;

public class RecordBizImpl implements RecordBiz {
	private RecordDao recordDao = new RecordDaoImpl();

	@Override
	public Vector<Record> listRecordBycontest(String contest) {
		Vector<Record> records = new Vector<Record>();
		TeamerDao teamerDao = new TeamerDaoImpl();
		Vector<Teamer> teamers = teamerDao.getAllTeamers();
		for (Teamer teamer : teamers) {
			Record record = recordDao.findRecordByTeamerAndContest(teamer.getUsername(), contest);
			if (record == null) {
				record = new Record(teamer.getUsername(), teamer.getName(), contest);
				records.add(0, record);
			} else {
				records.add(record);
			}
		}
		return records;
	}

	@Override
	public boolean updateRecord(Record record) {
		Record oldRecord = recordDao.findRecordByTeamerAndContest(record.getUsername(), record.getContest());
		
		recordDao.deleteRecordByTeamerAndContest(record.getUsername(), record.getContest());
		if (recordDao.insert(record) != 0) {
			double newPoint = getPointByRecord(record);
			PartitionPointDao pointDao = new PartitionPointDaoImpl();
			PartitionPoint partitionPoint = pointDao.findByUsername(record.getUsername());
			if(partitionPoint == null) {
				partitionPoint = new PartitionPoint(record.getUsername(), newPoint, 0, 0, 0);
				pointDao.insert(partitionPoint);
				updateTeamerRecord(partitionPoint);
			} else {
				double oldPoint;
				if(oldRecord == null) {
					oldPoint = 0;
				} else {
					oldPoint = getPointByRecord(oldRecord);
				}
				double dPoint = newPoint - oldPoint;
				partitionPoint.setTrainContest(partitionPoint.getTrainContest() + dPoint);
				System.out.println("老成绩:"+partitionPoint.getTrainContest());
				System.out.println("变化:"+dPoint);
				System.out.println("新成绩："+(partitionPoint.getTrainContest() + dPoint));
				pointDao.update(partitionPoint);
				updateTeamerRecord(partitionPoint);
			}
			return true;
		}
		return false;
	}

	private void updateTeamerRecord(PartitionPoint partitionPoint) {
		TeamerDao teamerDao = new TeamerDaoImpl();
		Teamer teamer = teamerDao.findTeamerByUsername(partitionPoint.getUsername());
		double t = partitionPoint.getTrainContest();
		double c = partitionPoint.getPersonContest();
		double p = partitionPoint.getSolveProblem();
		double d = partitionPoint.getAttendance();
		double k = 0;
		switch (Integer.parseInt(new CurrentTime().getYearString()) - teamer.getGrade()) {
		case 0:
		case 1:
			k = 1.5;
			break;
		case 2:
			k = 1.25;
			break;
		case 3:
			k = 1;
			break;
		}
		double point = (0.4 * t + 0.3 * c + 0.2 * p + 0.1 * d) * k;
		new DecimalFormat("#.0").format(point);
//		teamer.setPoint(point);
		System.out.println(point);
		teamerDao.modifyPointByUsername(partitionPoint.getUsername(), point);
		return ;
	}
	
	public double getPointByRecord(Record record) {
		if (true) { // 训练赛
			double t = 0;
			t += record.getAc();
			t += 0.5 * record.getOnlyAC();
			t += 0.2 * record.getFb();
			int rank = record.getRank();
			int num = getNumByContest(record.getContest());
			if (rank * 10 < num) {
				t += 4;
			} else if (rank * 10 < 3 * num) {
				t += 3;
			} else if (rank * 10 < 6 * num) {
				t += 2;
			} else {
				t += 1;
			}
			new DecimalFormat("#.0").format(t);
			return t;
		}
		// TODO 
		return 0;
	}

	@Override
	public double getPointByTeamer(Teamer teamer) {
		double t = 0;
		double c = 0;
		double p = 0;
		double d = 0;
		Vector<Record> records = recordDao.findRecordsByTeamer(teamer.getName());
		if (records != null) {
			for (Record record : records) {
				t += record.getAc();
				t += 0.5 * record.getOnlyAC();
				t += 0.2 * record.getFb();
				int rank = record.getRank();
				int num = getNumByContest(record.getContest());
				if (rank * 10 < num) {
					t += 4;
				} else if (rank * 10 < 3 * num) {
					t += 3;
				} else if (rank * 10 < 6 * num) {
					t += 2;
				} else {
					t += 1;
				}
			}
		}
		/*
		 * 2015:1 2016:1.25 2017:1.5
		 */
		double k = 0;
		switch (Integer.parseInt(new CurrentTime().getYearString()) - teamer.getGrade()) {
		case 0:
		case 1:
			k = 1.5;
			break;
		case 2:
			k = 1.25;
			break;
		case 3:
			k = 1;
			break;
		}
		double point = (0.4 * t + 0.3 * c + 0.2 * p + 0.1 * d) * k;
		new DecimalFormat("#.0").format(point);
		return point;
	}

	@Override
	public int getNumByContest(String contest) {
		return recordDao.countRecordByContest(contest);
	}

	@Override
	public Vector<Record> getRecordsByUsername(String username) {
		return recordDao.getRecordsByUsername(username);
	}

}
