package com.loui.spring.response;

import org.json.JSONArray;

public class GeneralResponse {
	public GeneralResponse() {
		
	}
	
	public String toJsonString(int[][] arrayMap) {
		return  new JSONArray(arrayMap).toString();
	}
}
