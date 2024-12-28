package com.diploma.practice.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.sleep;

public class CartPage {
    public SelenideElement goToCartLink = Selenide.$("a[href='/cart']");
    public SelenideElement addedProductIcon = Selenide.$("#item_7858");

    @Step("Open the cart page")
    public void openTheCartPage(){
        sleep(7000);
        Selenide.executeJavaScript("document.querySelector(\"a[href='/cart']\").style.display = 'block';");
        Selenide.executeJavaScript("document.querySelector(\"a[href='/cart']\").style.visibility = 'visible';");
        Selenide.executeJavaScript("document.querySelector(\"a[href='/cart']\").style.opacity = '1';");

        if(goToCartLink.getCssValue("display").equals("block")) {
            Selenide.executeJavaScript("document.querySelector(\"a[href='/cart']\").click();");
        }
        else{
            System.out.println(goToCartLink.getCssValue("display"));
            System.out.println(goToCartLink.getCssValue("visibility"));
            System.out.println(goToCartLink.getCssValue("opacity"));
        }
    }

    @Step("Wait added to the cart product")
    public void waitAddedProductIcon(){
        addedProductIcon.shouldBe(Condition.visible, Duration.ofSeconds(8));
    }
}
