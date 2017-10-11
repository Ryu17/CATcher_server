package data;

//ImageTalk 클래스입니다.
public class ImageTalk {

	private String name;
	private int exist;
	
	public ImageTalk(String name, int exist)
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
