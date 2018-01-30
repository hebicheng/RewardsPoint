package reward.entity;

public class Record {
	private String teamer;
	private String contest;
	private int ac;
	private int rank;
	private int onlyAC;
	private int fb;
	boolean isUpdate;
	public Record(String teamer, String contest, int ac, int rank, int onlyAC, int fb) {
		super();
		this.teamer = teamer;
		this.contest = contest;
		this.ac = ac;
		this.rank = rank;
		this.onlyAC = onlyAC;
		this.fb = fb;
		this.isUpdate = true;
	}
	public Record(String teamer, String contest) {
		super();
		this.teamer = teamer;
		this.contest = contest;
		this.isUpdate = false;
	}
	
	public boolean getIsUpdate() {
		return isUpdate;
	}
	public void setUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	public String getTeamer() {
		return teamer;
	}
	public void setTeamer(String teamer) {
		this.teamer = teamer;
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
