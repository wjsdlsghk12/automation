@test
Feature: Check app launch when link is clicked

  Scenario: Access the Instagram test page (https://dev.blog.airbridge.io/sdk-qa/) and click the (PlayStore) link. Check whether the ablog app runs when clicked
    # Given Instagram open
    When Add "https://dev.blog.airbridge.io/sdk-qa/" link to your profile
    And Click on link
    And "PlayStore" link click
    And Go to external app Continue Click
    And ttt
