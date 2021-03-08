package io.redtrack.app.tests;

import io.redtrack.app.other.*;
import io.redtrack.app.pages.*;
import io.redtrack.app.variable.Variables;
import org.apache.log4j.Logger;
import org.junit.ComparisonFailure;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import io.redtrack.app.other.ParsingURL;


import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.*;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Test;

public class RedtrackCustomDomains {

    public RemoteWebDriver driver;
    //public ChromeDriver driver;
    public static LoginPage loginPage;
    public static CheckingParam checkingParam;
    public static Navigation navigation;
    public static OtherElements otherElements;
    public static Variables vars;
    public static Domains domains;
    public static Campaigns campaigns;
    public static Clicks clicks;
    public static ParsingURL parsingURL;
    public static Postbacks postbacks;
    public static Conversions conversions;




    private String
            windowHandle;

    public static String s;
    private static String hubURL = "http://213.227.132.143:4444/wd/hub";
    public static final Logger logger = Logger.getLogger(RedtrackCustomDomains.class.getName());



    @BeforeClass
    private void init() {
        try {

            logger.info("Initialization driver");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            capabilities.setVersion("73.0");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            //driver = new ChromeDriver( options )

            driver = new RemoteWebDriver(new URL(hubURL),capabilities);
            //System.setProperty("webdriver.chrome.driver", "./src/Drivers/Chrome/chromedriver");
            //driver = new ChromeDriver();
            clicks = new Clicks(driver);
            loginPage = new LoginPage(driver);
            navigation = new Navigation(driver);
            otherElements = new OtherElements(driver);
            domains = new Domains(driver);
            campaigns = new Campaigns(driver);
            parsingURL = new ParsingURL(driver);
            postbacks = new Postbacks(driver);
            conversions = new Conversions(driver);
            windowHandle = driver.getWindowHandle();
            driver.switchTo().window(windowHandle);
            logger.info("Initialization driver success");
            logger.info("Opening page: "+Variables.urlProd);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(Variables.urlProd);
            driver.getCurrentUrl();
            if (driver.getCurrentUrl().equals(Variables.urlProd)) {
                Assert.assertEquals(Variables.urlProd, driver.getCurrentUrl());
                logger.info("Opened page is: "+driver.getCurrentUrl());
            }
        }
        catch(ComparisonFailure e){
            logger.error("Error opening page: "+e.getMessage());
        }
        catch (Exception e){
            logger.fatal("Something went wrong: "+e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void login() throws InterruptedException{
        try {
            Thread.sleep(3000);
            //driver.manage().window().fullscreen();
            driver.manage().window().maximize();
            logger.info("Logging into app");
            loginPage.Login();
           Thread.sleep(5000);
            otherElements.getUserName();
        }
        catch(StaleElementReferenceException f){
            logger.error("TestNG failed: "+f.getMessage());
            f.printStackTrace();
        }
        catch(ComparisonFailure e) {
            logger.error("Login failed: " +e.getMessage());

        }
        try {
            checkingParam.checkingElement();
            logger.info("Login successful ");
        }
        catch(StaleElementReferenceException f){
            logger.error("Too fast login, need one more try "+f.getMessage());
            f.printStackTrace();
        }
        catch(ComparisonFailure e) {
            logger.error("Login failed: " +e.getMessage());
        }

    }

    /*@Test (dependsOnMethods = "login")
    public void navToDomains() throws Exception{
        try {
            logger.info("Opening page "+"Domains");
            navigation.dropDownTools();
            Thread.sleep(3000);
            navigation.pageDomains();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //logger.info("Opened page is "+otherElements.getCheckOpenedPage());
            //Assert.assertEquals("Domains", otherElements.getCheckOpenedPage());
            Thread.sleep(5000);
        }
        catch(Exception e){
            logger.error("Opening page "+"Domains"+ " failed: "+e.getMessage());
        }
    }

    @Test(dependsOnMethods = "navToDomains")
    public void openCreateDomain(){
        try{
            Thread.sleep(5000);
            logger.info("Opening page for creating new domain");
            otherElements.CreateNew();

        }
        catch(Exception e){
            logger.error("Opening page "+"failed: "+e.getMessage());
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = "openCreateDomain")
    public void inputName(){
        try {
            Thread.sleep(5000);
            logger.info("Writing domains name");
            otherElements.TitleRand();
        }

        catch (NullPointerException n) {
            logger.error("Writing domains name failed: "+n.getMessage());
            n.printStackTrace();
        }
        catch (Exception e){
            logger.error("Writing domains name failed: "+e.getMessage());
            e.printStackTrace();
        }

    }

    @Test(dependsOnMethods = "inputName")
    public void inputURL(){
        try {
            Thread.sleep(5000);
            logger.info("Writing domains URL");
            domains.inputURL();
        }
        catch (NullPointerException n) {
            logger.error("Writing domains URL failed: "+n.getMessage());
            n.printStackTrace();
        }
        catch (Exception e){
            logger.error("Writing domains URL failed: "+e.getMessage());
            e.printStackTrace();
        }

    }

    @Test(dependsOnMethods = "inputURL")
    public void getName(){
        try {
            Thread.sleep(500);
            logger.info("Getting domains name");
            logger.info("Actual name is: "+otherElements.rand);

        }
        catch (NullPointerException n) {
            logger.error("Writing domains URL failed: "+n.getMessage());
            n.printStackTrace();
        }
        catch (Exception e){
            logger.error("Writing domains URL failed: "+e.getMessage());
            e.printStackTrace();
        }

    }

    @Test (dependsOnMethods = "getName")
    public void saveDomain() throws InterruptedException{
        Thread.sleep(5000);
        logger.info("Saving domain");
        //domains.saveDomain();
        domains.trySaveDomain();

    }
*/
    @Test (dependsOnMethods = "login")
    public void goToCampaignPage() throws InterruptedException{
        Thread.sleep(5000);
        logger.info("Navigating to campaigns");
        navigation.pageCampaigns();
        Thread.sleep(3000);
        logger.info("Navigation to campaign from dropdown");
        navigation.campPage();
    }

    @Test (dependsOnMethods = "goToCampaignPage")
    public void openCampaign() throws InterruptedException{
        Thread.sleep(5000);
        logger.info("Opening campaign");
        campaigns.chosseCamp();
        Thread.sleep(5000);
        otherElements.editCamp();
    }

   /* @Test (dependsOnMethods = "openCampaign")
    public void chooseDomain() throws InterruptedException {
        //Thread.sleep(5000);
        Thread.sleep(5000);
        logger.info("Choosing domain in campaign");
        campaigns.domainsListCamp();
        Thread.sleep(5000);
        campaigns.chooseDomainCamp();
        Thread.sleep(3000);

    }

    @Test (dependsOnMethods = "chooseDomain")
    public void saveCamp() {
        campaigns.saveCamp();
    }
*/
    @Test (dependsOnMethods = "openCampaign")
    public void getClickURL() throws InterruptedException {
        Thread.sleep(3000);
        logger.info("Getting click url");
        campaigns.getClickURL();
        //System.out.println(campaigns.clickURL);
    }

    @Test (dependsOnMethods = "getClickURL")
    public void creatingClick() throws InterruptedException, IOException, UnsupportedFlavorException {
        Thread.sleep(5000);
        logger.info("Generating click");
        campaigns.saveBuffer();
        //campaigns.setClip();

        //campaigns.getClipboard();
        //campaigns.setClipboard();
        System.out.println(campaigns.clickURL);
        //System.out.println(campaigns.str);
        Thread.sleep(3000);
        clicks.createOneClick();
        Thread.sleep(3000);
    }

    @Test (dependsOnMethods = "creatingClick")
    public void parsingURL() throws InterruptedException, NullPointerException {
        Thread.sleep(5000);
        logger.info("Parsing url for conversion");
        parsingURL.getCurrentURL();
        Thread.sleep(3000);
        parsingURL.parsingURL();

    }

    @Test (dependsOnMethods = "parsingURL")
        public void creatingConversion() throws InterruptedException{
        Thread.sleep(5000);
        logger.info("Generating conversion");
        clicks.createOneConversion();
        //Thread.sleep(5000);
        //logger.info("Generating conversion 2 ");
        //clicks.createOneConversion2();
    }

    @Test(dependsOnMethods = "creatingConversion")
    public void creatingConv2() throws InterruptedException{
        Thread.sleep(5000);
        logger.info("Generating conversion 2 ");
        clicks.createOneConversion2();
    }

    @Test (dependsOnMethods = "creatingConversion")
    public void parsingID() throws InterruptedException{
        Thread.sleep(3000);
        logger.info("Parsing url");
        parsingURL.parsingID();
    }

    @Test (dependsOnMethods = "parsingID")
    public void checkingPostback() throws InterruptedException{
        Thread.sleep(3000);
        logger.info("Opening postback page");
        this.driver.get(vars.urlProd);
        Thread.sleep(3000);
        login();
        Thread.sleep(5000);
        navigation.dropDownLogs();
        Thread.sleep(3000);
        navigation.pagePostbacks();
    }


    @Test (dependsOnMethods = "checkingPostback")
    public void findPostback() throws InterruptedException{
        Thread.sleep(5000);
        logger.info("Checking send postback");
        postbacks.findConve();
    }

    @Test (dependsOnMethods = "findPostback")
    public void checkingConv() throws InterruptedException{
        Thread.sleep(2000);
        logger.info("Opening conversoins page");
        navigation.dropDownLogs();
        Thread.sleep(3000);
        navigation.pageConversions();

    }

    @Test (dependsOnMethods = "checkingConv")
    public void findConv() throws InterruptedException{
        Thread.sleep(5000);
        logger.info("Checking created conversion");
        conversions.findConve();
    }

   /* @Test (dependsOnMethods = "findConv")
    public void backToDomains() throws InterruptedException, Exception{
        Thread.sleep(3000);
        logger.info("Opening domains page");
        navToDomains();
    }

    @Test (dependsOnMethods = "backToDomains")
    public void deleteDomain() throws InterruptedException{
        Thread.sleep(5000);
        logger.info("Deleting created domain");
        //System.out.println(otherElements.rand);
        domains.findCreatedDomain();
        Thread.sleep(3000);
        domains.deleteDomain();
    }
*/



        //driver.findElement(By.xpath("//div[@class='col-sm-9']//div[@class='Select input-sm is-clearable is-focused is-open is-searchable Select--single']//div[@class='Select-menu-outer']")).click();
        //List<WebElement> d = new ArrayList<>();
        //d = driver.findElements(By.className("Select-option"));
        //System.out.println(d.size());

        //WebElement searchTextBox= driver.findElement(By.className("Select-option"));
        //String d = searchTextBox.getAttribute("innerHTML");
        //System.out.println(d);
        //System.out.println(d);
        //for (int i = 0; i <d.size() ; i++) {

        //}






        //driver.findElement(By.xpath("//div[contains(text(),'Default domain')]")).sendKeys("12345");
        // driver.findElement(By.className("Select input-sm is-clearable is-focused is-open is-searchable Select--single")).sendKeys(Keys.DOWN);
        //campaigns.chooseDomain();


   // @Test (dependsOnMethods = "getName")
    //public void navToCampaign(){
        //try {

           // Thread.sleep(5000);
           // navigation.pageCampaigns();


       // }
        //catch (NullPointerException n){

        //}
        //catch (Exception e){

       // }
   // }

    //@Test (dependsOnMethods = "saveDomain")
    //public void setCreatedDomain() throws InterruptedException{
        //try {
            //Thread.sleep(5000);
            //domains.findCreatedDomain();
        //}
       // catch (NullPointerException n){

        //}
        //catch (Exception e){

        //}
    //}

    //@Test (dependsOnMethods = "setCreatedDomain")
    //public void deleteDomain(){
        //domains.deleteDomain();
    //}

   //@AfterClass
   @Test(dependsOnMethods = "findConv")
    private final void closingDriver() throws InterruptedException{
        logger.info("Closing driver");
        Thread.sleep(5000);
        //logger.info("Closing browser");
        driver.quit();
    }




}



