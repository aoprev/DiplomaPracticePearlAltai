package com.diploma.practice.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;

public class SearchResultsPage {
    public SelenideElement firstSuccessItem = Selenide.$("#bx_7592");
    public SelenideElement emptyItem = Selenide.$("div.group-content.row_products");

    @Step("Wait for success search results page loaded")
    public void waitForSuccessSearchResultsPageLoaded() {
        firstSuccessItem.scrollTo();
        firstSuccessItem.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    @Step("Wait for fail search results page loaded")
    public void waitForFailSearchResultsPageLoaded() {
        emptyItem.scrollTo();
        emptyItem.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
}
