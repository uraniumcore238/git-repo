package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPage {

    private final static SelenideElement
        loginInputField = $("input[name='login']"),
        inputPasswordBtn = $("button[data-testid='enter-password']"),
        passwordInputField = $("input[name='password']"),
        loginToMailBtn = $("button[data-testid='login-to-mail']"),
        inboxBtn = $("a[href='/inbox/']"),
        sendMessageBtn = $("a[href='/compose/']"),
        inputEmailField = $("div[class='contacts--1ofjA'] input"),
        inputThemeField = $("input[name='Subject']"),
        inputMessageField = $("div[contenteditable ='true']"),
        themeField = $x("//span/span[text()='Тест']"),
        letterBody = $(".letter__body");

    @Step("Open main page")
    public void openMainPage() {
        step("Open main page mail.ru website", () -> open(""));
        step("Confirm that website is opened", () -> {
            $("a[href='//mail.ru']").shouldBe(visible);
        });

    }

    @Step("Authorization on mail.ru website")
    public void login(String username, String password) {
        step("Enter login", () -> { loginInputField.setValue(username);
            inputPasswordBtn.click();
        });

        step("Enter password", () -> { passwordInputField.setValue(password);
            loginToMailBtn.click();
        });

        step("Confirm user authorization", () -> inboxBtn.shouldBe(visible));
    }

    @Step("Send test message")
    public void sendTestMessage(String receiverEmail, String theme, String message) {
        step("Open sending form, fill email, theme and message", () -> { sendMessageBtn.click();
            inputEmailField.sendKeys(receiverEmail);
            inputThemeField.sendKeys(theme);
            inputMessageField.sendKeys(message);
        });

        step("Send the message", () -> inputMessageField.sendKeys(Keys.CONTROL, Keys.ENTER));
    }

    @Step("Check test message")
    public void checkTestMessage(String expectedText) {
        step("Open the letter and check the information in it", () -> {
            themeField.click();
            letterBody.shouldHave(text(expectedText));
        });
    }
}
