package com.easysignage.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.easysignage.common.BasePage;

public class PlayListsPage extends BasePage {

	By playlistSettingsCloseButton = By
			.xpath("//div[text()='Playlist Settings']//following::i[contains(text(),'close')]");

	By horizontalButton = By.xpath("//button//span[text()='Horizontal']");

	By addButton = By.xpath("//button[span[text()=' Add ']]");

	By cloneButton = By.xpath("//button[span[text()=' Clone ']]");

	By deleteButtonButton = By.xpath("//button[span[text()=' Delete ']]");

	By deleteConfirmYesButton = By.xpath(
			"//div[contains(text(),'This will permanently delete this content from our server, do you want to continue?')]//following::button[span[contains(text(),'Yes')]]");

	By addWindowNameTextbox = By.xpath("// label[text()='Name']//following::input[1]");

	By addWindowSaveButton = By.xpath("//label[text()='Name']//following::button[span[text()='Save']]");

	By playListNameTextbox = By.xpath("//label[text()='Playlist Name']//following::input[1]");

	By playListNameSaveButton = By
			.xpath("//label[text()='Playlist Name']//following::button[contains(text(),'save')][1]");

	By manualControlOfPlaylistCheckbox = By.xpath("//div[text()=' Manual control of playlist ']//preceding::input[1]");

	By showNavigationButtonsCheckbox = By.xpath("//div[text()=' Show Navigation Buttons ']//preceding::input[1]");

	By showTapToStartCheckbox = By.xpath("//div[text()=' Show Tap To Start ']//preceding::input[1]");

	By changeTapTostartText = By.xpath("//label[(text()='Tap to start text')]//following::input[1]");

	By changeTapToStarttextsaveButton = By
			.xpath("//label[text()='Tap to start text']//following::button[contains(text(),'save')][1]");

	By transitionButton = By.xpath(
			"//label[text()='Transition']//following::i[@class='v-icon notranslate mdi mdi-menu-down theme--light'][1]");

	By transitionSelectedValue = By.xpath(
			"//label[text()='Transition']//following::div[@class='v-select__selection v-select__selection--comma']");

	By screenSaverButton = By.xpath(
			"//label[text()='Screensaver']//following::i[@class='v-icon notranslate mdi mdi-menu-down theme--light'][1]");

	By backButton = By.xpath(
			"//button[@class='v-btn v-btn--depressed v-btn--flat v-btn--text theme--dark v-size--default primary--text']//span[contains(text(),'Back')]");

	By resetTimeoutSlider = By
			.xpath("//div[text()=' Reset timeout (seconds) ']//following::div[@class='v-slider__thumb primary']");

	By resetTimeoutInput = By.xpath("//div[text()=' Reset timeout (seconds) ']//following::input[1]");

	public PlayListsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickHorizontalButton() {
		FindElement(horizontalButton).click();
	}

	public void closePlaylistSetting() {
		FindElement(playlistSettingsCloseButton).click();
	}

	private String GetPlayListXPath(String playlistName) {
		return String.format(
				"//div[@class= 'container grid-list-md text-xs-center']//div[@class= 'layout row wrap']//div[@class= 'flex xs12' and text()= ' %s ']",
				playlistName);
	}

	public boolean isPlayListExist(String playlistName) {
		By playList = By.xpath(GetPlayListXPath(playlistName));

		try {
			return (FindElement(playList) != null);
		} catch (Exception e) {
			return false;
		}
	}

	public void clickPlaylistSettings(String playlistName) {

		String playListSettingsPath = GetPlayListXPath(playlistName) + "//following::button[1]";

		By playListSettings = By.xpath(playListSettingsPath);

		FindElement(playListSettings).click();
		TimeDelay(2000);
	}

	// Add New PlayList
	public void clickAddButton() {
		FindElement(addButton).click();
		TimeDelay(3000);
	}

	public void setEnterNameTextbox(String name) {
		FindElement(addWindowNameTextbox).sendKeys(name);
	}

	public String getEnterNameTextbox() {
		WebElement nameText = FindElement(addWindowNameTextbox);
		return nameText.getAttribute("value");
	}

	public void addWindowSaveButtonClick() {

		FindElement(addWindowSaveButton).click();
	}

	// Change PlayList name
	public void setEnterPlaylistNameTextbox(String name) {

		WebElement nameTextbox = FindElement(playListNameTextbox);
		nameTextbox.sendKeys(Keys.CONTROL + "a");
		nameTextbox.sendKeys(name);
	}

	public String getEnterPlaylistNameTextboxValue() {
		WebElement nameTextbox = FindElement(playListNameTextbox);
		return nameTextbox.getAttribute("value");
	}

	public void clickPlayListNameSaveButton() {

		FindElement(playListNameSaveButton).click();
	}

