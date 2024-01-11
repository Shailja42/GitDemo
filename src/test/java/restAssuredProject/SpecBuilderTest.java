package restAssuredProject;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace;
import Pojo.Location;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilderTest {

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
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
	    addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		
		ResponseSpecification resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
	    RequestSpecification res = given().spec(req)
	   .body(p);
	    Response resp=  res.when().post("/maps/api/place/add/json")
		.then().spec(resspec).extract().response();
			
		String response = resp.asString();
		System.out.println("Response is " +response);
	    
		

	}

}
