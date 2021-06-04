package tests;

import config.ConfigHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("web")
public class CheckTheMainPageTest extends TestBase{

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Send test message")
    void sendTestMessage() {

        step("Open main page of the site mail.ru", () -> mainPage.OpenMainPage());

        step("Fill mail.ru auth form", () -> {
                mainPage.login(ConfigHelper.getWebSenderLogin(),
                        ConfigHelper.getWebSenderPassword());
            });

        step("Send test message", () -> {
            mainPage. sendTestMessage("receiver-test-qa@mail.ru", "Тест", "Тест отправки");
        });



    }

}
