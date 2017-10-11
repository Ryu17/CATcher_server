package data;

//ImageSpeaker 클래스입니다.
public class ImageSpeaker {

	private String name;
	private int exist;
	
	public ImageSpeaker(String name, int exist)
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
