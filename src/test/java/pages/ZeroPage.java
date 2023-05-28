package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ZeroPage {

    public ZeroPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="signin_button")
    public WebElement signInButton;

    @FindBy(id = "user_login")
    public WebElement logInButton;

    @FindBy(id="user_password")
    public WebElement passWord;

    @FindBy(xpath = "//input[@value='Sign in']")
    public WebElement sinInButton2;

    @FindBy(xpath = "//strong[text()='Online Banking']")
    public WebElement onlineBankingButton;

    @FindBy(id = "pay_bills_link")
    public WebElement payBill;

    @FindBy(xpath = "//a[text()='Purchase Foreign Currency']")
    public WebElement PurchaseText;

    @FindBy(id="pc_currency")
    public WebElement currencyDropdown;

    @FindBy(xpath = "//span[text()='1 euro (EUR) = 1.3862 U.S. dollar (USD)']")
    public WebElement selectCurrencyText;

    @FindBy(xpath = "//select[@name='currency']/option")
    public List<WebElement> dropdownList;

    @FindBy(xpath = "//option[@value='EUR']")
    public WebElement euroElement;


}
