@Mihail
Feature: Detailed search feature

  Background:
    Given Mobile.de website is accessed and the language is set to English
  @Test1
  Scenario Outline: Validate Detailed Search Functionality on cars category
    Given user accessed Detailed Search page
    When user chooses desired <condition> in condition category on detailed search page
    And user chooses <make> and <model> in make, model, variant category
    And user chooses <type> in vehicle type category
    And user chooses <min_price> and <max_price> in price range category
    And user selects vehicle's registration range <fromYear> and <toYear>
    And user selects vehicle's mileage range <fromKms> and <toKms>
    And user selects <fuel_type> and <transmission> and clicks on Show offers button
    And user chooses a random car from car list page
    Then chosen car's options: <make>, <type>, <min_price>, <max_price>, <fromYear>, <toYear>, <fromKms>, <toKms>, <fuel_type>, <transmission> match search criteria
    Examples:
      | condition | make     | model | type   | min_price | max_price | fromYear | toYear | fromKms | toKms  | fuel_type | transmission |
      | USED      | BMW      | 3     | SALOON | 10000     | 20000     | 2000     | 2015   | 30000   | 150000 | PETROL    | MANUAL       |
#      | USED      | MERCEDES | C     | ESTATE | 10000     | 20000     | 2005     | 2015   | 20000   | 120000 | DIESEL    | AUTOMATIC    |
#      | USED      | AUDI     | A4    | SALOON | 15000     | 20000     | 2000     | 2015   | 10000   | 150000 | PETROL    | MANUAL       |

  @Test2
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
#      | MERCEDES | VANEO   | 2004 | MAY   | 195000 | DIESEL   | 3           | 6         | 1            | 54126    |
#      | RENAULT  | ESPACE  | 2005 | JUNE  | 250000 | DIESEL   | 2           | 5         | 2            | 62148    |
      | KIA      | SORENTO | 2005 | APRIL | 150000 | PETROL   | 2           | 2         | 3            | 75482    |

  @Test3
  Scenario Outline: Validate side panel search functionality on car list page
    Given user accessed car list page without entering any search criteria
    When user changes from <option_type> one of the vehicle's <option>  to desired one
    Then the <option> appears on top of cars list
    When user clicks on close button of the option
    Then the option disappears
    Examples:
      | option_type       | option |
      | Price_from        | 10000  |
#      | Price_to          | 20000  |
#      | Registration_from | 2005   |
#      | Registration_to   | 2015   |
#      | Kilometer_from    | 20000  |
#      | Kilometer_to      | 150000 |

  @Test4
  Scenario Outline: Validate sorting functionality on car list page
    Given user accessed Detailed Search page
    When user chooses desired <condition> in condition category on detailed search page
    And user chooses <make> and <model> in make, model, variant category
    And user chooses <min_price> and <max_price> in price range category
    And user selects vehicle's registration range <fromYear> and <toYear>
    And user selects vehicle's mileage range <fromKms> and <toKms>
    And user pressed Show Offers Button and was redirected to car list page
    When user selects from sorting drop down <sorting_option>
    Then cars are sorted according to selected <sorting_option>
    Examples:
      | condition | make     | model | min_price | max_price | fromYear | toYear | fromKms | toKms  | sorting_option      |
#      | USED      | MERCEDES | S     | 10000     | 60000     | 1994     | 2015   | 20000   | 150000 | Price ascending     |
#      | USED      | MERCEDES | S     | 10000     | 60000     | 1994     | 2015   | 20000   | 150000 | Price descending    |
      | USED      | MERCEDES | S     | 10000     | 60000     | 1994     | 2015   | 20000   | 150000 | KM ascending        |
#      | USED      | MERCEDES | S     | 10000     | 60000     | 1994     | 2015   | 20000   | 150000 | KM descending       |
#      | USED      | MERCEDES | S     | 10000     | 60000     | 1994     | 2015   | 20000   | 150000 | 1st Reg. ascending  |
#      | USED      | MERCEDES | S     | 10000     | 60000     | 1994     | 2015   | 20000   | 150000 | 1st Reg. descending |

  @Test5
  Scenario Outline: Validate search save functionality
    Given user is logged in on Mobile.de
    And My search page is empty
    And user accessed Detailed Search page
    When user chooses desired <condition> in condition category on detailed search page
    And user chooses <make> and <model> in make, model, variant category
    And user chooses <min_price> and <max_price> in price range category
    And user selects vehicle's registration range <fromYear> and <toYear>
    And user selects vehicle's mileage range <fromKms> and <toKms>
    And user pressed Show Offers Button and was redirected to car list page
    And user saves current search by clicking on Save search button and following option on pop-up
    Then the Search is saved in My searches
    And by clicking on the Saved search user is redirected on car results page
    And filters <condition>, <make>, <model>, <min_price>, <max_price>, <fromYear>, <toYear>, <fromKms>, <toKms> match the original search
    Examples:
      | condition | make    | model   | min_price | max_price | fromYear | toYear | fromKms | toKms |
      | USED      | HONDA   | ACCORD  | 21000     | 30000     | 2015     | 2019   | 5000    | 30000 |
#      | USED      | TOYOTA  | CAMRY   | 10000     | 20000     | 2011     | 2018   | 40000   | 80000 |
#      | USED      | PORSCHE | CAYENNE | 70000     | 90000     | 2016     | 2017   | 10000   | 20000 |







