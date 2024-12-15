package com.diploma.practice.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;

public class OzonMainPage {
    private SelenideElement searchArea= Selenide.$("input.ae1a_33");
    private SelenideElement searchButton= Selenide.$("div.ag022-a");

    @Step ("Reload main page")
    public void reloadMainPage() {
        sleep(3000); // Ждём 3 секунды
        refresh();   // Обновляем текущую страницу
    }

    @Step("Wait for Ozon main page loaded")
    public void waitForOzonMainPageLoaded() {
        searchArea.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    @Step("Set value to the search field")
    public void clickAndSetSearchString() {
        searchArea.click();
        searchArea.setValue("software testing");
    }

    @Step("Set value to the search field")
    public void clickSearchButton() {
        searchButton.click();
    }
}
