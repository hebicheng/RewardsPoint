package reward.biz.impl;

import java.text.DecimalFormat;
import java.util.Vector;

import reward.biz.RecordBiz;
import reward.dao.RecordDao;
import reward.dao.TeamerDao;
import reward.dao.impl.RecordDaoImpl;
import reward.dao.impl.TeamerDaoImpl;
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
			Record record = recordDao.findRecordByTeamerAndContest(teamer.getName(), contest);
			if (record == null) {
				record = new Record(teamer.getName(), contest);
				records.add(0, record);
			} else {
				records.add(record);
			}
		}
		return records;
	}

	@Override
	public boolean updateRecord(Record record) {
		recordDao.delete(record);
		if (recordDao.insert(record) != 0) {
			return true;
		}

		return false;
	}

	@Override
	public double getPointByTeamer(Teamer teamer) {
		double t = 0;
		double c = 0;
		double p = 0;
		double d = 0;
		Vector<Record> records = recordDao.findRecordsByTeamer(teamer.getName());
		if(records != null) {
			for(Record record:records) {
				t += record.getAc();
				t += 0.5*record.getOnlyAC();
				t += 0.2*record.getFb();
				int rank = record.getRank();
				int num = getNumByContest(record.getContest());
				if(rank*10 < num) {
					t+=4;
				} else if(rank*10 < 3*num) {
					t+=3;
				} else if(rank*10 < 6*num) {
					t+=2;
				} else {
					t+=1;
				}
			}
		}
		/*
		 * 2015:1
		 * 2016:1.25
		 * 2017:1.5
		 */
		double k = 0;
		switch(teamer.getGrade()) {
		case 2015:
			k = 1;
			break;
		case 2016:
			k = 1.25;
			break;
		case 2017:
			k = 1.5;
			break;
		}
		double point = (0.4*t+0.3*c+0.2*p+0.1*d)*k;
		new DecimalFormat("#.0").format(point);
		return point;
	}

	@Override
	public int getNumByContest(String contest) {
		return recordDao.countRecordByContest(contest);
	}

}
