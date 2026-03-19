package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class CurrenciesPage {

    // Locators

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Курсы валют']/preceding-sibling::android.widget.ImageView")
    private WebElement backButton;

    @AndroidFindBy(accessibility = "Курсы валют")
    private WebElement pageTitleText;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Курсы АТБ')]")
    private WebElement atbRatesTab;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Курсы ЦБ')]")
    private WebElement cbRatesTab;

    // Methods

    public void goToLoginPage() {
        $(backButton).click();
    }

    // Assertions

    public void assertCurrenciesPageOpened() {
        $(backButton)
                .shouldHave(visible);
        $(pageTitleText)
                .shouldHave(visible);
        $(atbRatesTab)
                .shouldHave(visible)
                .shouldHave(selected);
        $(cbRatesTab)
                .shouldHave(visible)
                .shouldHave(not(selected));
    }
}