package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Zhihu {
	public static JSONObject getDailyNews(){
		JSONObject obj = null;
		try {
			InputStream input = new URL("http://news-at.zhihu.com/api/4/news/latest").openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			String output = br.readLine();
			obj = new JSONObject(output);
		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Zhihu Api could not be used");
		}
		return obj;
	}
	
	public static JSONObject getTopStories(){
		JSONObject obj = getDailyNews();
		JSONArray top_stories;
		JSONObject reval = new JSONObject();
		try {
			top_stories = obj.getJSONArray("top_stories");
			
			reval.put("top_stories", top_stories);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reval;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(Zhihu.getDailyNews().getString("date"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
