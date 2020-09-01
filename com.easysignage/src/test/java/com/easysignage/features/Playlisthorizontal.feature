Feature: Horizontal playlist
  Horizontal playlist functionality will be automated

  Background: Goto Playlist and select Horizontal
    Given Goto playlist page and select horizontal option

  @Completed @AddPalyList
  Scenario: Add new horizonatal playlist
    Given Select add button
      And Enter a name for your playlist
     When Click on save button
     Then The playlist should be created and the user should be redirected to the next page to choose layout

  @Completed @DeletePlayList
  Scenario: Delete playlist
    Given Click on the yellow Setting icon of the playlist which you want to delete
      And Click on the 'Delete' button to delete the selected playlist
     When Click on 'Yes' button to confirm the delete
     Then The playlist should be deleted

  @Completed @ClonePlayList
  Scenario: Clone playlist
    Given Click on the yellow Setting icon of the playlist which you want to clone
     When Click on the Clone button
     Then The playlist should be cloned and the user should be redirected to the media page

  @Completed @Changeplaylistname
  Scenario: Change playlist name
    Given Click on the yellow Setting icon of the playlist which you want to rename
     When Enter the new name in 'Playlist name field'
      And Close the sidebar reopen the sidebar
     Then The name of the playlist should be changed

  @Completed @ChangePlayListTransition
  Scenario: Change playlist transition
    Given Click on the setting icon of the playlist
     When Click on the 'transition' dropdown
      And Select the new transition style from the dropdown list
     Then The new transition should be applied

  @Completed @ManualControlOfPlayList
  Scenario: Select manual control option of playlist
    Given Click on the setting icon of the playlist
      And Click on the checkbox Manual Control of Playlist
     Then More form fields should be opened below the checkbox

  @Completed @NavigationButtons
  Scenario: Select show navigation buttons of playlist
    Given Click on the setting icon of the playlist
      And Click on the checkbox show navigation buttons
     Then The show navigation buttons checkbox should be checked and the option should be saved

  @Completed @PlaylistNoScreensaver
  Scenario: Screensaver with no screen saver selection
    Given Click on the setting icon of the playlist
      And Click on the checkbox Manual Control of Playlist
      And Click on 'Screen Saver' dropdown
     When Select no screen  from the 'screen saver' dropdown
     Then The option for 'Show tap to start' should be disabled

  @Completed @PlaylistScreensaver
  Scenario: Screensaver with screen saver selection
    Given Click on the setting icon of the playlist
      And Click on the checkbox Manual Control of Playlist
      And Click on 'Screen Saver' dropdown
     When Select any screen from the 'screen saver' dropdown
     Then The option for 'Show tap to start' should be enabled

  @Completed @CheckTapToStartCheckbox
  Scenario: Click on show tap to start checkbox
    Given Click on the setting icon of the playlist
      And Click on the checkbox Manual Control of Playlist
      And Click on 'Screen Saver' dropdown
     When Select any screen from the 'screen saver' dropdown
      And Click on the checkbox 'Show Tap to Start' to check it
     Then The show tap to start checkbox should be checked and the option should be saved

  @Completed @ChangeTapToStartText
  Scenario: Select Tap To Start Text
    Given Click on the setting icon of the playlist
      And Click on the checkbox Manual Control of Playlist
      And Click on 'Screen Saver' dropdown
     When Select any screen from the 'screen saver' dropdown
      And Click on the checkbox 'Show Tap to Start' to check it
      And Click on the text and enter new text
      And Close the sidebar reopen the sidebar
     Then The text entered for tap to start in the previous step should be saved.

  @ChangeResetTimeout
  Scenario: Change Reset Timeout
    Given Click on the setting icon of the playlist
      And Click on the checkbox Manual Control of Playlist
     When Find the Reset Timeout option and drag the icon to the position according to time you need
     Then The new Reset Timeout time should be applied.
