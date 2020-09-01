package com.easysignage.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.easysignage.common.BasePage;

public class HomePage extends BasePage {

	By loginLink = By.linkText("Login");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnLogin() {

		FindElement(loginLink).click();
	}

	public void swithToLoginTab() {
		ArrayList<String> allHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allHandles.get(1));
	}
}
