package com.intelias.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KreditFragePage extends BasePage {

    private static final By progBarStep1Active = By.xpath("//div[@class='progress-bar__step progress-bar__step_active']/div[@class='progress-bar__step-circle' and text()=1]");
    private static final By progBarPersonActive = By.xpath("//div[@class='progress-bar__step progress-bar__step_active']/span[@class='progress-bar__step-title' and text()='Person']");


    public KreditFragePage(WebDriver driver) {
        super(driver);
    }

    public boolean checkProgrBarStep1Active() {
        return isElementPresent(progBarStep1Active);
    }

    public boolean checkProgrBarPersonActive() {
        return isElementPresent(progBarPersonActive);
    }

}

