package org.example.Lesson14;

import io.qameta.allure.Step;
import org.example.Lesson14.Makeup.*;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

public class MakeupTest {

    private ChromeDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;
    private BucketPage basket;
    private FilterPage filterPage;

    public MakeupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kozac\\Downloads\\chrome\\chromedriver.exe");
        ChromeOptions op = new ChromeOptions();
        op.addArguments("window-size=1300,700");
        this.driver = new ChromeDriver(op);
        this.loginPage = new LoginPage(driver);
        this.productPage = new ProductPage(driver);
        this.basket = new BucketPage(driver);
        this.filterPage = new FilterPage(driver);
    }

    @Test
    public void authorization_with_shouldBeAuthorized() {
        loginPage
                .openSite()
                .clickOnUserAccount()
                .userLogin("kateryna.test6545@gmail.com")
                .userPassword("TEST54651")
                .clickLoginButton();


        loginPage.explicitWait();
        String element = loginPage.getAuthorizedElement();

        assertTrue(element.equals("Кабінет"));

        driver.close();
    }

    @Test
    public void createOrder_with_shouldBeAuthorized() {
        loginPage
                .openSite()
                .waitUserAccount()
                .clickOnUserAccount()
                .userLogin("kateryna.test6545@gmail.com")
                .userPassword("TEST54651")
                .clickLoginButton()
                .waitBrandSelection()
                .selectionBrand()
                .waitBrandChoice()
                .clickChoiceBrand()
                .waitProductSelection()
                .selectionProduct()
                .waitBuy()
                .clickBuy()
                .waitBucket()
                .bucket()
                .waitCheckout()
                .checkout();


        basket.waitBucketPage();
        String element = basket.getСompletedPurchase();

        assertTrue(element.equals("Дякуємо за ваше замовлення"));

        driver.close();
    }

    @Test
    public void filtration_with_shouldBeAuthorized() {
        loginPage
                .openSite()
                .clickOnUserAccount()
                .userLogin("kateryna.test6545@gmail.com")
                .userPassword("TEST54651")
                .clickLoginButton()
                .waitBrandSelection()
                .selectionBrand()
                .waitBrandChoice()
                .clickChoiceBrand()
                .selectionProduct();


        filterPage.waitFilterPage();
        String element = filterPage.getFilteredProduct();

        assertTrue(element.equals("MAKEUP>Тіло і ванна>Для тіла>Креми, молочко та лосьйони>Олія для тіла>Кокосове масло \"100% Natural\""));

        driver.close();
    }


    @Test
    public void feedback_with_shouldBeAuthorized() {
        loginPage
                .openSite()
                .clickOnUserAccount()
                .userLogin("kateryna.test6545@gmail.com")
                .userPassword("TEST54651")
                .clickLoginButton()
                .waitBrandSelection()
                .selectionProduct()
                .waitBuy()
                .openFeedback()
                .leaveFeedback("Kateryna", "kateryna.test6545@gmail.com", "", "Відмінний товар!")
                .addMessage();


        productPage.explicitWait();
        String element = productPage.getAddedFeedback();

        assertTrue(element.equals("Ваш відгук успішно додано!"));

        driver.close();
    }
}


