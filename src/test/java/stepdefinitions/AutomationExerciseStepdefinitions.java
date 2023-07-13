package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.AutoExerPage;
import utilities.Driver;

public class AutomationExerciseStepdefinitions {


    AutoExerPage autoExerPage = new AutoExerPage();
    Faker faker = new Faker();
    String emailAdress;//email'ı kaydetmek istiyorsak class levele'de obje oluşturulur
    String firstName;//tekrar lazım olduğu için kaydedilir
    Actions actions;//class levelde oluşturulan objelerde sorun cıkabildiği için burada obje
    //tanımlanır, methodun içinde de değer atanır (36.satır)

    @Given("user sign up linkine tiklar")
    public void user_sign_up_linkine_tiklar() {
        autoExerPage.signUpLinki.click();
    }
    //page sayfasındaki locator (lokeytlere) ulaşabilmek için calass levelde AutoExerPage'den
    //obje oluşturulur

    @Given("signUp butonuna basar")
    public void sign_up_butonuna_basar() {
        autoExerPage.signUpButonu.click();
    }
    @Given("user kisisel bilgilerini ve iletisim bilgilerini girer")
    public void user_kisisel_bilgilerini_ve_iletisim_bilgilerini_girer() throws InterruptedException {
        actions = new Actions(Driver.getDriver());

        actions.click(autoExerPage.mrButonu)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())//şifreyi kaydetmeye gerek yok
                .sendKeys(Keys.TAB)
                .sendKeys("7")//day
                .sendKeys(Keys.TAB)
                .sendKeys("May")//month
                .sendKeys(Keys.TAB)
                .sendKeys("2000").perform();//year
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(firstName)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())//kaydetmediğimiz için faker üzerinden gönderiyoruz
                .sendKeys(Keys.TAB)
                .sendKeys(faker.company().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("United States")
                .sendKeys(Keys.TAB)
                .sendKeys("Texas")
                .sendKeys(Keys.TAB)
                .sendKeys("Dallas")
                .sendKeys(Keys.TAB)
                .sendKeys("07100")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .perform();
    }
    @Given("user Create Account butonuna basar")
    public void user_create_account_butonuna_basar() {

        autoExerPage.createAccountButonu.click();
    }

    @Then("hesap olustugunu test edin")
    public void hesap_olustugunu_test_edin() {
        Assert.assertTrue(autoExerPage.accountCreatedYaziElementi.isDisplayed());
    }

    @And("user Create an account bolumune name ve email adresi girer")
    public void userCreateAnAccountBolumuneNameVeEmailAdresiGirer() {
        firstName=faker.name().firstName();
        autoExerPage.signUpNameKutusu.sendKeys(firstName);
        emailAdress=faker.internet().emailAddress();//email'ı atama yaparak kaydettik
        autoExerPage.signUpEmailKutusu.sendKeys(emailAdress);//burada da göndermiş olduk
    }

    @Then("Login to your account bolumunde email kutusuna @isareti olmayan email adresi yazar")
    public void login_to_your_account_bolumunde_email_kutusuna_isareti_olmayan_email_adresi_yazar() {
        autoExerPage.loginEmailKutusu.sendKeys("ByeByeWorld");
    }
    @Then("password kutusuna sifre yazar ve enter'a tiklar")
    public void password_kutusuna_sifre_yazar_ve_enter_a_tiklar() {
        autoExerPage.loginPasswordKutusu.sendKeys("SeeYouSoon" + Keys.ENTER);
    }

    @Then("sisteme giris yapilamadigini test eder")
    public void sistemeGirisYapilamadiginiTestEder() {
        Assert.assertTrue(autoExerPage.loginPasswordKutusu.isEnabled());
    }
}
