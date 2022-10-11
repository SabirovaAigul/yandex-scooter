import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.MainPage;
import pages.OrderFormPage;

public class OrderTest {
    private WebDriver driver;
    private MainPage mainPage;
    private OrderFormPage orderFormPage;

    @Before
    public void setupDriver(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        orderFormPage = new OrderFormPage(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void testTopOrderButton(){
        mainPage.clickCookieButtonIfPresent();
        mainPage.waitForTopButton();
        mainPage.clickTopButton();
        fillForm();
    }

    @Test
    public void testBotOrderButton(){
        mainPage.clickCookieButtonIfPresent();
        mainPage.waitForBotButton();
        mainPage.clickBotButton();
        fillForm();
    }
    private void fillForm(){
        orderFormPage.waitForForm();
        orderFormPage.setName("Тест");
        orderFormPage.setLastName("Тестов");
        orderFormPage.setAddress("Москва");
        orderFormPage.clickMetro();
        orderFormPage.waitForSelectMetroLoad();
        orderFormPage.selectMetro();
        orderFormPage.setPhone("89121212121");
        orderFormPage.clickNext();
        orderFormPage.waitForForm();
        orderFormPage.clickDate();
        orderFormPage.waitForDayOfDateLoad();
        orderFormPage.clickDayOfDate();
        orderFormPage.clickRent();
        orderFormPage.waitForRentTimeLoad();
        orderFormPage.clickRentTimeOption();
        orderFormPage.clickSubmitOrder();
        orderFormPage.waitForConfirmLoad();
        orderFormPage.clickConfirmButton();
        orderFormPage.checkSuccessModal("Заказ оформлен");
    }
    @After
    public void quit(){
        driver.quit();
    }
}
