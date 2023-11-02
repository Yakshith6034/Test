Feature: Deleting Items from the Shopping Cart using the ShoppingCart Delete API


  # This scenario tests the successful clearing of a shopping cart by sending a delete request.
  Scenario: Clear the shopping cart successfully
    And Read Base URL with Endpoint for the cart delete API
    When Add the Headers for the cart delete API
    Then Validate the Delete Response
