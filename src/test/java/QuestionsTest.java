import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import java.util.HashMap;
import java.util.Map;

public class QuestionsTest {
    private static WebDriver driver;
    private static MainPage mainPage;

    @BeforeClass
    public static void setupDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
    @Test
    public void checkPriceQuestion(){
        mainPage.waitForQuestionsLoad();
        mainPage.checkAnswerForQuestion("Сколько это стоит? И как оплатить?","Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
    }
    @Test
    public void checkCountQuestion(){
        mainPage.waitForQuestionsLoad();
        mainPage.checkAnswerForQuestion("Хочу сразу несколько самокатов! Так можно?","Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
    }
    @Test
    public void checkRentQuestion(){
        mainPage.waitForQuestionsLoad();
        mainPage.checkAnswerForQuestion("Как рассчитывается время аренды?","Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
    }

    @Test
    public void checkRentTodayQuestion(){
        mainPage.waitForQuestionsLoad();
        mainPage.checkAnswerForQuestion("Можно ли заказать самокат прямо на сегодня?","Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
    }

    @Test
    public void checkTimeQuestion(){
        mainPage.waitForQuestionsLoad();
        mainPage.checkAnswerForQuestion("Можно ли продлить заказ или вернуть самокат раньше?","Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
    }

    @Test
    public void checkChargeQuestion(){
        mainPage.waitForQuestionsLoad();
        mainPage.checkAnswerForQuestion("Вы привозите зарядку вместе с самокатом?","Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
    }

    @Test
    public void checkCanselQuestion(){
        mainPage.waitForQuestionsLoad();
        mainPage.checkAnswerForQuestion("Можно ли отменить заказ?","Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
    }

    @Test
    public void checkMKADQuestion(){
        mainPage.waitForQuestionsLoad();
        mainPage.checkAnswerForQuestion("Я жизу за МКАДом, привезёте?","Да, обязательно. Всем самокатов! И Москве, и Московской области.");
    }

    @AfterClass
    public static void quit(){
        driver.quit();
    }
}
