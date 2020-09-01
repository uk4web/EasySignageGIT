package com.easysignage.common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.nio.charset.Charset;
import java.util.Random;


public class BaseTest {

	public WebDriver driver;

	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\SampleApplications\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to(ConfigFileReader.getInstance().getBaseUrl());
		driver.manage().window().maximize();
	}

	public void cleanUp() {
		
		if (driver != null) {
			driver.quit();
		}
	}	

	public void TimeDelay(long timeSpan) {
		try {
			Thread.sleep(timeSpan);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getCellData(String sheetName, int row, int column) {
		return DataHelper.GetDataHelper().getCellData(sheetName, row, column);
	}
	
	public double getCellNumberData(String sheetName, int row, int column) {
		return DataHelper.GetDataHelper().getCellNumberData(sheetName, row, column);
	}

	public static String getAlphaNumericString(int n) {

		// https://www.geeksforgeeks.org/generate-random-string-of-given-size-in-java/
		// length is bounded by 256 Character
		byte[] array = new byte[256];
		new Random().nextBytes(array);

		String randomString = new String(array, Charset.forName("UTF-8"));

		// Create a StringBuffer to store the result
		StringBuffer r = new StringBuffer();

		// Append first 20 alphanumeric characters
		// from the generated random String into the result
		for (int k = 0; k < randomString.length(); k++) {

			char ch = randomString.charAt(k);

			if (((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) && (n > 0)) {

				r.append(ch);
				n--;
			}
		}

		// return the resultant string
		return r.toString();
	}
}
