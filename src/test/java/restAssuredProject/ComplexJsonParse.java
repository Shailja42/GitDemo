package restAssuredProject;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js = new JsonPath(payload.CoursePrice());
		int size = js.getInt("courses.size()");
		System.out.println("Size is " + size);
		
		
		int purchaseAmt = js.getInt("dashboard.purchaseAmount");
		System.out.println("Amount is " + purchaseAmt);
		
		int sum_Amt =0;
		for(int i=0;i<size;i++)
		{
		String title = js.get("courses["+i+"].title");
		int price = js.getInt("courses["+i+"].price");
		int copies = js.getInt("courses["+i+"].copies");
		
		int totalAmt = price*copies;
		sum_Amt =  totalAmt+sum_Amt;
		System.out.println("Total amount is " + sum_Amt);
		
		if(purchaseAmt==sum_Amt)
		{
			System.out.println("Amount matched");
		}
		else
			System.out.println("Not matched");
		if (title.equals("RPA"))
		{
			System.out.println("RPA copies are " +copies);
			break;
		}
		System.out.println("Title is : " +title + " and price is " +price);
		
		}
		
		System.out.println("**Match all course price is equal to purchase amount**");
		 
		


	}

}
