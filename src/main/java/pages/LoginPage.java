package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class LoginPage {

    // Locators

    @AndroidFindBy(xpath = "//android.widget.EditText/preceding-sibling::android.widget.ImageView")
    private WebElement logoImage;

    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement phoneEditText;

    @AndroidFindBy(className = "android.widget.CheckBox")
    private WebElement termsOfServicesCheckBox;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Я принимаю')]")
    private WebElement termsOfServicesText;

    @AndroidFindBy(accessibility = "Войти")
    private WebElement entranceButton;

    @AndroidFindBy(accessibility = "Адреса отделений")
    private WebElement officeAddressesButton;

    @AndroidFindBy(accessibility = "Курсы валют")
    private WebElement currenciesButton;

    // Methods

    public LoginPage typePhone(String phone) {
        $(phoneEditText).type(phone);
        return this;
    }

    public LoginPage setTermsOfServiceCheckBox(boolean state) {
        if ($(termsOfServicesCheckBox).is(checked) != state) {
            $(phoneEditText).click();
        }
        return this;
    }

    public void goToOfficeAndAtmsPage() {
        $(officeAddressesButton).click();
    }

    public void goToCurrenciesPage() {
        $(currenciesButton).click();
    }

    // Assertions

    public void assertLoginPageOpened() {
        $(logoImage)
                .shouldHave(visible);
        $(phoneEditText)
                .shouldHave(visible);
        $(termsOfServicesCheckBox)
                .shouldHave(visible)
                .shouldHave(not(checked));
        $(termsOfServicesText)
                .shouldHave(visible)
                .shouldHave(attribute(
                        "content-desc",
                        "Я принимаю \nусловия универсального договора банковского обслуживания"));
        $(entranceButton)
                .shouldHave(visible)
                .shouldHave(not(enabled));
        $(officeAddressesButton)
                .shouldHave(visible);
        $(currenciesButton)
                .shouldHave(visible);
    }

    public void assertEntranceButtonEnabled() {
        $(entranceButton).shouldHave(enabled);
    }
}
