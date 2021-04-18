package com.qa.stepdefs;

import com.qa.pageobjects.TwitterProfilePage;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TwitterProfileStepDef {
	
	TwitterProfilePage profilePage=new TwitterProfilePage();
    
	@Given("^User launch the Twitter url \"([^\"]*)\"$")
    public void user_launch_twitter_URL(String url) {
		profilePage.launchUrl(url);
    }

	@When("^User is on the Twitter login page$")
    public void user_is_on_twitter_login_page(){
    	profilePage.clickOnLogin();
    }

    @And("^User enter valid username \"([^\"]*)\"$")
    public void user_enter_valid_username(String username) {
    	profilePage.enterUserName(username);
    }
    
    @And("^User enter valid password \"([^\"]*)\"$")
    public void user_enter_valid_password(String password) {
    	profilePage.enterPassword(password);
    }

    @And("^User click on login button$")
    public void user_clicks_on_login_button() {
    	profilePage.clickOnLogin();
    }

    @Then("^Verify user \"([^\"]*)\" successfully login into twitter and navigate to Twitter \"([^\"]*)\" page$")
    public void verify_user_login_successfull(String username, String homePageString) {
    	profilePage.verifyUserLoginSuccessfully(username);
    	profilePage.verifyUserNavigateToHomePage(homePageString);
    }
    
    @And("^User keep the password field as blank \"([^\"]*)\" and try to login$")
    public void user_enter_blank_password(String password) {
    	profilePage.setPasswordFieldBlank(password);
    }
    
    @Then("^Verify user is not able to login as password field is mandatory$")
    public void verify_password_field_is_mandatory() {
    	profilePage.verifyPasswordIsMandatoryField();
    }
    
    @When("^User keep the username field as blank \"([^\"]*)\"$")
    public void user_enter_blank_username(String username) {
    	profilePage.setUserNameFieldBlank(username);
    }
    
    @Then("^Verify user is not able to login as username field is mandatory$")
    public void verify_username_field_is_mandatory() {
    	profilePage.verifyUserNameIsMandatoryField();
    }
    
    @When("^User navigate to the profile section$")
    public void user_navigate_to_the_profile_section(){
    	profilePage.navigateToProfile();
    }

    @And("^User upload the profile picture \"([^\"]*)\"$")
    public void user_upload_the_profile_picture(String picPath){
    	profilePage.uploadProfilePic(picPath);
    }

    @Then("^Verify profile picture uploaded successfully$")
    public void verify_profile_picture_uploaded_successfully() {
    	profilePage.verifyProfilePicUploaded();
    }
    
    //*****
    @And("^User clicks on Edit Profile button to update the user profile$")
    public void user_clicks_on_Edit_Profile_button_to_update_the_user_profile() {
        profilePage.clicksOnEditProfile();
    }

    @And("^User update the BIO field in profile section as \"([^\"]*)\"$")
    public void user_update_the_BIO_field_in_profile_section_as(String bioString){
        profilePage.updateBioProfileField(bioString);
    }

    @Then("^Verify profile field BIO \"([^\"]*)\" updated successfully$")
    public void verify_profile_field_BIO_updated_successfully(String bioString){
        profilePage.veirfyBioProfileUpdated(bioString);
    }

    @And("^User update the location field in profile section as \"([^\"]*)\"$")
    public void user_update_the_location_field_in_profile_section_as(String locationString) {
        profilePage.updateLocationProfileField(locationString);
    }

    @Then("^Verify profile field location \"([^\"]*)\" updated successfully$")
    public void verify_profile_field_location_updated_successfully(String locationString){
    	profilePage.veirfyLocationProfileUpdated(locationString);
    }
    
    @And("^User update the website field in profile section as \"([^\"]*)\"$")
    public void user_update_the_website_field_in_profile_section_as(String websiteString) throws Throwable {
    	profilePage.updateWebsiteProfileField(websiteString);
    }

    @Then("^Verify profile field website \"([^\"]*)\" updated successfully$")
    public void verify_profile_field_website_updated_successfully(String websiteString) throws Throwable {
    	profilePage.veirfyWebsiteProfileUpdated(websiteString);
    }

    @And("^User retrieve the BIO, location and website profile fields$")
    public void user_retrieve_the_BIO_location_and_website_profile_fields(){
    	profilePage.userRetrieveBioLocationWebsiteFieldValues();
    }

    @Then("^Verify profile field BIO \"([^\"]*)\", location \"([^\"]*)\" and website \"([^\"]*)\" are updated correctly$")
    public void verify_profile_field_BIO_location_and_website_are_updated_properly(String biovalue, String locationValue, String websiteValue){
    	profilePage.verifyBioLocationWebsiteUpdatedCorrectly(biovalue, locationValue, websiteValue);
    }
    
    @And("^User update the BIO, location and website field in profile section as \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_update_the_BIO_location_and_website_field_in_profile_section_as_and(String bioString, String locationString, String websiteString){
    	profilePage.updateAllProfileField(bioString, locationString, websiteString);
    }
    
    @When("^User navigate to \"([^\"]*)\" twitter page and retrieve tweets published in last \"([^\"]*)\" hrs$")
    public void user_navigate_to_twitter_page_and_retrieve_tweets_published_in_last_hrs(String accountName, String hrs){
        profilePage.seachForTheTwitterHandle(accountName);
        profilePage.retrieveLastTwoHrsTweets(hrs);
    }

    @Then("^Verify user has successfully retrieve the last (\\d+) hrs published tweets$")
    public void verify_user_has_successfully_retrieve_the_last_hrs_published_tweets(int hrs){
        profilePage.verifyUserRetrieveLastTwoHrsTweetsSuccessfully(hrs);
    }
}
