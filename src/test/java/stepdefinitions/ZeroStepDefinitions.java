package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.ZeroPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeroStepDefinitions{

    ZeroPage zeroPage = new ZeroPage();

    @Given("Kullanici zero anasayfaya gider")
    public void kullanici_zero_anasayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("zeroURL"));
    }

    @Then("Sign in tusuna basar")
    public void signInTusunaBasar() {
        zeroPage.signInButton.click();
    }


    @Then("Login kutusuna {string} yazar")
    public void loginKutusunaYazar(String gecerliUserName) {
        zeroPage.logInButton.sendKeys(ConfigReader.getProperty(gecerliUserName));
    }


    @Then("Password kutusuna {string} yazar")
    public void passwordKutusunaYazar(String gecerliPassWord) {
        zeroPage.passWord.sendKeys(ConfigReader.getProperty(gecerliPassWord));
    }


    @Then("Sign in tusuna basin")
    public void signInTusunaBasin() {
        zeroPage.sinInButton2.click();
    }

    @Then("Geri sekmesine basar")
    public void geriSekmesineBasar() {
        Driver.getDriver().navigate().back();

    }

    @Then("Online Bankin buttona tıklar")
    public void onlineBankinButtonaTıklar() {
        zeroPage.onlineBankingButton.click();
    }

    @Then("Online banking menusu icinde Pay Bills sayfasina gider")
    public void onlineBankingMenusuIcindePayBillsSayfasinaGider() {
        zeroPage.payBill.click();

    }

    @Then("Purchase Foreign Currency tusuna basar")
    public void purchaseForeignCurrencyTusunaBasar() {
        zeroPage.PurchaseText.click();
    }

    @Then("Currency drop down menusunden Eurozone’u secer")
    public void currencyDropDownMenusundenEurozoneUSecer() {
        zeroPage.currencyDropdown.click();
        Select select = new Select(zeroPage.currencyDropdown);
        select.selectByValue(ConfigReader.getProperty("zeroSecilenCurrencyValue"));
    }


    @Then("zeroSecilenCurrencyValue secildigini test eder")
    public void zerosecilencurrencyvalueSecildiginiTestEder() {
        Assert.assertTrue(zeroPage.selectCurrencyText.isDisplayed());
    }

    @Then("Soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin")
    public void softAssertKullanarakDropDownListesininSuSecenekleriOldugunuTestEdin() {


        List<String> expectedList =new ArrayList<>(Arrays.asList("Select One", "Australia (dollar)",
                "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)",
                "Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)",
                "Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)",
                "Sweden (krona)","Singapore (dollar)","Thailand (baht)"));


        List<String> actualDropDownStringList=new ArrayList<>();
        for (WebElement eachWebElemnt:zeroPage.dropdownList) {
            actualDropDownStringList.add(eachWebElemnt.getText());
        }
        System.out.println(actualDropDownStringList.size());


        Assert.assertEquals(expectedList,actualDropDownStringList);
    }



}
