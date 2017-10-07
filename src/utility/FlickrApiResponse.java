package utility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FlickrApiResponse {
	
	HashMap<Integer, String> hmap = new HashMap<Integer, String>();
	public HashMap<Integer, String> GetResponse() throws ClientProtocolException, IOException {

		String url = "https://api.flickr.com/services/feeds/photos_public.gne?format=json&nojsoncallback=1&tags=continents";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		con.connect();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		String inline = "";
		Scanner sc = new Scanner(obj.openStream());

		while (sc.hasNext()) {
			inline += sc.nextLine();
		}

		JSONParser parser = new JSONParser();

		// try {

		Object object;
		try {
			object = parser.parse(inline);

			// convert Object to JSONObject
			JSONObject jsonObject = (JSONObject) object;
//			System.out.println(jsonObject);
//
//			String name = (String) jsonObject.get("title");
//			System.out.println(name);

			// loop array
			JSONArray msg = (JSONArray) jsonObject.get("items");

			for (int i = 0; i < msg.size(); i++) {
				JSONObject rec = (JSONObject) msg.get(i);
				String title = (String) rec.get("title");
				
				hmap.put(i, title);
			}
			System.out.println(hmap);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sc.close();

		return hmap;

	}
}
