package com.intelias.page;


import com.intelias.model.Laufzeit;
import com.intelias.model.Nettokreditbetrag;
import com.intelias.model.Verwendung;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final By etztKreditverglButton = By.xpath("//*[@class = 'Button__button ButtonNext__button Button__orange Button__is-fullwidth' and @type = 'submit']/span/span[text()='Jetzt Kreditvergleich starten']");
    private static final By verwendungDropBox = By.xpath("(//div[@class='Calulator__form-field-wrapper'])[1]");
    private static final By nettokreditbetragDropBox = By.xpath("//div[@class='Calulator__form-field-wrapper'][2]");
    private static final By laufzeitDropBox = By.xpath("//div[@class='Calulator__form-field-wrapper'][3]");
    private static final By anmeldenLabel = By.xpath("//div[(text() = 'Anmelden ' or . = 'Anmelden ')]");

    private static final By loginNameInput = By.xpath("//div[@class='Popup__content']//input[@name='email']");
    private static final By pwdNameInput = By.xpath("//div[@class='Popup__content']//input[@name='password']");
    private static final By anmeldenButton = By.xpath("//button[@class = 'Button__button LoginForm__button' and @type = 'submit' and (text() = 'Anmelden ' or . = 'Anmelden ')]");

    private static final By errorText = By.xpath("//div[@class= 'Popup__content']//*[contains(@class, 'FieldWrapper__error-message FieldWrapper__error-message')]");

    private static final By signInUserName(String usernamer) {
        return By.xpath("//span[@class = 'TopMenu__item-title'  and (text() = '" + usernamer + "')]");
    }

    private static final By selectVerwendung(String dropBoxListSelectedValue) {
        return verwendungDropBox.xpath("//div[@class='Select-menu']/div[@class='Select-option' and @aria-label='" + dropBoxListSelectedValue + "']");
    }

    private static final By selectNetkreditbetr(String dropBoxListSelectedValue) {
        return nettokreditbetragDropBox.xpath("//div[@class='Select-menu']/div[@class='Select-option' and contains(@aria-label, '" + dropBoxListSelectedValue + "')]");
    }

    private static final By selectLaufzeit(String dropBoxListSelectedValue) {
        return laufzeitDropBox.xpath("//div[@class='Select-menu']/div[@class='Select-option' and @aria-label='" + dropBoxListSelectedValue + "']");
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void selectCreditCalculatorValues(Verwendung verwendung, Nettokreditbetrag nettokreditbetrag, Laufzeit laufzeit) throws InterruptedException {
        click(verwendungDropBox);
        click(selectVerwendung(verwendung.getValue()));

        click(nettokreditbetragDropBox);
        click(selectNetkreditbetr(nettokreditbetrag.getValue()));

        click(laufzeitDropBox);
        click(selectLaufzeit(laufzeit.getValue()));
    }

    public void login(String userName, String pwd) {
        click(anmeldenLabel);
        click(loginNameInput);
        writeText(loginNameInput, userName);
        click(pwdNameInput);
        writeText(pwdNameInput, userName);
        click(anmeldenButton);
    }

    public String getErrorText() {
        return readText(errorText);

    }

    public boolean checkSignInUserNameIsPresent(String userName) {
        return isElementPresent(signInUserName(userName));
    }

    public void jetztKreditvergleichstartenClick() {
        click(etztKreditverglButton);
    }

}
