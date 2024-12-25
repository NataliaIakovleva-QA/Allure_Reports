package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelTest {
    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("NataliaIakovleva")
    @Severity(SeverityLevel.CRITICAL)
    @Link (value = "Testing", url = "https://testing.github.com")
    @DisplayName("Создание Issue для авторизованного пользователя")

    public void testStaticLabels() {

    }

    @Test
    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Создание Issue для авторизованного пользователя")
        );
        Allure.feature("Issue в репозитории");
        Allure.story("Создание Issue");
        Allure.label("owner", "eroshenkoam");
        Allure.label("severity", SeverityLevel.BLOCKER.value());
        Allure.link("Testing", "https://testing.github.com");
    }
}
