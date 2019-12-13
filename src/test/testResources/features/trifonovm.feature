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
    Then Available offers page is displaying containing vehicles that mach the search criteria
    Examples:
      | condition | make     | model | type   | min_price | max_price | fromYear | toYear | fromKms | toKms  | fuel_type | transmission |
      | USED      | BMW      | 3     | SALOON | 10000     | 20000     | 2000     | 2015   | 30000   | 150000 | PETROL    | MANUAL       |
      | USED      | MERCEDES | C     | ESTATE | 10000     | 20000     | 2005     | 2015   | 20000   | 120000 | DIESEL    | AUTOMATIC    |
      | USED      | AUDI     | A4    | SALOON | 15000     | 20000     | 2000     | 2015   | 10000   | 150000 | PETROL    | MANUAL       |

  Scenario Outline: Validate Sell option functionality
    Given user has logged in and accessed Sell page
    When  user enters the <make> and <model> of his vehicle
    And user enters <year> and <month> of first registration
    And user enters the mileage <KMs> and <fuelType>
    And user enters model <description> and <equipment> level
    And user chooses <selling_plan> and enters <zip_code> and clicks on continue button
    Then user is redirected to results page where he can see the price of his car
    Examples:
      | make     | model | year | month | KMs    | fuelType | description | equipment | selling_plan | zip_code |
      | MERCEDES | VANEO | 2004 | MAY   | 195000 | DIESEL   | CDI1.7      | TREND     | 1            | 54126    |
