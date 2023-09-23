@UI @UI_US1 @UI_US1_AC1
Feature: AC1 User Able to Login
  Background:
    Given user goes to "roombadiURL"


  Scenario:  TC01 Searchbox button must be seen when at least 3 char entered to the search box
    And click to "personalButton"
    And click to "girisYapButton"
    And user waits for "3"
    And user type in "phoneNumberArea" to "configphone"
    And click to "girisyapButtonInGirisYapMenu"
    Given user opens phone
    And user goes and checks the sms
    Then close WebSite
    And click to "personalButton"
