package com.qa.pageobjects;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.jetty.html.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TwitterProfilePage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public static String bioProfileValue;
	public static String locationProfileValue;
	public static String websiteProfileValue;
	public static Map<String, String> hm;
	
	public By loginButton=By.xpath(".//*[text()='Log in']");
	public By loginButtonDisable=By.xpath(".//*[@aria-disabled='true']");
	public By userName=By.xpath("(.//*[contains(@class,'css-901oao css-bfa6kz')])[1]");
	public By password=By.xpath("(.//*[@name='session[password]'])[1]");
	public By userLogonName=By.xpath("(.//*[@aria-label=\"belora24\"])[1]");
	public By homeString=By.xpath(".//*[text()='Home']");
	public By profileIcon=By.xpath(".//*[@aria-label='Profile']");
	public By picUploadLink=By.xpath(".//*[@aria-label=\"Add avatar photo\"]");
	public By editProfileButton=By.xpath(".//*[text()='Edit profile']");
	public By applyProfilPicButton=By.xpath(".//*[text()='Apply']");
	public By saveButton=By.xpath(".//*[text()='Save']");
	public By removePicButton=By.xpath(".//*[@aria-label=\"Remove photo\"]");	
	public By bio=By.xpath(".//*[@name='description']");
	public By location=By.xpath(".//*[@name='location']");
	public By website=By.xpath(".//*[@name='url']");
	
	public By bioHomeField=By.xpath(".//*[@data-testid=\"UserDescription\"]/span");
	public By locationHomeField=By.xpath(".//*[@data-testid=\"UserProfileHeader_Items\"]/span/span/span");
	public By websiteHomeField=By.xpath(".//*[@data-testid='UserProfileHeader_Items']/a");
	
	public By searchAccount=By.xpath(".//*[@aria-label=\"Search query\"]");
	public By searchAccountHeading=By.xpath(".//*[@data-testid='primaryColumn']//h2//span/span/span");
	
	
	
	
	public void launchUrl(String url) {
		System.setProperty("webdriver.chrome.driver", ".//lib//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void clickOnLogin() {
		waitForPageLoad();
		driver.findElement(loginButton).click();
	}
	
	public void enterUserName(String username) {		
		waitForPageLoad();
		//wait.until(ExpectedConditions.elementToBeClickable(userName));
		new Actions(driver).sendKeys(username).build().perform();
	}
	
	public void enterPassword(String pass) {
		driver.findElement(password).click();
		waitForPageLoad();
		//wait.until(ExpectedConditions.elementToBeClickable(password));
		new Actions(driver).sendKeys(pass).build().perform();
	}
	
	public void verifyUserLoginSuccessfully(String username) {
		if(driver.findElement(userLogonName).isDisplayed()){
				System.out.println("****** user successfully logged in");
				//can use the logger here
			}else {
				Assert.fail("****** user not logged in successfully, test failed");
			}
	}
	
	public void verifyUserNavigateToHomePage(String homePageString) {
		if(driver.findElement(homeString).getText().equalsIgnoreCase(homePageString)){
				System.out.println("****** user successfully navigate to twitter home page");
			}else {
				Assert.fail("****** user not successfully navigate to home page, test failed");
			}
	}

	public void setPasswordFieldBlank(String pass) {
		if(pass.equalsIgnoreCase("null")) {
			driver.findElement(password).clear();
		}else {
			System.out.println("****** Please pass input password value as null for mandatory field validation");
			Assert.fail();
		}
	}
	
	public void verifyPasswordIsMandatoryField() {
		if(driver.findElement(loginButtonDisable).isDisplayed()) {
			System.out.println("***** Login button is disable hence password is a mandatory field");
		}else {
			Assert.fail("***** Login button is not disable hence password is not mandatory field, test failed");
		}
	}
	
	public void setUserNameFieldBlank(String username) {
		if(username.equalsIgnoreCase("null")) {
			//driver.findElement(userName).clear();
			new Actions(driver).sendKeys(Keys.CONTROL+"a").build().perform();
			new Actions(driver).sendKeys(Keys.DELETE).build().perform();
		}else {
			System.out.println("****** Please pass input username value as null for mandatory field validation");
			Assert.fail();
		}
	}
	
	public void verifyUserNameIsMandatoryField() {
		if(driver.findElement(loginButtonDisable).isDisplayed()) {
			System.out.println("***** Login button is disable hence password is a mandatory field");
		}else {
			Assert.fail("***** Login button is not disable hence password is not mandatory field, test failed");
		}
	}
	
	public void navigateToProfile() {
		driver.findElement(profileIcon).click();
	}
	
	public void uploadProfilePic(String picPath) {
		driver.findElement(editProfileButton).click();
		driver.findElement(picUploadLink).click();		
		waitForPageLoad();		
		/*
		 * try { Runtime.getRuntime().exec( "wscript F:/vbsScript.vbs" ); }
		 * catch(IOException e){ // TODO Auto-generated catch block e.printStackTrace();
		 * } }
		 */
		enterPicPath();
		waitForPageLoad();
		driver.findElement(applyProfilPicButton).click();
		driver.findElement(saveButton).click();		
	}
	
	public void clicksOnEditProfile() {
		driver.findElement(editProfileButton).click();
		waitForPageLoad();	
	}
	
	//Bio field update
	public void updateBioProfileField(String bioString) {
		driver.findElement(bio).clear();
		driver.findElement(bio).sendKeys(bioString);
		driver.findElement(saveButton).click();
	}
	
	public void veirfyBioProfileUpdated(String bioString) {
		clicksOnEditProfile();
		if(driver.findElement(bioHomeField).getText().equalsIgnoreCase(bioString)) {
			System.out.println("**** Bio field updated successfully");
		}else {
			System.out.println("**** Bio field not updated successfully");
			Assert.fail();
		}
	}
	
	//location field update
	public void updateLocationProfileField(String locationString) {
		driver.findElement(location).clear();
		driver.findElement(location).sendKeys(locationString);
		driver.findElement(saveButton).click();
	}
	
	public void veirfyLocationProfileUpdated(String locationString) {
		clicksOnEditProfile();
		if(driver.findElement(locationHomeField).getText().equalsIgnoreCase(locationString)) {
			System.out.println("**** Location field updated successfully");
		}else {
			System.out.println("**** Location field not updated successfully");
			Assert.fail();
		}
	}
	
	//website field update
	public void updateWebsiteProfileField(String websiteString) {
		driver.findElement(website).clear();
		driver.findElement(website).sendKeys(websiteString);
		driver.findElement(saveButton).click();
	}
	
	public void veirfyWebsiteProfileUpdated(String websiteString) {
		clicksOnEditProfile();
		if(driver.findElement(websiteHomeField).getText().equalsIgnoreCase(websiteString)) {
			System.out.println("**** Website field updated successfully");
		}else {
			System.out.println("**** Website field not updated successfully");
			Assert.fail();
		}
	}
	
	public void updateAllProfileField(String bioString, String locationString, String websiteString) {
		waitForPageLoad();
		driver.findElement(bio).clear();
		driver.findElement(bio).sendKeys(bioString);
		driver.findElement(location).clear();
		driver.findElement(location).sendKeys(locationString);
		driver.findElement(website).clear();
		driver.findElement(website).sendKeys(websiteString);
		driver.findElement(saveButton).click();
	}
	
	public void userRetrieveBioLocationWebsiteFieldValues() {
		waitForPageLoad();
		clicksOnEditProfile();
		bioProfileValue=driver.findElement(bio).getAttribute("value");
		locationProfileValue=driver.findElement(location).getAttribute("value");
		websiteProfileValue=driver.findElement(website).getAttribute("value");
	}
	
	public void verifyBioLocationWebsiteUpdatedCorrectly(String biovalue, String locationValue, String websiteValue) {
		if(biovalue.equalsIgnoreCase(bioProfileValue)
				&& locationValue.equalsIgnoreCase(locationProfileValue)
				&& websiteProfileValue.contains(websiteValue)) {
			System.out.println("***** All the fields are updated correctly");
		}else {
			System.out.println("***** All the fields are updated correctly");
			System.out.println(biovalue +""+bioProfileValue);
			System.out.println(locationValue +""+locationProfileValue);
			System.out.println(websiteValue +""+websiteProfileValue);
			Assert.fail();
		}
	}
	
	public void verifyProfilePicUploaded() {
		waitForPageLoad();
		driver.findElement(editProfileButton).click();
		if(driver.findElement(removePicButton).isDisplayed()) {
			System.out.println("Profile pic uploaded successfully");
		}else {
			System.out.println("Profile pic not uploaded successfully");
			Assert.fail();
		}
	}
	
	public void seachForTheTwitterHandle(String accountName) {
		driver.findElement(searchAccount).sendKeys(accountName);
		waitForPageLoad();
		waitForPageLoad();
		waitForPageLoad();
		new Actions(driver).sendKeys(Keys.ARROW_DOWN).build().perform();
		new Actions(driver).sendKeys(Keys.ENTER).build().perform();
		waitForPageLoad();
		if(driver.findElement(searchAccountHeading).getText().equalsIgnoreCase(accountName)) {
			System.out.println("Twitter handle searched and open successfully");
		}else {
			System.out.println("Twitter handle not searched and open");
			Assert.fail();
		}
	}

	public void retrieveLastTwoHrsTweets(String hrs) {
		hm=new HashMap<String, String>();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		java.util.List<WebElement> elements=driver.findElements(By.xpath(".//*[contains(@aria-label,'Timeline')]//div[contains(@style,'position')]//a[contains(@aria-label,'ago')]"));
		for(int i=0;i<elements.size();i++) {
			java.util.List<WebElement> tweets=driver.findElements(By.xpath(".//article[@role=\"article\"]//div[@lang=\"en\"]/span[1]"));
			js.executeScript("arguments[0].scrollIntoView(true);",elements.get(i));
			if(elements.get(i).getText().contains("m") || elements.get(i).getText().equalsIgnoreCase(hrs)) {
				hm.put(elements.get(i).getText(), tweets.get(i).getText());
			}			
		}
	}		
	
	
	public void verifyUserRetrieveLastTwoHrsTweetsSuccessfully(int hrsTime) {
		if(hm.size()>0) {
			System.out.println("last 2 hrs tweets has been successfully retrieved");
			for(Map.Entry<String, String> entry:hm.entrySet()) {
				System.out.println("****************************************");
				System.out.print(entry.getKey()+" --> "+entry.getValue());
				System.out.println("****************************************");
			}
		}else {
			System.out.println("No tweets in the last 2 hrs");
		}
	}
	
	
	//********************************
	public void waitForPageLoad() {
		try {
			Thread.sleep(2000); 
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		}
	}
	
	public void enterPicPath() {
		Robot rb;
		try {
			rb = new Robot();
			rb.keyPress(KeyEvent.VK_F);
			rb.keyPress(KeyEvent.VK_SHIFT);
			rb.keyPress(KeyEvent.VK_SEMICOLON);
			rb.keyRelease(KeyEvent.VK_SHIFT);
			rb.keyPress(KeyEvent.VK_BACK_SLASH);
			rb.keyPress(KeyEvent.VK_P);
			rb.keyPress(KeyEvent.VK_I);
			rb.keyPress(KeyEvent.VK_C);
			rb.keyPress(KeyEvent.VK_DECIMAL);
			rb.keyPress(KeyEvent.VK_P);
			rb.keyPress(KeyEvent.VK_N);
			rb.keyPress(KeyEvent.VK_G);
			rb.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}				
	}
}
