package com.api.stedefinations;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ApiTest {
	static int petId;
	@DataProvider(name="pet")
	public Object[][] getPet(){
		return new Object[][] {{233,"nitro"},{234,"astro"},{235,"maxy"}};
		
	}
	@Test(priority=1,dataProvider="pet")
	public void  addPet(int id,String name) {
	RestAssured.baseURI="https://petstore.swagger.io/v2";
		//add a new pet
	String postresponse =	given().log().all().headers("Content-Type", "application/json")
		.body( PetDetails.petData(248,"tom"))
		.when().post("/pet")
		.then().assertThat().statusCode(200).extract().response().asString();
	System.out.println("response" +postresponse);
	JsonPath j=new JsonPath(postresponse);
	petId=j.get("id");
	System.out.println("Response Id:" +petId);
	}
	@Test(priority=2)
	public void  retrivePet() {
		given().log().all().header("Content-Type", "application/json" ).pathParam("id",petId).when().get("/pet/{id}") 
		.then().log().all().assertThat().statusCode(200);
		//update
	}
	
	@Test(priority=3)
	public void updatePet() {
	String post=	given().log().all().header("Content-Type","application/json").body(PetDetails.petData(233,"cat"))
		.when().put("/pet")
		.then().assertThat().statusCode(200).extract().response().asString();
	System.out.println(post);
	}
	@Test(priority=4)
	  public void findByStatus() {
		  given().log().all().header("Content-Type","application/json").queryParam("status","available")
		  .when().get("/pet/findByStatus")
		 .then().log().all().assertThat().statusCode(200);
	  }
}
