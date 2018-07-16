package com.loui.spring.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.loui.spring.response.GeneralResponse;

public class JsonUtilTest {

	GeneralResponse generalResponse;
	
    @Before
    public void setup() {
    	generalResponse = new GeneralResponse();
    }
    
	@Test
	public void couldParseTwoDimentionArrayToString() {
		int[][] twoDimentionArray = new int[][]{{0,0,0},{1,1,1}};
		String response = generalResponse.toJsonString(twoDimentionArray);
		assertEquals("response", response, "[[0,0,0],[1,1,1]]");
	}
}
