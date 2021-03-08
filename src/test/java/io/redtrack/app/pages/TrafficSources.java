package io.redtrack.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TrafficSources {

    public TrafficSources(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public WebDriver driver;


    //@FindBy (linkText = "New")






}
