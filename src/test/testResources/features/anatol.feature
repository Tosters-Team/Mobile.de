@Anatol
Feature: Demo feature
  Background: open browser
    Given mobile de is opened and language changed to English

    Scenario: Validate Parking to My Car Park functionality
      Given login to Mobile de and click on search button
      When click on park button to add the first car
      And click on park button to add the second car
      And click on car park button
      Then added cars are displayed