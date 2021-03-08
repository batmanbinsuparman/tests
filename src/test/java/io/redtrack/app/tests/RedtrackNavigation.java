package io.redtrack.app.tests;

import io.redtrack.app.other.CheckingParam;
import io.redtrack.app.other.Navigation;
import io.redtrack.app.other.OtherElements;
import io.redtrack.app.pages.LoginPage;
import io.redtrack.app.pages.TrafficSources;
import io.redtrack.app.variable.Variables;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.concurrent.TimeUnit;






public class RedtrackNavigation {
    public Date   date;
    public        WebDriver driver;
    public static LoginPage loginPage;
    public static CheckingParam checkingParam;
    public static Navigation navigation;
    public static OtherElements otherElements;
    public static TrafficSources sources;


    public static String
            password1 = "99948936",

            usrnm = "Logs",

            page0 = "Campaigns",
            page1 = "Offers",
            page2 = "Landings",
            page3 = "Networks",
            page4 = "Sources",
            page5 = "Domains",
            page6 = "Dashboard",
            logspage0 = "Clicks",
            logspage1 = "Conversions",
            logspage2 = "Postbacks",
            toolspage0 = "Conversion tracking",
            toolspage1 = "Bot Blacklist",
            toolspage2 = "Default fallback-URL",
            toolspage3 = "Filter presets",
            toolsApiPage = "Introduction";


    private String
            windowHandle,
            CheckopenedPage;

public static final Logger logger = Logger.getLogger(RedtrackNavigation.class.getSimpleName());

    @BeforeClass
    public void init(){
        try {
            logger.info("Initialization driver");
            System.setProperty("webdriver.chrome.driver", "./src/Drivers/Chrome/chromedriver");
            driver = new ChromeDriver();
            loginPage = new LoginPage(driver);
            //checkingParam = new CheckingParam(driver);
            navigation = new Navigation(driver);
            otherElements = new OtherElements(driver);
            sources = new TrafficSources(driver);
            windowHandle = driver.getWindowHandle();
            driver.switchTo().window(windowHandle);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://app.redtrack.io/signin");
        }
        catch(StaleElementReferenceException e){
            logger.fatal("Fatal initialization error: "+e.getMessage());
        }
        catch(ComparisonFailure e){
            logger.error("Something went wrong: "+e.getMessage());
        }
        catch(Exception e){
            logger.error("Something went wrong: "+e.getMessage());
        }
    }



