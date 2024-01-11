package restAssuredProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> pricesList = new ArrayList<>();

		JsonPath js = new JsonPath(payload.CoursePrice());
		int size = js.getInt("courses.size()");

		System.out.println("Size is " + size);
		
		

		for (int i = 0; i < size; i++) {
			//int length = js.getInt("courses.subCourses.length()");
			for (int j = 0; j < 2; j++) {
				int sub_price1 = js.getInt("courses[" + i + "].subCourses[" + j + "].price");

				int price = js.getInt("courses[" + i + "].price");

				System.out.println("Price values are " + price);
				System.out.println("Sub Prices values are " + sub_price1);
				pricesList.add(price);
				pricesList.add(sub_price1);
			}

		}
		Collections.sort(pricesList, Collections.reverseOrder());
		System.out.println("Sorted Prices: " + pricesList);
		
		

	}

}
