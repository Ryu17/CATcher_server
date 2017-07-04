package data;

//LikeInfo 클래스입니다.
public class LikeInfo {

	private int user_key;
	private int group_id;
	
	public LikeInfo(int user_key, int group_id)
	{
		this.setUser_key(user_key);
		this.setGroup_id(group_id);
	}
	
	public int getUser_key() {
		return user_key;
	}
	
	public void setUser_key(int user_key) {
		this.user_key = user_key;
	}
	
	public int getGroup_id() {
		return group_id;
	}
	
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	
}
