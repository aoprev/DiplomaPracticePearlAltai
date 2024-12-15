package com.diploma.practice.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.sleep;

public class CartPage {
    public SelenideElement cartButton = Selenide.$("a[data-widget=\"headerIcon\"][href=\"/cart\"]");
    public SelenideElement bookElement = Selenide.$("input[type=\"checkbox\"].a4012-a2");
    public SelenideElement placeOrderButton = Selenide.$("div.b2121-a[style*='background-color:#ffffff']");

    @Step("Open cart")
    public void openCart() {
        sleep(8000);
        cartButton.shouldBe(Condition.exist, Duration.ofSeconds(10));
        cartButton.click();
    }

    @Step("Check that the book is in the cart")
    public void checkBookPresence() {
        sleep(3000);
        bookElement.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    @Step("Click place order button")
    public void placeOrder() {
        placeOrderButton.shouldBe(Condition.hidden, Duration.ofSeconds(10));
        sleep(4000);
        placeOrderButton.click();
    }
}

