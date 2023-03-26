package PageObject.OrderPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RentData {

    private final WebDriver driver;

    public RentData(WebDriver driver) {
        this.driver = driver;
    }
    // кнопка "Заказать"
    static final By createOrderButton =
            By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text() = 'Заказать']");
    // поле ввода "* Когда привезти самокат"
    private static final By dateOfTheOrderField =
            By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // поле "* Срок аренды"
    private static final By durationOfRentField = By.className("Dropdown-placeholder");
    // элемент "Сутки" из выпадающего списка Срока аренды
    private static final By oneDayRent = By.xpath(".//div[text() = 'сутки']");
    // чекбокс "чёрный жемчуг"
    private static final By colorBlackCheckbox = By.xpath(".//label[text() = 'чёрный жемчуг']");
    // полле ввода "Комментарий для курьера"
    private static final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // кнопка следующего месяца из выпадаюшего календаря
    private static final By nextMonthButton = By.xpath(".//button[text() = 'Next Month']");
    // любой день следующего месяца из выпадаюшего календаря
    private static final By anyDayNextMonth = By.xpath(".//div[@class='react-datepicker__week']/*");
    // кнопка подтверждения заказа "Да" в всплывающем окне
    private static final By yesButton =
            By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    public void chooseRentDurationForOneDay() {
        driver.findElement(durationOfRentField).click();
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(oneDayRent));
        driver.findElement(oneDayRent).click();
    }
    public void chooseTheDateOfRent() {
        driver.findElement(dateOfTheOrderField).click();
        WebElement buttonOfNextMonth = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(nextMonthButton));
        buttonOfNextMonth.click();
        WebElement buttonOfTheDay = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(anyDayNextMonth));
        buttonOfTheDay.click();
    }
    public void fillTheRentDataFields(String comment) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(dateOfTheOrderField));
        chooseTheDateOfRent();
        chooseRentDurationForOneDay();
        driver.findElement(colorBlackCheckbox).click();
        driver.findElement(commentField).sendKeys(comment);
    }
    public void pressCreateOrderButton() {
        driver.findElement(createOrderButton).click();
    }
    public void pressYesButtonToConfirmTheOrder() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(yesButton));
        element.click();
    }

}
