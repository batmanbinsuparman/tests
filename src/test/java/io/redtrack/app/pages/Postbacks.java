package io.redtrack.app.pages;
import org.openqa.selenium.WebDriver;
import io.redtrack.app.variable.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;




public class Postbacks {

    public Postbacks(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static Variables vars;

    public WebDriver driver;

    public void findConve(){
        driver.findElement(By.xpath("//div[contains(text(),'"+vars.output+"')]"));
    }

}
