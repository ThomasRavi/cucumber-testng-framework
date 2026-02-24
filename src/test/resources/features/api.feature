
@api
Feature: API Testing

  Scenario: Validate GET users API
    Given User sends GET request to "/api/users?page=2"
    Then Status code should be 200
