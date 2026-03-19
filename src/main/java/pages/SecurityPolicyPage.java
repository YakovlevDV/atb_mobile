package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class SecurityPolicyPage {

    // Locators

    @AndroidFindBy(accessibility = "Устройство не соответствует политике безопасности")
    private WebElement warningTitleText;

    @AndroidFindBy(accessibility = "Продолжение использования этого приложения может нести в себе риск несанкционированного доступа к функциям приложения")
    private WebElement warningText;

    @AndroidFindBy(accessibility = "Продолжить")
    private WebElement continueButton;

    @AndroidFindBy(accessibility = "Сообщить об ошибке")
    private WebElement sendErrorButton;

    // Methods

    public void goToLoginPage() {
        $(continueButton).click();
    }

    // Assertions

    public void assertSecurityPolicyPageOpened() {
        $(warningTitleText)
                .shouldHave(visible)
                .shouldHave(attribute(
                        "content-desc",
                        "Устройство не соответствует политике безопасности"));
        $(warningText)
                .shouldHave(visible)
                .shouldHave(attribute(
                        "content-desc",
                        "Продолжение использования этого приложения может нести в себе риск несанкционированного доступа к функциям приложения"));
        $(continueButton)
                .shouldHave(visible);
        $(sendErrorButton)
                .shouldHave(visible);
    }
}