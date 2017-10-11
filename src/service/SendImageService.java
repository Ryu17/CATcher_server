package service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import service.SendImageCoverService;
import service.SendImageListService;
import service.SendImageSpeakerService;
import service.SendImageTalkService;

public class SendImageService {
	public JSONObject ConvertData2Json(String param_index) {		

		//리스트와 톡 JSON 을 넣어줄 JSONObject를 만들어줍니다.
		JSONObject imageObject = new JSONObject();
		
		if (param_index.equals("1"))
		{
			//SendImageCoverService를 통해서 만들어 놓은 coverJsonArray 를 가져옵니다.
			SendImageCoverService sendImageCoverService = new SendImageCoverService();
			JSONArray coverJsonArray = sendImageCoverService.ConvertCoverData2Json();
			
			//ImageCover JsonArray 를 dataListObject 에 넣어줍니다.
			imageObject.put("Cover", coverJsonArray);
		}
		else if (param_index.equals("2"))
		{
			//SendImageListService를 통해서 만들어 놓은 listJsonArray 를 가져옵니다.
			SendImageListService sendImageListService = new SendImageListService();
			JSONArray listJsonArray = sendImageListService.ConvertListData2Json();
			
			//ImageList JsonArray 를 dataListObject 에 넣어줍니다.
			imageObject.put("List", listJsonArray);
		}
		else if (param_index.equals("3"))
		{
			//SendImageSpeakerService를 통해서 만들어 놓은 speakerJsonArray 를 가져옵니다.
			SendImageSpeakerService sendImageSpeakerService = new SendImageSpeakerService();
			JSONArray speakerJsonArray = sendImageSpeakerService.ConvertSpeakerData2Json();
			
			//ImageSpeaker JsonArray 를 dataListObject 에 넣어줍니다.
			imageObject.put("Speaker", speakerJsonArray);
		}
		else if (param_index.equals("4"))
		{
			//SendImageTalkService를 통해서 만들어 놓은 talkJsonArray 를 가져옵니다.
			SendImageTalkService sendImageTalkService = new SendImageTalkService();
			JSONArray talkJsonArray = sendImageTalkService.ConvertTalkData2Json();
			
			//ImageTalk JsonArray 를 dataListObject 에 넣어줍니다.
			imageObject.put("Talk", talkJsonArray);
		}
		
		//최종 만들어진 dataListObject를 반환해줍니다.
		return imageObject;
	}	
}
