package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.Guru99Page;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuruStepdefinitions {

    List<String> sirketListesi = new ArrayList<>();//obje olarak oluşturmamızın nedeni başka bir
                                                  //methodda kullanılacağı için
    Guru99Page guru99Page = new Guru99Page();

    @Given("guru99 sayfasinda Cookies kabul eder")
    public void guru99_sayfasinda_cookies_kabul_eder() {
        Driver.getDriver().switchTo().frame(guru99Page.cookiesIFrame);
        //cookies'ı kabul etmeden önce iframe (ayfıreym) geçiş yaparız
        guru99Page.acceptCookies.click();
    }

    @Then("Company listesini consola yazdirir")
    public void company_listesini_consola_yazdirir() {

        sirketListesi = ReusableMethods.stringListeCevir(guru99Page.sirketElementList);
        System.out.println(sirketListesi);
        //Guru99Page'deki WebElementlerden oluşan bir List'i burada direk çağırarak yazdıramayız
        //yazdırabilmek için ReusableMethod'dan ReusableMethods.stringListeCevir() methodu
        //kullanılarak List, string bir listeye çevrilerek kaydedilir ve yazdırılır
        //for loop kullanmaktan daha kolay ve kısa bir yöntem

    }


    @And("listede {string} oldugunu test eder")
    public void listedeOldugunuTestEder(String istenenSirket) {
        Assert.assertTrue(sirketListesi.contains(istenenSirket));
    }

    @Then("tum sayfa Screenshot alir")
    public void tumSayfaScreenshotAlir() throws IOException {
        ReusableMethods.getScreenshot("Guru99");
        //fotoğraflama ReusableMethods.getScreenshot() methodu kullanılarak da yapılabilir
    }

    @And("{string} Prev.Close degerini yazdirir")
    public void prevCloseDegeriniYazdirir(String istenenSirket) {

        //   //tbody/tr[9]/td[3]
        //   sirket ismi //tbody/tr[?]/td[1] locater'i ile bulunup
        //   previous deger  //tbody/tr[?]/td[3] locater'i ile elde edilecek

        // satir sayisini bulalim

        int satirSayisi= guru99Page.satirlarListesi.size();

        for (int i = 1; i <satirSayisi ; i++) {
            String dinamikXpath= "//tbody/tr["+ i +"]/td[1]";//dinamik
            String satirdakiSirketIsmi=
                    Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText();//satırdaki
            if (satirdakiSirketIsmi.equalsIgnoreCase(istenenSirket)){               //şirket ismi
                dinamikXpath ="//tbody/tr["+ i +"]/td[3] ";
                String istenenSirketPreValue=
                        Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText();
                System.out.println(istenenSirketPreValue);
            }
        }
    }


    @Then("Prev.Close degerinin {string} oldugunu test eder")
    public void prevCloseDegerininOldugunuTestEder(String prevValue) {
    }
}
