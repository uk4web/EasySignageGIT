//package com.easysignage.steps;
//
//import com.easysignage.common.BaseTest;
//import com.easysignage.pages.HomePage;
//import com.easysignage.pages.LoginPage;
//
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
//import org.junit.Assert;
//
//public class Login extends BaseTest {
//
//	LoginPage loginPage;
//	HomePage homePage;
//
//	@Before
//	public void intialSetup() {
//		setup();
//	}
//
//	@After
//	public void tearDown() {
//		cleanUp();
//	}
//
//	@Given("Goto login page")
//	public void goto_login_page() throws Throwable {
//		homePage = new HomePage(driver);
//		homePage.clickOnLogin();		
//		homePage.swithToLoginTab();
//	}
//
//	@Given("Enter correct userid and password")
//	public void enter_correct_userid_and_password() throws Throwable {
//		loginPage = new LoginPage(driver);
//	}
//
//	@When("Click on login")
//	public void click_on_login() throws Throwable {
//		loginPage.Login();		
//	}
//
//	@Then("Login Should be successfull")
//	public void login_Should_be_successfull() throws Throwable {
//		System.out.println(driver.getCurrentUrl());
//		Assert.assertEquals("https://manage.easysignage.com/#/dashboard", driver.getCurrentUrl());
//	}
//}
