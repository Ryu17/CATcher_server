package dataList.image;

import java.util.ArrayList;
import data.ImageSpeaker;

public class Speaker {
	static ArrayList<ImageSpeaker> array_imageSpeaker = new ArrayList<ImageSpeaker>();
	
	public static void addImageSpeaker(ImageSpeaker imageSpeaker)
	{
		array_imageSpeaker.add(imageSpeaker);
	}
		 
	public static ImageSpeaker findImageSpeaker(int id)
	{
		return array_imageSpeaker.get(id);
	}
	 
	public static int getImageSpeakerSize()
	{
		return array_imageSpeaker.size();
	}
	
	public static void clearImageSpeaker()
	{
		array_imageSpeaker.clear();
	}
 
}
