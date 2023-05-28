Feature:US2001 Zero.webappsecurity.com Testi


Scenario: DropDownTesti
Given Kullanici "zeroURL" sayfasına gider
Then Sign in tusuna basar
Then Login kutusuna "zeroUsername" yazar
Then Password kutusuna "zeroPassword" yazar
Then Sign in tusuna basin
Then Geri sekmesine basar
Then Online Bankin buttona tıklar
Then Online banking menusu icinde Pay Bills sayfasina gider
Then Purchase Foreign Currency tusuna basar
Then Currency drop down menusunden Eurozone’u secer
Then zeroSecilenCurrencyValue secildigini test eder
Then Soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
Then Sayfayi kapatir
