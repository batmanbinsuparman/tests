package io.redtrack.app.other;

import io.redtrack.app.pages.Campaigns;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import io.redtrack.app.variable.Variables;

import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Clicks {

    public Clicks(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static Campaigns campaigns;
    public static Variables vars;

    public WebDriver driver;

    public void createOneClick() throws IOException, UnsupportedFlavorException {
        //driver.get(campaigns.clipboard.getData(campaigns.flavor));

        this.driver.get(campaigns.clickURL);
    }

    public String s;


    public void createOneConversion(){
        this.driver.get(vars.domainurl2+"/postback?"+vars.parseURL[1]+"&sum=10");
    }


    public void createOneConversion2(){
        this.driver.get(vars.domainurl2+"/postback?"+vars.parseURL[1]+"&sum=15");
    }

}
