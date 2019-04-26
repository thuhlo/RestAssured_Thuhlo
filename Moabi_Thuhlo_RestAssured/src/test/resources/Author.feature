Feature: Retrieve the correct author name by ID

    As a blogger
    I want to use the service to find the correct author
    I will search with blogger id to get correct author name

    Scenario: Find author name by using id
      Given I have a valid author id
      When I submit the correct id
      Then I should receive the correct author name