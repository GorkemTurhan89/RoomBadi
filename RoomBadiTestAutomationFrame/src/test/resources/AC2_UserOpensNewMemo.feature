@UI @UI_US1 @UI_US1_AC1
Feature: AC1 User Able to Login and log out
  Background:
    Given user goes to "roombadiURL"


  Scenario:  TC02a User who lend a house login
    And click to "personalButton"
    And click to "girisYapButton"
    And user waits for "3"
    And user type in "phoneNumberArea" to "configphone"
    And click to "girisyapButtonInGirisYapMenu"
    Given user opens phone
    And user goes and checks the sms
    And click to "devamEtButton"
    And cli