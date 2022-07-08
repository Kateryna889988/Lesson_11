package org.example.Lesson14.Makeup;

import org.example.Lesson14.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginPage extends BasePage {
    By userAccountMobileLocator = By.xpath("//div[contains(@data-popup-handler, 'auth') and (contains(@class, 'header-office'))]");
    By userAccountDesktopLocator = By.xpath("//div[contains(@data-popup-handler, 'auth') and (contains(text(),'Вхід до кабінету'))]");
    By userLoginLocator = By.xpath("//input[contains(@name, 'user_login')]");
    By userPasswordLocator = By.xpath("//input[contains(@name, 'user_pw')]");
    By loginButtonLocator = By.xpath("//button[(contains(text(),'Увійти'))]");

    public LoginPage(ChromeDriver driver) {
        super(driver);
    }

    public boolean isMobile() {
        int windowSize = driver.manage().window().getSize().width;
        return windowSize <= 1000;
    }

    public LoginPage clickOnUserAccount() {
        By xpath = isMobile() ? userAccountMobileLocator : userAccountDesktopLocator;
        driver.findElement(xpath).click();
        return this;
    }

    public LoginPage userLogin(String login) {
        By xpath = userLoginLocator;
        driver.findElement(xpath).sendKeys(login);
        return this;
    }

    public LoginPage userPassword(String password) {
        By xpath = userPasswordLocator;
        driver.findElement(xpath).sendKeys(password);
        return this;
    }

    public MainPage clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
        return new MainPage(driver);
    }

    public String getAuthorizedElement() {
        WebElement element = driver.findElement(By.xpath("//div[(contains(@class,'layout'))]/div[(contains(., 'Кабінет'))]"));
        return element.getText();
    }

    public void explicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public LoginPage waitMainPage() {
        super.implicitlyWait();
        return this;
    }

    public LoginPage waitUserAccount() {
        By xpath = isMobile() ? userAccountMobileLocator : userAccountDesktopLocator;
        super.waitClickableElement(xpath);
        return this;
    }

    public LoginPage openSite() {
        driver.get("https://makeup.com.ua/ua/");
        return this;
    }
}
