package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HerokuPage {
    public HerokuPage(){//bir page sayfası oluşturulacağı zaman önce constructor oluşturulur
        PageFactory.initElements(Driver.getDriver(),this);//ve driver'ımıza tanıtmalıyız
    }

    @FindBy(xpath = "//*[text()='Add Element']")
    public WebElement addElementButonu;

    @FindBy(xpath = "//*[text()='Delete']")
    public WebElement deleteButonu;
}
