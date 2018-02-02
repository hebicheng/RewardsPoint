package reward.entity;

public class Record {
	private String name;
	private String username;
	private String contest;
	private int ac;
	private int rank;
	private int onlyAC;
	private int fb;
	private String updateTime; 
	boolean isUpdate;
	public Record(String username,String name, String contest, int ac, int rank, int onlyAC, int fb, String updateTime) {
		super();
		this.username = username;
		this.name = name;
		this.contest = contest;
		this.ac = ac;
		this.rank = rank;
		this.onlyAC = onlyAC;
		this.fb = fb;
		this.updateTime = updateTime;
		this.isUpdate = true;
	}
	public Record(String username, String name, String contest) {
		super();
		this.username = username;
		this.name = name;
		this.contest = contest;
		this.isUpdate = false;
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
	public String getName() {
		return name;
	}
	public void setName(String teamer) {
		this.name = teamer;
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
