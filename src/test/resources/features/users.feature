Feature: Reqres.in

  Background: User Already on Reqres.in

@Positive
Scenario: User successfully GET single user
When User send GET HTTP request to reqresin
Then response status code should be 200
And response status should match with schema "Get-Single-User.json"






