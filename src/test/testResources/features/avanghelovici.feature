@Artur
Feature: Demo feature

  Background: opening browser
    Given Mobile de is opened and language changed to English

  Scenario Outline: Validate Quick Search functionality on cars category
    When I select <make> in Make drop-down
    And select <model> in Model drop-down
    And select price up to <price>
    And click on Search button
    Then cars search was done and only cars of <make> and <model> under <price> are displayed
    Examples:
      | make          | model | price   |
      | BMW           | 5     | €10,000 |
      | Mercedes-Benz | E     | €15,000 |
      | Audi          | A6    | €8,000  |


  Scenario: Validate Login functionality positive
    Given Login page is opened
    When I provide valid credentials Email and Password
    And click on Log in Button
    Then I have successfully logged in