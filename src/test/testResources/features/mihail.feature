@Mihail
Feature: Mobile de search function

 Background: Mobile de is opened
  Given User clicks on 'Language selector drop-down' on 'Header'
  And User clicks on 'English language option'

  @Test103
  Scenario Outline: Validate side panel search functionality on car list page
    Given User clicks on 'Search button' on 'Home Page'
    And User is on 'Side Panel Search Page'
    When User inserts value '<option>' in '<option_type>'
    And User clicks on 'Show offers'
    Then the selected '<option>' matches the 'Displayed option'
    When User clicks on 'Close displayed option'
    Then 'Displayed option' is not displayed
    Examples:
      | option_type       | option |
      | Price_from        | 10000  |
#      | Price_to          | 20000  |
#      | Registration_from | 2005   |
#      | Registration_to   | 2015   |
#      | Kilometer_from    | 20000  |
#      | Kilometer_to      | 150000 |

  @Test101
  Scenario Outline: Validate Detailed Search Functionality on cars category
    Given User clicks on 'Detailed search link' on 'Home Page'
    And User is on 'Detailed Car Search Page'
    When User clicks on option <condition>
    And User clicks on option <type>
    And User clicks on option <fuel_type>
    And User clicks on option <transmission>
    And User clicks on 'Show offers button'
    And User is on 'Backup Car List Page'
    And User selects a random car from 'Car results'
    Then User is on 'Selected Car Page'
    Then chosen car complies to the selected options: <type>, <fuel_type>, <transmission>
    Examples:
      | condition | type   | fuel_type | transmission |
      | USED      | SALOON | PETROL    | MANUAL       |
#      | USED      | ESTATE | DIESEL    | AUTOMATIC    |

  @Test104
  Scenario Outline: Validate sorting functionality on car list page
    Given User clicks on 'Detailed search link' on 'Home Page'
    And User is on 'Detailed Car Search Page'
    When User clicks on option <condition>
    And User inserts value '<make>' in 'Make field'
    And User inserts value '<model>' in 'Model field'
    And User inserts value '<min_price>' in 'Min price field'
    And User inserts value '<max_price>' in 'Max price field'
    And User inserts value '<fromYear>' in 'Min year field'
    And User inserts value '<toYear>' in 'Max year field'
    And User inserts value '<fromKms>' in 'Min mileage field'
    And User inserts value '<toKms>' in 'Max mileage field'
    And User clicks on 'Show offers button'
    Then User is on 'Backup Car List Page'
    When User inserts value '<sorting_option>' in 'Sorting options drop-down'
    Then displayed offers are sorted according to selected <sorting_option>
    Examples:
      | condition | make     | model | min_price | max_price | fromYear | toYear | fromKms | toKms  | sorting_option      |
      | USED      | MERCEDES | S     | 10000     | 60000     | 1994     | 2015   | 20000   | 150000 | Price ascending     |
#      | USED      | MERCEDES | S     | 10000     | 60000     | 1994     | 2015   | 20000   | 150000 | Price descending    |
#      | USED      | MERCEDES | S     | 10000     | 60000     | 1994     | 2015   | 20000   | 150000 | KM ascending        |
#      | USED      | MERCEDES | S     | 10000     | 60000     | 1994     | 2015   | 20000   | 150000 | KM descending       |
#      | USED      | MERCEDES | S     | 10000     | 60000     | 1994     | 2015   | 20000   | 150000 | 1st Reg. ascending  |
#      | USED      | MERCEDES | S     | 10000     | 60000     | 1994     | 2015   | 20000   | 150000 | 1st Reg. descending |

  @Test102
  Scenario Outline: Validate Sell option functionality
    Given User is logged in Mobile de
    And User clicks on 'Sell tab' on 'Home Page'
    And User is on 'Sell Page'
    And User inserts value '<make>' in 'Make field'
    And User inserts value '<model>' in 'Model field'
    And User inserts value '<year>' in 'Year'
    And User inserts value '<month>' in 'Month'
    And User inserts value '<KMs>' in 'Mileage'
    And User scrolls to and clicks on selected '<fuelType>'
    And User selects specific 'description'
    And User selects specific '<description>'
    And User selects specific '<equipment>'
    And User scrolls to and clicks on selected '<selling_plan>'
    And User inserts value '<zip_code>' in 'Zip code field'
    And User clicks on 'Continue button'
    Then the selected '<model>' matches the 'Sell your vehicle text'
    And 'Your car price' message is displayed
    Examples:
      | make     | model   | year | month | KMs    | fuelType | description | equipment  | selling_plan   | zip_code |
#      | MERCEDES | VANEO   | 2004 | M    | 195000 | DIESEL   | Model 3     | Equipment 6 | Sell option 1 | 54126    |
#      | RENAULT  | ESPACE  | 2005 | J    | 250000 | DIESEL   | Model 2     | Equipment 5 | Sell option 2 | 62148    |
      | KIA      | SORENTO | 2005 | A     | 150000 | PETROL   | Model 2     | Equipment 1 | Sell option 2 | 75482    |

  @Test105
  Scenario Outline: Validate search save functionality
    Given User is logged in Mobile de
    And User clicks on 'Detailed search link' on 'Home Page'
    And User is on 'Detailed Car Search Page'
    When User clicks on option <condition>
    And User clicks on 'Make field'
    And User inserts value '<make>' in 'Make field'
    And User clicks on 'Make field'
    And User clicks on 'Model field'
    And User inserts value '<model>' in 'Model field'
    And User clicks on 'Model field'
    And User inserts value '<min_price>' in 'Min price field'
    And User inserts value '<max_price>' in 'Max price field'
    And User inserts value '<fromYear>' in 'Min year field'
    And User inserts value '<toYear>' in 'Max year field'
    And User inserts value '<fromKms>' in 'Min mileage field'
    And User inserts value '<toKms>' in 'Max mileage field'
    And User clicks on 'Show offers button'
    And User clicks on 'Save search button' on 'Backup Car List Page'
    And User clicks on 'Save search button on pop-up'
    And User clicks on 'My searches' on 'Header'
    And User clicks on 'Show my searches'
    And User is on 'My Searches Page'
    Then 'Stored search' message is displayed
    When User clicks on 'Stored search'
    And User is on 'Backup Car List Page'
    Then filters <condition>, <make>, <model>, <min_price>, <max_price>, <fromYear>, <toYear>, <fromKms>, <toKms> match the original search
    And Delete saved searches
    Examples:
      | condition | make    | model   | min_price | max_price | fromYear | toYear | fromKms | toKms |
      | USED      | HONDA   | ACCORD  | 21000     | 30000     | 2015     | 2019   | 5000    | 30000 |
#      | USED      | TOYOTA  | CAMRY   | 10000     | 20000     | 2011     | 2018   | 40000   | 80000 |
#      | USED      | PORSCHE | CAYENNE | 70000     | 90000     | 2016     | 2017   | 10000   | 20000 |
