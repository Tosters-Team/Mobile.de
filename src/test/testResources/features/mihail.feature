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
    Then the selected <option> matches the 'Displayed option'
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
    And User selects 'Make field' field to populate
    And User enters <make>
    And User selects 'Model field' field to populate
    And User enters <model>
    And User selects 'Min price field' field to populate
    And User enters <min_price>
    And User selects 'Max price field' field to populate
    And User enters <max_price>
    And User selects 'Min year field' field to populate
    And User enters <fromYear>
    And User selects 'Max year field' field to populate
    And User enters <toYear>
    And User selects 'Min mileage field' field to populate
    And User enters <fromKms>
    And User selects 'Max mileage field' field to populate
    And User enters <toKms>
    And User clicks on 'Show offers button'
    Then User is on 'Backup Car List Page'
    When User selects 'Sorting options drop-down' field to populate
    And User enters <sorting_option>
    Then displayed offers are sorted according to selected <sorting_option>



#    Given user accessed Detailed Search page
#    When user chooses desired <condition> in condition category on detailed search page
#    And user chooses <make> and <model> in make, model, variant category
#    And user chooses <min_price> and <max_price> in price range category
#    And user selects vehicle's registration range <fromYear> and <toYear>
#    And user selects vehicle's mileage range <fromKms> and <toKms>
#    And user pressed Show Offers Button and was redirected to car list page
#    When user selects from sorting drop down <sorting_option>
#    Then cars are sorted according to selected <sorting_option>
    Examples:
      | condition | make     | model | min_price | max_price | fromYear | toYear | fromKms | toKms  | sorting_option      |
      | USED      | MERCEDES | S     | 10000     | 60000     | 1994     | 2015   | 20000   | 150000 | Price ascending     |
#      | USED      | MERCEDES | S     | 10000     | 60000     | 1994     | 2015   | 20000   | 150000 | Price descending    |
#      | USED      | MERCEDES | S     | 10000     | 60000     | 1994     | 2015   | 20000   | 150000 | KM ascending        |
#      | USED      | MERCEDES | S     | 10000     | 60000     | 1994     | 2015   | 20000   | 150000 | KM descending       |
#      | USED      | MERCEDES | S     | 10000     | 60000     | 1994     | 2015   | 20000   | 150000 | 1st Reg. ascending  |
#      | USED      | MERCEDES | S     | 10000     | 60000     | 1994     | 2015   | 20000   | 150000 | 1st Reg. descending |