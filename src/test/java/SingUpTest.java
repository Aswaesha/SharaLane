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

        // Ввести First name
        WebElement zipCodeInputFirstName = driver.findElement(By.name("first_name"));
        zipCodeInputFirstName.sendKeys("Alex");

        // Ввести Last name
        WebElement zipCodeInputLastName = driver.findElement(By.name("last_name"));
        zipCodeInputLastName.sendKeys("Petrov");

        // Ввести email
        WebElement zipCodeInputEmail = driver.findElement(By.name("email"));
        zipCodeInputEmail.sendKeys("alex-petrov@gmail.com");

        // Ввести password
        WebElement zipCodeInputPassword = driver.findElement(By.name("password1"));
        zipCodeInputPassword.sendKeys("q1w2e3r4t5y6u7i8");

        // Ввести password2
        WebElement zipCodeInputPasswordTwo = driver.findElement(By.name("password2"));
        zipCodeInputPasswordTwo.sendKeys("q1w2e3r4t5y6u7i8");

        // Нажимаетм кнопку Register
        WebElement registerButton = driver.findElement(By.cssSelector("[value = Register]"));
        registerButton.click();

        // Убедиться что выбило
        boolean isDisplayed = driver.findElement(By.cssSelector("[class=confirmation_message]")).isDisplayed();
        Assert.assertTrue(isDisplayed);

        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void unSuccessfulSingUp() {
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

        // Ввести Last name
        WebElement zipCodeInputLastName = driver.findElement(By.name("last_name"));
        zipCodeInputLastName.sendKeys("Petrov");

        // Ввести email
        WebElement zipCodeInputEmail = driver.findElement(By.name("email"));
        zipCodeInputEmail.sendKeys("alex-petrov@gmail.com");

        // Ввести password
        WebElement zipCodeInputPassword = driver.findElement(By.name("password1"));
        zipCodeInputPassword.sendKeys("q1w2e3r4t5y6u7i8");

        // Ввести password2
        WebElement zipCodeInputPasswordTwo = driver.findElement(By.name("password2"));
        zipCodeInputPasswordTwo.sendKeys("q1w2e3r4t5y6u7i8");

        // Нажимаетм кнопку Register
        WebElement registerButton = driver.findElement(By.cssSelector("[value = Register]"));
        registerButton.click();

        // Убедиться что выбило
        boolean isDisplayed = driver.findElement(By.cssSelector("[class=error_message]")).isDisplayed();
        Assert.assertTrue(isDisplayed, "Oops, error on page. Some of your fields have invalid data or email was previously used");

        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void unSuccessfulSingUpUnValidEmail() {
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

        // Ввести First name
        WebElement zipCodeInputFirstName = driver.findElement(By.name("first_name"));
        zipCodeInputFirstName.sendKeys("Alex");

        // Ввести Last name
        WebElement zipCodeInputLastName = driver.findElement(By.name("last_name"));
        zipCodeInputLastName.sendKeys("Petrov");

        // Ввести email
        WebElement zipCodeInputEmail = driver.findElement(By.name("email"));
        zipCodeInputEmail.sendKeys("abcd12345abcd");

        // Ввести password
        WebElement zipCodeInputPassword = driver.findElement(By.name("password1"));
        zipCodeInputPassword.sendKeys("q1w2e3r4t5y6u7i8");

        // Ввести password2
        WebElement zipCodeInputPasswordTwo = driver.findElement(By.name("password2"));
        zipCodeInputPasswordTwo.sendKeys("q1w2e3r4t5y6u7i8");

        // Нажимаетм кнопку Register
        WebElement registerButton = driver.findElement(By.cssSelector("[value = Register]"));
        registerButton.click();

        // Убедиться что выбило
        boolean isDisplayed = driver.findElement(By.cssSelector("[class=error_message]")).isDisplayed();
        Assert.assertTrue(isDisplayed, "Oops, error on page. Some of your fields have invalid data or email was previously used");

        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void successfulSingUpDifferentPassword() {
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

        // Ввести First name
        WebElement zipCodeInputFirstName = driver.findElement(By.name("first_name"));
        zipCodeInputFirstName.sendKeys("Alex");

        // Ввести Last name
        WebElement zipCodeInputLastName = driver.findElement(By.name("last_name"));
        zipCodeInputLastName.sendKeys("Petrov");

        // Ввести email
        WebElement zipCodeInputEmail = driver.findElement(By.name("email"));
        zipCodeInputEmail.sendKeys("alex-petrov@gmail.com");

        // Ввести password
        WebElement zipCodeInputPassword = driver.findElement(By.name("password1"));
        zipCodeInputPassword.sendKeys("q1w2e3r4t5y6u7i8");

        // Ввести password2
        WebElement zipCodeInputPasswordTwo = driver.findElement(By.name("password2"));
        zipCodeInputPasswordTwo.sendKeys("q1w2e3r4t5y6u7");

        // Нажимаетм кнопку Register
        WebElement registerButton = driver.findElement(By.cssSelector("[value = Register]"));
        registerButton.click();

        // Убедиться что выбило
        boolean isDisplayed = driver.findElement(By.cssSelector("[class=error_message]")).isDisplayed();
        Assert.assertTrue(isDisplayed, "Oops, error on page. Some of your fields have invalid data or email was previously used");

        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void privatePassword() {
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
        // Ввести password
        WebElement zipCodeInputPassword = driver.findElement(By.name("password1"));
        zipCodeInputPassword.sendKeys("q1w2e3r4t5y6u7i8");

        // Убедиться что выбило
        boolean isDisplayed = driver.findElement(By.cssSelector("[type = password]")).isDisplayed();
        Assert.assertTrue(isDisplayed);

        // Закрыть браузер
        driver.quit();
    }
}
