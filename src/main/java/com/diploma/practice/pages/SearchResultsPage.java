package com.diploma.practice.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;

public class SearchResultsPage {
    public SelenideElement firstSuccessItem = Selenide.$("#bx_7592");

    @Step("Wait for search results page loaded")
    public void waitForSearchResultsPageLoaded() {
        firstSuccessItem.scrollTo();
        firstSuccessItem.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
}
