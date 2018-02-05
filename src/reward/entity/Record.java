package reward.entity;

public class Record {
	private String username;
	private String contest;
	private int type;
	private int ac;
	private int rank;
	private int onlyAC;
	private int fb;
	private int rating;
	private double nowPoint;
	private String updateTime;
	boolean isUpdate;
	private double score;

	public Record(String username, String contest, int type, int ac, int rank, int onlyAC, int fb, int rating,
			String updateTime, double nowPoint) {
		super();
		this.username = username;
		this.contest = contest;
		this.type = type;
		this.ac = ac;
		this.rank = rank;
		this.onlyAC = onlyAC;
		this.fb = fb;
		this.rating = rating;
		this.updateTime = updateTime;
		this.isUpdate = true;
		this.nowPoint = nowPoint;
	}

	/**
	 * 构造训练赛
	 */
	public Record(String username, String contest, int ac, int rank, int onlyAC, int fb, String updateTime) {
		super();
		this.username = username;
		this.contest = contest;
		this.type = 0;
		this.ac = ac;
		this.rank = rank;
		this.onlyAC = onlyAC;
		this.fb = fb;
		this.updateTime = updateTime;
		this.isUpdate = true;
	}

	/**
	 * 构造个人赛
	 */
	public Record(String username, String contest, int type, int rating, String updateTime) {
		super();
		this.username = username;
		this.contest = contest;
		this.type = type;
		this.rating = rating;
		this.updateTime = updateTime;
		this.isUpdate = true;
	}

	public Record(String username, String contest) {
		super();
		this.username = username;
		this.contest = contest;
		this.isUpdate = false;
	}
	
	public double getScore() {
		return score;
	}

	public double getNowPoint() {
		return nowPoint;
	}

	public void setNowPoint(double nowPoint) {
		this.nowPoint = nowPoint;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public void calcScore() {
		double t = 0;
		if (type == 1) {  // cf
			t = Math.max(0, (this.rating-1000.0)/40);
		} else if (type == 2) {  // atcoder
			t = Math.max(0, (this.rating-900.0)/80);
		} else if (type == 3) {
			// 考勤
		}
		this.score = t;
	}

	public void calcScore(int rank) {
		double t = 0;
		t += ac;
		t += 0.5 * onlyAC;
		t += 0.2 * fb;
		if (this.rank * 10 < rank) {
			t += 4;
		} else if (this.rank * 10 < 3 * rank) {
			t += 3;
		} else if (this.rank * 10 < 6 * rank) {
			t += 2;
		} else {
			t += 1;
		}
		score = t;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean getIsUpdate() {
		return isUpdate;
	}

	public void setUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	public String getContest() {
		return contest;
	}

	public void setContest(String contest) {
		this.contest = contest;
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getOnlyAC() {
		return onlyAC;
	}

	public void setOnlyAC(int onlyAC) {
		this.onlyAC = onlyAC;
	}

	public int getFb() {
		return fb;
	}

	public void setFb(int fb) {
		this.fb = fb;
	}

}
