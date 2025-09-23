package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FuelStationsMapPage {
    protected SelenideElement heading = $("h1"),
            fuelStationMap = $(".fuel-station-map");

    protected String headingText = "Карта АЗС. Найдите ближайшую заправку на карте";

    public FuelStationsMapPage h1Checking() {
        heading.shouldHave(text(headingText));
        return this;
    }

    public FuelStationsMapPage checkingThatMapIsVisible() {
        fuelStationMap.shouldBe(visible);
        return this;
    }
}
