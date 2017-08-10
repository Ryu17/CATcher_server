package data;

//ListInfo 클래스입니다.
public class ListInfo {
	
	private int id;
	private int group_id;
	private String author;
	private String img_id;
	private String title;
	private int view_count;
	private int like_count;
	private int category_id;
	private int date;
	private int bg_img;
	private String continuity;
	private String synopsis;
	
	public ListInfo(int id, int group_id, String author, String img_id, String title, int view_count, int like_count, int category_id, int date, int bg_img, String continuity, String synopsis)
	{
		this.setId(id);
		this.setGroup_id(group_id);
		this.setAuthor(author);
		this.setImg_id(img_id);
		this.setTitle(title);
		this.setView_count(view_count);
		this.setLike_count(like_count);
		this.setCategory_id(category_id);
		this.setDate(date);
		this.setBg_img(bg_img);
		this.setCont(continuity);
		this.setSynopsis(synopsis);
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

	public String getImg_id() {
		return img_id;
	}

	public void setImg_id(String img_id) {
		this.img_id = img_id;
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
	
	public int getBg_img() {
		return bg_img;
	}
	
	public void setBg_img(int bg_img) {
		this.bg_img = bg_img;
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
}
