package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    protected SelenideElement
            topButton = $(".top-button"),
            appForm = $("#appForm"),
            personalAccountButton = $(".account-menu-head"),
            introBanners = $(".intro-banners"),
            eCalc = $("#e-calc");

    protected String
            appFormHeadingText = "Ответим на все вопросы и подберём услуги",
            introBannerFuelStationMapText = "Самая широкая сеть АЗС";

    @Step("Открыли главную страницу ")
    public MainPage openPage() {
        open("/");
        return this;
    }

    @Step("Кликаем на кнопку «Оставить заявку»")
    public MainPage clickOnTopButton() {
        topButton.click();
        return this;
    }

    @Step("Проверяем, что видно форму сбора заявок и заголовок")
    public MainPage checkAppForm() {
        appForm.shouldBe(visible);
        appForm.shouldHave(text(appFormHeadingText));
        return this;
    }

    @Step("Жмем на кнопку «Личный кабинет»")
    public MainPage clickOnPersonalAccountButton() {
        personalAccountButton.click();
        return this;
    }

    @Step("Переходим на новую вкладку")
    public MainPage switchWindow() {
        Selenide.switchTo().window(1);
        return this;
    }

    @Step("Жмем на баннер «Самая широкая сеть АЗС»")
    public MainPage clickOnIntroBanner() {
        introBanners.$(byText(introBannerFuelStationMapText)).click();
        return this;
    }

    @Step("Скроллим до блока с калькулятором")
    public MainPage scrollToCalc() {
        eCalc.scrollTo();
        return this;
    }
}
