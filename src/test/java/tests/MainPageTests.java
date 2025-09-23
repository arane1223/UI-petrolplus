package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@DisplayName("UI тесты для главной страницы petrolplus")
public class MainPageTests extends TestBase{

    @DisplayName("После клика на кнопку «Оставить заявку» происходит скроллинг к форме сбора заявок")
    @Test
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

    @DisplayName("После клика на кнопку «Личный кабинет», мы попадаем на страницу входа в личный кабинет")
    @Test
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

    @DisplayName("После клика на баннер «Самая широкая сесть АЗС» мы переходим на страницу с картой АЗС")
    @Test
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

    @DisplayName("При изменении в калькуляторе полей «Тип машин» и «Количество машин», результат меняется")
    @Test
    void whenChangeValuesInCalcThenResultChangesToo() {

        step("Открываем главную страницу и скроллим в блок с калькулятором", () -> {
            mainPage
                    .openPage()
                    .scrollToCalc();
        });

        step("Проверяем исходное значение 58 093", () -> {
            calcComponents
                    .checkingDefaultCalcResult("58 093");
        });

        step("Меняем тип машин на «Коммерческий», и проверяем, что значение изменилось на 132 270", () -> {
            calcComponents
                    .changingCarsTypeAndCheckCalkResult("Коммерческий", "132 270");
        });

        step("Меняем количество машин на «2-5», и проверяем, что значение изменилось на 138 752", () -> {
            calcComponents
                    .changingCarsCountAndCheckResult("2-5", "138 752");
        });
    }

    @DisplayName("Если убрать все галочки в калькуляторе, то результат будет 0")
    @Test
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

    @DisplayName("При нажатии в калькуляторе на кнопку «Хочу так» происходит скроллинг к форме сбора заявок")
    @Test
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
