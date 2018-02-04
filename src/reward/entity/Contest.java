package reward.entity;

import java.util.Date;

public class Contest {
	private int id;
	private String name;
	private String content;
	private int type;
	private int weight;
	private Date time;
	private String oj;
	private String url;
	private int num;
	public Contest(String name, String content, int type, int weight, Date time, String oj, String url, int num) {
		super();
		this.name = name;
		this.content = content;
		this.type = type;
		this.weight = weight;
		this.time = time;
		this.oj = oj;
		this.url = url;
		this.num = num;
	}
	public Contest(int id, String name, String content, int type, int weight, Date time, String oj, String url, int num) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.type = type;
		this.weight = weight;
		this.time = time;
		this.oj = oj;
		this.url = url;
		this.num = num;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getOj() {
		return oj;
	}
	public void setOj(String oj) {
		this.oj = oj;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
