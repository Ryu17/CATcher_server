package dataList.image;

import java.util.ArrayList;
import data.ImageList;

public class List {
	static ArrayList<ImageList> array_imageList = new ArrayList<ImageList>();
	
	public static void addImageList(ImageList imageList)
	{
		array_imageList.add(imageList);
	}
		 
	public static ImageList findImageList(int id)
	{
		return array_imageList.get(id);
	}
	 
	public static int getImageListSize()
	{
		return array_imageList.size();
	}
	
	public static void clearImageList()
	{
		array_imageList.clear();
	}
 
}
