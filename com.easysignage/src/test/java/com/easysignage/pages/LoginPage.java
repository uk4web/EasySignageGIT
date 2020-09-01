package com.easysignage.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.easysignage.common.BasePage;
import com.easysignage.common.ConfigFileReader;

public class LoginPage extends BasePage {
	
	By userNameTextbox = By.xpath("//input[@name='login']");
	By PasswordTextbox = By.xpath("//input[@name='password']");
	By loginButton = By.xpath("//span[@class='v-btn__content'][contains(text(),'Login')]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void Login() {

		TimeDelay(2000);
		FindElement(userNameTextbox,10).sendKeys(ConfigFileReader.getInstance().getUserName());
		FindElement(PasswordTextbox).sendKeys(ConfigFileReader.getInstance().getPassword());
		FindElement(loginButton).click();
		TimeDelay(3000);
	}

}