	// Manual Control Of Playlist Checkbox
	public void checkManualControlOfPlaylistCheckbox() {

		WebElement manualCheckbox = driver.findElement(manualControlOfPlaylistCheckbox);
		
		if (manualCheckbox.getAttribute("checked") == null) {
			JavaScriptClick(manualCheckbox);
		}
	}

	public boolean getManualControlOfPlaylistCheckbox() {

		WebElement manualCheckbox = driver.findElement(manualControlOfPlaylistCheckbox);
		return Boolean.parseBoolean(manualCheckbox.getAttribute("checked"));

//		String checkVale = manualCheckbox.getAttribute("checked");
//		retun Boolean.parseBoolean(checkVale);
	}

	// Show Navigation Buttons Checkbox
	public void checkShowNavigationButtonsCheckbox() {

		WebElement showNavCheckbox = driver.findElement(showNavigationButtonsCheckbox);

		if (showNavCheckbox.getAttribute("checked") == null) {
			JavaScriptClick(showNavCheckbox);
		}
		TimeDelay(3000);
	}

	public boolean getShowNavigationButtonsCheckbox() {

		WebElement showNavCheckbox = driver.findElement(showNavigationButtonsCheckbox);
		return Boolean.parseBoolean(showNavCheckbox.getAttribute("checked"));
	}

	// Show Tap To Start Checkbox
	public void checkshowTapToStartCheckbox() {

		WebElement showTapCheckbox = driver.findElement(showTapToStartCheckbox);

		if (showTapCheckbox.getAttribute("checked") == null) {
			JavaScriptClick(showTapCheckbox);
		}
		TimeDelay(3000);
	}

	public boolean getCheckshowTapToStartCheckboxValue() {

		WebElement showTapCheckbox = driver.findElement(showTapToStartCheckbox);
		return Boolean.parseBoolean(showTapCheckbox.getAttribute("checked"));
	}

	// Change Tap To Start Textbox
	public void setTapToStartTextbox(String name) {

		WebElement nameText = FindElement(changeTapTostartText);
		nameText.sendKeys(Keys.CONTROL + "a");
		nameText.sendKeys(name);
	}

	public String getchangeTapToStartTextboxValue() {
		return FindElement(changeTapTostartText).getAttribute("value");
	}

	public void changeTapToStartTextSaveButtonClick() {

		FindElement(changeTapToStarttextsaveButton).click();
	}

	// Clone Button
	public void cloneButtonClick() {
		FindElement(cloneButton).click();
	}

	// Delete Button
	public void deleteBUttonClick() {
		FindElement(deleteButtonButton).click();
	}

	public void yesButtonClick() {
		FindElement(deleteConfirmYesButton).click();
	}

	// Reset Timeout
	public void setResetTimeout(double seconds) {

		int timeout = (int) seconds;
		WebElement slider = driver.findElement(resetTimeoutSlider);

		Actions actions = new Actions(driver);
		// actions.moveToElement(slider).clickAndHold().moveByOffset(-400,
		// 0).release().perform();

		actions.moveToElement(slider).click(slider).perform();

		for (int i = 0; i < timeout; i++) {

			actions.sendKeys(Keys.ARROW_DOWN).perform();
		}

		for (int i = 0; i < timeout; i++) {

			actions.sendKeys(Keys.ARROW_UP).perform();
		}

		TimeDelay(2000);
	}

	public String getCurrentResetValue() {
		WebElement resetTime = driver.findElement(resetTimeoutInput);
		return resetTime.getAttribute("value");
	}

	// Transition dropdown
	public void clickTransitionDropDown() {
		FindElement(transitionButton).click();
	}

	public void selectTransitionDropDownOption(String transintion) {
		String selectOption = String.format("//div[@role='listbox']//div[@role='option']//div[text()='%s']",
				transintion);
		FindElement(By.xpath(selectOption)).click();
		TimeDelay(3000);
	}

	public String getTransitionSelectedValue() {
		return FindElement(transitionSelectedValue).getText();
	}

	public void clickScreenSaverDropDown() {
		FindElement(screenSaverButton).click();
	}

	public void selectScreenSaverDropDownOption(String ScreenSaver) {
		String selectOption = String.format("//div[@role='listbox']//div[@role='option']//div[text()='%s']",
				ScreenSaver);
		FindElement(By.xpath(selectOption)).click();
		TimeDelay(3000);
	}

	public void clickOnBackButton() {
		FindElement(backButton).click();
	}

	public void addPlayListIfNotExist(String playListName) {

		if (!isPlayListExist(playListName)) {
			clickAddButton();
			setEnterNameTextbox(playListName);
			addWindowSaveButtonClick();
			clickOnBackButton();
		}
	}

	public boolean isScreenSaverVisible() {
		return FindElement(screenSaverButton).isEnabled();
	}

	public boolean isShowTapToStartDisabled() {
		WebElement showTapCheckbox = driver.findElement(showTapToStartCheckbox);
		return Boolean.parseBoolean(showTapCheckbox.getAttribute("disabled"));
	}
}
