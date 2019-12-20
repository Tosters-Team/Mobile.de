@Artur
Feature: Demo feature

  Background: Mobile de is opened
    Given User clicks on 'Language selector drop-down' on 'Header'
    And User clicks on 'English language option'


  Scenario Outline: Validate Quick Search functionality on cars category
    Given User is on 'Home Page'
    When User selects <make> in Make drop-down
    And selects <model> in Model drop-down
    And selects price up to <price> in Price field
    And User clicks on 'Search button'
    Then User is on 'Car List Page'
    And cars search was done and only cars of <make> and <model> under <price> are displayed
    Examples:
      | make          | model | price   |
      | BMW           | 5     | €10,000 |
      | Mercedes-Benz | E     | €15,000 |
      | Volkswagen    | Golf  | €22,000 |


  Scenario Outline: Validate access to Detailed Search page on Trucks category
    Given User is on 'Home Page'
    When User clicks on 'Truck Tab'
    Then User is on 'Quick Truck Search page'
    When User selects <category> category on Quick Truck Search
    Then detailed search of that <category> is displayed
    Examples:
      | category                |
      | Vans/Trucks up to 7.5 t |
      | Trucks over 7.5 t       |
      | Semi-trailer truck      |
      | Trailers                |
      | Semi-Trailers           |
      | Construction Machines   |
      | Buses                   |
      | Agricultural Vehicles   |
      | Forklift Trucks         |


  Scenario: Validate Login functionality with valid credentials
    Given User clicks on 'Login button' on 'Header'
    And User is on 'Login Page'
    When User provides 'Vangartur@gmail.com' in 'Email field'
    And User provides 'Artiq!23' in 'Password field'
    And User clicks on 'LogIn button'
    Then User is on 'Home Page'


  Scenario: Validate Login impossibility with invalid credentials
    Given User clicks on 'Login button' on 'Header'
    And User is on 'Login Page'
    When User provides 'Vaasdasdadur@gmail.com' in 'Email field'
    And User provides 'Aadsdasdtiq!23' in 'Password field'
    And User clicks on 'LogIn button'
    Then 'The credentials you provided cannot be confirmed as authentic.' message is displayed

  Scenario Outline: Validate account data editing functionality
    Given User is logged in Mobile de
    Given User clicks on 'My car park button' on 'Header'
    And User clicks on 'My Mobile.de drop-down'
    And User clicks on 'Edit Account'
    Then User is on 'Edit Account Page'
    When User clicks on 'Change name button'
    And User provides '<first>' in 'First Name field'
    And User provides '<last>' in 'Last Name field'
    And User clicks on 'Save button'
    Then 'Changed' message is displayed
    When User clicks on 'Change address button'
    And User provides '<street>' in 'Street field'
    And User provides '<houseNumber>' in 'House Number field'
    And User provides '<zipCode>' in 'ZipCode field'
    And User provides '<city>' in 'City field'
    And User clicks on 'Save button'
    Then 'Changed' message is displayed

    Examples:
      | first  | last   | street           | houseNumber | zipCode | city          |
      | Jackie | Chan   | ChinaTown        | 22          | 12345   | Hong Kong     |
      | John   | Rambo  | Rambo's str.     | 33          | 23456   | Bowie Arizona |
      | Steven | Seagal | BrokenBones str. | 44          | 34567   | LosAngeles    |


