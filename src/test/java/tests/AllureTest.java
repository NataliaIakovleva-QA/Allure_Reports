package tests;

import org.junit.jupiter.api.Test;
import steps.WebSteps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AllureTest extends TestBase {
    WebSteps steps = new WebSteps();

    @Test
    void selenideTest() {

        open("https://github.com/");
        $(".header-search-button").click();
        $("#query-builder-test").setValue("NataliaIakovleva-QA/Allure_Reports").pressEnter();
        $("a[href=\"/NataliaIakovleva-QA/Allure_Reports\"]").click();
        $("#issues-tab").click();
        $(".container-md").shouldHave(text("Welcome to issues!"));
    }

    @Test
    void lambdaTest() {

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий под названием " + REPOSITORY, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").setValue("NataliaIakovleva-QA/Allure_Reports").pressEnter();
        });
        step("Нажимаем на ссылку найденного репозитория" + REPOSITORY, () -> {
            $("a[href=\"/NataliaIakovleva-QA/Allure_Reports\"]").click();
        });
        step("Нажимаем на вкладку Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие заголовка под названием " + TITLE, () -> {
            $(".container-md").shouldHave(text("Welcome to issues!"));
        });

    }

    @Test
    void stepTest() {
        steps.openMainPage(baseUrl);
        steps.searchRepository(REPOSITORY);
        steps.clickRepoLink();
        steps.clickIssuesTab();
        steps.checkTitle(TITLE);

    }
}
