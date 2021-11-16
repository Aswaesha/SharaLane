import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SingUpTest {
    @Test
    public void zipCodeShouldAccept5Digits() {
        // Открытие страницы https://www.sharelane.com/cgi-bin/register.py
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Ввести 5 цифр
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");

        // Нажимаетм кнопку Continue
        WebElement continueButton = driver.findElement(By.cssSelector("[value = Continue]"));
        continueButton.click();

        // Убедиться что мы на транице SingUp
        boolean isDisplayed = driver.findElement(By.cssSelector("[value = Register]")).isDisplayed();
        Assert.assertTrue(isDisplayed);
        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void zipCodeShouldAccept6Digits() {
        // Открытие страницы https://www.sharelane.com/cgi-bin/register.py
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Ввести 6 цифр
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("123456");

        // Нажимаетм кнопку Continue
        WebElement continueButton = driver.findElement(By.cssSelector("[value = Continue]"));
        continueButton.click();

        // Убедиться что есть ошибка
        boolean isDisplayed = driver.findElement(By.cssSelector("[class=error_message]")).isDisplayed();
        Assert.assertTrue(isDisplayed, "We have error");
        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void zipCodeShouldAccept4Digits() {
        // Открытие страницы https://www.sharelane.com/cgi-bin/register.py
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Ввести 4 цифр
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("1234");

        // Нажимаетм кнопку Continue
        WebElement continueButton = driver.findElement(By.cssSelector("[value = Continue]"));
        continueButton.click();

        // Убедиться что выбило текст с ошибкой
        boolean isDisplayed = driver.findElement(By.cssSelector("[class=error_message]")).isDisplayed();
        Assert.assertTrue(isDisplayed);
        // Закрыть браузер
        driver.quit();

    }

    @Test
    public void successfulSingUp() {


    }

}
