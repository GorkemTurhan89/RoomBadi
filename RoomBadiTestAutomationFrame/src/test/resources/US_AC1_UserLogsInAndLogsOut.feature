@UI @UI_US1 @UI_US1_AC1
Feature: AC1 User Able to Login
  Background:
    Given user goes to "roombadiURL"


  Scenario:  TC01 Searchbox button must be seen when at least 3 char entered to the search box
    And click to "personalButton"
    And click to "girisYapButton"
    And click to "girisyapButtonInGirisYapMenu"
    And user type in "countryPhoneAreaCodeSelection" to "+90"
    And user type in "phoneNumberArea" to "5399171941"
    Then close WebSite