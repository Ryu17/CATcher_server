package data;

//TalkInfo 클래스입니다.
public class TalkInfo {

	private int category_id;
	private int group_id;
	private int id;
	private int msg_order;
	private float delay;
	private String speaker;
	private String msg_view_point;
	private String msg_type;
	private String msg_data;
	private int stm_check;
	private String profile_img;
	
	public TalkInfo
	(int category_id, int group_id, int id, int msg_order, float delay, String speaker,
			String msg_view_point, String msg_type, String msg_data, int stm_check, String profile_img)
	{
		this.setCategory_id(category_id);
		this.setGroup_id(group_id);
		this.setId(id);
		this.setMsg_order(msg_order);
		this.setDelay(delay);
		this.setSpeaker(speaker);
		this.setMsg_view_point(msg_view_point);
		this.setMsg_type(msg_type);
		this.setMsg_data(msg_data);
		this.setStm_check(stm_check);
		this.setProfile_img(profile_img);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public int getMsg_order() {
		return msg_order;
	}

	public void setMsg_order(int msg_order) {
		this.msg_order = msg_order;
	}

	public float getDelay() {
		return delay;
	}

	public void setDelay(float delay) {
		this.delay = delay;
	}

	public String getSpeaker() {
		return speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	public String getMsg_view_point() {
		return msg_view_point;
	}

	public void setMsg_view_point(String msg_view_point) {
		this.msg_view_point = msg_view_point;
	}

	public String getMsg_type() {
		return msg_type;
	}

	public void setMsg_type(String msg_type) {
		this.msg_type = msg_type;
	}

	public String getMsg_data() {
		return msg_data;
	}

	public void setMsg_data(String msg_data) {
		this.msg_data = msg_data;
	}

	public int getStm_check() {
		return stm_check;
	}

	public void setStm_check(int stm_check) {
		this.stm_check = stm_check;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getProfile_img() {
		return profile_img;
	}

	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	
	
}
