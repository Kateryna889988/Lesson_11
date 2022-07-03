package org.example.Lesson13;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class Makeup {

    private Actions actionBuilder;
    private ChromeDriver сhromeDriver;
    private MakeupActions makeupActions;

    public Makeup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kozac\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions op = new ChromeOptions();
        op.addArguments("window-size=1300,700");
        this.сhromeDriver = new ChromeDriver(op);
        this.actionBuilder = new Actions(сhromeDriver);
        this.makeupActions = new MakeupActions(сhromeDriver);
    }

    @Test
    public void authorization_with_shouldBeAuthorized() {
        makeupActions.explicitWait();
        makeupActions.openSite();
        makeupActions.implicitWait();
        actionBuilder
                .click(makeupActions.getUserAccountElement())
                .pause(1000);

        actionBuilder
                .sendKeys(makeupActions.getLoginElement(), "kateryna.test6545@gmail.com")
                .sendKeys(makeupActions.getPasswordElement(), "TEST54651")
                .click(makeupActions.getLoginButtonElement())
                .build()
                .perform();

        String element = makeupActions.getAuthorizedElement();
        makeupActions.explicitWait();

        assertTrue(element.equals("Кабінет"));

    }

    @Test
    public void createOrder_with_shouldBeAuthorized() {
        makeupActions.explicitWait();
        makeupActions.openSite();
        makeupActions.implicitWait();
        actionBuilder
                .click(makeupActions.getUserAccountElement())
                .pause(1000);

        actionBuilder
                .sendKeys(makeupActions.getLoginElement(), "kateryna.test6545@gmail.com")
                .sendKeys(makeupActions.getPasswordElement(), "TEST54651")
                .click(makeupActions.getLoginButtonElement())
                .pause(1000);

        actionBuilder
                .click(makeupActions.getSelectProduct())
                .click(makeupActions.getBuy())
                .click(makeupActions.getCheckout())
                .build()
                .perform();

        String element = makeupActions.getСompletedPurchase();
        makeupActions.explicitWait();

        assertTrue(element.equals("Дякуємо за ваше замовлення"));
    }
}
