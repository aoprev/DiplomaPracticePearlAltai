package com.diploma.practice.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;

public class CataloguePage {
    public SelenideElement firstCatalogueItem = Selenide.$("a[href='/catalog/pantovaya-produkciya']");

    @Step("Open page of section in the catalogue")
    public void openACatalogueSection(){
        firstCatalogueItem.shouldBe(Condition.visible, Duration.ofSeconds(7));
        firstCatalogueItem.click();
    }
}