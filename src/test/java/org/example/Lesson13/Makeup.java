package org.example.Lesson13;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class Makeup {

    private Actions actionBuilder;
    private ChromeDriver driver;
    private MakeupActions makeupActions;

    public Makeup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kozac\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions op = new ChromeOptions();
        op.addArguments("window-size=1300,700");
        this.driver = new ChromeDriver(op);
        this.actionBuilder = new Actions(driver);
        this.makeupActions = new MakeupActions(driver);
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

    @Test
    public void filtration_with_shouldBeAuthorized() {
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
                .click(makeupActions.getCategorySelection())
                .pause(1000)
                .click(makeupActions.getBrandChoice())
                .pause(1000)
                .click(makeupActions.getProductSelection())
                .build()
                .perform();

        String element = makeupActions.getFilteredProduct();
        makeupActions.explicitWait();

        assertTrue(element.equals("MAKEUP>Тіло і ванна>Для тіла>Креми, молочко та лосьйони>Олія для тіла>Кокосове масло \"100% Natural\""));

    }

    @Test
    public void feedback_with_shouldBeAuthorized() {
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
                .click(makeupActions.getProductSelection())
                .click(makeupActions.getLeaveFeedback())
                .pause(1000)
                .click(makeupActions.getNameUser())
                .sendKeys(makeupActions.getNameUser(), "Kateryna")
                .sendKeys(makeupActions.getEmailUser(), "kateryna.test6545@gmail.com")
                .click(makeupActions.getGradeUser())
                .sendKeys(makeupActions.getMessageUser(), "Відмінний товар!")
                .pause(1000)
                .click(makeupActions.getAddMessage())
                .build()
                .perform();

        String element = makeupActions.getAddedFeedback();
        makeupActions.explicitWait();

        assertTrue(element.equals("Ваш відгук успішно додано!"));

    }
}
