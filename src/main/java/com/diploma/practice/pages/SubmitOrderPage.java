package com.diploma.practice.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

public class SubmitOrderPage {
    public SelenideElement checkoutDescriptionArea = Selenide.$("#checkout_description");
    public SelenideElement confirmOrderButton = Selenide.$("button.btn.btn-primary[type='submit']");
    SelenideElement personalDataFieldset = Selenide.$("div.col-md-6 fieldset legend");

    @Step("Waiting for submit order page opened")
    public void waitSubmitOrderPageLoaded(){
        checkoutDescriptionArea.shouldBe(Condition.visible, Duration.ofSeconds(8));
        personalDataFieldset.shouldBe(Condition.visible, Duration.ofSeconds(8));
        confirmOrderButton.scrollTo();
        confirmOrderButton.shouldBe(Condition.visible, Duration.ofSeconds(8));
    }

}
