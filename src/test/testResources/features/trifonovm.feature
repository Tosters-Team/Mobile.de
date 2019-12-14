@Mihail
Feature: Detailed search feature

  Background:
    Given Mobile.de website is accessed and the language is set to english

  Scenario Outline: Validate Detailed Search Functionality on cars category
    Given user accessed Detailed Search page
    When user selects vehicle's <condition> in condition category
    And user selects <make> and <model> in make, model, variant category
    And user selects <type> in vehicle type category
    And user selects <min_price> and <max_price> in price range category
    And user selects vehicle's registration range <fromYear> and <toYear>
    And user selects vehicle's mileage range <fromKms> and <toKms>
    And user selects <fuel_type> and <transmission> and clicks on Show offers button
    Then Available offers page is displaying containing vehicles that match the search criteria
    Examples:
      | condition | make     | model | type   | min_price | max_price | fromYear | toYear | fromKms | toKms  | fuel_type | transmission |
      | USED      | BMW      | 3     | SALOON | 10000     | 20000     | 2000     | 2015   | 30000   | 150000 | PETROL    | MANUAL       |
      | USED      | MERCEDES | C     | ESTATE | 10000     | 20000     | 2005     | 2015   | 20000   | 120000 | DIESEL    | AUTOMATIC    |
      | USED      | AUDI     | A4    | SALOON | 15000     | 20000     | 2000     | 2015   | 10000   | 150000 | PETROL    | MANUAL       |

  Scenario Outline: Validate Sell option functionality
    Given user has logged in and accessed Sell page
    When  user enters the <make> and <model> of his vehicle
    And enters <year> and <month> of first registration
    And enters the mileage <KMs> and <fuelType>
    And enters model <description> and <equipment> level
    And user chooses <selling_plan> and enters <zip_code> and clicks on continue button
    Then user is redirected to results page where he can see the price of his car <model>
    Examples:
      | make     | model   | year | month | KMs    | fuelType | description | equipment | selling_plan | zip_code |
      | MERCEDES | VANEO   | 2004 | MAY   | 195000 | DIESEL   | 3           | 6         | 1            | 54126    |
      | RENAULT  | ESPACE  | 2005 | JUNE  | 250000 | DIESEL   | 2           | 5         | 2            | 62148    |
      | KIA      | SORENTO | 2005 | APRIL | 150000 | PETROL   | 2           | 2         | 3            | 75482    |

  Scenario Outline: Validate side panel search functionality on car list page
    Given user accessed car list page without entering any search criteria
    When user changes from <option_type> one of the vehicle's <option>  to desired one
    Then the <option> appears on top of cars list
    When user clicks on close button of the option
    Then the option disappears
    Examples:
      | option_type       | option  |
      | Price_from        | 10000   |
      | Price_to          | 20000   |
      | Registration_from | 2005    |
      | Registration_to   | 2015    |
      | Kilometer_from    | 20000   |
      | Kilometer_to      | 150000  |

  Scenario: Validate sorting functionality on car list page
    Given user accessed Detailed Search page

    When i do
    Then success

  Scenario: Validate search save functionality
    Given asdgag
    When asasg
    Then dgsg








