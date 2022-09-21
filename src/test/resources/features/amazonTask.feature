@amazon
Feature: Amazon Automation Test

  @Amazon
  Scenario: Retrieve data from the second priced Samsung TV item on Amazon.in
    Given user is on the Amazon Home page
    When user clicks the hamburger menu
    And user clicks the Tv Appliances Electronics Button
    And user clicks the Televisions Button
    And user goes all the way down and clicks the "LG" Button
    And user clicks the sort button and sorts high to low
    And user clicks the second highest priced item
    Then user verifies that About this item is visible and log the text
