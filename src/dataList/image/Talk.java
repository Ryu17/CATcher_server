package dataList.image;

import java.util.ArrayList;
import data.ImageTalk;

public class Talk {
	static ArrayList<ImageTalk> array_imageTalk = new ArrayList<ImageTalk>();
	
	public static void addImageTalk(ImageTalk imageTalk)
	{
		array_imageTalk.add(imageTalk);
	}
		 
	public static ImageTalk findImageTalk(int id)
	{
		return array_imageTalk.get(id);
	}
	 
	public static int getImageTalkSize()
	{
		return array_imageTalk.size();
	}
	
	public static void clearImageTalk()
	{
		array_imageTalk.clear();
	}

}
