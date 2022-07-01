package org.example.Lesson13;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertTrue;

public class Makeup {

    private Actions actionBuilder;
    private ChromeDriver сhromeDriver;
    private MakeupActions makeupActions;

    public Makeup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kozac\\Downloads\\chromedriver_win32\\chromedriver.exe");
        this.сhromeDriver = new ChromeDriver();

        this.actionBuilder = new Actions(сhromeDriver);
        this.makeupActions = new MakeupActions(сhromeDriver);
    }

    @Test
    public void authorization_with_shouldBeAuthorized()
    {
        makeupActions.explicitWait();
        makeupActions.openSite();
        makeupActions.implicitWait();
        actionBuilder
                .click(makeupActions.getUserAccountElement())
                .keyUp(makeupActions.getLoginElement(), "kateryna.test6545@gmail.com")
                .keyUp(makeupActions.getPasswordElement(), "TEST54651")
                .click(makeupActions.getLoginButtonElement());

        assertTrue( true );
    }
}
