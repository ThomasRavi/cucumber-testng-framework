
@api
Feature: API Testing


Scenario: Validate GET users API
  Given User sends GET request to "/users"
  Then Status code should be 200
