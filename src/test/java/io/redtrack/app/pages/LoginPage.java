package io.redtrack.app.pages;

import io.redtrack.app.tests.RedtrackStatsTests;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.redtrack.app.variable.Variables;


public class LoginPage {

    public static Variables vars;

    public LoginPage (WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;


    }
    public static final Logger logger = Logger.getLogger(RedtrackStatsTests.class.getSimpleName());
    public WebDriver driver;

    @FindBy(name = "login")
   public  WebElement loginField;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(xpath = ".//*[normalize-space(text()) and normalize-space(.)='Your credentials'][1]/following::button[1]")
    public WebElement submitButton;

    @FindBy (xpath = "//body[@class='no-transitions navbar-top sidebar-xs']/div[@class='main-container']/div/div/div[@class='navbar navbar-inverse navbar-fixed-top']/div[@class='navbar-collapse collapse']/div[@class='navbar-right']/ul[@id='nabvar-top-right']/li[5]/a[1]")
    public WebElement logoutButton;
    public void logout(){
        logoutButton.click();

    }


    public void inputLogin (String login){
        try {
            loginField.sendKeys(login);
        }
        catch(Throwable e){
            logger.error("Error logining"+ e);
        }
    }

    public void inputPassword (String password){
        passwordField.sendKeys(password);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public void Login(){
        inputLogin(vars.login2);
        inputPassword(vars.password1);
        clickSubmitButton();
    }

}