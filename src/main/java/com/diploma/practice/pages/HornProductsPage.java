package com.diploma.practice.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;

public class HornProductsPage {
    public SelenideElement firstHornProductItem = Selenide.$("#bx_7858");

    @Step("Open page of an item in the catalogue horn section")
    public void openHornItemPage(){
        firstHornProductItem.scrollTo();
        firstHornProductItem.shouldBe(Condition.visible, Duration.ofSeconds(7));
        firstHornProductItem.click();
    }
}
