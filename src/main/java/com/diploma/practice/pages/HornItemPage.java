package com.diploma.practice.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

public class HornItemPage {

    public SelenideElement addItemToCartButton = Selenide.$("span.btn.btn-primary.btn-sm.add_cart[data-product='7858']");
    public SelenideElement itemDescriptionSection = Selenide.$("div.description[itemprop='description']");
    public SelenideElement itemPriceSection = Selenide.$("div.price");
    public SelenideElement itemImage = Selenide.$("#photo-cover");

    @Step("Check the presence of elements on the horn item page")
    public void waitPresenceOfItemElements(){
        addItemToCartButton.shouldBe(Condition.visible, Duration.ofSeconds(8));
        itemDescriptionSection.shouldBe(Condition.visible, Duration.ofSeconds(8));
        itemPriceSection.shouldBe(Condition.visible, Duration.ofSeconds(8));
        itemImage.shouldBe(Condition.visible, Duration.ofSeconds(8));
    }
}
