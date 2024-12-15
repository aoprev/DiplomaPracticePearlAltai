package com.diploma.practice.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.sleep;

public class PlacingOrderPage {
    public SelenideElement enterButton = Selenide.$("button.b2121-a0.b2121-b5.b2121-b2.b2121-a4");

    @Step ("Reload placing order page")
    public void reloadPlacingOrderPage() {
        sleep(5000);
        refresh();
    }
}
