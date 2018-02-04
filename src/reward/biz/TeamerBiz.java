package reward.biz;

import java.util.Vector;

import reward.entity.Record;
import reward.entity.Teamer;

public interface TeamerBiz {
	public Vector<Teamer> listTeamerByRecord(Vector<Record> records);
}
