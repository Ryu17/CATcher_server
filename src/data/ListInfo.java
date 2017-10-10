package data;

//ListInfo 클래스입니다.
public class ListInfo {
	
	private int id;
	private int group_id;
	private String author;
	private String title;
	private int view_count;
	private int like_count;
	private int unlike_count;
	private int category_id;
	private int date;
	private String continuity;
	private String synopsis;
	private int nologinrecommend;
	private String hashtag1;
	private String hashtag2;
	private String hashtag3;
	private String hashtag4;
	private String hashtag5;
	
	public ListInfo(int id, int group_id, String author, String title, int view_count, int like_count, int unlike_count, int category_id, int date, String continuity, 
					String synopsis, int nologinrecommend, String hashtag1, String hashtag2, String hashtag3, String hashtag4, String hashtag5)
	{
		this.setId(id);
		this.setGroup_id(group_id);
		this.setAuthor(author);
		this.setTitle(title);
		this.setView_count(view_count);
		this.setLike_count(like_count);
		this.setUnlike_count(unlike_count);
		this.setCategory_id(category_id);
		this.setDate(date);
		this.setCont(continuity);
		this.setSynopsis(synopsis);
		this.setNologinrecommend(nologinrecommend);
		this.setHashtag1(hashtag1);
		this.setHashtag2(hashtag2);
		this.setHashtag3(hashtag3);
		this.setHashtag4(hashtag4);
		this.setHashtag5(hashtag5);
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getView_count() {
		return view_count;
	}
	
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	
	public int getLike_count() {
		return like_count;
	}
	
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	
	public int getUnlike_count() {
		return unlike_count;
	}
	
	public void setUnlike_count(int unlike_count) {
		this.unlike_count = unlike_count;
	}
	
	public int getCategory_id() {
		return category_id;
	}
	
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	public int getDate() {
		return date;
	}
	
	public void setDate(int date) {
		this.date = date;
	}
	
	public String getCont() {
		return continuity;
	}
	
	public void setCont(String continuity) {
		this.continuity = continuity;
	}
	
	public String getSynopsis() {
		return synopsis;
	}
	
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	public int getNologinrecommend() {
		return nologinrecommend;
	}
	
	public void setNologinrecommend(int nologinrecommend) {
		this.nologinrecommend = nologinrecommend;
	}
	
	public String getHashtag1() {
		return hashtag1;
	}
	
	public void setHashtag1(String hashtag1) {
		this.hashtag1 = hashtag1;
	}
	
	public String getHashtag2() {
		return hashtag2;
	}
	
	public void setHashtag2(String hashtag2) {
		this.hashtag2 = hashtag2;
	}
	
	public String getHashtag3() {
		return hashtag3;
	}
	
	public void setHashtag3(String hashtag3) {
		this.hashtag3 = hashtag3;
	}
	
	public String getHashtag4() {
		return hashtag4;
	}
	
	public void setHashtag4(String hashtag4) {
		this.hashtag4 = hashtag4;
	}
	
	public String getHashtag5() {
		return hashtag5;
	}
	
	public void setHashtag5(String hashtag5) {
		this.hashtag5 = hashtag5;
	}
}
