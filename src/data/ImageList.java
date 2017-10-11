package data;

//ImageList 클래스입니다.
public class ImageList {
	
	private String name;
	private int exist;
	
	public ImageList(String name, int exist)
	{
		this.setName(name);
		this.setExist(exist);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getExist() {
		return exist;
	}
	
	public void setExist(int exist) {
		this.exist = exist;
	}
}
