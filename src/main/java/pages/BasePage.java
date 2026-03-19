import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class BasePage {

    @AndroidFindBy(accessibility = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private WebElement whileUsingAppButton;

    public BasePage acceptLocationAlert() {
        if ($(whileUsingAppButton).is(visible)) {
            $(whileUsingAppButton).click();
        }
        return this;
    }
}
