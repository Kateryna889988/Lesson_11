import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        swagLabs();
        makeup();
    }

    public static void swagLabs() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kozac\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        String elementForWaiting = "//input[contains(@name, 'user-name')]";

        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementForWaiting)));

        WebElement username = driver.findElement(By.xpath("//input[contains(@name, 'user-name')]"));

        username.click();

        username.sendKeys("standard_user", Keys.END);

        WebElement password = driver.findElement(By.xpath("//input[contains(@name, 'password')]"));

        password.click();

        password.sendKeys("secret_sauce", Keys.END);

        WebElement authorization = driver.findElement(By.xpath("//input[contains(@name, 'login-button')]"));

        authorization.click();


        WebElement click = driver.findElement(By.xpath("//button[contains(@name, 'add-to-cart-sauce-labs-backpack')]"));

        click.click();

        WebElement basket = driver.findElement(By.xpath("//a[contains(@class, 'shopping_cart_link')]"));

        basket.click();

        WebElement checkOut = driver.findElement(By.xpath("//button[contains(@name, 'checkout')]"));

        checkOut.click();

        WebElement firstName = driver.findElement(By.xpath("//input[contains(@name, 'firstName')]"));

        firstName.click();

        firstName.sendKeys("Kateryna", Keys.END);

        WebElement lastName = driver.findElement(By.xpath("//input[contains(@name, 'lastName')]"));

        lastName.click();

        lastName.sendKeys("Kozachenko", Keys.END);

        WebElement postalCode = driver.findElement(By.xpath("//input[contains(@name, 'postalCode')]"));

        postalCode.click();

        postalCode.sendKeys("79005", Keys.END);

        WebElement makeAnOrder = driver.findElement(By.xpath("//input[contains(@name, 'continue')]"));

        makeAnOrder.click();

        WebElement finish = driver.findElement(By.xpath("//button[contains(@name, 'finish')]"));

        finish.click();

        WebElement comeBack = driver.findElement(By.xpath("//button[contains(@name, 'back-to-products')]"));

        comeBack.click();
    }


    public static void makeup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kozac\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://makeup.com.ua/ua/");

        String elementForWaiting = "//div[contains(@data-popup-handler, 'auth')]";

        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementForWaiting)));

        String xpathMobile = "//div[contains(@data-popup-handler, 'auth') and (contains(@class, 'header-office'))]";
        String xpathDesktop = "//div[contains(@data-popup-handler, 'auth') and (contains(text(),'Вхід до кабінету'))]";
        int windowSize = driver.manage().window().getSize().width;

        String xpath = windowSize > 1000 ? xpathDesktop : xpathMobile;

        WebElement input = driver.findElement(By.xpath(xpath));

        input.click();

        WebElement email = driver.findElement(By.xpath("//input[contains(@name, 'user_login')]"));

        email.click();

        email.sendKeys("kateryna.test6545@gmail.com", Keys.END);

        WebElement password = driver.findElement(By.xpath("//input[contains(@name, 'user_pw')]"));

        password.click();

        password.sendKeys("TEST54651", Keys.END);

        WebElement authorization = driver.findElement(By.xpath("//button[(contains(text(),'Увійти'))]"));

        authorization.click();


        WebElement click = driver.findElement(By.xpath("//div[(contains(@class,'simple-slider-list__link'))]/a[contains(@href, '/ua/product/657505/')]"));

        click.click();

        WebElement buy = driver.findElement(By.xpath("//div[(contains(@data-id,'657505'))]/div/div[(contains(.,'Купити'))]"));

        buy.click();

        WebElement makeAnOrder = driver.findElement(By.xpath("//div[(contains(@class,'align-center'))]/div[(contains(., 'Оформити замовлення'))]"));

        makeAnOrder.click();
    }
}

