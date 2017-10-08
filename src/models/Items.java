package models;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;

import utility.FlickrApiResponse;

public class Items {
	HashMap<Integer,String> ExpectedMap;

	// this method gets the Title from the Api call.
	public HashMap<Integer,String> getTitlesApi(String searchText) throws ClientProtocolException, IOException {
		FlickrApiResponse flickrApiResponse = new FlickrApiResponse();
		ExpectedMap = flickrApiResponse.GetResponse(searchText);
		System.out.println(ExpectedMap);
		return ExpectedMap;
	}

	//This method compares the Hashmap objects and returns boolean.
	public boolean verify(HashMap<Integer, String> map1, HashMap<Integer, String> map2) {
		boolean isEqual = false;
		if (map1.equals(map2)) {
			isEqual = true;
		}

		return isEqual;
	}
}
