@Anatol
Feature: Demo feature

  Background: open browser
    Given Mobile de is opened and language changed to English

  Scenario: Validate Parking to My Car Park functionality
    Given user is logged in Mobile de and search button was clicked
    When 1 random car from list was parked
    And car park button was clicked
    Then car is displayed on car park page

  Scenario: Validate restoring cars functionality on My Car Park page
    Given user is logged in Mobile de and search button was clicked
    And  1 random car from list was parked
    And  car park button was clicked
    When user clicks on remove button
    Then removed car disappears and undo button is displayed
    When user clicks on undo button
    Then removed car is restored

  Scenario: Validate Removing functionality on My Car Park page
    Given user is logged in Mobile de and search button was clicked
    And  1 random car from list was parked
    And  car park button was clicked
    When user clicks on remove button
    And  user click on delete button
    Then message "You have no vehicles in your car park yet" is displayed

  Scenario Outline: Validate Add Note functionality
    Given user is logged in Mobile de and search button was clicked
    And 1 random car from list was parked
    And car park button was clicked
    When click on add note button under car and enter <text> in field
    And click on hide note button and click show note button
    Then the same <text> is displayed
    Examples:
      | text   |
      | Anatol |
      | Tolean |
      | Tolik  |

  Scenario: Validate Compare functionality on My Car Park page Compare these cars
    Given user is logged in Mobile de and search button was clicked
    And 2 random car from list was parked
    And car park button was clicked
    When click on compare checkboxes under cars and click on run comparison button
    Then comparison page with cars is displayed