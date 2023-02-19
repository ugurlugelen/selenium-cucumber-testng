Feature: Place the order for product

  @wip
  Scenario Outline:
    Given User is on GreenCart Landing Page
    When User searched with shortname "<productName>" and extracted actual name of the product
    And Added "3" items of the selected product to cart
    Then User proceeds to checkout and validate the "<productName>" items in checkout page
    And verify user has ability to enter promo code and place the order

    Examples:
      | productName|
      | Cucumber   |