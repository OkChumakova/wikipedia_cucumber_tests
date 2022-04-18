Feature: Test creating account feature

  Scenario Outline: Test create account
    Given I navigate to <page>
    When I enter <username> into username input field
    And I enter <password> into password input field
    And I enter <confirmPassword> into confirm password input field
    And I enter <email> into email input field
    And I submit the form
    Then I should be able to see <message>
    Examples:
      | page                                                                                  | username | password | confirmPassword | email | message                       |
      | "https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Main+Page" | ""       | ""       | ""              | ""    | "Please fill out this field." |
















