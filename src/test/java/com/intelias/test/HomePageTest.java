package com.intelias.test;

import com.intelias.model.Laufzeit;
import com.intelias.model.Nettokreditbetrag;
import com.intelias.model.Verwendung;
import com.intelias.page.HomePage;
import com.intelias.page.KreditFragePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HomePageTest extends BaseWebdriverTest {
    private HomePage homePage;

    @Before
    public void init() {
        openPage("https://www.smava.de/");

        homePage = new HomePage(driver);
    }

    @Test
    public void creditCalculatoreTest() throws InterruptedException {
        homePage.selectCreditCalculatorValues(Verwendung.WOHNEN, Nettokreditbetrag.AMOUNT_2750, Laufzeit.MONTH24);
        homePage.jetztKreditvergleichstartenClick();

        KreditFragePage kreditFragePage = new KreditFragePage(driver);
        kreditFragePage.waitPageLoadComplete();

        Assert.assertTrue(kreditFragePage.checkProgrBarStep1Active());
        Assert.assertTrue(kreditFragePage.checkProgrBarPersonActive());

    }

    @Test
    public void loginIncorrectDataIncorrectEMailTest() throws InterruptedException {
        String errorTextExpected = "Bitte überprüfen Sie Ihre Eingabe.";
        String usernamer = "TesterLogin";
        String pwd = "pwdTest";

        homePage.login(usernamer, pwd);

        Assert.assertEquals(homePage.getErrorText(), errorTextExpected);
    }

    //TODO ask about ignore behaiviour - no error message
    @Test
    public void loginIncorrectDataCorrectEmailIncorrectPWDTest() throws InterruptedException {
        String userNamer = "ululul@gmail.com";
        String pwd = "pwdTestIncorrect";

        homePage.login(userNamer, pwd);

        Assert.assertEquals(false, homePage.checkSignInUserNameIsPresent(userNamer));
    }
}
