package reward.entity;

public class Teamer {
	private String name;
	private int grade;
	private String sicnuoj;
	private String cf;
	private String atcoder;
	private double point;
	
	public Teamer(String name, int grade, double point) {
		super();
		this.name = name;
		this.grade = grade;
		this.point = point;
	}
	public Teamer(String name, int grade, String sicnuoj, String cf, String atcoder, double point) {
		super();
		this.name = name;
		this.grade = grade;
		this.sicnuoj = sicnuoj;
		this.cf = cf;
		this.atcoder = atcoder;
		this.point = point;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getSicnuoj() {
		return sicnuoj;
	}
	public void setSicnuoj(String sicnuoj) {
		this.sicnuoj = sicnuoj;
	}
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public String getAtcoder() {
		return atcoder;
	}
	public void setAtcoder(String atcoder) {
		this.atcoder = atcoder;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	
	
}
