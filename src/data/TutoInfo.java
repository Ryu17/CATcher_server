package data;

//TutoInfo 클래스입니다.
public class TutoInfo {
	private int id;
	private int group_id;
	private String message1;
	private String message2;
	
	public TutoInfo(int id, int group_id, String message1, String message2)
	{
		this.setId(id);
		this.setGroup_id(group_id);
		this.setMessage1(message1);
		this.setMessage2(message2);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int index) {
		this.id = index;
	}
	
	public int getGroup_id() {
		return group_id;
	}
	
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	
	public String getMessage1() {
		return message1;
	}
	
	public void setMessage1(String message1) {
		this.message1 = message1;
	}
	
	public String getMessage2() {
		return message2;
	}
	
	public void setMessage2(String message2) {
		this.message2 = message2;
	}

}
