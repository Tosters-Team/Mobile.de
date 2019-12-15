@Artur
Feature: Demo feature

  Background: opening browser
    Given Mobile de is opened and language changed to English

  Scenario Outline: Validate Quick Search functionality on cars category
    When User selects <make> in Make drop-down
    And selects <model> in Model drop-down
    And selects price up to <price>
    And clicks on Search button
    Then cars search was done and only cars of <make> and <model> under <price> are displayed
    Examples:
      | make          | model | price   |
      | BMW           | 5     | €10,000 |
      | Mercedes-Benz | E     | €15,000 |
      | Volkswagen    | Golf  | €22,000 |


  Scenario Outline: Validate access to Detailed Search page on Trucks category
    When User selects Truck category
    Then Truck category page is displayed
    When User selects <category> category on Quick Truck Search
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


  Scenario: Validate Login functionality with valid credentials
    Given Login page is opened
    When User provide valid credentials Email and Password
    And clicks on Log in Button
    Then User was successfully logged in

  Scenario: Validate Login impossibility with invalid credentials
    Given Login page is opened
    When User provides invalid credentials Email and Password
    And clicks on Log in Button
    Then pop-up message about invalid credentials is displayed

  Scenario Outline: Validate account data editing functionality
    Given Login page is opened
    And User provide valid credentials Email and Password
    And clicks on Log in Button
    And User was successfully logged in
    When Edit Account page is opened
    And User changes <first> and <last> name and presses save button
    And changes street to <street> and house number to <houseNumber>
    And zip code to <zipCode> and city to <city> and presses save button
    Then changed <first> and <last> name,<street>,<houseNumber>,<zipCode>
    And <city> are displayed in Edit Account page
    Examples:
      | first  | last   | street           | houseNumber | zipCode | city          |
      | Jackie | Chan   | ChinaTown        | 22          | 12345   | Hong Kong     |
      | John   | Rambo  | Rambo's str.     | 33          | 23456   | Bowie Arizona |
      | Steven | Seagal | BrokenBones str. | 44          | 34567   | LosAngeles    |
