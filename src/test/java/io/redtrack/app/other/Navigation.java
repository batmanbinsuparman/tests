package io.redtrack.app.other;


//import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





public class Navigation {

    boolean s;

    public Navigation(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;


    @FindBy(linkText = "Dashboard")
    public WebElement PageDashboard;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/span[1]")
    public WebElement PageCampaigns;

    @FindBy(linkText = "Offers")
    public  WebElement PageOffers;

    @FindBy (linkText = "Landers")
    public WebElement PageLanders;

    @FindBy(linkText = "Networks")
    public WebElement PageNetworks;


    @FindBy(linkText = "Traffic sources")
    //@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[6]/a[1]/span[1]")
    public WebElement trafficSources;

    //@FindBy(linkText = "Domains")
    @FindBy(xpath = "//span[contains(text(),'Domains')]")
    public WebElement PageDomains;

    @FindBy(linkText = "Clicks")
    public WebElement PageClicks;

    @FindBy(linkText = "Conversions")
    public WebElement PageConversions;

    @FindBy(linkText = "Postbacks")
    public WebElement PagePostbacks;

    @FindBy(linkText = "Conversion Tracking")
    public WebElement PageConvTrack;

    @FindBy(linkText = "Bot blacklist")
    public WebElement PageBotBlack;

    @FindBy(linkText = "Cloaking")
    public WebElement PageCloaking;

    @FindBy(linkText = "Default fallback-URL")
    public WebElement PageDefaultFallbackURL;

    @FindBy(linkText = "Filter presets")
    public WebElement PageFilterPresets;

    @FindBy(linkText = "API Documentation")
    public WebElement PageAPI_Documentation;

    @FindBy(xpath = "//span[contains(text(),'Campaigns')]")
    public WebElement camppage;
    public void campPage (){
        camppage.click();
    }

    /* Dropdown elements */

    @FindBy(linkText = "Tools")
    public WebElement DropDownTools;

    @FindBy(id = "user-nav-dropdown")
    public WebElement DropDownLogs;
    /* ---------------- */




    @FindBy(className = "icon-switch")
    public WebElement LogoutButton;









    public void SourcePage(){
        trafficSources.click();
    }

    public void pageCampaigns(){
        PageCampaigns.click();
    }

    public void pageDashboard(){
        PageDashboard.click();
    }

    public void pageOffers(){
        PageOffers.click();
    }

    public void pageLanders(){
        PageLanders.click();
    }

    public void pageNetworks(){
        PageNetworks.click();
    }

    public void pageDomains(){
        PageDomains.click();
    }

    public void pageClicks(){
        PageClicks.click();
    }

    public void pageConversions(){
        PageConversions.click();
    }

    public void pagePostbacks(){
        PagePostbacks.click();
    }

    public void pageConvTrack(){
        PageConvTrack.click();
    }

    public void pageBotBlack(){
        PageBotBlack.click();
    }

    public void pageCloaking(){
        PageCloaking.click();
    }

    public void pageDefaultFallbackURL(){
        PageDefaultFallbackURL.click();
    }

    public void pageFilterPresets(){
        PageFilterPresets.click();
    }

    public void pageAPI_Documentation(){
        PageAPI_Documentation.click();
    }



    /* Dropdown menu */


    public void dropDownLogs(){
        DropDownLogs.click();
    }

    public void dropDownTools(){
        DropDownTools.click();
    }

    /* -------------- */





    public void logoutButton(){
        LogoutButton.click();
    }


}