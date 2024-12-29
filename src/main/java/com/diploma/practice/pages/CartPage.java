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
    public SelenideElement plusProductButton = Selenide.$("span.btn.btn-sm.btn-primary[onclick*=\"cart.plusProduct('7858')\"]");
    public SelenideElement minusProductButton = Selenide.$("span.btn.btn-sm.btn-primary[onclick*=\"cart.minusProduct('7858')\"]");
    public SelenideElement quantityArea = Selenide.$("input[type='text'][name='quantity\\[7858\\]'].form-control");
    public SelenideElement totalAmountArea = Selenide.$x("//div[@class='table-total']//table[@class='table']//tr//td[contains(text(),'Итого')]/following-sibling::td/strong");
    public SelenideElement submitOrderButton = Selenide.$("input[type='submit'][value='Оформить заказ']");
    public SelenideElement clearCartButton = Selenide.$("button[type='button'][title='Очистить корзину']");
    public SelenideElement emptyCartMessage = Selenide.$("#page-cart p");

    @Step("Open the cart page")
    public void openTheCartPage(){
        sleep(5000);
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
        addedProductIcon.shouldBe(Condition.visible, Duration.ofSeconds(7));
    }

    @Step("Click plus item button")
    public void clickPlusButton(){
        plusProductButton.scrollTo();
        sleep(2000);
        plusProductButton.click();
        sleep(2000);
    }

    @Step("Get amount of product value")
    public String getProductAmount() {
        String productAmount = quantityArea.getAttribute("value");
        return productAmount;
    }

    @Step("Set visibility of total price element")
    public void setVisibilityOfTotalPrice(){
        sleep(5000);
        Selenide.executeJavaScript(
                "arguments[0].style.display = 'block'; arguments[0].style.visibility = 'visible'; arguments[0].style.opacity = '1';",
                totalAmountArea);

        totalAmountArea.shouldBe(Condition.visible, Duration.ofSeconds(7));
        System.out.println("Display: " + totalAmountArea.getCssValue("display"));
        System.out.println("Visibility: " + totalAmountArea.getCssValue("visibility"));
        System.out.println("Opacity: " + totalAmountArea.getCssValue("opacity"));

        if (totalAmountArea.is(Condition.visible)) {
            System.out.println("Element is visible now");
        } else {
            System.out.println("Element is still not visible.");
        }
    }

    @Step("Get total price of product value")
    public String getTotalPrice() {
        totalAmountArea.shouldBe(Condition.visible, Duration.ofSeconds(5));
        return totalAmountArea.getText();
    }

    @Step("Click minus item button")
    public void clickMinusButton(){
        minusProductButton.click();
        sleep(2000);
    }

    @Step("Click submit order button")
    public void clickSubmitOrderButton(){
        submitOrderButton.click();
    }

    @Step("Clear the cart")
    public void clearTheCart(){
        clearCartButton.scrollTo();
        clearCartButton.click();
        emptyCartMessage.shouldBe(Condition.visible, Duration.ofSeconds(5));
    }

    @Step("Get text from empty cart element")
    public String getEmptyCartText() {
        emptyCartMessage.shouldBe(Condition.visible, Duration.ofSeconds(5));
        return emptyCartMessage.getText();
    }
}
