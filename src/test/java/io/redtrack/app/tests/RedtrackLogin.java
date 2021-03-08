package io.redtrack.app.tests;

import io.redtrack.app.messages.Mess;
import io.redtrack.app.other.*;
import io.redtrack.app.pages.*;
import io.redtrack.app.variable.*;
import io.redtrack.app.variable.Variables;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class RedtrackLogin {

    //public ChromeDriver driver;
    public RemoteWebDriver driver;

    private static String hubURL = "http://213.227.132.143:4444/wd/hub";

    public static LoginPage loginPage;
    public static CheckingParam checkingParam;
    public static OtherElements otherElements;
    //public static Variables variables;

    public static String login2 = "sdfsdfsdf@sdfsdf.sdf",
    password2= "sdfsdfsdf",
    password1 = "99948936",
    usernotfound = "User not found",
    invalidCred = "Invalid credentials",
    cheklogin = "Logs";
    public String windowHandle, invalidcred, username;
    public static final Logger logger = Logger.getLogger(RedtrackLogin.class.getName());

    //public RedtrackLogin(RemoteWebDriver driver) {
    //}

    @BeforeClass
    public void init() {
        try {
            logger.info("Initialization driver");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            capabilities.setVersion("73.0");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);
            driver = new RemoteWebDriver(new URL(hubURL),capabilities);
            //System.setProperty("webdriver.chrome.driver", "./src/Drivers/Chrome/chromedriver");
            //driver = new ChromeDriver();
            loginPage = new LoginPage(driver);
            otherElements = new OtherElements(driver);
            //checkingParam = new CheckingParam(driver);
            windowHandle = driver.getWindowHandle();
            driver.switchTo().window(windowHandle);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://app.redtrack.io/signin");
        }
        catch(StaleElementReferenceException e){
            logger.fatal("Fatal initialization error: "+e.getMessage());
        }
        catch(ComparisonFailure e){
            logger.error("Error opening page: "+e.getMessage());
        }
        catch (Exception e){
            logger.error("Something went wrong: "+e.getMessage());
        }
    }

    //@Test (groups = "cheking")
    public void InvalidLogin() throws InterruptedException {
        try {
            loginPage.inputLogin(login2);
            loginPage.inputPassword(password2);
            loginPage.clickSubmitButton();
            Thread.sleep(5000);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //invalidcred = checkingParam.getInvalidCred();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Assert.assertEquals(usernotfound , otherElements.getInvalidCred());
           // if (usernotfound.equals(otherElements.getInvalidCred())) {
               // Mess.newdDateInfo();
                logger.info("'Invalid Login' passed, found: "+otherElements.getInvalidCred());
                //System.out.println("Test 'InvalidLogin' passed, found: " + "'" + otherElements.getInvalidCred() + "'");
            //} else {
               // Mess.error();
               // System.out.println("Somthing went wrong: Test 'InvalidLogin' FAILED");
               // Mess.ansi_reset();
            //}
            //Assert.assertEquals(usernotfound, invalidcred);
        }
        catch(StaleElementReferenceException e){
            logger.fatal("TestNG failed: "+e.getMessage());
        }
        catch(ComparisonFailure e){
            logger.error("Something went wrong: "+e.getMessage());
        }
        catch(Exception e){
            logger.error("Something went wrong: "+e.getMessage());
        }
    }

    @Test (groups = "cheking", dependsOnMethods = "InvalidLogin")
    public void upperCaseLogin() throws InterruptedException {
        try {
            logger.info("Login with upper case");
            loginPage.inputLogin(Variables.upp_Reg);
            loginPage.inputPassword(Variables.password1);
            loginPage.clickSubmitButton();
            Thread.sleep(5000);
            username = otherElements.getUserName();
            Assert.assertEquals(cheklogin, username);
            Thread.sleep(3000);
            loginPage.logout();
            logger.info("Test login with uppercase passed");
            //Assert.assertEquals(invalidCred, otherElements.getInvalidCred());
            //if (usernotfound.equals(otherElements.getInvalidCred())) {
              //  Mess.error();
            //    System.out.println("Test with uppercase failed. Found: " + otherElements.getInvalidCred());
             //   Mess.ansi_reset();
           // } else {
            //    Mess.newdDateInfo();
           //     System.out.println("Test with uppercase passed. Found: " + otherElements.getUserName());
           // }
            //invalidcred = checkingParam.getInvalidCred();
            //Mess.newdDateInfo();
            //System.out.println(invalidcred);
        }
        catch(StaleElementReferenceException e){
            logger.fatal("TestNG failed: "+e.getMessage());
        }
        catch(ComparisonFailure e){
            logger.error("Something went wrong: "+e.getMessage());
        }
        catch(Exception e){
            logger.error("Something went wrong: "+e.getMessage());
        }
    }


   // @Test (groups = "cheking", dependsOnMethods = "upperCaseLogin")
   // public void Login(RemoteWebDriver driver) throws InterruptedException {

    //}

    @Test(dependsOnMethods = "upperCaseLogin")
    public void Login (RemoteWebDriver driver) {
        try {
            logger.info("Login with correct creds");
            Thread.sleep(3000);
            loginPage.inputLogin(Variables.login2);
            loginPage.inputPassword(password1);
            loginPage.clickSubmitButton();
            username = otherElements.getUserName();
            Assert.assertEquals(cheklogin, username);
            Thread.sleep(3000);
            loginPage.logout();
            logger.info("Login successful");
            //if (cheklogin.equals(username)) {
            //Mess.newdDateInfo();
            //System.out.println("Test 'Login' passed, found: " + "'" + username + "'");
            // } else {
            // Mess.error();
            //System.out.println("Somthing went wrong: Test 'InvalidLogin' FAILED");
            //Mess.ansi_reset();
            // }
            //Assert.assertEquals(cheklogin, username);
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        }
        catch(StaleElementReferenceException e){
            logger.fatal("TestNG failed: "+e.getMessage());
        }
        catch(ComparisonFailure e){
            logger.error("Something went wrong: "+e.getMessage());
        }
        catch(Exception e){
            logger.error("Something went wrong: "+e.getMessage());
        }
    }

    @AfterClass
    //@Test (groups = "exit", dependsOnGroups = "cheking")
    public void closingDrvr(){
        // Mess.newdDateInfo();
        logger.info("Closing browser");
        //System.out.println("Exiting driver, closing browser");
        driver.quit();
    }


}
