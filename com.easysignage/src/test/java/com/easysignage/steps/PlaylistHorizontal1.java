package com.easysignage.steps;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.easysignage.common.BaseTest;
import com.easysignage.pages.HomePage;
import com.easysignage.pages.LoggedInMenuPage;
import com.easysignage.pages.LoginPage;
import com.easysignage.pages.PlayListsPage;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PlaylistHorizontal1 extends BaseTest {

	final String PLAYLIST_SHEET_NAME = "Playlist";
	String currentPlaylistName;
	String resetTimeOutCurrentValue = null;

	LoginPage loginPage;
	HomePage homePage;
	LoggedInMenuPage loggedinMenuPage;
	PlayListsPage playListsPage;

	@Before
	public void IntialSetup() {
		setup();
	}

	@After
	public void tearDown(Scenario scenario) {
		afterScenario(scenario);
		cleanUp();
	}

	private void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				// This takes a screenshot from the driver at save it to the specified location
				File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				// Building up the destination path for the screenshot to save
				// Also make sure to create a folder 'screenshots' with in the cucumber-report
				// folder
				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/"
						+ screenshotName + ".png");

				// Copy taken screenshot from source location to destination location
				Files.copy(sourcePath, destinationPath);

				// This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			}
		}
	}

	@Given("^Goto playlist page and select horizontal option$")
	public void goto_playlist_page_and_select_horizontal_option() throws Throwable {

		homePage = new HomePage(driver);
		homePage.clickOnLogin();
		homePage.swithToLoginTab();

		loginPage = new LoginPage(driver);
		loginPage.Login();

		loggedinMenuPage = new LoggedInMenuPage(driver);
		loggedinMenuPage.SelectPlaylist();

		playListsPage = new PlayListsPage(driver);
		playListsPage.clickHorizontalButton();
	}

	// Add Playlist
	@Given("^Select add button$")
	public void select_add_button() throws Throwable {
		playListsPage.clickAddButton();
	}

	@Given("^Enter a name for your playlist$")
	public void enter_a_name_for_your_playlist() throws Throwable {
		generatePlaylistName();
		playListsPage.setEnterNameTextbox(currentPlaylistName);
	}

	private void generatePlaylistName() {
		currentPlaylistName = getAlphaNumericString(10);
	}

	@When("^Click on save button$")
	public void click_on_save_button() throws Throwable {
		playListsPage.addWindowSaveButtonClick();
	}

	@Then("^The playlist should be created and the user should be redirected to the next page to choose layout$")
	public void the_playlist_should_be_created_and_the_user_should_be_redirected_to_the_next_page_to_choose_layout()
			throws Throwable {
		Assert.assertTrue(playListsPage.isPlayListExist(currentPlaylistName));
	}

	// Delete Playlist

	@Given("^Click on the yellow Setting icon of the playlist which you want to delete$")
	public void click_on_the_yellow_Setting_icon_of_the_playlist_which_you_want_to_delete() throws Throwable {

		String deletePlayListName = getCellData(PLAYLIST_SHEET_NAME, 3, 2);
		currentPlaylistName = deletePlayListName;
		playListsPage.addPlayListIfNotExist(deletePlayListName);
		playListsPage.clickPlaylistSettings(deletePlayListName);
	}

	@Given("^Click on the 'Delete' button to delete the selected playlist$")
	public void click_on_the_Delete_button_to_delete_the_selected_playlist() throws Throwable {
		playListsPage.deleteBUttonClick();
	}

	@When("^Click on 'Yes' button to confirm the delete$")
	public void click_on_Yes_button_to_confirm_the_delete() throws Throwable {
		playListsPage.yesButtonClick();
	}

	@Then("^The playlist should be deleted$")
	public void the_playlist_should_be_deleted() throws Throwable {
		Assert.assertFalse(playListsPage.isPlayListExist(getCellData(PLAYLIST_SHEET_NAME, 3, 2)));
	}

	// Clone Playlist
	@Given("^Click on the yellow Setting icon of the playlist which you want to clone$")
	public void click_on_the_yellow_Setting_icon_of_the_playlist_which_you_want_to_clone() throws Throwable {

		String clonePlayListName = getCellData(PLAYLIST_SHEET_NAME, 3, 1);
		currentPlaylistName = clonePlayListName;
		playListsPage.addPlayListIfNotExist(clonePlayListName);
		playListsPage.clickPlaylistSettings(clonePlayListName);
	}

	@When("^Click on the Clone button$")
	public void click_on_the_Clone_button() throws Throwable {
		playListsPage.cloneButtonClick();
	}

	@Then("^The playlist should be cloned and the user should be redirected to the media page$")
	public void the_playlist_should_be_cloned_and_the_user_should_be_redirected_to_the_media_page() throws Throwable {
		Assert.assertTrue(playListsPage.isPlayListExist(getCellData(PLAYLIST_SHEET_NAME, 3, 1) + "-clone"));
	}

	// transition' dropdown
	@Given("^Click on the setting icon of the playlist$")
	public void click_on_the_setting_icon_of_the_playlist() throws Throwable {
		String updatePlayListName = getCellData(PLAYLIST_SHEET_NAME, 3, 0);
		currentPlaylistName = updatePlayListName;
		playListsPage.addPlayListIfNotExist(updatePlayListName);
		playListsPage.clickPlaylistSettings(updatePlayListName);
	}

	@When("^Click on the 'transition' dropdown$")
	public void click_on_the_transition_dropdown() throws Throwable {
		playListsPage.clickTransitionDropDown();
	}

	@When("^Select the new transition style from the dropdown list$")
	public void select_the_new_transition_style_from_the_dropdown_list() throws Throwable {
		playListsPage.selectTransitionDropDownOption(getCellData(PLAYLIST_SHEET_NAME, 3, 3));
	}

	@Then("^The new transition should be applied$")
	public void the_new_transition_should_be_applied() throws Throwable {
		Assert.assertEquals(getCellData(PLAYLIST_SHEET_NAME, 3, 3), playListsPage.getTransitionSelectedValue());
	}

	// Manual Control of Playlist
	@Given("^Click on the checkbox Manual Control of Playlist$")
	public void click_on_the_checkbox_Manual_Control_of_Playlist() throws Throwable {
		playListsPage.checkManualControlOfPlaylistCheckbox();
	}

	@Then("^More form fields should be opened below the checkbox$")
	public void more_form_fields_should_be_opened_below_the_checkbox() throws Throwable {
		Assert.assertTrue(playListsPage.isScreenSaverVisible());
	}

	// Screen saver
	@Given("^Click on 'Screen Saver' dropdown$")
	public void click_on_Screen_Saver_dropdown() throws Throwable {
		playListsPage.clickScreenSaverDropDown();
	}

	@When("^Select any screen from the 'screen saver' dropdown$")
	public void select_screen_saver_from_the_dropdown_list() throws Throwable {
		playListsPage.selectScreenSaverDropDownOption(getCellData(PLAYLIST_SHEET_NAME, 3, 4));
	}

	@When("^The option for 'Show tap to start' should be enabled$")
	public void the_new_screen_saver_should_be_applied() throws Throwable {
		Assert.assertFalse(playListsPage.isShowTapToStartDisabled());
	}

	@When("^Select no screen  from the 'screen saver' dropdown$")
	public void select_no_screen_from_the_screen_saver_dropdown() throws Throwable {
		playListsPage.selectScreenSaverDropDownOption(getCellData(PLAYLIST_SHEET_NAME, 3, 5));
	}

	@Then("^The option for 'Show tap to start' should be disabled$")
	public void the_option_for_Show_tap_to_start_should_be_disabled() throws Throwable {
		Assert.assertTrue(playListsPage.isShowTapToStartDisabled());
	}

	// Show tap to start
	@When("^Click on the checkbox 'Show Tap to Start' to check it$")
	public void click_on_the_checkbox_Show_Tap_to_Start_to_check_it() throws Throwable {
		playListsPage.checkshowTapToStartCheckbox();
	}

	@Then("^The show tap to start checkbox should be checked and the option should be saved$")
	public void the_show_tap_to_start_checkbox_should_be_checked_and_the_option_should_be_saved() throws Throwable {
		Assert.assertTrue(playListsPage.getCheckshowTapToStartCheckboxValue());
	}

	// Tap to start text
	@When("^Click on the text and enter new text$")
	public void click_on_the_text_and_enter_new_text() throws Throwable {
		playListsPage.setTapToStartTextbox(getCellData(PLAYLIST_SHEET_NAME, 3, 6));
		playListsPage.changeTapToStartTextSaveButtonClick();
	}

	@When("^Close the sidebar reopen the sidebar$")
	public void close_the_sidebar_reopen_the_sidebar() throws Throwable {
		playListsPage.closePlaylistSetting();
		playListsPage.clickPlaylistSettings(currentPlaylistName);
	}

	@Then("^The text entered for tap to start in the previous step should be saved\\.$")
	public void the_text_entered_for_tap_to_start_in_the_previous_step_should_be_saved() throws Throwable {
		Assert.assertEquals(getCellData(PLAYLIST_SHEET_NAME, 3, 6), playListsPage.getchangeTapToStartTextboxValue());
	}

	@Given("^Click on the checkbox show navigation buttons$")
	public void click_on_the_checkbox_show_navigation_buttons() throws Throwable {

		playListsPage.checkShowNavigationButtonsCheckbox();
	}

	@Then("^The show navigation buttons checkbox should be checked and the option should be saved$")
	public void the_show_navigation_buttons_checkbox_should_be_checked_and_the_option_should_be_saved()
			throws Throwable {

		Assert.assertTrue(playListsPage.getShowNavigationButtonsCheckbox());
	}

	@When("^Find the Reset Timeout option and drag the icon to the position according to time you need$")
	public void find_the_Reset_Timeout_option_and_drag_the_icon_to_the_position_according_to_time_you_need()
			throws Throwable {
		resetTimeOutCurrentValue = playListsPage.getCurrentResetValue();
		playListsPage.setResetTimeout(getCellNumberData(PLAYLIST_SHEET_NAME, 3, 8));
	}

	@Then("^The new Reset Timeout time should be applied\\.$")
	public void the_new_Reset_Timeout_time_should_be_applied() throws Throwable {
		Assert.assertEquals(resetTimeOutCurrentValue, playListsPage.getCurrentResetValue());
	}

	@Given("^Click on the yellow Setting icon of the playlist which you want to rename$")
	public void click_on_the_yellow_Setting_icon_of_the_playlist_which_you_want_to_rename() throws Throwable {

		String renamePlayListName = getCellData(PLAYLIST_SHEET_NAME, 3, 9);

		playListsPage.addPlayListIfNotExist(renamePlayListName);
		playListsPage.clickPlaylistSettings(renamePlayListName);
	}

	@When("^Enter the new name in 'Playlist name field'$")
	public void enter_the_new_name_in_Playlist_name_field() throws Throwable {
		String renamePlaylist = getCellData(PLAYLIST_SHEET_NAME, 3, 10);
		playListsPage.setEnterPlaylistNameTextbox(renamePlaylist);
		playListsPage.clickPlayListNameSaveButton();
		currentPlaylistName = renamePlaylist;
	}

	@Then("^The name of the playlist should be changed$")
	public void the_name_of_the_playlist_should_be_changed() throws Throwable {
		Assert.assertEquals(getCellData(PLAYLIST_SHEET_NAME, 3, 10), playListsPage.getEnterPlaylistNameTextboxValue());
	}

}
