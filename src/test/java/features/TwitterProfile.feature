Feature: Twitter user profile actions

  @LoginProfile
  Scenario Outline: User login into Twitter with valid username and password
    Given User launch the Twitter url "https://twitter.com/"
    When User is on the Twitter login page
    And User enter valid username "<username>"
    And User enter valid password "<password>"
    And User click on login button
    Then Verify user "<username>" successfully login into twitter and navigate to Twitter "Home" page

    Examples: 
      | username | password |
      | testuser | pass     |

  @LoginProfile
  Scenario: Users login username and password mandatory field validations
    Given User launch the Twitter url "https://twitter.com/"
    When User is on the Twitter login page
    And User enter valid username "Test"
    And User keep the password field as blank "null" and try to login
    Then Verify user is not able to login as password field is mandatory
    When User keep the username field as blank "null"
    And User enter valid password "pass123"
    Then Verify user is not able to login as username field is mandatory

  @UpdateProfile
  Scenario Outline: User profile field update - upload picture
    Given User launch the Twitter url "https://twitter.com/"
    When User is on the Twitter login page
    And User enter valid username "<username>"
    And User enter valid password "<password>"
    And User click on login button
    Then Verify user "<username>" successfully login into twitter and navigate to Twitter "Home" page
    When User navigate to the profile section
    And User upload the profile picture "<imagepath>"
    Then Verify profile picture uploaded successfully

    Examples: 
      | username | password | imagepath   |
      | testuser | pass     | F:\\pic.png |

  @UpdateProfile
  Scenario Outline: Home page - User profile field update and validations - BIO
    Given User launch the Twitter url "https://twitter.com/"
    When User is on the Twitter login page
    And User enter valid username "<username>"
    And User enter valid password "<password>"
    And User click on login button
    Then Verify user "<username>" successfully login into twitter and navigate to Twitter "Home" page
    When User navigate to the profile section
    And User clicks on Edit Profile button to update the user profile
    And User update the BIO field in profile section as "<BIO>"
    Then Verify profile field BIO "<BIO>" updated successfully

    Examples: 
      | username | password | BIO                      |
      | testuser | pass     | Selenium Automation user |

  @UpdateProfile
  Scenario Outline: Home User - profile field update and validations - Location
    Given User launch the Twitter url "https://twitter.com/"
    When User is on the Twitter login page
    And User enter valid username "<username>"
    And User enter valid password "<password>"
    And User click on login button
    Then Verify user "<username>" successfully login into twitter and navigate to Twitter "Home" page
    When User navigate to the profile section
    And User clicks on Edit Profile button to update the user profile
    And User update the location field in profile section as "<location>"
    Then Verify profile field location "<location>" updated successfully

    Examples: 
      | username | password | location |
      | testuser | pass     | pune     |

  @UpdateProfile
  Scenario Outline: Home page - User profile field update and validations - website
    Given User launch the Twitter url "https://twitter.com/"
    When User is on the Twitter login page
    And User enter valid username "<username>"
    And User enter valid password "<password>"
    And User click on login button
    Then Verify user "<username>" successfully login into twitter and navigate to Twitter "Home" page
    When User navigate to the profile section
    And User clicks on Edit Profile button to update the user profile
    And User update the website field in profile section as "<website>"
    Then Verify profile field website "<website>" updated successfully

    Examples: 
      | username | password | website     |
      | testuser | pass     | twitter.com |

  @ValidateProfile
  Scenario Outline: Edit profile page - Updation, Retrieval and Validation of User profile field BIO, location and website
    Given User launch the Twitter url "https://twitter.com/"
    When User is on the Twitter login page
    And User enter valid username "<username>"
    And User enter valid password "<password>"
    And User click on login button
    Then Verify user "<username>" successfully login into twitter and navigate to Twitter "Home" page
    When User navigate to the profile section
    And User clicks on Edit Profile button to update the user profile
    And User update the BIO, location and website field in profile section as "<BIO>", "<location>" and "<website>"
    And User retrieve the BIO, location and website profile fields
    Then Verify profile field BIO "<BIO>", location "<location>" and website "<website>" are updated correctly

    Examples: 
      | username | password | BIO                      | location | website     |
      | testuser | pass     | Selenium Automation user | Pune     | twitter.com |

  @Tweets
  Scenario Outline: Verification of The Times of India tweets published in last 2 hrs
    Given User launch the Twitter url "https://twitter.com/"
    When User is on the Twitter login page
    And User enter valid username "<username>"
    And User enter valid password "<password>"
    And User click on login button
    Then Verify user "<username>" successfully login into twitter and navigate to Twitter "Home" page
    When User navigate to "The Times of India" twitter page and retrieve tweets published in last "2h" hrs
    Then Verify user has successfully retrieve the last 2 hrs published tweets

    Examples: 
      | username | password | twitterpage    |
      | testuser | pass     | Times of India |
