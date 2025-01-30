@test
Feature: DeepLink Check

  Scenario: When you click the Instagram link (https://go.ab180.co/8vpfwh), check if it moves to the store (ablog).
    # Given Instagram open
    When Add "https://go.ab180.co/8vpfwh" link to your profile
    And Click on link
    And Go to external app Continue Click
    Then Go to the App Store and make sure you are directed to the ablog installation page.
