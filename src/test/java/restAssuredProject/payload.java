package restAssuredProject;

public class payload {
	
	
	public static String addData()
	{
		String data = "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "";
		
		return data;
		
	}
	
	public static String CoursePrice()
	{
	
return "{\r\n"
		+ "  \"dashboard\": {\r\n"
		+ "    \"purchaseAmount\": 910,\r\n"
		+ "    \"website\": \"rahulshettyacademy.com\"\r\n"
		+ "  },\r\n"
		+ "  \"courses\": [\r\n"
		+ "    {\r\n"
		+ "      \"title\": \"Selenium Python\",\r\n"
		+ "      \"price\": 50,\r\n"
		+ "      \"copies\": 6,\r\n"
		+ "      \"subCourses\": [\r\n"
		+ "        {\r\n"
		+ "          \"title\": \"Selenium Python 1\",\r\n"
		+ "          \"price\": 500,\r\n"
		+ "          \"copies\": 60\r\n"
		+ "        },\r\n"
		+ "        {\r\n"
		+ "          \"title\": \"Selenium Python 2\",\r\n"
		+ "          \"price\": 50,\r\n"
		+ "          \"copies\": 70\r\n"
		+ "        }\r\n"
		+ "      ]\r\n"
		+ "    },\r\n"
		+ "    {\r\n"
		+ "      \"title\": \"Cypress\",\r\n"
		+ "      \"price\": 40,\r\n"
		+ "      \"copies\": 4,\r\n"
		+ "      \"subCourses\": [\r\n"
		+ "        {\r\n"
		+ "          \"title\": \"Cypress 1\",\r\n"
		+ "          \"price\": 5000,\r\n"
		+ "          \"copies\": 60\r\n"
		+ "        },\r\n"
		+ "        {\r\n"
		+ "          \"title\": \"Cypress 2\",\r\n"
		+ "          \"price\": 500,\r\n"
		+ "          \"copies\": 6\r\n"
		+ "        }\r\n"
		+ "      ]\r\n"
		+ "    },\r\n"
		+ "    {\r\n"
		+ "      \"title\": \"RPA\",\r\n"
		+ "      \"price\": 45,\r\n"
		+ "      \"copies\": 10,\r\n"
		+ "      \"subCourses\": [\r\n"
		+ "        {\r\n"
		+ "          \"title\": \"RPA 1\",\r\n"
		+ "          \"price\": 6000,\r\n"
		+ "          \"copies\": 6\r\n"
		+ "        },\r\n"
		+ "        {\r\n"
		+ "          \"title\": \"RPA 2\",\r\n"
		+ "          \"price\": 5000,\r\n"
		+ "          \"copies\": 60\r\n"
		+ "        }\r\n"
		+ "      ]\r\n"
		+ "    }\r\n"
		+ "  ]\r\n"
		+ "}";
	}
	
	public static String addBook(String isbn , String aisle)
	{
		String BookData = "{\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foer\"\r\n"
				+ "}\r\n"
				+ "";
		return BookData;
		
	}

}
