package data;

//CategoryInfo 클래스입니다.
public class CategoryInfo {
	
	private int category_serial;
	private int category_id;
	private int category_order;
	private int group_id;
	private String author;
	private String img_id;
	private String title;
	private int view_count;
	private int like_count;
	
	public CategoryInfo
	(int category_serial, int category_id, int category_order, int group_id,
			String author, String img_id, String title, int view_count, int like_count)
	{
		this.setCategory_serial(category_serial);
		this.setCategory_id(category_id);
		this.setCategory_order(category_order);
		this.setGroup_id(group_id);
		this.setAuthor(author);
		this.setImg_id(img_id);
		this.setTitle(title);
		this.setView_count(view_count);
		this.setLike_count(like_count);
	}
	
	public int getCategory_serial() {
		return category_serial;
	}
	
	public void setCategory_serial(int category_serial) {
		this.category_serial = category_serial;
	}
	
	public int getCategory_id() {
		return category_id;
	}
	
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	public int getCategory_order() {
		return category_order;
	}
	
	public void setCategory_order(int category_order) {
		this.category_order = category_order;
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
}
