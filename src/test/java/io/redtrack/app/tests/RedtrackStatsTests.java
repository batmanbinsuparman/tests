package io.redtrack.app.tests;

        import io.redtrack.app.other.*;
        import io.redtrack.app.pages.*;
        import org.junit.Assert;
        import org.junit.ComparisonFailure;
        import org.openqa.selenium.StaleElementReferenceException;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.remote.DesiredCapabilities;
        //import org.openqa.selenium.remote.RemoteWebDriver;
        import org.openqa.selenium.remote.RemoteWebDriver;
        import org.openqa.selenium.support.PageFactory;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;
        import io.redtrack.app.variable.Variables;
        import java.io.IOException;
        import java.net.URL;
        import java.util.concurrent.TimeUnit;
        import org.apache.log4j.*;


public class RedtrackStatsTests {


    public RemoteWebDriver driver;
    //public ChromeDriver driver;
    public static LoginPage loginPage;
    public static CheckingParam checkingParam;
    public static Navigation navigation;
    public static OtherElements otherElements;
    public static ForCheckingStats getStats;
    public static ManipWithString manipulation;
    public static CalculatingValues calculate;
    public static RenewingVarsVals renew;
    public static Variables vars;

    private String
            windowHandle;

    //public static String s;
    private static String hubURL = "http://213.227.132.143:4444/wd/hub";
    public static final Logger logger = Logger.getLogger(RedtrackStatsTests.class.getName());


