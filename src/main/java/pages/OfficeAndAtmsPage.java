package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class OfficeAndAtmsPage {

    // Locators

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Отделения и банкоматы']/preceding-sibling::android.widget.ImageView")
    private WebElement backButton;

    @AndroidFindBy(accessibility = "Отделения и банкоматы")
    private WebElement titlePageText;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Отделения']/preceding-sibling::android.widget.ImageView")
    private WebElement filterButton;

    @AndroidFindBy(accessibility = "Отделения")
    private WebElement officesButton;

    @AndroidFindBy(accessibility = "Банкоматы")
    private WebElement atmsButton;

    @AndroidFindBy(accessibility = "Терминалы")
    private WebElement terminalsButton;

    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement findEditText;

    @AndroidFindBy(className = "android.widget.ScrollView")
    @AndroidFindBy(className = "android.view.View")
    private List<WebElement> placesList;

    // Assertions

    public void assertOfficeAndAtmsPage() {
        $(backButton)
                .shouldHave(visible)
                .shouldHave(clickable);
        $(titlePageText)
                .shouldHave(visible);
        $(filterButton)
                .shouldHave(visible)
                .shouldHave(clickable);
        $(officesButton)
                .shouldHave(visible)
                .shouldHave(clickable);
        $(atmsButton)
                .shouldHave(visible)
                .shouldHave(clickable);
        $(terminalsButton)
                .shouldHave(visible)
                .shouldHave(clickable);
        $(findEditText)
                .shouldHave(visible)
                .shouldHave(clickable);
    }
}