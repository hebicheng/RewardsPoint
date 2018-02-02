package reward.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTime {
	private Date date;
	private String dateString;
	
	public CurrentTime() {
		date = new Date();
	}

	public String getDateString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return dateString = format.format(date);
	}
	public String getYearString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		return dateString = format.format(date);
	}
}
