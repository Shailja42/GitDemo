package restAssuredProject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.Assert;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123")
				.headers("Content-Type", "application/json").body(payload.addData()).when()
				.post("maps/api/place/add/json").then().assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("Server", "Apache/2.4.52 (Ubuntu)").extract().asString();

		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String placeId = js.getString("place_id");
		System.out.println();
		System.out.println("place id is " + placeId);

		// update place
		
//		String str1 = "Hello, World!";
//        String str2 = "Hello, World!";
//
//        MatcherAssert.assertThat(str1, Matchers.equalTo(str2));
        
	//	https://rahulshettyacademy.com/maps/api/place/update/json?key=qaclick123
		System.out.println("******** Update place *********");
		
		String message = "Address successfully updated";
		String res = given().log().all().queryParam("key", "qaclick123").
		headers("Content-Type", "application/json").
		body("{\r\n"
				+ "\""+ placeId + "\":\"d1454b103ba04395857c6aa12193ccfb\",\r\n"
				+ "\"address\":\"70 winter walk, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		.when().post("/maps/api/place/update/json").
		then().log().all().assertThat().statusCode(200)
		.body("msg", Matchers.equalTo("Address successfully updated")).header("Server", "Apache/2.4.52 (Ubuntu)")
		.extract().asString();
		JsonPath actualmsg = new JsonPath(res);
		String msg1 = actualmsg.getString("msg");
		System.out.println("message is "+msg1);
		Assert.assertEquals(message, "Address successfully updated");
	}

}
