package tests;

import org.testng.annotations.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.page;

public class DemoTests extends BaseTest {

    @Test(description =
            "КОГДА запускаем приложение на эмуляторе " +
            "ТОГДА отображаеся страница 'Политика безопасности'")
    public void securityPageTest() {
        SecurityPolicyPage securityPolicyPage = page(SecurityPolicyPage.class);
        securityPolicyPage.assertSecurityPolicyPageOpened();
    }

    @Test(description =
            "КОГДА на странице 'Политика безопасности' нажимаем 'Пропустить' " +
            "ТОГДА отображаеся страница 'Вход по номеру телефона'")
    public void loginPageTest() {
        SecurityPolicyPage securityPolicyPage = page(SecurityPolicyPage.class);
        securityPolicyPage.goToLoginPage();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.assertLoginPageOpened();
    }

    @Test(description =
            "ДАНО страница 'Вход по номеру телефона' " +
            "КОГДА вводим корректный номер и принимаем условия универсального банковского обслуживания" +
            "ТОГДА кнопка 'Войти' активна")
    public void entranceButtonTest() {
        String validPhone = "9211234567";

        SecurityPolicyPage securityPolicyPage = page(SecurityPolicyPage.class);
        securityPolicyPage.goToLoginPage();

        LoginPage loginPage = page(LoginPage.class);
        loginPage
                .typePhone(validPhone)
                .setTermsOfServiceCheckBox(false)
                .assertEntranceButtonEnabled();
    }

    @Test(description =
            "КОГДА на странице 'Вход в приложение' нажимаем 'Курсы валют' " +
            "ТОГДА отображаеся страница 'Курсы валют'")
    public void currenciesPageTest() {
        SecurityPolicyPage securityPolicyPage = page(SecurityPolicyPage.class);
        securityPolicyPage.goToLoginPage();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.goToCurrenciesPage();

        CurrenciesPage currenciesPage = page(CurrenciesPage.class);
        currenciesPage.assertCurrenciesPageOpened();
    }

    @Test(description =
            "КОГДА на странице 'Вход в приложение' нажимаем 'Адреса отделений' " +
            "ТОГДА отображаеся страница 'Отделения и банкоматы'")
    public void officeAndAtmsPageTest() {
        SecurityPolicyPage securityPolicyPage = page(SecurityPolicyPage.class);
        securityPolicyPage.goToLoginPage();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.goToOfficeAndAtmsPage();

        OfficeAndAtmsPage officeAndAtmsPage = page(OfficeAndAtmsPage.class);
        officeAndAtmsPage.assertOfficeAndAtmsPage();
    }
}