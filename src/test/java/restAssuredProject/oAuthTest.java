package restAssuredProject;
import static io.restassured.RestAssured.given;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;


public class oAuthTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").build();
		RequestSpecification request=	given().spec(req).
		formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
		formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").
		formParam("grant_type", "client_credentials").
		formParam("scope", "trust");
		ResponseSpecification resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		Response res = request.when().post("oauthapi/oauth2/resourceOwner/token").
				then().spec(resspec).log().all().extract().response();
		String response = res.asString();
		System.out.println("Response is " +response);
		
		
       
	}

}
