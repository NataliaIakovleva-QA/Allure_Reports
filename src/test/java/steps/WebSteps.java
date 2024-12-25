package steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage(String url) {
        open(url);
    }

    @Step("Ищем репозиторий под названием {repo}")
    public void searchRepository(String repo) {
        $(".header-search-button").click();
        $("#query-builder-test").setValue(repo).pressEnter();
    }

    @Step("Нажимаем на ссылку найденного репозитория")
    public void clickRepoLink() {
        $("a[href=\"/NataliaIakovleva-QA/Allure_Reports\"]").click();
    }

    @Step("Нажимаем на вкладку Issues")
    public void clickIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие заголовка под названием {title}")
    public void checkTitle(String title) {
        $(".container-md").shouldHave(text(title));

    }
}
