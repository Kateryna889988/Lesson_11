package org.example.Lesson13;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertTrue;

public class SwagLabs {

    private Actions actionBuilder;
    private ChromeDriver сhromeDriver;
    private SwagLabsActions swagLabsActions;

    public SwagLabs() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kozac\\Downloads\\chromedriver_win32\\chromedriver.exe");
        this.сhromeDriver = new ChromeDriver();
        this.actionBuilder = new Actions(сhromeDriver);
        this.swagLabsActions = new SwagLabsActions(сhromeDriver);
    }

    @Test
    public void authorization_with_shouldBeAuthorized() {
        swagLabsActions.explicitWait();
        swagLabsActions.openSite();
        swagLabsActions.implicitWait();

        actionBuilder
                .sendKeys(swagLabsActions.getUsernameElement(), "standard_user")
                .sendKeys(swagLabsActions.getPasswordElement(), "secret_sauce")
                .click(swagLabsActions.getLoginButtonElement())
                .build()
                .perform();

        String element = swagLabsActions.getAuthorizedElement();
        swagLabsActions.explicitWait();

        assertTrue(element.equals("PRODUCTS"));
    }

    @Test
    public void createOrder_with_shouldBeAuthorized() {
        swagLabsActions.explicitWait();
        swagLabsActions.openSite();
        swagLabsActions.implicitWait();

        actionBuilder
                .sendKeys(swagLabsActions.getUsernameElement(), "standard_user")
                .sendKeys(swagLabsActions.getPasswordElement(), "secret_sauce")
                .click(swagLabsActions.getLoginButtonElement())
                .pause(1000)
                .click(swagLabsActions.getSelectProduct())
                .click(swagLabsActions.getAddToBasket())
                .pause(1000)
                .click(swagLabsActions.getVerify())
                .pause(1000)
                .click(swagLabsActions.getFirstName())
                .sendKeys(swagLabsActions.getFirstName(), "Kateryna")
                .sendKeys(swagLabsActions.getLastName(), "Kozachenko")
                .sendKeys(swagLabsActions.getPostalCode(), "79005")
                .pause(1000)
                .click(swagLabsActions.getProceed())
                .pause(1000)
                .click(swagLabsActions.getFinish())
                .build()
                .perform();

        String element = swagLabsActions.getСompletedPurchase();
        swagLabsActions.explicitWait();

        assertTrue(element.equals("THANK YOU FOR YOUR ORDER"));
    }
}


