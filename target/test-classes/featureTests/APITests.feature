#Feature: API Tests
#
#Background: User generates token for Authorisation
#
#Given I am an authorized user
#
#Scenario: the Authorized user can Add and Remove a book.
#
#Given A list of books are available
#
#When I add a book to my reading list
#
#Then The book is added
#
#When I remove a book from my reading list
#
#Then The book is removed



Feature: Login Functionality
  @validLogin
  Scenario: User Should Login With Valid Credentials
    Given Post Login API
    When Provide Valid Credential
    Then Status_code equals 200
    And  response contains IsPosted equals "true"
  @invalidLogin
  Scenario Outline: Email and Password Validation in Login API
    Given Post Login API
    When Provide different combinations to "<email>""<password>"
    Then Status_code equals <statuscode>
    And  response contains message equals "<message>"
    Examples:
      |email     		|password    | statuscode |  message
      |          		|            |   401      | Required email and password
      | abc	  	|            |   401      | Email format is incorrect
      | abc@mail7.io  	|	     |   401      | Required password
      | abc@mail7.io   	| password   |   401      | Email and Password combination Incorrect