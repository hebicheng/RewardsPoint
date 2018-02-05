package reward.entity;

import java.text.DecimalFormat;

public class Teamer {
	private String name;
	private String username;
	private String password;
	private int grade;
	
	private String sicnuoj;
	private String cf;
	private String atcoder;
	private double point;
	
	public Teamer(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Teamer(String name, int grade, double point,String sicnuoj, String cf, String atcoder) {
		super();
		this.name = name;
		this.grade = grade;
		this.point = point;
		this.cf = cf;
		this.atcoder = atcoder;
		this.sicnuoj = sicnuoj;
	}
	
	public Teamer(String username, String name, int grade, String sicnuoj, String cf, String atcoder, double point) {
		super();
		this.username = username;
		this.name = name;
		this.grade = grade;
		this.sicnuoj = sicnuoj;
		this.cf = cf;
		this.atcoder = atcoder;
		this.point = point;
	}
	public Teamer(String username,String password, String name, int grade, String sicnuoj, String cf, String atcoder ) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.grade = grade;
		this.sicnuoj = sicnuoj;
		this.cf = cf;
		this.atcoder = atcoder;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getShowPoint() {
		DecimalFormat df= new DecimalFormat(".##");
		String showPoint = df.format(this.point);
		return showPoint;
	}
	
}
