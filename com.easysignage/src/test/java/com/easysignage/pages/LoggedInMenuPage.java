package com.easysignage.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.easysignage.common.BasePage;

public class LoggedInMenuPage extends BasePage {
	
	By playlistsButton = By.xpath("//button[@class='hidden-xs-only v-btn v-btn--flat v-btn--text theme--light v-size--default primary--text']//span[contains(text(),'Playlists')]");

	public LoggedInMenuPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void SelectPlaylist()
	{
		FindElement(playlistsButton).click();
		TimeDelay(3000);
	}
}
