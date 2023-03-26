package PageObject.OrderPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalData {
    private final WebDriver driver;

    public PersonalData(WebDriver driver) {
        this.driver = driver;
    }

    // поле ввода "Имя"
    private static final By fieldName =
            By.xpath(".//input[@placeholder='* Имя']");
    // поле ввода "Фамилия"
    private static final By fieldSurname =
            By.xpath(".//input[@placeholder='* Фамилия']");
    // поле ввода "Адрес"
    private static final By fieldAddress =
            By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // поле "Метро"
    private static final By fieldMetroStation =
            By.xpath(".//input[@placeholder='* Станция метро']");
    // поле ввода "Телефон"
    private static final By fieldPhone =
            By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // конпка "Далее"
    public static final By buttonNext =
            By.xpath(".//div[@class ='Order_NextButton__1_rCA']/button");
    // любая станция метро из выпадающего списка метро
    private static final By anyMetroStation = By.xpath(".//div[@class='select-search__select']/*");

    public void chooseMetroStation() {
        driver.findElement(fieldMetroStation).click();
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(anyMetroStation));
        driver.findElement(anyMetroStation).click();


    }

    public void fillPersonalDataFields(String name, String surname, String address, String phone) {
        driver.findElement(fieldName).sendKeys(name);
        driver.findElement(fieldSurname).sendKeys(surname);
        driver.findElement(fieldAddress).sendKeys(address);
        chooseMetroStation();
        driver.findElement(fieldPhone).sendKeys(phone);
    }
    public void pressTheButtonNext() {
        driver.findElement(buttonNext).click();
    }

}
