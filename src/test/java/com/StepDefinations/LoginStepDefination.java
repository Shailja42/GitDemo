package com.StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import com.mainpages.*;

public class LoginStepDefination extends LoginPage {

	@Given("^I launch the application$")
	public void i_launch_the_application() throws IOException {
		launch();
	}

	@And("^I fill From location with Delhi and To location with Pune$")
	public void i_fill_from_location_with_and_to_location_with() throws IOException, InterruptedException {
		book_form();
	}
	
	@Then("^I select the class type$")
	public  void i_select_the_class_type() throws InterruptedException {
		select_class();
		
	}
	
	@When("^I confrim the booking$")
	public  void i_confrim_the_booking() throws InterruptedException {
		confirm_booking();
		
	}

	

}
