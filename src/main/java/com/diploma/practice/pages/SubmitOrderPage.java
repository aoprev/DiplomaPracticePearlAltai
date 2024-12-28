package com.diploma.practice.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

public class SubmitOrderPage {
    public SelenideElement checkoutDescriptionArea = Selenide.$("#checkout_description");

    @Step("Waiting for submit order page opened")
    public void waitSubmitOrderPageLoaded(){
        checkoutDescriptionArea.shouldBe(Condition.visible, Duration.ofSeconds(8));
    }

}
