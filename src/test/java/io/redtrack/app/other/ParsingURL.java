package io.redtrack.app.other;
import org.openqa.selenium.WebDriver;
import io.redtrack.app.variable.Variables;
import org.openqa.selenium.support.PageFactory;
import java.util.regex.Pattern;


public class ParsingURL {

    public ParsingURL(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static Variables vars;

    public WebDriver driver;

    public void getCurrentURL(){

        vars.currentURL = driver.getCurrentUrl();
        System.out.println("------- "+vars.currentURL);


    }

    public void parsingURL(){
       vars.parseURL = vars.currentURL.split(Pattern.quote("?"));
       System.out.println("------- "+vars.parseURL[1]);
    }

    public void parsingID(){
        vars.parseURL = vars.currentURL.split("=");
        System.out.println("=============== "+vars.parseURL[1]);
        vars.output = vars.parseURL[1];
        System.out.println("*********** "+vars.output);
    }


}
