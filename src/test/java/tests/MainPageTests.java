package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tag("mainPage")
@Owner("sergeyglukhov")
@DisplayName("UI тесты для главной страницы petrolplus")
public class MainPageTests extends TestBase{

    @Test
    @Feature("Действия на главной странице")
    @Story("Нажатие на кнопку «Оставить заявку»")
    @Link(value = "MainPage", url = "https://www.petrolplus.ru/")
    @DisplayName("После клика на кнопку «Оставить заявку» происходит скроллинг к форме сбора заявок")
    void whenClickButtonSubmitApplicationThenScrollToApplicationForm() {

        step("Открываем главную страницу", () -> {
            mainPage
                    .openPage();
        });

        step("Жмем на кнопку «Оставить заявку» в верхнем левом углу экрана", () -> {
            mainPage
                    .clickOnTopButton();
        });

        step("Проверяем, что проскроллило к форме сбора заявок", () -> {
            mainPage
                    .checkAppForm();
        });
    }

    @Test
    @Feature("Действия на главной странице")
    @Story("Переход в «Личный кабинет»")
    @Link(value = "MainPage", url = "https://www.petrolplus.ru/")
    @DisplayName("После клика на кнопку «Личный кабинет», мы попадаем на страницу входа в личный кабинет")
    void whenWeClickButtonPersonalAccountThenGoToLoginPageInNewWindow() {

        step("Открываем главную страницу и жмем на кнопку «Личный кабинет»", () -> {
            mainPage.openPage()
                    .clickOnPersonalAccountButton();
        });

        step("Переходим на новую вкладку", () -> {
            Selenide.switchTo().window(1);
        });

        step("Проверяем что зашли в личный кабинет, видим форму для авторизации", () -> {
            loginPage
                    .h1Checking()
                    .fieldsVisibleChecking();
        });
    }

    @Test
    @Feature("Действия на главной странице")
    @Story("Переход на карту АЗС")
    @Link(value = "MainPage", url = "https://www.petrolplus.ru/")
    @DisplayName("После клика на баннер «Самая широкая сесть АЗС» мы переходим на страницу с картой АЗС")
    void whenClickOnFuelStationsBannerThenGoToFuelStationsMap() {

        step("Открываем страницу и жмем на баннер «Самая широкая сесть АЗС»", () -> {
            mainPage
                    .openPage()
                    .clickOnIntroBanner();
        });

        step("Проверяем, что перешли на страницу с картой АЗС, карта видима", () -> {
            fuelStationsMapPage
                    .h1Checking()
                    .checkingThatMapIsVisible();
        });
    }

    @Test
    @Tag("calc")
    @Feature("Блок с калькулятором")
    @Story("Изменение полей «Тип машин» и «Количество машин»")
    @Link(value = "MainPage", url = "https://www.petrolplus.ru/")
    @DisplayName("При изменении в калькуляторе полей «Тип машин» и «Количество машин», результат меняется")
    void whenChangeValuesInCalcThenResultChangesToo() {

        step("Открываем главную страницу и скроллим в блок с калькулятором", () -> {
            mainPage
                    .openPage()
                    .scrollToCalc();
        });

        step("Проверяем исходное значение 58 093", () -> {
            calcComponents
                    .checkingDefaultCalcResult("58,093");
        });

        step("Меняем тип машин на «Коммерческий», и проверяем, что значение изменилось на 132 270", () -> {
            calcComponents
                    .changingCarsTypeAndCheckCalkResult("Коммерческий", "132,270");
        });

        step("Меняем количество машин на «2-5», и проверяем, что значение изменилось на 138 752", () -> {
            calcComponents
                    .changingCarsCountAndCheckResult("2-5", "138,752");
        });
    }

    @Test
    @Tag("calc")
    @Feature("Блок с калькулятором")
    @Story("Изменение результата с изменением галочек")
    @Link(value = "MainPage", url = "https://www.petrolplus.ru/")
    @DisplayName("Если убрать все галочки в калькуляторе, то результат будет 0")
    void whenDeleteAllTypesOfServicesInCalcThenResultShouldBe0() {

        step("Открываем главную страницу и скроллим в блок с калькулятором", () -> {
            mainPage
                    .openPage()
                    .scrollToCalc();
        });

        step("Убираем галочки со всех значений, и проверяем, что рузельтат получился 0", () -> {
            calcComponents.removingAllCheckmarks()
                    .checkingCalcResults("0");
        });
    }

    @Test
    @Tag("calc")
    @Feature("Блок с калькулятором")
    @Story("Нажатие на кнопку «Хочу так»")
    @Link(value = "MainPage", url = "https://www.petrolplus.ru/")
    @DisplayName("При нажатии в калькуляторе на кнопку «Хочу так» происходит скроллинг к форме сбора заявок")
    void whenClickButtonWantSoInCalcThenScrollToApplicationForm() {

        step("Открываем главную страницу и скроллим в блок с калькулятором", () -> {
            mainPage
                    .openPage()
                    .scrollToCalc();
        });

        step("Жмем на кнопку «Хочу так»", () -> {
            calcComponents
                    .clickOnCalcSubmit();
        });

        step("Проверяем, что проскроллило к форме сбора заявок", () -> {
            mainPage
                    .checkAppForm();
        });
    }
}
