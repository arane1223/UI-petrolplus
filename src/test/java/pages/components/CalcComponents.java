package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalcComponents {

    protected SelenideElement
            eCalcResult = $("#e-calc-total"),
            eCalk = $("#e-calc"),
            carsType = $("#cars-type"),
            carsCount = $("#cars-count"),
            eCalcSubmitButton = $(".e-calc__submit");

    protected List<String> services = List.of(
            "Топливо", "Мойки", "Ремонт и ТО", "Шиномонтаж", "Штрафы",
            "Парковки", "Платные дороги", "ОСАГО", "КАСКО");

    @Step("Меняем тип машин")
    public  CalcComponents changingCarsType(String carsTypeValue) {
        carsType.click();
        $(byText(carsTypeValue)).click();
        return this;
    }

    @Step("Меняем количество машин")
    public CalcComponents changingCarsCount(String carsCountValue) {
        carsCount.click();
        $(byText(carsCountValue)).click();
        return this;
    }

    @Step("Снимаем галочки со всех типов услуг")
    public CalcComponents removingAllCheckmarks() {
        for (String service : services) {
            eCalk.$(byText(service)).click();
        }
        return this;
    }

    @Step("Проверяем результат в калькуляторе")
    public CalcComponents checkingCalcResults (String result) {
        eCalcResult.shouldHave(text(result));
        return this;
    }

    @Step("Жмем на кнопку «Хочу так»")
    public CalcComponents clickOnCalcSubmit() {
        eCalcSubmitButton.click();
        return this;
    }
}
