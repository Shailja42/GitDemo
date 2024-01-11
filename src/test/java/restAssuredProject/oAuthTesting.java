package restAssuredProject;

import static io.restassured.RestAssured.given;

import java.util.List;

import Pojo.GetCourse;
import Pojo.WebAutomation;
import Pojo.api;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class oAuthTesting {

	public static void main(String[] args) {

		String code_Url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AfJohXkm5xdEm0u-5KZy4pF2YMPDOC96tSKSHLobEyXOW9CJpSmU_cAc_SK0xhiKXp_YMg&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none";
		String st1 = code_Url.split("code=")[1];
		String codeString = st1.split("&scope")[0];
		System.out.println("Code is " + codeString);

		// Code
		String accessTokenResponse = given().urlEncodingEnabled(false).queryParams("code", codeString)
				.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.queryParams("grant_type", "authorization_code").when()
				.post("https://www.googleapis.com/oauth2/v4/token").asString();
		JsonPath js = new JsonPath(accessTokenResponse);
		String accessToken = js.getString("access_token");
		System.out.println("Access token is" + accessToken);

		// Access Token
		GetCourse gc = given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON).when()
				.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);

		System.out.println(gc.getInstructor());
		System.out.println(gc.getLinkedIn());

		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());

		List<api> apiCourses = gc.getCourses().getApi();
		for (int i = 0; i < apiCourses.size(); i++) {
			if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
			{
				System.out.println("Price is : "+apiCourses.get(i).getPrice());
			}

		}

		List<WebAutomation> apiTitle = gc.getCourses().getWebAutomation();
		for (int i = 0; i < apiTitle.size(); i++) {
			String titleName = apiTitle.get(i).getCourseTitle();
			{
				System.out.println("Title is : "+titleName);
			}

		}
		

	}

}
