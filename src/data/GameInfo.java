package data;

//GameInfo 클래스입니다.
public class GameInfo {
	
	private int latest_version;
	private int image_download;
	
	public GameInfo(int latest_version, int image_download)
	{
		this.setVersion(latest_version);
		this.setImageDownload(image_download);
	}
	
	public int getVersion() {
		return latest_version;
	}
	
	public void setVersion(int version) {
		this.latest_version = version;
	}
	
	public int getImageDownload() {
		return image_download;
	}
	
	public void setImageDownload(int image_download) {
		this.image_download = image_download;
	}
}
