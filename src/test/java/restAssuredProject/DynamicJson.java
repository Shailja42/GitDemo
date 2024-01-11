package restAssuredProject;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {

	@Test(dataProvider = "BooksData")
	public void addBook(String isbn , String aisle) {

		RestAssured.baseURI = "http://216.10.245.166/";
		String res = given().log().all().queryParam("key", "qaclick123").headers("Content-Type", "application/json")
				.body(payload.addBook(isbn, aisle)).when().post("Library/Addbook.php").then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		JsonPath js = new JsonPath(res);
		String Id = js.getString("ID");
		System.out.println("ID is " + Id);

	}

	@DataProvider(name = "BooksData")
	public Object[][] getData() {
		return new Object[][] { { "aisle1", "980" }, { "aisle2", "987" }, { "aisle3", "986" } };
	}

}
