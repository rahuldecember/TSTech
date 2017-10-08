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

	HashMap<Integer, String> al = new HashMap<Integer, String>();

	public HashMap<Integer, String> GetResponse(String searchText) throws ClientProtocolException, IOException {

		String url = "https://api.flickr.com/services/feeds/photos_public.gne?format=json&nojsoncallback=1&tags="
				+ searchText;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//http Connection connect
		con.connect();

		//fetching response code of request.
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		// if responsecode is 200 then json response will be parsed.
		if (responseCode == 200) {
			String inline = "";
			Scanner sc = new Scanner(obj.openStream());

			while (sc.hasNext()) {
				inline += sc.nextLine();
			}

			JSONParser parser = new JSONParser();

			Object object;
			try {
				object = parser.parse(inline);

				// convert Object to JSONObject
				JSONObject jsonObject = (JSONObject) object;

				// loop array
				JSONArray msg = (JSONArray) jsonObject.get("items");

				for (int i = 0; i < msg.size(); i++) {
					JSONObject rec = (JSONObject) msg.get(i);
					String title = (String) rec.get("title");
					al.put(i, title);
				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			sc.close();
		}

		return al;

	}
}
