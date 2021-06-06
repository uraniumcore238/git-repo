package tests;

import config.ConfigHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import static io.qameta.allure.Allure.step;

@Tag("web")
public class MailingTest extends TestBase {

    MainPage mainPage = new MainPage();
    String receiverEmail = ConfigHelper.getWebReceiverLogin()+"@mail.ru";

    @Test
    @DisplayName("Send test message")
    void sendTestMessage() {

        step("Open main page of the site mail.ru", () -> mainPage.openMainPage());

        step("Login as sender", () -> {
                mainPage.login(ConfigHelper.getWebSenderLogin(),
                        ConfigHelper.getWebSenderPassword());
            });

        step("Send test message", () -> {
            mainPage. sendTestMessage(receiverEmail, "Тест", "Тест отправки");
        });
    }

    @Test
    @DisplayName("Check test message")
    void checkTestMessage() {

        step("Open main page of the site mail.ru", () -> mainPage.openMainPage());

        step("Login as receiver", () -> {
            mainPage.login(ConfigHelper.getWebReceiverLogin(),
                    ConfigHelper.getWebReceiverPassword());
        });

        step("Check test message", () -> {
            mainPage.checkTestMessage("Тест отправки");
        });


    }

}
