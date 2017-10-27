package data;

public class CommentInfo {
	
	private String group_id;
	private String imgname;
	private String nickname;
	private String comments;
	private String date;
	
	public CommentInfo(String group_id, String imgname, String nickname, String comments, String date)
	{
		this.setGroup_id(group_id);
		this.setImgname(imgname);
		this.setNickname(nickname);
		this.setComments(comments);
		this.setDate(date);
	}

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	
	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
