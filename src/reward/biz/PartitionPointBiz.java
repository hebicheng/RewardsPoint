package reward.biz;

public interface PartitionPointBiz {
	public double updateTrainContest(String user, double dPoint);

	public double updatePersonContest(String user, double dPoint);
	
	public double updateSolveProblem(String user, double dPoint);
	
	public double updateAttendance(String user, double dPoint);
}
