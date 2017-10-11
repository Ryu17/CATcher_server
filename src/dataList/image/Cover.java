package dataList.image;

import java.util.ArrayList;
import data.ImageCover;

public class Cover {
	static ArrayList<ImageCover> array_imageCover = new ArrayList<ImageCover>();
	
	public static void addImageCover(ImageCover imageCover)
	{
		array_imageCover.add(imageCover);
	}
		 
	public static ImageCover findImageCover(int id)
	{
		return array_imageCover.get(id);
	}
	 
	public static int getImageCoverSize()
	{
		return array_imageCover.size();
	}
	
	public static void clearImageCover()
	{
		array_imageCover.clear();
	}
 
}
