package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("mainPage")
@Owner("sergeyglukhov")
@DisplayName("UI тесты для главной страницы petrolplus")
public class MainPageTests extends TestBase {

    @Test
    @Feature("Действия на главной странице")
    @Story("Нажатие на кнопку «Оставить заявку»")
    @Link(value = "MainPage", url = "https://www.petrolplus.ru/")
    @DisplayName("После клика на кнопку «Оставить заявку» происходит скроллинг к форме сбора заявок")
    void whenClickButtonSubmitApplicationThenScrollToApplicationForm() {

        mainPage
                .openPage()
                .clickOnTopButton()
                .checkAppForm();
    }

    @Test
    @Feature("Действия на главной странице")
    @Story("Переход в «Личный кабинет»")
    @Link(value = "MainPage", url = "https://www.petrolplus.ru/")
    @DisplayName("После клика на кнопку «Личный кабинет», мы попадаем на страницу входа в личный кабинет")
    void whenWeClickButtonPersonalAccountThenGoToLoginPageInNewWindow() {

        mainPage.openPage()
                .clickOnPersonalAccountButton()
                .switchWindow();

        loginPage
                .h1Checking()
                .fieldsVisibleChecking();
    }

    @Test
    @Feature("Действия на главной странице")
    @Story("Переход на карту АЗС")
    @Link(value = "MainPage", url = "https://www.petrolplus.ru/")
    @DisplayName("После клика на баннер «Самая широкая сесть АЗС» мы переходим на страницу с картой АЗС")
    void whenClickOnFuelStationsBannerThenGoToFuelStationsMap() {

        mainPage
                .openPage()
                .clickOnIntroBanner();

        fuelStationsMapPage
                .h1Checking()
                .checkingThatMapIsVisible();
    }

    @Test
    @Tag("calc")
    @Feature("Блок с калькулятором")
    @Story("Изменение полей «Тип машин» и «Количество машин»")
    @Link(value = "MainPage", url = "https://www.petrolplus.ru/")
    @DisplayName("При изменении в калькуляторе полей «Тип машин» и «Количество машин», результат меняется")
    void whenChangeValuesInCalcThenResultChangesToo() {

        mainPage
                .openPage()
                .scrollToCalc();


        calcComponents
                .checkingCalcResults("58,093")
                .changingCarsType("Коммерческий")
                .checkingCalcResults("132,270")
                .changingCarsCount("2-5")
                .checkingCalcResults("138,752");
    }

    @Test
    @Tag("calc")
    @Feature("Блок с калькулятором")
    @Story("Изменение результата с изменением галочек")
    @Link(value = "MainPage", url = "https://www.petrolplus.ru/")
    @DisplayName("Если убрать все галочки в калькуляторе, то результат будет 0")
    void whenDeleteAllTypesOfServicesInCalcThenResultShouldBe0() {

        mainPage
                .openPage()
                .scrollToCalc();

        calcComponents
                .removingAllCheckmarks()
                .checkingCalcResults("0");
    }

    @Test
    @Tag("calc")
    @Feature("Блок с калькулятором")
    @Story("Нажатие на кнопку «Хочу так»")
    @Link(value = "MainPage", url = "https://www.petrolplus.ru/")
    @DisplayName("При нажатии в калькуляторе на кнопку «Хочу так» происходит скроллинг к форме сбора заявок")
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
