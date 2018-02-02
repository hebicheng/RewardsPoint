/**
 * 
 */
package reward.entity;

/**
 * @author HE BICHENG
 *
 */
public class PartitionPoint {
	private String username;
	private double trainContest;
	private double personContest;
	private double solveProblem;
	private double attendance;
	
	public PartitionPoint(String username, double trainContest, double personContest, double solveProblem,
			double attendance) {
		super();
		this.username = username;
		this.trainContest = trainContest;
		this.personContest = personContest;
		this.solveProblem = solveProblem;
		this.attendance = attendance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getTrainContest() {
		return trainContest;
	}

	public void setTrainContest(double trainContest) {
		this.trainContest = trainContest;
	}

	public double getPersonContest() {
		return personContest;
	}

	public void setPersonContest(double personContest) {
		this.personContest = personContest;
	}

	public double getSolveProblem() {
		return solveProblem;
	}

	public void setSolveProblem(double solveProblem) {
		this.solveProblem = solveProblem;
	}

	public double getAttendance() {
		return attendance;
	}

	public void setAttendance(double attendance) {
		this.attendance = attendance;
	}
	
}
