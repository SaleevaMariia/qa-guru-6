package guru.qa.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {
    private static final String REPOSITORY_NAME = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "68";

    @Test
    @Feature("Issues")
    @Story("Поиск по Issue")
    @Owner("dpchelintsevv")
    @Severity(SeverityLevel.BLOCKER)
    @Description(
            "Тест проверяет наличие задачи "+ ISSUE_NUMBER +
                    " в репозитории " + REPOSITORY_NAME
    )
    void testRepositoryIssue() {
        step("Open main page", () -> {
            open("https://github.com");
        });
        step("Look for repository", ()-> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY_NAME);
            $(".header-search-input").submit();
        });
        step("Open repository", () -> {
            $(linkText(REPOSITORY_NAME)).click();
        });
        step("Go to issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Check issue exist with number " + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).should(exist);
        });
    }
}
