package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//JUnit'ten geliyor
@CucumberOptions(//feature dosyaları ile stepdefinitions class'larını birbirine bağlar

        plugin = {"html:target/cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"
        },
        features = "src/test/resources/features",//feature dosyalarının dosya yolu (feature sağ tuş ve copy path)
        glue = "stepdefinitions",//feature dosyalarının bağlı olduğu (çalıştıracak olan) kodlar nerede ise
                                //onun ismi yazılır
        tags = "@regression and @smoke",//hangi notasyondaki testlerin çalışmasını istiyorsak tags'a onu yazarız
                                       //sadece @smoke veya @regression da yazabiliriz
        dryRun = false
)

public class Runner {//Runner' ı dryRun=false iken çalıştırırız

    /*
        Cucumber'da Runner Class'i istedigimiz testleri calistirmak
        ve her calistirilan test icin rapor hazirlamak amaciyla kullanilir

        Runner Class'i bos bir Class'dir

        Belirtilen bu isleri
        class icerisindeki kodlar degil
        class deklarasyonunda kullanacagimiz Notasyonlar halleder

        @RunWith notasyonu framework'umuze JUnit yuklememizin sebebidir
                 ve Runner Class'inin cucumber ile calismasini saglar

        @CucumberOptions ise framework'umuzde gerekli ayarlari yapar

        features : feature dosyalarimizin bulundugu konumu gosterir
                   dikkat edilirse tek tek feature dosyalarini degil
                   tum feature dosyalarini iceren klasorun yolunu yaziyoruz
        glue : feature dosyalari ile bagli olan
               Java method'larinin yerini gosterir
               Burada da tek tek class'lari degil,
               tum class'lari iceren package'in adresini yazariz
               boylece ilgili step hangi class altinda olursa olsun
               cucumber bulup calistirir
        tags : calistirilacak Feature veya Scenerio(lari) isaretlemek icin kullanilir
               Cucumber Runner class'i calistirildiginda
               tum feature dosyalarini gozden gecirir ve
               Runner class'inda belirtilen tag'a sahip
               TUM Fature ve Scenario(lari) calistirir

               Eger birden fazla tag'i kontrol ederek calistirmasini istersek
               "@regression or @smoke" veya "@regression and @smoke" gibi yazabiliriz

       dryRun : Bir feature dosyasini ilk defa yazdigimizda
                step'lerden bazilari daha once var oldugundan BEYAZ
                bazilari ise ilk defa kullanacagimiz icin SARI olur

                Bu Feature dosyasini direk calistirmak istersek
                Bastan baslayarak beyaz olan adimlari calistirir
                Ilk sari adima geldiginde, exception firlatip
                calistirmayi denedigi ilk sari satir
                ve geriye kalan sari satirlarin
                eksik steplerini bize yazdirir

                Amacimiz Feature dosyasini calistirmak degil,
                sadece eksik step'lere ait kodlari olusturmak ise
                (yani beyaz olan satırları çalıştırmadan
                sarı renkle yazılı satırların adımlarını tamamlamak için)
                Runner class'inda dryRun = true yapip
                Runner class'ini calistiririz

                dryRun'ı sadece eksik adımları tamamlamak için, kontrol
                etmek için true yaparız

                dryRun= true dedigimizde
                Cucumber testleri calistirmaz, sadece eksik adim var mi diye kontrol eder
                eksik adim yoksa Test PASSED yazar (yani test çalışmadı ama eksik adım da yok)

                dryRun = false default degerdir
                ve Testleri normal olarak calistirmamizi saglar

     */
}
