package org.example.Lesson14.Makeup;

import org.example.Lesson14.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ProductPage extends BasePage {

    By BuyLocator = By.xpath("//div[(contains(@data-id,'657505'))]/div/div[(contains(.,'Купити'))]");
    By OpenFeedbackLocator = By.xpath("//div[(contains(@class,'align-center'))]/div[contains(@class, 'add-comment button-more')]");
    By NameUserLocator = By.xpath("//div[(contains(@class,'input-wrap'))]/input[contains(@id, 'comments-name')]");
    By EmailUserLocator = By.xpath("//div[(contains(@class,'input-wrap'))]/input[contains(@id, 'mail')]");
    By GradeUserLocator = By.xpath("//div[(contains(@class,'stars-wrap'))]/ul[contains(@class, 'stars')]");
    By MessageUserLocator = By.xpath("//div[(contains(@class,'input-wrap'))]/textarea[contains(@name, 'body')]");
    By AddMessageLocator = By.xpath("//div[(contains(@class,'private-office__row status'))]/button[contains(@class, 'button')]");

    public ProductPage(ChromeDriver driver) {
        super(driver);
    }

    public BucketPage clickBuy() {
        By xpath = BuyLocator;
        driver.findElement(xpath).click();
        return new BucketPage(driver);
    }

    public ProductPage openFeedback() {
        By xpath = OpenFeedbackLocator;
        driver.findElement(xpath).click();
        return this;
    }

    public ProductPage leaveFeedback(String name, String email, String grade, String message) {
        By xpath1 = NameUserLocator;
        By xpath2 = EmailUserLocator;
        By xpath3 = GradeUserLocator;
        By xpath4 = MessageUserLocator;
        driver.findElement(xpath1).sendKeys(name);
        driver.findElement(xpath2).sendKeys(email);
        driver.findElement(xpath3).sendKeys(grade);
        driver.findElement(xpath4).sendKeys(message);
        return this;
    }

    public BucketPage addMessage() {
        By xpath = AddMessageLocator;
        driver.findElement(xpath).click();
        return new BucketPage(driver);
    }


    public String getAddedFeedback() {
        WebElement element = driver.findElement(By.xpath("//div[(contains(@class,'popup__window message active'))]/div[contains(@class, 'popup-content')]"));
        return element.getText();
    }

    public void explicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public ProductPage waitBuy() {
        super.waitClickableElement(BuyLocator);
        return this;
    }
}
