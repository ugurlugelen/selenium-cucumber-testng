@smoke
Feature: Search and Place the order of the products

  Scenario Outline: Search Experience for home and Offers Page
    Given User is on GreenCart Landing Page
    When User searched with shortname "<productName>" and extracted actual name of the product
    And user searched for same shortname in offers page to check if product exist
    Then validates same results are displayed at search results

    Examples:
      | productName |
      | kdfhgsd     |
      | Potato      |

