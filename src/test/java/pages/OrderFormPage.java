package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrderFormPage {
    private final WebDriver driver;

    private final By form = By.className("Order_Form__17u6u");
    private final By name = By.xpath("//input[@placeholder='* Имя']");
    private final By lastName = By.xpath("//input[@placeholder='* Фамилия']");
    private final By address = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metro = By.className("select-search__input");
    private final By phone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By metroSelect = By.className("select-search__options");
    private final By metroButton = By.xpath("//li[@class='select-search__row']/button");
    private final By nextButton = By.xpath("//button[text()='Далее']");

    private final By date = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By submitOrder = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private final By dayOfDate = By.className("react-datepicker__day");
    private final By rentTime = By.className("Dropdown-control");
    private final By rentTimeOption = By.className("Dropdown-option");
    private final By confirmOrder = By.className("Order_Modal__YZ-d3");
    private final By confirmOrderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    private final By successModal = By.xpath("//div[text()='Заказ оформлен']");
    public OrderFormPage(WebDriver driver) {
        this.driver = driver;
    }

   public void waitForForm(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(form));
    }

    public void setName(String val){
        driver.findElement(name).sendKeys(val);
    }

    public void setLastName(String val){
        driver.findElement(lastName).sendKeys(val);
    }

    public void setAddress(String val){
        driver.findElement(address).sendKeys(val);
    }

    public void setPhone(String val){
        driver.findElement(phone).sendKeys(val);
    }

    public void clickMetro(){
        driver.findElement(metro).click();
    }

    public void waitForSelectMetroLoad(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(metroSelect));
    }

    public void selectMetro(){
        driver.findElement(metroButton).click();
    }

    public void clickNext(){
        driver.findElement(nextButton).click();
    }

    public void clickDate(){
        driver.findElement(date).click();
    }

    public void waitForDayOfDateLoad(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(dayOfDate));
    }

    public void clickDayOfDate(){
        driver.findElement(dayOfDate).click();
    }

    public void clickRent(){
        driver.findElement(rentTime).click();
    }

    public void waitForRentTimeLoad(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(rentTimeOption));
    }

    public void clickRentTimeOption(){
        driver.findElement(rentTimeOption).click();
    }

    public void clickSubmitOrder(){
        driver.findElement(submitOrder).click();
    }

    public void waitForConfirmLoad(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(confirmOrder));
    }

    public void clickConfirmButton(){
        driver.findElement(confirmOrderButton).click();
    }

    public void checkSuccessModal(String message){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElementLocated(successModal, message));
    }

}
