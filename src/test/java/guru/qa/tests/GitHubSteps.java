package guru.qa.tests;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class GitHubSteps {

    @Step("Open main page")
    public GitHubSteps openMainPage(){
        open("https://github.com");
        return this;
    }

    @Step("Look for repository [{repository}]")
    public GitHubSteps lookForRepository(String repository){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
        return this;
    }

    @Step("Open repository [{repository}]")
    public GitHubSteps openRepository(String repository){
        $(linkText(repository)).click();
        return this;
    }

    @Step("Go to issues")
    public GitHubSteps goToIssues(){
        $(partialLinkText("Issues")).click();
        return this;
    }

    @Step("Check issue exist with number [{issue}]")
    public void checkIssueExist(String issue){
        $(withText("#" + issue)).should(exist);
    }
}
