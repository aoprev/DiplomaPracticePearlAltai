package com.diploma.practice.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.sleep;

public class SubmitOrderPage {
    public SelenideElement checkoutDescriptionArea = Selenide.$("#checkout_description");
    public SelenideElement confirmOrderButton = Selenide.$("button.btn.btn-primary[type='submit']");
    public SelenideElement personalDataFieldset = Selenide.$("div.col-md-6 fieldset legend");
    public SelenideElement goToCartLink = Selenide.$("a[href='/cart']");
    public SelenideElement cartButton = Selenide.$("#shoping-cart");

    @Step("Waiting for submit order page opened")
    public void waitSubmitOrderPageLoaded(){
        checkoutDescriptionArea.shouldBe(Condition.visible, Duration.ofSeconds(8));
        personalDataFieldset.shouldBe(Condition.visible, Duration.ofSeconds(8));
        confirmOrderButton.scrollTo();
        confirmOrderButton.shouldBe(Condition.visible, Duration.ofSeconds(8));
    }

    @Step("Scroll to and open the cart modal")
    public void scrollToAndOpenTheCartModal(){
        cartButton.click();
    }

    @Step("Return to the cart")
    public void returnToTheCart(){
        sleep(4000);
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
}
