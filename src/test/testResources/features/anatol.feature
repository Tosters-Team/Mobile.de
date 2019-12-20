@Anatol
Feature: Demo feature

  Background: Mobile de is opened
    Given User clicks on 'Language selector drop-down' on 'Header'
    And User clicks on 'English language option'


  Scenario: Validate parking to My Car Park functionality
    Given User is logged in Mobile de
    And User is on 'Home Page'
    And User clicks on 'Search button'
    And User is on 'Car List Page'
    When User clicks on 2 random 'Park button'
    And User clicks on 'My car park button' on 'Header'
    Then User is on 'Car Park Page'
    And  Cars are displayed


  Scenario: Validate Removing functionality on My Car Park page
    Given User is logged in Mobile de
    And User is on 'Home Page'
    And User clicks on 'Search button'
    And User is on 'Car List Page'
    And User clicks on 2 random 'Park button'
    And User clicks on 'My car park button' on 'Header'
    And User is on 'Car Park Page'
    When User clicks on all 'Remove buttons'
    And User clicks on all 'X buttons'
    Then 'You have no vehicles in your car park yet' message is displayed

  Scenario: Validate restoring cars functionality on My Car Park page
    Given User is logged in Mobile de
    And User is on 'Home Page'
    And User clicks on 'Search button'
    And User is on 'Car List Page'
    And User clicks on 2 random 'Park button'
    And User clicks on 'My car park button' on 'Header'
    And User is on 'Car Park Page'
    When User clicks on all 'Remove buttons'
    And User clicks on all 'Undo buttons'
    Then Cars are displayed


  Scenario Outline: Validate Add Note functionality
    Given User is logged in Mobile de
    And User is on 'Home Page'
    And User clicks on 'Search button'
    And User is on 'Car List Page'
    And User clicks on 1 random 'Park button'
    And User clicks on 'My car park button' on 'Header'
    And User is on 'Car Park Page'
    When User clicks on 'Note button'
    And User provides '<text>' in 'Note field'
    And User clicks on 'Note button'
    And User clicks on 'Note button'
    Then the same <text> is displayed
    Examples:
      | text           |
      | Text           |
      | Some Text      |
      | Add Note Field |

  Scenario: Validate Compare functionality on My Car Park page Compare these cars
    Given User is logged in Mobile de
    And User is on 'Home Page'
    And User clicks on 'Search button'
    And User is on 'Car List Page'
    And User clicks on 2 random 'Park button'
    And User clicks on 'My car park button' on 'Header'
    And User is on 'Car Park Page'
    When User clicks on all 'Compare checkboxes'
    And User clicks on 'Run comparison button'
    Then User is on 'Comparison Page'
    And 'Comparison table' is displayed