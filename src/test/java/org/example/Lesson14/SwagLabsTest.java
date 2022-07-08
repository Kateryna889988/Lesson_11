package org.example.Lesson14;

import org.example.Lesson14.SwagLabs.*;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

public class SwagLabsTest {
    private ChromeDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private AddBucketPage addBucketPage;
    private VerificationPage verificationPage;
    private FinishPage finishPage;

    public SwagLabsTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kozac\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions op = new ChromeOptions();
        op.addArguments("window-size=1300,700");
        this.driver = new ChromeDriver(op);
        this.loginPage = new LoginPage(driver);
        this.mainPage = new MainPage(driver);
        this.addBucketPage = new AddBucketPage(driver);
        this.verificationPage = new VerificationPage(driver);
        this.finishPage = new FinishPage(driver);
    }

    @Test
    public void authorization_with_shouldBeAuthorized() {
        loginPage
                .openSite()
                .userLogin("standard_user")
                .userPassword("secret_sauce")
                .clickLoginButton();


        loginPage.explicitWait();
        String element = loginPage.getAuthorizedElement();

        assertTrue(element.equals("PRODUCTS"));

        driver.close();
    }

    @Test
    public void createOrder_with_shouldBeAuthorized() {
        loginPage
                .openSite()
                .userLogin("standard_user")
                .userPassword("secret_sauce")
                .clickLoginButton()
                .selectionsProduct()
                .addBucket()
                .clickCheckout()
                .completeFields("Kateryna", "Kozachenko", "79005")
                .clickContinue()
                .clickFinish();


        finishPage.explicitWait();
        String element = finishPage.getСompletedPurchase();

        assertTrue(element.equals("THANK YOU FOR YOUR ORDER"));

        driver.close();
    }
}
