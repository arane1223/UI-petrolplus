package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    protected SelenideElement
            heading = $("h1"),
            userNameField = $("#username"),
            passwordField = $("#password");

    protected String headingText = "Личный кабинет";

    public LoginPage h1Checking() {
        heading.shouldHave(text(headingText));
        return this;
    }

    public LoginPage fieldsVisibleChecking() {
        userNameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        return this;
    }
}
