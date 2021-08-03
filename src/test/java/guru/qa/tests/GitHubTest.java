package guru.qa.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

public class GitHubTest {

    private static final String REPOSITORY_NAME = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "68";

    private final GitHubSteps gitHubSteps = new GitHubSteps();

    @Test
    @Feature("Issues")
    @Story("Поиск по Issue")
    @Owner("dpchelintsevv")
    @Severity(SeverityLevel.BLOCKER)
    @Description(
            "Тест проверяет наличие задачи "+ ISSUE_NUMBER +
                    " в репозитории " + REPOSITORY_NAME
    )
    void checkIssueExist() {
        gitHubSteps.openMainPage()
                .lookForRepository(REPOSITORY_NAME)
                .openRepository(REPOSITORY_NAME)
                .goToIssues()
                .checkIssueExist(ISSUE_NUMBER);
    }
}
