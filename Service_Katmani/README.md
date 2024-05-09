Servis, iş katmanındaki (business layer) bileşen yapısını temsil eder.
Şimdi, genellikle entity (varlık) sınıflarımız için ne tür ihtiyaçlara sahip olduğumuza bir göz atalım.
Bu ihtiyaçlar doğrultusunda, bir data sınıfına (entity) ihtiyaç duyulur,
iş katmanına (business layer) ihtiyaç duyulur veya bir kontrolcü katmanına (controller) ihtiyaç duyulmaktadır.
Kontrolcü katmanının yerine API katmanını (API layer) da kullanılabilir.

Normalde, örneğin bir müşteri (customer) entity'si için,
bir iş sınıfına (business class) veya bir kontrolcü sınıfına (controller class) ihtiyacımız vardır.
Ancak, bu yerine API katmanını kullanabiliriz. Örneğin, "CustomerController" yerine "CustomerApi" diyebiliriz.

Biz zaten bu yapıyı hızlı bir şekilde kullanacaksak, veri tipini integer olarak belirtilmektedir.

- public void methodName(int variableName)

Mesela bir kontrolcü (controller) vardı.
Örneğin, "CustomerController" adında bir sınıf yazıyordum.
Bu sınıfa RestController anotasyonunu ekliyordum ve burada bir repository olduğunu belirtiyordum.
Repository'yi belirtmek içinse genellikle "CustomerRepository" diyordum ve burada işlemler gerçekleştiriyordum.

Artık burada işte biraz daha ileri gidiyoruz.
Bu işlemleri sağlayacak bir Business katmanı (business layer) nasıl oluşturacağımıza bir bakalım.
Bu sefer yine bildiğimiz işlemleri yapacağız. Örneğin, "CustomerManager" sınıfını oluşturuyoruz.

Bu sefer, bir "CustomerService" adında bir arayüz (interface) oluşturabiliriz.
Genellikle bu arayüzü, işlemleri gerçekleştireceğimiz yapıya büründürmek için kullanırız.
Bu arayüz içerisinde genellikle işlemleri yazarak, örneğin "GetByID" veya "Save" gibi metodları belirtiriz.

Ardından, "CustomerManager" sınıfını oluşturuyoruz.
Bu sınıfı, "CustomerService" arayüzünü implement eden bir sınıf olarak tanımlıyoruz.
Böylece, bu sınıf içinde gerekli metodları implement etmek zorunda kalıyoruz.

Bu noktada dikkat edilmesi gereken bir diğer şey, bu sınıfın içinde,
işlemlerimizi gerçekleştirmek için gerekli olan diğer bileşenlere nasıl ulaşacağımızdır.
Örneğin, "CustomerRepository" ile iletişim kurmamız gerekiyorsa, bunu sınıfın constructor'ında belirterek yapabiliriz.

Sonuç olarak, bu yapılar arasında iletişimi kurduk.
Artık kontrolcü sınıfından servis sınıfına, oradan da repository sınıfına ulaşabiliyoruz.
Çünkü bu, katmanlı mimari prensiplerine uygun bir yapıdır.

-----------------------------------------------------------------------

Spring'in temel bir kavramı olan "Inversion of Control (IoC)" kavramına bir göz atacağız ve konseptin çalışma mantığını anlamaya çalışacağız.

IoC, nesne yönetimini Spring'e bırakma prensibidir.
Spring içerisinde bir "IoC Container" bulunmaktadır.
Bu container, projemizdeki component'leri, yani controller'ları, servisleri, repository'leri ve
dependency injection uyguladığımız diğer yapıları içine alır ve ihtiyaç duyulduğunda bu nesneleri bize sağlar.

Diyelim ki bir Banka uygulaması geliştiriyoruz ve bu uygulamada döviz kurlarını çekmek için bir servisimiz var.
IoC Container, bu servisin nesnesini projemizin içine alır ve ihtiyaç duyulduğunda bu nesneyi bize temin eder.
Yani, bir sınıfta bir nesne sürekli olarak üretilip atılmaz, ihtiyaç olduğunda container tarafından verilir.

IoC Container'ın içine atılan bu nesneler, genellikle "beans" olarak adlandırılır.
Beans'lerin, yani nesnelerin oluşturulması ve yönetilmesiyle ilgili görevi ise Spring konfigürasyonları üstlenir.
Bu konfigürasyonlar, genellikle bir sınıfa @Configuration anotasyonu ekleyerek başlar.

Bu noktada, IoC Container'a bir bean eklemek için bir örnek yapalım.
Örneğin, bir CurrencyService adında bir sınıfımız var ve bu sınıf döviz kurlarını çekmekle görevli.
Bu servisi IoC Container'a eklemek için bir konfigürasyon sınıfı oluşturuyoruz.

````java
@Configuration
public class AppConfig {

@Bean
public CurrencyService currencyService() {
return new CurrencyService();
}
}
````

Yukarıdaki örnekte @Bean anotasyonu ile işaretlenen currencyService metodu, IoC Container'a bu servisin bir bean olarak eklenmesini sağlar.

Bu sayede, projemizdeki herhangi bir sınıf, CurrencyService'e ihtiyaç duyduğunda IoC Container'dan bu bean'i alabilir ve kullanabilir.
Örneğin, HomeController sınıfı içinde CurrencyService'i injection etmek için aşağıdaki gibi bir kod kullanabiliriz:

````java
@RestController
public class HomeController {

private final CurrencyService currencyService;

public HomeController(CurrencyService currencyService) {
this.currencyService = currencyService;
}

@GetMapping("/showCurrency")
public String showCurrency() {
// CurrencyService'i kullanarak işlemler yapabiliriz.
String currencyData = currencyService.getCurrencyData();
return "Kur verisi çekildi: " + currencyData;
}
}
````

Bu sayede, herhangi bir yeni nesne üretme veya IoC Container'a ekleme işlemiyle uğraşmadan,
projemizdeki farklı sınıflar arasında bağımlılıkları yönetebiliriz.