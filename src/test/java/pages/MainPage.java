package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainPage {

    public void OpenMainPage() {
        step("Open main page", () -> open(""));

        step("Open main page of mail.ru", () -> {
            $("a[href='//mail.ru'] span").shouldHave(text("Mail.ru"));
        });

    }


}
