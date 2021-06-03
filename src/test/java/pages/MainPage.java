package pages;

import com.codeborne.selenide.Configuration;
import config.ConfigHelper;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainPage {

    private final static SelenideElement
            loginInputField = $("input[name='login']"),
            inputPasswordBtn = $("button[data-testid='enter-password']"),
            passwordInputField = $("input[name='password']"),
            loginToMailBtn = $("button[data-testid='login-to-mail']"),
            inboxBtn = $("a[href='/inbox/']");

    public void OpenMainPage() {
        step("Open main page", () -> open(""));
        step("Open main page mail.ru website", () -> {
            $("a[href='//mail.ru']").shouldBe(visible);
        });

    }

    @Step("Authorization on mail.ru website")
    public void login(String username, String password) {
        loginInputField.setValue(username);
        inputPasswordBtn.click();
        passwordInputField.setValue(password);
        loginToMailBtn.click();
        inboxBtn.shouldBe(visible);
    }



}
