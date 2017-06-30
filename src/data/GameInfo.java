package data;

//GameInfo 클래스입니다.
public class GameInfo {
	
	private int latest_version;
	
	public GameInfo(int latest_version)
	{
		this.setVersion(latest_version);
	}
	
	public int getVersion() {
		return latest_version;
	}
	
	public void setVersion(int version) {
		this.latest_version = version;
	}
}
