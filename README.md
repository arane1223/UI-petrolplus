# Тестовый проект по автоматизации UI тестирования на petrolplus.ru
<a href="https://www.petrolplus.ru/"><img width="50%" title="DEMOQA" src="https://www.petrolplus.ru/assets/47e3d030-1ac8-48ad-85fe-facdd41c087e/logo-white.svg"></a>

## :point_up: Структура:

- <a href="#point_up_2-технологии-и-инструменты">Стек</a>
- <a href="#point_up_2-проведенные автотесты">Проведенные автотесты</a>
- <a href="#point_up_2-сборка-в-Jenkins">Сборка в Jenkins</a>
- <a href="#point_up_2-запуск-из-терминала">Запуск из терминала</a>
- <a href="#point_up_2-allure-отчет">Allure отчет</a>
- <a href="#point_up_2-интеграция-с-allure-testops">Интеграция с Allure TestOps</a>
- <a href="#point_up_2-интеграция-с-jira">Интеграция с Jira</a>
- <a href="#point_up_2-отчет-в-telegram">Отчет в Telegram</a>
- <a href="#point_up_2-видео-примеры-прохождения-тестов">Видео примеры прохождения тестов</a>

## :point_up_2: Стек
<p align="center">
<img src="images/icons/Java.svg" width="50" />
<img src="images/icons/Intelij_IDEA.svg" width="50" />
<img src="images/icons/GitHub.svg" width="50" />
<img src="images/icons/JUnit5.svg" width="50" />
<img src="images/icons/Selenide.svg" width="50" />
<img src="images/icons/Selenoid.svg" width="50" />
<img src="images/icons/Gradle.svg" width="50" />
<img src="images/icons/Jenkins.svg" width="50" />
<img src="images/icons/Allure_Report.svg" width="50" />
<img src="images/icons/AllureTestOps.svg" width="50" />
<img src="images/icons/Telegram.svg" width="50" />
<img src="images/icons/Jira.svg" width="50" />
</p>


## :point_up_2: Проведенные автотесты
- На функционала кнопки «Личный кабинет»
- На функционал кнопки «Оставить заявку»
- Переход на карту АЗС
- Тест функционала калькулятора:
  - Изменение полей «Типа машин» и «Количество машин»
  - Изменение Вида услуг
  - Нажатие на кнопку «Хочу так»

## :point_up_2: Сборка в Jenkins
[**Сборка в Jenkins**](https://jenkins.autotests.cloud/job/UI-petrolplus/)
<p>
<img title="Jenkins Dashboard" src="images/screenshots/jenkins-project.png">
</p>

### Параметры сборки в Jenkins:
Сборка в Jenkins

- baseUrl(по умолчанию https://www.petrolplus.ru/)
- task (выбор групп тестов)
- webDriverHost (адрес удаленного сервера selenoid)
- browser (браузер, по умолчанию chrome)
- browserVersion (версия браузера, по умолчанию 127)
- browserSize (размер окна браузера, по умолчанию 1920x1080)

## :point_up_2: Запуск из терминала
Локальный запуск:
```
gradle clean mainPage
```
Удаленный запуск:
```
clean 
${TASK} 
-DbaseUrl=${BASE_URL}
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE} 
-DwebDriverHost=${WEB_DRIVER_HOST}
```

## :point_up_2: Allure отчет

[Allure отчет](https://jenkins.autotests.cloud/job/UI-petrolplus/allure/)

- ### Главный экран отчета
<p>
<img title="Allure report" src="images/screenshots/allure-report.png">
</p>

- ### Страница с проведенными тестами
<p>
<img title="Allure report suites" src="images/screenshots/allure-report-suites.png">
</p>

## :point_up_2: Интеграция с Allure TestOps

[Проект в Allure TestOps](https://allure.autotests.cloud/project/4926/dashboards)

- ### Экран с результатами запуска тестов
<p>
<img title="Allure TestOps" src="images/screenshots/allure-test-ops-lounchs.png">
</p>

- ### Экран с дашбордами, включающие ручные и автотесты
<p>
<img title="Allure TestOps" src="images/screenshots/allure-test-ops.png">
</p>

- ### Страница с ручными и автотестами в TestOps
<p>
<img title="Allure test cases" src="images/screenshots/allure-test-ops-tests.png">
</p>

## :point_up_2: Интеграция с Jira

[Задача в Jira](https://jira.autotests.cloud/browse/HOMEWORK-1500)

- ### Страница с задачей в Jira
<p>
<img title="Jira task description" src="images/screenshots/jira-task.png">
<img title="Jira test-cases" src="images/screenshots/jira-allure-test-case.png">
<img title="Jira test launches" src="images/screenshots/jira-allure-launches.png">
</p>

## :point_up_2: Отчет в Telegram
<p>
<img title="Telegram" src="images/screenshots/Telegram.png">
</p>

## :point_up_2: Видео примеры прохождения тестов
> К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже.
<p>
  <img title="Selenoid Video" src="images/gif/selenoid.gif">
</p>