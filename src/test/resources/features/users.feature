Feature: Reqres.in

  Background: User Already on Reqres.in

@Positive
Scenario: User successfully GET single user
When User send GET HTTP request to reqresin
Then response status code should be 200
And response status should match with schema "Get-Single-User.json"

@Negative
Scenario: User unsuccessfully GET single user
When User send other GET HTTP requset to reqresin
Then response status code should be 404
And response status should match with schema "User-Not-Found.json"

@Positive
Scenario: User successfully POST login
When User send POST login HTTP request to reqresin
Then response status code should be 200
And response status should match with schema "Login.json"

@Positive
Scenario: User successfully POST register
When User send POST register HTTP request to reqresin
Then response status code should be 200
And response status should match with schema "Register.json"

@Positive
Scenario: User successfully POST create
When User send POST create HTTP request to reqresin
Then response status code should be 201
And response status should match with schema "Create.json"

@Positive
Scenario: User successfully PUT update
When User send PUT update HTTP request to reqresin
Then response status code should be 200
And response status should match with schema "Update.json"

@Positive
Scenario: User successfully Delete data
When User send Delete data HTTP request to reqresin
Then response status code should be 204





