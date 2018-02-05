package reward.biz.impl;

import reward.biz.PartitionPointBiz;
import reward.dao.PartitionPointDao;
import reward.dao.TeamerDao;
import reward.dao.impl.PartitionPointDaoImpl;
import reward.dao.impl.TeamerDaoImpl;
import reward.entity.CurrentTime;
import reward.entity.PartitionPoint;
import reward.entity.Teamer;

public class PartitionPointBizImpl implements PartitionPointBiz {
	PartitionPointDao pointDao = new PartitionPointDaoImpl();

	@Override
	public int updateTrainContest(String userName, double dPoint) {
		PartitionPoint partitionPoint = pointDao.findByUsername(userName);
		if (partitionPoint == null) {
			partitionPoint = new PartitionPoint(userName, dPoint, 0, 0, 0);
			pointDao.insert(partitionPoint);
		} else {
			partitionPoint.setTrainContest(partitionPoint.getTrainContest() + dPoint);
			System.out.println("老成绩:" + partitionPoint.getTrainContest());
			System.out.println("变化:" + dPoint);
			System.out.println("新成绩：" + (partitionPoint.getTrainContest() + dPoint));
			pointDao.update(partitionPoint);
		}
		updateTeamerRecord(partitionPoint);
		return 1;
	}

	@Override
	public int updatePersonContest(String userName, double dPoint) {
		PartitionPoint partitionPoint = pointDao.findByUsername(userName);
		if (partitionPoint == null) {
			partitionPoint = new PartitionPoint(userName, 0, dPoint, 0, 0);
			pointDao.insert(partitionPoint);
		} else {
			partitionPoint.setPersonContest(partitionPoint.getPersonContest() + dPoint);
			System.out.println("老成绩:" + partitionPoint.getTrainContest());
			System.out.println("变化:" + dPoint);
			System.out.println("新成绩：" + (partitionPoint.getPersonContest() + dPoint));
			pointDao.update(partitionPoint);
		}
		updateTeamerRecord(partitionPoint);
		return 1;
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
		System.out.println(point);
		teamerDao.modifyPointByUsername(partitionPoint.getUsername(), point);
		return;
	}
}
