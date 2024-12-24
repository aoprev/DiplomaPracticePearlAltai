package com.diploma.practice.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;

public class PearlAltaiMainPage {
    public SelenideElement returnToMainPageButton = Selenide.$("img[src='/data/files/138.png']");
    public SelenideElement firstProductSection= Selenide.$("a.item-link[href='/catalog/fitosbory-travy-korni']");
    public SelenideElement siteDeveloperLogoLink= Selenide.$("div.quick_link p a[href='https://astro-tech.ru']");

    @Step("Wait for PearlAltai main page header and middle part loaded")
    public void waitForPearlAltaiMainPageHeaderAndMiddlePartLoaded() {
        returnToMainPageButton.shouldBe(Condition.hidden, Duration.ofSeconds(10));
        firstProductSection.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    @Step("Scroll to the main page footer")
    public void scrollToMainPageFooter() {
        Selenide.executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    @Step("Wait for PearlAltai main page footer loaded")
    public void waitForPearlAltaiMainPageFooterLoaded() {
        siteDeveloperLogoLink.shouldBe(Condition.visible, Duration.ofSeconds(8));
    }
}
