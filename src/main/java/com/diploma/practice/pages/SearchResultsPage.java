package com.diploma.practice.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;

public class SearchResultsPage {
    public SelenideElement searchItem= Selenide.$("[data-widget='searchResultsError'] .aa0g_33");
    public SelenideElement firstSearchItem= Selenide.$("div[data-index='0']");
    public SelenideElement buyFirstItemButton = Selenide.$(".p0b08-a5.p0b08-a7.jk_23");

    @Step("Wait items loading")
    public void waitItem() {
        firstSearchItem.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    @Step("Add first item to the cart")
    public void addItemToTheCart() {
        buyFirstItemButton.shouldBe(Condition.visible, Duration.ofSeconds(10));
        buyFirstItemButton.click();
    }
}


