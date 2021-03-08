package io.redtrack.app.other;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Date;
//import java.lang.Math;
import java.lang.String;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import io.redtrack.app.variable.Variables;

import io.redtrack.app.messages.Mess;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OtherElements {


    //public Randomizzer randomizer;
    //public Math math;
    public Date date;
    //public String rand;
    public OtherElements(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public static Variables vars;
    public WebDriver driver;

    public static String rand;

    /* Apply buttonuttons in Logs page Clicks && Conversions */

    @FindBy(xpath = "//div[@class='alert alert-danger alert-styled-left alert-bordered']")
    public WebElement InvalidCred;
    public String getInvalidCred(){
        String invalidCred = InvalidCred.getText();
        return invalidCred;
    }

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ol[1]/li[1]/a[1]")
    public WebElement CheckOpenedPage;
    public String getCheckOpenedPage(){
        String checkOpenedPage = CheckOpenedPage.getText();
        return checkOpenedPage;
    }

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ol[1]/li[1]/a[1]")
    public WebElement CheckOpenedPage2;
    public String getCheckOpenegPage2(){
        String checkOpenedPage2 = CheckOpenedPage2.getText();
        return checkOpenedPage2;
    }

    @FindBy(xpath = ".//*[normalize-space(text()) and normalize-space(.)='E-mail us support@redtrack.io'][1]/following::h1[1]")
    public WebElement CheckOpenedPage3;
    public String getCheckOpenedPage3(){
        String checkOpenedPage3 = CheckOpenedPage3.getText();
        return checkOpenedPage3;
    }

    @FindBy(linkText = "Bot Blacklist")
    public WebElement botBlacklist;
    public String getBotBlacklist(){
        String checkBotBlacklist = botBlacklist.getText();
        return checkBotBlacklist;
    }

    @FindBy(xpath = ".//*[normalize-space(text()) and normalize-space(.)='E-mail us support@redtrack.io'][1]/following::a[2]")
    public WebElement CheckOpenedPage0;
    public String getOpenedPage0(){
        String checkOpenedPage0 = CheckOpenedPage0.getText();
        return checkOpenedPage0;
    }

    @FindBy (id = "introduction")
    public WebElement CheckApiPage;
    public String getOpenedApiPage(){
        String checkOpenedApiPage = CheckApiPage.getText();
        return checkOpenedApiPage;
    }

    @FindBy(id = "user-nav-dropdown")
    public WebElement userProfile;
    public String getUserName(){
        String userName = userProfile.getText();
        vars.CheckParam = userName;
        return userName;
    }

    @FindBy(xpath = ".//*[normalize-space(text()) and normalize-space(.)='E-mail us support@redtrack.io'][1]/following::h5[1]")
    public WebElement CheckOpenedPage4;
    public String getOpenedPage4(){
        String checkOpenedPage4 = CheckOpenedPage4.getText();
        return checkOpenedPage4;
    }


    @FindBy(className = "btn btn-sm btn-primary")
    public WebElement ApplyClickConv;

    /* Apply button in Logs page Postbacks */

    @FindBy(className = "btn btn-sm btn-primary btn-block")
    public WebElement ApplyPostb;

    /* Period all pages */

    @FindBy(className = "text-left-forse overflow-hidden btn btn-sm btn-default btn-block")
    public WebElement ReportPeriod;

    /* Columns for all pages != Dashboard */

    @FindBy(className = "btn btn-xs btn-default")
    public WebElement Columns;

    @FindBy (linkText = "New")
    public WebElement createNew;
    public void CreateNew(){
        createNew.click();
    }

    @FindBy (linkText = "Add")
    public WebElement addNew;
    public void AddNew(){
        addNew.click();
    }

    @FindBy (name = "title")
    public WebElement TitleTitle;
    //public String randsourceTitle(){
       // rand = randomizer.randText();
     //   return randsourceTitle();
   // }

    @FindBy(xpath = "/html[1]/body[1]/div[4]/div[3]/div[2]/table[1]/tbody[1]/tr[5]/td[4]")
    public WebElement LastDate;
    public void setLastDate(){
        LastDate.click();
    }

    @FindBy(xpath = "//button[@class='btn btn-sm btn-primary btn-block']")
    public WebElement ApplyButton2;
    public void clickApplyButton2(){
        ApplyButton2.click();
    }

    @FindBy(xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/button[1]")
    public WebElement ApplyButton1;
    public void clickApplyButton1(){
        ApplyButton1.click();
    }

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='This month'])[1]/following::li[1]")
    public WebElement CustomRange;
    public void customRange(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        CustomRange.click();
    }

    public void setFirstDate(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        FirstDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[7]")));
        FirstDate.click();
    }

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[2]/table[1]/thead[1]/tr[1]/th[1]/i[1]")
    public WebElement BackwardCalendar;

    public void backWardCalendar(){
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        BackwardCalendar.click();
    }

    @FindBy(xpath = "//button[@class='text-left-force overflow-hidden btn btn-sm btn-default btn-block']")
    public WebElement Period;

    public String checkingFirswtDate(){
        String firstdate = FirstDate.getText();
        System.out.println(firstdate);
        return firstdate;
    }

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/button[1]")
    public WebElement FirstDate;
    public void setPeriod(){
        Period.click();
    }

    public void TitleRand(){
        //System.out.println("Clearing Source name");
        TitleTitle.clear();
        //System.out.println("Sourcename Clear");
        //System.out.println("Send random keys to Source name");
        rand = Integer.toString(new Random().nextInt(254335363)+987765352);
        TitleTitle.sendKeys(rand);
    }


    @FindBy(xpath = "//span[@class='switchery switchery-default']")
    public WebElement QuickStat;
    public void offQuickQtat(){
        QuickStat.click();
    }

    /* Navigation menu */

    @FindBy (linkText = "Edit")
    public WebElement editCamp;
    public void editCamp(){
        editCamp.click();
    }




}
