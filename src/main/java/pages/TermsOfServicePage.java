package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class TermsOfServicePage {

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Поделиться']/preceding-sibling::android.widget.ImageView[@index=0]")
    private WebElement backButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Поделиться']/preceding-sibling::android.widget.ImageView[@index=2]")
    private WebElement downloadButton;

    @AndroidFindBy(accessibility = "Поделиться")
    private WebElement shareButton;

    public void assertTermsOfServicePageOpened() {
        $(backButton)
                .shouldHave(visible);
        $(downloadButton)
                .shouldHave(visible);
        $(shareButton)
                .shouldHave(visible);
    }
}
