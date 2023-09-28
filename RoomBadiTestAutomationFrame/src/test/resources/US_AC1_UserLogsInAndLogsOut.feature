@UI @UI_US1 @UI_US1_AC1
Feature: AC1 User Able to Login and log out

  Background:
    Given user goes to "roombadiURL"

  Scenario:  TC01a Whether advert is created while signup
    And user waits for "3"
    And click to "yeniIlanButton"
    And user waits for "3"
    And user type in "phoneNumberArea" to "configphone"
    And click to "girisyapButtonInGirisYapMenu"
    Given user opens phone
    And user goes and checks the sms
    And click to "devamEtButton"
    And user type in "signUpName" to "Denemeisim"
    And user type in "signUpLastName" to "Denemesoyisim"
    And user type in "signUpEmail" to "Deneme@email.com"
    And user type in "birthDate" to "19091899"
    And click to "genderMale"
    And click to "nextButton"
    And click to "petInput"
    And user type in "petInput" to chose one
    And click to "misafirButton"
    And user type in "misafirButton" to chose one
    And click to "temizlikButton"
    And user type in "temizlikButton" to chose one
    And click to "smokingYes"
    And click to "kaydet2"

  Scenario:  TC02a User who lend a house login
    And click to "personalButton"
    And click to "girisYapButton"
    And user waits for "3"
    And user type in "phoneNumberArea" to "configphone"
    And click to "girisyapButtonInGirisYapMenu"
    Given user opens phone
    And user goes and checks the sms
    And click to "devamEtButton"


  Scenario:  TC02b User who lend a house in and then can log out
    And click to "personalButton"
    And click to "girisYapButton"
    And user waits for "3"
    And user type in "phoneNumberArea" to "configphone"
    And click to "girisyapButtonInGirisYapMenu"
    Given user opens phone
    And user goes and checks the sms
    And click to "devamEtButton"
    And click to "personalButton"
    And click to "cikisYapEtButton"
    Then close WebSite


  Scenario:  TC02a1 User who rent a house login
    And click to "faceIcon"
    And click to "personalButton"
    And click to "girisYapButton"
    And user waits for "3"
    And user type in "phoneNumberArea" to "configphone"
    And click to "girisyapButtonInGirisYapMenu"
    Given user opens phone
    And user goes and checks the sms
    And click to "devamEtButton"


  Scenario:  TC02b1 User who rent a house in and then can log out
    And click to "faceIcon"
    And click to "personalButton"
    And click to "girisYapButton"
    And user waits for "3"
    And user type in "phoneNumberArea" to "configphone"
    And click to "girisyapButtonInGirisYapMenu"
    Given user opens phone
    And user goes and checks the sms
    And click to "devamEtButton"
    And click to "personalButton"
    And click to "cikisYapEtButton"
    Then close WebSite