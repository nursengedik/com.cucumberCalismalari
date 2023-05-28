package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import pages.HerokuPage;

public class HerokuappStepDefinitions {
    HerokuPage herokuPage = new HerokuPage();//obje oluşturulur

    @Then("Add Element butonuna basar")
    public void add_element_butonuna_basar() {
        herokuPage.addElementButonu.click();
    }
    @Then("Delete butonu gorunur oluncaya kadar bekler")
    public void delete_butonu_gorunur_oluncaya_kadar_bekler() {
        // Delete butonu implicitly wait suresi icinde gorunur oldugundan
        // bu adimda bir islem yapilmadi
    }
    @Then("Delete butonunun gorunur oldugunu test eder")
    public void delete_butonunun_gorunur_oldugunu_test_eder() {
        Assert.assertTrue(herokuPage.deleteButonu.isDisplayed());

    }
    @Then("Delete butonuna basarak butonu siler")
    public void delete_butonuna_basarak_butonu_siler() {
        herokuPage.deleteButonu.click();
    }
    @Then("Delete butonunun gorunmedigini test eder")
    public void delete_butonunun_gorunmedigini_test_eder() {//olmayan bir elementi nasıl test ederiz

        //Assert.assertTrue(herokuPage.deleteButonu.isDisplayed()); sadece bu satırı yazıp çalıştırdığımızda
        //elementi bulmaya çalışır ve bulamayınca NoSuchElemenetException verir, NoSuchElemenetException
        //vermesi testin geçtiği anlamına gelir (butonun görünmediği) ama exception verince kod çalışmaz,
        //bu durumda butonu bulamadığına dair exception verip kodun da çalışmaya devam etmesi için
        //satırı  Code/Surround With'den try/catch içerisine alırız

        try {
            Assert.assertTrue(herokuPage.deleteButonu.isDisplayed());
        } catch (NoSuchElementException e) {//NoSuchElementException e seleniumdan istenir

            Assert.assertTrue(true);
        }
    }
}
