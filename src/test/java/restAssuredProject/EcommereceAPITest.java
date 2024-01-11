package restAssuredProject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Pojo.AddProduct;
import Pojo.LoginRequest;
import Pojo.LoginResponse;
import Pojo.Orders;
import Pojo.OrderDetail;
import io.restassured.specification.RequestSpecification;

public class EcommereceAPITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RequestSpecification rspec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).build();
		LoginRequest loginrequest = new LoginRequest();
		loginrequest.setUserEmail("shailja4530@gmail.com");
		loginrequest.setUserPassword("Test@1234");
		RequestSpecification req = given().spec(rspec).body(loginrequest);
		LoginResponse res = req.when().post("api/ecom/auth/login").then().assertThat().extract().response()
				.as(LoginResponse.class);
		System.out.println("Message is " + res.getMessage());
		String token = res.getToken();
		System.out.println("Token is " + res.getToken());
		String UserId = res.getToken();
		System.out.println("Use Id is " + res.getUserId());

		// Add Product

		RequestSpecification addProductBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", token).build();

		RequestSpecification addProductresponse = given().log().all().spec(addProductBaseReq)
				.param("productName", "qwerty").param("productAddedBy", UserId).param("productCategory", "Appliances")
				.param("productSubCategory", "shirts").param("productPrice", "11500")
				.param("productDescription", "Addias Originals").param("productFor", "women")
				.multiPart("productImage", new File("C://Users//akumar94//Downloads//laptopImage.jpg"));

		AddProduct addproduct = addProductresponse.when().post("api/ecom/product/add-product").then().log().all()
				.extract().response().as(AddProduct.class);
		String message = addproduct.getMessage();
		String ProductId = addproduct.getProductId();

		System.out.println("Message is :" + message + " Product id is : " + ProductId);

		// Create Order

		RequestSpecification createOrderReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", token).setContentType(ContentType.JSON).build();

		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setCountry("India");
		orderDetail.setProductOrderedId(ProductId);

		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();

		orderDetailList.add(orderDetail);

		Orders firstOrder = new Orders();
		firstOrder.setOrders(orderDetailList);

		RequestSpecification REq = given().log().all().spec(createOrderReq).body(firstOrder);
		// MakeOrder createOrderreq =
		// REq.when().post("api/ecom/order/create-order").then().extract().response()
		// .as(MakeOrder.class);
		String createOrderreq = REq.when().post("api/ecom/order/create-order").then().extract().response().asString();

		JsonPath js1 = new JsonPath(createOrderreq);
		String orderNum = js1.getString("orders");
		String productOrder = js1.getString("productOrderId");
		String product_message = js1.getString("message");

		System.out.println("Order  num is : " + orderNum);
		System.out.println("Product id is : " + productOrder);
		System.out.println("Message is : " + product_message);

		// Delete Product

		RequestSpecification deleteOrderReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", token).build();
		RequestSpecification deleteReq= given().spec(deleteOrderReq).pathParam("ProductId", ProductId);
		String delReq= deleteReq.when().delete("/api/ecom/product/delete-product/{ProductId}").then().log().all().extract().response().asString();
		JsonPath js2 = new JsonPath(delReq);
		String message_del = js2.getString("message");
		System.out.println(message_del);
		

	}

}
