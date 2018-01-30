package reward.biz.impl;

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
			Record record = recordDao.findRecordByTeamer(teamer.getName());
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

}
