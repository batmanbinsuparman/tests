package io.redtrack.app.pages;

import io.redtrack.app.other.OtherElements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
//import io.redtrack.app.other.Navigation;


public class Campaigns {

    public Campaigns(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;
    public static OtherElements otherElements;

    public static String clickURL;
    public static String str;


    //public Navigation navigation;


    @FindBy(xpath = "//div[contains(text(),'#03 Conversion w/o LP')]")
    public WebElement chooseCapm;

    public void chosseCamp() {
        chooseCapm.click();
    }

    @FindBy(xpath = "//div[contains(text(),'Default domain')]")
    public WebElement domainsListCamp;

    public void domainsListCamp() {
        domainsListCamp.click();

        //domainsListCamp.sendKeys(otherElements.rand);
        //domainsListCamp.sendKeys(Keys.ENTER);
        //domainsListCamp.click();
    }

    @FindBy(xpath = "//div[contains(text(),'Default domain')]")
    public WebElement chooseDomain;

    public void chooseDomain() {

    }


    public void chooseDomainCamp() {
        //List<WebElement> d = new ArrayList<>();
        //d = driver.findElements(By.className("Select-option"));
        //System.out.println(d.size());
        //WebElement searchTextBox= driver.findElement(By.className("Select-menu-outer"));
        WebElement searchTextBox = driver.findElement(By.className("Select-option"));
        //String a = searchTextBox.getAttribute("innerHTML");
        //System.out.println(a);
        searchTextBox.click();
    }


    @FindBy(xpath = "//div[@class='btn-group']//button[1]")
    public WebElement saveCamp;

    public void saveCamp() {
        saveCamp.click();
    }


    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[3]/div[1]/ul[1]/li[1]/a[1]/i[1]")
    public WebElement editCamp;

    public void editCamp() {
        editCamp.click();
    }

    @FindBy(xpath = "//div[8]//div[1]//span[1]//span[1]//button[1]//i[1]")
    public WebElement getClickURL;

    public void getClickURL() {
        getClickURL.click();
        //System.out.println(clickURL);
    }


    //Херня, для работы с буффером, не трогать




    public static DataFlavor flavor;
    public  Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    public void saveBuffer() throws IOException, UnsupportedFlavorException {

        try {

            flavor = DataFlavor.stringFlavor;
            clickURL = clipboard.getData(flavor).toString();
            //System.out.println(clickURL);

        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        } catch (UnsupportedFlavorException u) {
            System.out.println("Something went wrong: " + u.getMessage());
        }

    }



    //public static void setClip() {

       // StringSelection clickURL = new StringSelection(str);
       // Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clickURL, null);
   // }


    //Херня закончилась


//}


    public void getClipboard() {
        Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);

        try {
            if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                clickURL = (String) t.getTransferData(DataFlavor.stringFlavor);
            }
        }
        catch (UnsupportedFlavorException e) {
        }
        catch (IOException e) {
        }

    }

    // This method writes a string to the system clipboard.
// otherwise it returns null.
    public void setClipboard() {
        StringSelection ss = new StringSelection(str);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    }
}