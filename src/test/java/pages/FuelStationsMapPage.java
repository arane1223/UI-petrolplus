package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FuelStationsMapPage {
    protected SelenideElement heading = $("h1"),
            fuelStationMap = $(".fuel-station-map");

    protected String headingText = "Карта АЗС. Найдите ближайшую заправку на карте";

    @Step("Проверяем заголовок")
    public FuelStationsMapPage h1Checking() {
        heading.shouldHave(text(headingText));
        return this;
    }

    @Step("Проверяем видимость карты с АЗС")
    public FuelStationsMapPage checkingThatMapIsVisible() {
        fuelStationMap.shouldBe(visible);
        return this;
    }
}
