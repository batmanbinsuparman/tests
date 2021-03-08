package io.redtrack.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class Dashboard {

    public Dashboard(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(className = "btn-primary btn btn-sm btn-default")
    private WebElement DashboardApply;

    @FindBy (className = "pull-right btn btn-xs btn-default")
    private WebElement DashboardColumns;
}