    @Test(groups = "Nav")
    public void Login() throws InterruptedException {
        try {
            logger.info("Logging into app");
            loginPage.inputLogin(Variables.login2);
            loginPage.inputPassword(password1);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(5000);
            loginPage.clickSubmitButton();
            String username = otherElements.getUserName();
            Thread.sleep(15000);
            Assert.assertEquals(usrnm, username);
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
            //if (usrnm.equals(username)) {
              //  System.out.print("[" + date.toString() + "]: ");
              //  System.out.println("Login success, found: " + username);
           // } else {
             //   System.out.print("[" + date.toString() + "]: ");
             //   System.out.println("Login failed: " + username);
            //}
            Thread.sleep(5000);
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

    @Test (groups = "Nav", dependsOnMethods = "Login")
    public void campPage() {//throws InterruptedException {
        try {
            logger.info("Opening page "+page0);
            //date = new Date();
            navigation.pageCampaigns();
            Thread.sleep(5000);
            //CheckopenedPage = otherElements.getCheckOpenedPage();
            Assert.assertEquals(page0, otherElements.getCheckOpenedPage());
            //if (page0.equals(CheckopenedPage)) {
                //System.out.print("[" + date.toString() + "]: ");
                //System.out.println("Campaigns page open, found: " + CheckopenedPage);
           // } else {
              //  System.out.print("[" + date.toString() + "]: ");
               // System.out.println("Opening page " + page0 + " failed: " + CheckopenedPage);
            //}
            Thread.sleep(5000);
        }
        catch(Exception e){
            logger.error("Opening page "+page0+" failed: "+e.getMessage());
        }
    }

    @Test (groups = "Nav", dependsOnMethods = "campPage")
    public void offersPage() {//throws InterruptedException{
        try {
            logger.info("Opening page "+page1);
            //date = new Date();
            navigation.pageOffers();
            Thread.sleep(5000);
            //CheckopenedPage = otherElements.getCheckOpenedPage();
            Assert.assertEquals(page1, otherElements.getCheckOpenedPage());
            //if (page1.equals(CheckopenedPage)){
            //System.out.print("["+date.toString()+"]: ");
            //System.out.println("Offers page open, found: "+CheckopenedPage);
            //}
            //else {
            //System.out.print("["+date.toString()+"]: ");
            //System.out.println("Opening page "+page1 +" failed: "+CheckopenedPage);
            //}
            Thread.sleep(5000);
        }
        catch(Exception e){
            logger.error("Opening page "+page1+" failed "+e.getMessage());
        }
    }

    @Test (groups = "Nav", dependsOnMethods = "offersPage")
    public void landersPage() throws  InterruptedException{
        try {
            logger.info("Opening page "+page2);
            //date = new Date();
            navigation.pageLanders();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //CheckopenedPage = otherElements.getCheckOpenedPage();
            Assert.assertEquals(page2, otherElements.getCheckOpenedPage());
            //if (page2.equals(CheckopenedPage)) {
                //System.out.print("[" + date.toString() + "]: ");
                //System.out.println("Landers page open, found: " + CheckopenedPage);
            //} else {
               // System.out.print("[" + date.toString() + "]: ");
              //  System.out.println("Opening page " + page2 + " failed: " + CheckopenedPage);
            //}
            Thread.sleep(5000);
        }
        catch(Exception e){
            logger.error("Opening page "+page2+" failed: "+e.getMessage());
        }
    }

    @Test (groups = "Nav", dependsOnMethods = "landersPage")
    public void networksPage() throws InterruptedException{
        //date = new Date();
        try {
            logger.info("Opening page "+page3);
            navigation.pageNetworks();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //CheckopenedPage = otherElements.getCheckOpenedPage();
            Assert.assertEquals(page3, otherElements.getCheckOpenedPage());
            //if (page3.equals(CheckopenedPage)){
            // System.out.print("["+date.toString()+"]: ");
            // System.out.println("Networks page open, found: "+CheckopenedPage);
            // }
            // else{
            // System.out.print("["+date.toString()+"]: ");
            // System.out.println("Opening page "+page3 +" failed: "+CheckopenedPage);
            //}
            Thread.sleep(5000);
        }
        catch(Exception e){
            logger.error("Opening page "+page3+" failed: "+e.getMessage());
        }
    }


    @Test (groups = "Nav", dependsOnMethods = "networksPage")
    public void tSpage() throws InterruptedException {
        try {
            logger.info("Opening page "+page4);
            //date = new Date();
            navigation.SourcePage();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //CheckopenedPage = otherElements.getCheckOpenedPage();
            Assert.assertEquals(page4, otherElements.getCheckOpenedPage());
            //if (page4.equals(CheckopenedPage)){
            //System.out.print("["+date.toString()+"]: ");
            //System.out.println("Traffic Sources page open, found: "+CheckopenedPage);
            //}
            // else{
            //System.out.print("["+date.toString()+"]: ");
            //System.out.println("Opening page "+page4 +" failed: "+CheckopenedPage);
            //}
            Thread.sleep(5000);
        }
        catch(Exception e){
            logger.error("Opening page "+page4+" failed: "+e.getMessage());
        }
    }

    @Test (groups = "Nav", dependsOnMethods = "tSpage")
    public void domainsPage() throws InterruptedException{
        try {
            logger.info("Opening page "+page5);
            navigation.dropDownTools();
            //date = new Date();
            navigation.pageDomains();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //CheckopenedPage = otherElements.getCheckOpenedPage();
            Assert.assertEquals(page5, otherElements.getCheckOpenedPage());
            //if (page5.equals(CheckopenedPage)){
            // System.out.print("["+date.toString()+"]: ");
            // System.out.println("Domains page open, found: "+CheckopenedPage);
            //}
            // else{
            //System.out.print("["+date.toString()+"]: ");
            //System.out.println("Opening page "+page5 +" failed: "+CheckopenedPage);
            // }
            Thread.sleep(5000);
        }
        catch(Exception e){
            logger.error("Opening page "+page5+ " failed: "+e.getMessage());
        }
    }

    @Test (groups = "Nav", dependsOnMethods = "domainsPage")
    public void dashBoardPage() throws InterruptedException{
        try {
            logger.info("Opening page "+page6);
            //date = new Date();
            navigation.pageDashboard();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //CheckopenedPage = otherElements.getCheckOpenedPage();
            Assert.assertEquals(page6, otherElements.getCheckOpenedPage());
            //if (page6.equals(CheckopenedPage)) {
               // System.out.print("[" + date.toString() + "]: ");
                //System.out.println("Dashboard page open, found: " + CheckopenedPage);
            //} else {
                //System.out.print("[" + date.toString() + "]: ");
                //System.out.println("Opening page " + page6 + " failed: " + CheckopenedPage);
            //}
            Thread.sleep(5000);
        }
        catch(Exception e){
            logger.error("Opening page "+page6+" failed: "+e.getMessage());
        }
    }

    @Test (groups = "NavLogs", dependsOnMethods = "dashBoardPage")
    public void logsClicksPage () throws InterruptedException {
        try {
            logger.info("Opening page "+logspage0);
            //date = new Date();
            navigation.dropDownLogs();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            navigation.pageClicks();
            //CheckopenedPage = otherElements.getCheckOpenegPage2();
            Assert.assertEquals(logspage0, otherElements.getCheckOpenedPage());
            //if (logspage0.equals(CheckopenedPage)) {
               // System.out.print("[" + date.toString() + "]: ");
               // System.out.println("Logs -> Clicks page open, found: " + CheckopenedPage);
           // } else {
              //  System.out.print("[" + date.toString() + "]: ");
              //  System.out.println("Opening page " + logspage0 + " failed: " + CheckopenedPage);
            //}
            Thread.sleep(5000);
        }catch(Exception e){
            logger.error("Opening page "+logspage0+" faoled: "+e.getMessage());
        }
    }

    @Test (groups = "NavLogs", dependsOnMethods = "logsClicksPage")
    public void logsConversionPage() throws InterruptedException {
        try {
            logger.info("Opening page "+logspage1);
            //date = new Date();
            navigation.dropDownLogs();
            navigation.pageConversions();
            //CheckopenedPage = otherElements.getCheckOpenegPage2();
            Assert.assertEquals(logspage1, otherElements.getCheckOpenegPage2());
            //if (logspage1.equals(CheckopenedPage)) {
                //System.out.print("[" + date.toString() + "]: ");
                //System.out.println("Logs -> Conversions page open, found: " + CheckopenedPage);
           // } else {
              //  System.out.print("[" + date.toString() + "]: ");
              //  System.out.println("Opening page " + logspage1 + " failed: " + CheckopenedPage);
            //}
            Thread.sleep(5000);
        }
        catch(Exception e){
            logger.error("Opening page "+logspage1+" failed: "+e.getMessage());
        }
    }

    @Test (groups ="NavLogs", dependsOnMethods = "logsConversionPage")
    public void logsPostbackPage() throws InterruptedException{
        try {
            logger.info("IOpening page "+logspage2);
            //date = new Date();
            navigation.dropDownLogs();
            navigation.pagePostbacks();
            //CheckopenedPage = otherElements.getCheckOpenegPage2();
            Assert.assertEquals(logspage2, otherElements.getCheckOpenegPage2());
           // if (logspage2.equals(CheckopenedPage)) {
             //   System.out.print("[" + date.toString() + "]: ");
             //   System.out.println("Logs -> Postbacks page open, found: " + CheckopenedPage);
           // } else {
             //   System.out.print("[" + date.toString() + "]: ");
             //   System.out.println("Opening page " + logspage2 + " failed: " + CheckopenedPage);
            //}
            Thread.sleep(5000);
        }
        catch(Exception e){
            logger.error("Opening page "+logspage2+" failed: "+e.getMessage());
        }
    }

    @Test (groups = "NavTools", dependsOnMethods = "logsPostbackPage")
    public void toolsConversionTracking() throws InterruptedException {
        try {
            logger.info("Opening page "+toolspage0);
            //date = new Date();
            navigation.dropDownTools();
            navigation.pageConvTrack();
            //CheckopenedPage = otherElements.getCheckOpenedPage3();
            Assert.assertEquals(toolspage0, otherElements.getCheckOpenedPage());
            //if (toolspage0.equals(CheckopenedPage)) {
                //System.out.print("[" + date.toString() + "]: ");
               // System.out.println("Tools -> Conversion tracking page open, found: " + CheckopenedPage);
           // } else {
               // System.out.print("[" + date.toString() + "]: ");
               // System.out.println("Opening page " + toolspage0 + " failed: " + CheckopenedPage);
            //}
            Thread.sleep(3000);
        }
        catch(Exception e){
            logger.error("Opening page "+toolspage0+" failed: "+e.getMessage());
        }
    }

    @Test (groups = "NavTools", dependsOnMethods = "toolsConversionTracking")
    public void toolsBotBlack() throws InterruptedException{
        try {
            logger.info("Opening page "+toolspage1);
            navigation.dropDownTools();
            Thread.sleep(5000);
            navigation.pageBotBlack();
            //CheckopenedPage = otherElements.getBotBlacklist();
            Assert.assertEquals(toolspage1, otherElements.getBotBlacklist());
            Thread.sleep(5000);
            //date = new Date();
            //if (toolspage1.equals(CheckopenedPage)) {
                //System.out.print("[" + date.toString() + "]: ");
               // System.out.println("Tools -> Bot Blacklist page open, found: " + CheckopenedPage);
           // } else {
              //  System.out.print("[" + date.toString() + "]: ");
               // System.out.println("Opening page " + toolspage1 + "failed: " + CheckopenedPage);
            //}
        }
        catch(Exception e){
            logger.error("Opening page "+toolspage1+" failed: "+e.getMessage());
        }
    }

    @Test (groups = "NavTools", dependsOnMethods = "toolsBotBlack")
    public void toolsDefFallbackURL() throws InterruptedException{
        try {
            logger.info("Opening page "+toolspage2);
            navigation.dropDownTools();
            navigation.pageDefaultFallbackURL();
            //CheckopenedPage = otherElements.getOpenedPage0();
            Assert.assertEquals(toolspage2, otherElements.getCheckOpenedPage());
            Thread.sleep(3000);
            //date = new Date();
            //if (toolspage2.equals(CheckopenedPage)) {
              //  System.out.print("[" + date + "]: ");
              //  System.out.println("Tools -> Default fallback-URL page open, found: " + CheckopenedPage);
            //} else {
             //   System.out.println("Opening page " + toolspage1 + "failed: " + CheckopenedPage);
           // }
        }catch(Exception e){
            logger.error("Opening page "+toolspage2+" failed: "+e.getMessage());
        }
    }

    @Test (groups = "NavTools", dependsOnMethods = "toolsDefFallbackURL")
    public void toolsFilterPresets() throws InterruptedException{
        try {
            logger.info("Opening page "+toolspage3);
            navigation.dropDownTools();
            navigation.pageFilterPresets();
           // CheckopenedPage = otherElements.getOpenedPage4();
            Assert.assertEquals(toolspage3, otherElements.getOpenedPage4());
            Thread.sleep(3000);
            //date = new Date();
            //if (toolspage3.equals(CheckopenedPage)) {
             //   System.out.print("[" + date + "]: ");
            ///    System.out.println("Tools -> Filter presets page open, found: " + CheckopenedPage);
           // } else {
             //   System.out.println("Opening page " + toolspage3 + "failed: " + CheckopenedPage);
            //}
        }
        catch(Exception e){
            logger.error("Opening page "+toolspage3+" failed: "+e.getMessage());
        }
    }

    @Test (groups = "NavTools", dependsOnMethods = "toolsFilterPresets")
    public void toolsAPIDocumentation() throws InterruptedException{
        try {
            logger.info("Opening page" +toolsApiPage);
            navigation.dropDownTools();
            navigation.pageAPI_Documentation();
            //CheckopenedPage = otherElements.getOpenedApiPage();
            Assert.assertEquals(toolsApiPage, otherElements.getOpenedApiPage());
            Thread.sleep(3000);
            //date = new Date();
            //if (toolsApiPage.equals(CheckopenedPage)) {
              //  System.out.print("[" + date + "]: ");
               // System.out.println("Tools -> API Documentation page open, found: " + CheckopenedPage);
            //} else {
               // System.out.println("Opening page " + toolsApiPage + "failed: " + CheckopenedPage);
            //}
        }
        catch(Exception e){
            logger.error("Opening page "+toolsApiPage+" failed: "+e.getMessage());
        }
    }



   /* @Test (groups = "exit", dependsOnGroups = "Nav")
        driver.quit();

    } */


}
