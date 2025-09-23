package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("UI тесты для главной страницы petrolplus")
public class MainPageTests extends TestBase{

    @DisplayName("После клика на кнопку «Оставить заявку» происходит скроллинг к форме сбора заявок")
    @Test
    void whenClickButtonSubmitApplicationThenScrollToApplicationForm() {

        mainPage
                .openPage()
                .clickOnTopButton()
                .checkAppForm();
    }

    @DisplayName("После клика на кнопку «Личный кабинет», мы попадаем на страницу входа в личный кабинет")
    @Test
    void whenWeClickButtonPersonalAccountThenGoToLoginPageInNewWindow() {

        mainPage.openPage()
                .clickOnPersonalAccountButton();

        Selenide.switchTo().window(1);

        loginPage
                .h1Checking()
                .fieldsVisibleChecking();
    }

    @DisplayName("После клика на баннер «Самая широкая сесть АЗС» мы переходим на страницу с картой АЗС")
    @Test
    void whenClickOnFuelStationsBannerThenGoToFuelStationsMap() {

        mainPage
                .openPage()
                .clickOnIntroBanner();

        fuelStationsMapPage
                .h1Checking()
                .checkingThatMapIsVisible();
    }

    @DisplayName("При изменении в калькуляторе полей «Тип машин» и «Количество машин», результат меняется")
    @Test
    void whenChangeValuesInCalcThenResultChangesToo() {

        mainPage
                .openPage()
                .scrollToCalc();

        calcComponents
                .checkingDefaultCalcResult("58 093")
                .changingCarsTypeAndCheckCalkResult("Коммерческий", "132 270")
                .changingCarsCountAndCheckResult("2-5", "138 752");
    }

    @DisplayName("Если убрать все галочки в калькуляторе, то результат будет 0")
    @Test
    void whenDeleteAllTypesOfServicesInCalcThenResultShouldBe0() {

        mainPage
                .openPage()
                .scrollToCalc();

        calcComponents.removingAllCheckmarks()
                .checkingCalcResults("0");
    }

    @DisplayName("При нажатии в калькуляторе на кнопку «Хочу так» происходит скроллинг к форме сбора заявок")
    @Test
    void whenClickButtonWantSoInCalcThenScrollToApplicationForm() {

        mainPage
                .openPage()
                .scrollToCalc();

        calcComponents
                .clickOnCalcSubmit();

        mainPage
                .checkAppForm();
    }
}