    @BeforeClass
    private void init() {
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
            getStats = new ForCheckingStats(driver);
            navigation = new Navigation(driver);
            otherElements = new OtherElements(driver);
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
      public static void login () throws InterruptedException{
   // public static void login(RemoteWebDriver driver) throws InterruptedException{
        try {
            logger.info("Logging into app");
            loginPage.inputLogin(vars.login2);
            loginPage.inputPassword(vars.password1);
            loginPage.clickSubmitButton();
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

    @Test(dependsOnMethods = "login")
    public void campaignsPage(){
        try {
            logger.info("Opening page: 'Campaigns'");
            navigation.pageCampaigns();
        }
        catch(Exception e){
            logger.error("Navigation failed: "+e.getMessage());
        }
    }

    @Test(dependsOnMethods = "campaignsPage")
    public void setCustomPeriod() throws InterruptedException {
        try {
            Thread.sleep(5000);
            logger.info("Opening calendar to set period");
            otherElements.setPeriod();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            //Thread.sleep(5000);
            logger.info("Set period 'Last 30 days'");
            otherElements.customRange();
        }
        catch (Exception e){
            logger.error("Set period 'Last 30 days' failed: "+e.getMessage());
        }
    }

    @Test(dependsOnMethods = "setCustomPeriod")
    public void offQuickStat(){
        try{
            logger.info("Offing Quick Stat");
            otherElements.offQuickQtat();
        }
        catch (Exception e){
            logger.error("Offing Quick Stat failed: "+e.getMessage());
        }
    }
    @Test(dependsOnMethods = "offQuickStat")
    public void setDate(){
        try {
            logger.info("Confirming setted period");
            otherElements.clickApplyButton2();
        }
        catch(Exception e){
            logger.error("Confirming setted period failed: "+e.getMessage());
        }
    }

    @Test(dependsOnMethods = "setDate")
    public void checkingCPC() throws InterruptedException{
        try {
            Thread.sleep(5000);
            logger.info("Getting costs");
            getStats.getCheckingCosts();

            logger.info("Converting array with " + vars.CheckCost);
            manipulation.stringToDouble();
            logger.info("Converting successful, current value is " + vars.checkCost);

            logger.info("Getting clicks");
            getStats.getClicks();

            logger.info("Converting array with " + vars.CheckCost);
            manipulation.getSometoDouble();
            logger.info("Converting successful, current value is " + vars.valOfClicks);
            calculate.valueOFcpc();
            renew.renewVal();
            logger.info("Getting CPC");
            getStats.getCheckingCPC();
            logger.info("CPC Getted");
            manipulation.stringToDouble();
            Thread.sleep(3000);
            manipulation.checkingDecimal();
            checkingParam.checkingVal();

        }
        catch(Exception e){
            logger.error("Checking CPC failed: "+e.getMessage());
        }
        catch(AssertionError e){
            logger.error("Error assertion: "+e.getMessage());
        }
    }

    @Test(dependsOnMethods = "checkingCPC")
    public void checkingProfit(){
        try {
            logger.info("Checking of Profit value...");
            getStats.getRevenue();
            manipulation.stringToDouble();
            renew.renewVar();
            logger.info("Checking cost");
            getStats.getCheckingCosts();
            logger.info("Cost checked");
            logger.info("manipulating");
            manipulation.stringToDouble();
            logger.info("manipulating finished");
            getStats.getProfit();
            calculate.valOfProfit();
            renew.renewVal();
            manipulation.stringToDouble();
            manipulation.checkingDecimal();
            checkingParam.checkingVal();
        }
        catch(Exception e){
            logger.error("Sometring went wrong: "+e.getMessage());
        }
    }

    @Test(dependsOnMethods = "checkingProfit")
    public void checkingCPT() throws IOException {
        try {
            logger.info("getting transaction");
            getStats.getTransaction();
            logger.info("transaction getted");
            manipulation.getSometoDouble();
            if (vars.valOfClicks > 0) {
                logger.info("getting cost");
                getStats.getCheckingCosts();
                logger.info("cost getted");
                manipulation.stringToDouble();
                calculate.valOfCPT();
                manipulation.checkingDecimal();
                renew.renewVal();
                getStats.getCPT();
                manipulation.stringToDouble();
                manipulation.checkingDecimal();
                checkingParam.checkingVal();
            }else
            {
                logger.info("Transaction less than 1, continue with next test");
                checkCPA();
            }
        }
        catch(Exception e){
                logger.error("Error checking CPT: " + e.getMessage());
            }

    }

    @Test(dependsOnMethods = "checkingCPT")
    public void checkCPA() throws IOException {
        try {
            getStats.getConversionRate();
            manipulation.getSometoDouble();
            getStats.getCheckingCosts();
            manipulation.stringToDouble();
            renew.renewVar();
            calculate.valOfCPA();
            manipulation.checkingDecimal();
            renew.renewVal();
            getStats.costPeraction();
            manipulation.stringToDouble();
            manipulation.checkingDecimal();
            checkingParam.checkingVal();
        }
        catch (Exception e){
            logger.error("Checking CPA failed: "+e.getMessage());
        }
    }

    @Test(dependsOnMethods = "checkCPA")
    public void checkEPC() throws IOException {
        try {
            getStats.getRevenue();
            manipulation.stringToDouble();
            renew.renewVar();
            getStats.getClicks();
            manipulation.getSometoDouble();
            calculate.valueOFcpc();
            renew.renewVal();
            getStats.getEPC();
            manipulation.stringToDouble();
            manipulation.checkingDecimal();
            checkingParam.checkingVal();
        }
        catch(Exception e){
            logger.error("Checking EPC failed: "+e.getMessage());
        }
    }

    @Test(dependsOnMethods = "checkEPC")
    public void checkTR() throws IOException {
        try {
            getStats.getTransaction();
            manipulation.getSometoDouble();
            if (vars.valOfClicks > 0){
                renew.renewVar2();
                getStats.getClicks();
                manipulation.getSometoDouble();
                calculate.valOfTR();
                renew.renewVal();
                getStats.getTR();
                manipulation.stringToDouble();
                manipulation.checkingDecimal();
                checkingParam.checkingVal();
           }
            else{
                logger.info("Transaction rate is less then 1, continue with next test");
                checkCR();
            }
        }
        catch(Exception e){
            logger.error("Checking TR failed: "+e.getMessage());
        }
    }

    @Test(dependsOnMethods = "checkTR")
    public void checkCR() throws IOException {
        try {
            getStats.getConversionRate();
            manipulation.getSometoDouble();
            if (vars.valOfClicks > 0) {
                renew.renewVar2();
                getStats.getClicks();
                manipulation.getSometoDouble();
                calculate.valOfTR();
                renew.renewVal();
                getStats.getCRpercent();
                manipulation.stringToDouble();
                manipulation.checkingDecimal();
                checkingParam.checkingVal();
            }
            else{
                logger.info("Value of conversion is less then 1, continue with next test");
                checkROI();

            }
        }
        catch(Exception e){
            logger.error("Checking CR failed: "+e.getMessage());

        }
        catch(ComparisonFailure e){
            logger.error("Values doesn't match: "+e.getMessage());
        }
    }

    @Test(dependsOnMethods = "checkCR")
    public void checkROI() throws IOException {
        try {
            getStats.getCheckingCosts();
            manipulation.stringToDouble();
            renew.renevVar4();
            getStats.getProfit();
            manipulation.stringToDouble();
            renew.renewVar();
            getStats.getRoi();
            calculate.valOfTR();
            renew.renewVal();
            manipulation.stringToDouble();

            manipulation.checkingDecimal();
            checkingParam.checkingVal();
        }
        catch(Exception e){
            logger.error("Checking ROI failed: "+e.getMessage());
        }
    }

    @AfterClass
    //@Test(dependsOnMethods = "checkROI")
     private final void closingDriver(){
        driver.quit();
    }

}







