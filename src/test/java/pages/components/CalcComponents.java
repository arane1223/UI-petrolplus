package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalcComponents {

    protected SelenideElement
            eCalcResult = $("#e-calc-total"),
            carsType = $("#cars-type"),
            carsCount = $("#cars-count"),
            eCalcSubmitButton = $(".e-calc__submit");

    public CalcComponents checkingDefaultCalcResult(String defaultResult) {
        eCalcResult.shouldHave(text(defaultResult));
        return this;
    }

    public  CalcComponents changingCarsTypeAndCheckCalkResult(String carsTypeValue, String result) {
        carsType.click();
        $(byText(carsTypeValue)).click();
        checkingCalcResults(result);
        return this;
    }

    public CalcComponents changingCarsCountAndCheckResult(String carsCountValue, String result) {
        carsCount.click();
        $(byText(carsCountValue)).click();
        checkingCalcResults(result);
        return this;
    }

    public CalcComponents removingAllCheckmarks() {
        $(byText("Топливо")).click();
        $(byText("Мойки")).click();
        $(byText("Ремонт и ТО")).click();
        $(byText("Шиномонтаж")).click();
        $(byText("Штрафы")).click();
        $(byText("Парковки")).click();
        $(byText("Платные дороги")).click();
        $("#e-calc").$(byText("ОСАГО")).click();
        $("#e-calc").$(byText("КАСКО")).click();
        return this;
    }

    public CalcComponents checkingCalcResults (String result) {
        eCalcResult.shouldHave(text(result));
        return this;
    }

    public CalcComponents clickOnCalcSubmit() {
        eCalcSubmitButton.click();
        return this;
    }
}
