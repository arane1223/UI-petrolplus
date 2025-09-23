package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.FuelStationsMapPage;
import pages.LoginPage;
import pages.MainPage;
import pages.components.CalcComponents;

import java.util.Map;

public class TestBase {

    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    FuelStationsMapPage fuelStationsMapPage = new FuelStationsMapPage();
    CalcComponents calcComponents = new CalcComponents();
    static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    static void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://www.petrolplus.ru";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        String login = config.login();
        String password = config.password();
        String webDriverHost = System.getProperty("webDriverHost");
        Configuration.remote = "https://" + login + ":" + password + "@" + webDriverHost + "/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void allureSetUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttach() {
        Selenide.closeWebDriver();
    }
}
