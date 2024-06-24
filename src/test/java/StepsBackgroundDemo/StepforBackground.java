package StepsBackgroundDemo;

import io.cucumber.java.en.*;

public class StepforBackground {
	@Given("user on login page")
	public void user_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("background");
	}

	@When("user click on welcome link")
	public void user_click_on_welcome_link() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("background");
	}

	@Then("logout liink is visiable")
	public void logout_liink_is_visiable() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("background");
	}

	@Given("user loggin")
	public void user_loggin() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("background");
	}

	@When("click on dashboard link")
	public void click_on_dashboard_link() {
	    // Write code here that turns the phrase above into concrete actions
	    //hrow new io.cucumber.java.PendingException();
	    System.out.println("background");
	}

	@Then("quick lunch toolbar displayed")
	public void quick_lunch_toolbar_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("background");
	}
	
// ----------background code------------------------
	
	
	@Given("user in login page")
	public void user_in_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("bbbbbbbbbbbbbbackground");
	}

	@When("enter email and password")
	public void enter_email_and_password() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("click submit")
	public void click_submit() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("navigated to home")
	public void navigated_to_home() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}



}
