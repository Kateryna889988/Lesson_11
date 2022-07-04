package org.example.Lesson14.Makeup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    By userAccountMobileLocator = By.xpath("//div[contains(@data-popup-handler, 'auth') and (contains(@class, 'header-office'))]");
    By userAccountDesktopLocator = By.xpath("//div[contains(@data-popup-handler, 'auth') and (contains(text(),'Вхід до кабінету'))]");
    By userLoginLocator = By.xpath("//input[contains(@name, 'user_login')]");
    By userPasswordLocator = By.xpath("//input[contains(@name, 'user_pw')]");
    By loginButtonLocator = By.xpath("//button[(contains(text(),'Увійти'))]");


    private final ChromeDriver driver;

    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
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

}
