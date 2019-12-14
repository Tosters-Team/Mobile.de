@Anatol
Feature: Demo feature

  Background: open browser
    Given mobile de is opened and language changed to English

  Scenario: Validate Parking to My Car Park functionality
    Given user is logged in Mobile de and search button was clicked
    When 1 random car from list was parked
    Then car is displayed on car park page

  Scenario: Validate Compare functionality on My Car Park page Compare these cars
    Given user is logged in Mobile de and search button was clicked
    And  2 random car from list was parked
    And click on car park button
    And click on compare checkboxes under cars
    Then comparison page with cars is displayed

  Scenario Outline: Validate Add Note functionality
    Given login to Mobile de and click on car park button
    When click on add note button under  car and enter <text> in field
    And click on hide note button and click show note button
    Then the same <text> is displayed
    Examples:
      | text   |
      | Anatol |
      | Java   |
      | Python |

  Scenario: Validate Removing functionality on My Car Park page