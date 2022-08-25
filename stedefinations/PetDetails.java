package com.api.stedefinations;

public class PetDetails {
	public static String petData(int id,String name ) {
		return "{\r\n" + 
				"  \"id\": "+id+",\r\n" + 
				"  \"category\": {\r\n" + 
				"    \"id\": 22,\r\n" + 
				"    \"name\": \"Cat\"\r\n" + 
				"  },\r\n" + 
				"  \"name\": \""+name+"\",\r\n" + 
				"  \"photoUrls\": [\r\n" + 
				"    \"string\"\r\n" + 
				"  ],\r\n" + 
				"  \"tags\": [\r\n" + 
				"    {\r\n" + 
				"      \"id\": 1,\r\n" + 
				"      \"name\": \"Germen Sheaprd\"\r\n" + 
				"    },\r\n" + 
				"     {\r\n" + 
				"      \"id\": 2,\r\n" + 
				"      \"name\": \"Liger\"\r\n" + 
				"    },\r\n" + 
				"     {\r\n" + 
				"      \"id\": 3,\r\n" + 
				"      \"name\": \"Lion\"\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"status\": \"available\"\r\n" + 
				"}";
	}

}
