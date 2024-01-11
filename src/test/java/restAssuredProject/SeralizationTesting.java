package restAssuredProject;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace;
import Pojo.Location;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class SeralizationTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AddPlace p = new AddPlace();
		Location loc = new Location();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setName("Frontline house");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("https://rahulshettyacademy.com");
		loc.setLng(-38.383494);
		loc.setLat(33.427362);
		
		List<String> mylist = new ArrayList<String>();
		
		mylist.add("shoe park");
		mylist.add("shop");
		p.setTypes(mylist);
		p.setLocation(loc);

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response res = given().queryParam("key", "qaclick123")
	    .body(p).when().log().all().post("/maps/api/place/add/json").then()
		.assertThat().statusCode(200).extract().response();
		
		String response = res.asString();
		System.out.println("Response is " +response);
		
		
		
		
	}

}
