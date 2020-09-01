package com.easysignage.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	public WebDriver driver;

	public WebElement FindElement(By element, long timeSpan) {
		WebDriverWait wait = new WebDriverWait(driver, timeSpan);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public WebElement FindElement(By element) {
		return FindElement(element, 5);
	}

	public void JavaScriptClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void TimeDelay(long timeSpan) {
		try {
			Thread.sleep(timeSpan);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
