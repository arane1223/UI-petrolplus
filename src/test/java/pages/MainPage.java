package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalcComponents;

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

    CalcComponents calcComponents = new CalcComponents();

    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage clickOnTopButton() {
        topButton.click();
        return this;
    }

    public MainPage checkAppForm() {
        appForm.shouldBe(visible);
        appForm.shouldHave(text(appFormHeadingText));
        return this;
    }

    public MainPage clickOnPersonalAccountButton() {
        personalAccountButton.click();
        return this;
    }

    public MainPage clickOnIntroBanner() {
        introBanners.$(byText(introBannerFuelStationMapText)).click();
        return this;
    }

    public MainPage scrollToCalc() {
        eCalc.scrollTo();
        return this;
    }
}
