package com.api.stedefinations;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class NormalClass {
	public static void main(String[] args) {
		
			RestAssured.baseURI="https://petstore.swagger.io/v2";
				//add a new pet
			String postresponse =	given().log().all().headers("Content-Type", "application/json")
				.body( PetDetails.petData(248,"tom"))
				.when().post("/pet")
				.then().assertThat().statusCode(200).extract().response().asString();
			System.out.println("response" +postresponse);
			JsonPath j=new JsonPath(postresponse);
			int petId=j.get("id");
			
			String name = j.getString("name");
			String status = j.getString("status");
			System.out.println("Response Id:" +petId);
			System.out.println("Response Name:" +name);
			System.out.println("Response Status:" +status);
			int tag = j.get("tags.size()");
			for (int i = 0; i <tag; i++) {
				System.out.println("tags["+i+"].id");
				System.out.println("tags["+i+"].name");
				
			}
			}
	}


