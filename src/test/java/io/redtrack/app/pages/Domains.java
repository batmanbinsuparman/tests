package io.redtrack.app.pages;


import io.redtrack.app.variable.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.redtrack.app.other.OtherElements;

import java.util.concurrent.TimeUnit;

//import java.util.Random;

public class Domains {

    public Domains(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String domainName;

    public static OtherElements otherElements;
    public static Variables vars;


    public WebDriver driver;

    @FindBy(name = "url")
    public WebElement inpURL;
    public void inputURL(){
        inpURL.clear();
        inpURL.sendKeys(vars.domainURL);
    }

    //@FindBy(name = {})
    //public WebElement addDomain;

    public void findCreatedDomain (){
        WebElement domain;
        domain = driver.findElement(By.xpath("//div[contains(text(),'"+vars.domainURL+"')]"));
        domain.click();

    }

    public void trySaveDomain(){
        //driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary']")).clear();
        //driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary']")).getText();
        driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary']")).click();
        //driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[6]/div[1]/button[1]")).click();
    }


    @FindBy(xpath = "//button[@class='btn btn-sm btn-default btn btn-default']")
    public WebElement delete;
    public void deleteDomain(){
        delete.click();
        this.driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        this.driver.switchTo().alert().accept();
    }



}
