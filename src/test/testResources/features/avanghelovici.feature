@Artur
Feature: Demo feature

  Background: opening browser
    Given Mobile de is opened and language changed to English

  Scenario Outline: Validate Quick Search functionality on cars category
    When User select <make> in Make drop-down
    And select <model> in Model drop-down
    And select price up to <price>
    And click on Search button
    Then cars search was done and only cars of <make> and <model> under <price> are displayed
    Examples:
      | make          | model | price   |
      | BMW           | 5     | €10,000 |
      | Mercedes-Benz | E     | €15,000 |
      | Volkswagen    | Golf  | €22,000 |

  Scenario Outline: Validate access to Detailed Search page on trucks category
    When User selects Truck category
    Then Truck category page is displayed
    When user selects <category> category
    Then detailed search of that <category> is displayed
    Examples:
      | category                    |
      | Vans and Trucks up to 7.5 t |
      | Trucks over 7.5 t           |
      | Semi-Trailer Trucks         |
      | Trailers                    |
      | Semi-Trailers               |
      | Construction Machines       |
      | Buses                       |
      | Agricultural Vehicles       |
      | Forklift Trucks             |


  Scenario: Validate Login functionality
    Given Login page is opened
    When User provide valid credentials Email and Password
    And click on Log in Button
    Then User was successfully logged in

  Scenario: Validate Login impossibility with wrong credentials
    Given Login page is opened
    When User provides invalid credentials Email and Password
    And click on Log in Button
    Then pop-up message about invalid credentials is displayed

  Scenario Outline: Validate account data editing
    Given User is logged in with valid credentials
    And Edit Account page is opened
    When User changes <first> and <last> name and presses save button
    And User changes street to <street> and house number to <houseNumber>
    And zip code to <zipCode> and city to <city> and presses save button
    Then changed <first> and <last> name,<street>,<houseNumber>,<zipCode>
    And <city> are displayed in Edit Account page
    Examples:
      | first  | last   | street           | houseNumber | zipCode | city          |
      | Jackie | Chan   | ChinaTown        | 22          | 12345   | Hong Kong     |
      | John   | Rambo  | Rambo's str.     | 33          | 23456   | Bowie Arizona |
      | Steven | Seagal | BrokenBones str. | 44          | 34567   | LosAngeles    |
