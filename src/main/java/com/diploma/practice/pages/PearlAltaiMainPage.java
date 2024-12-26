package com.diploma.practice.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;

public class PearlAltaiMainPage {
    public SelenideElement returnToMainPageButton = Selenide.$("img[src='/data/files/138.png']");
    public SelenideElement firstProductSection= Selenide.$("a.item-link[href='/catalog/fitosbory-travy-korni']");
    public SelenideElement siteDeveloperLogoLink= Selenide.$("div.quick_link p a[href='https://astro-tech.ru']");
    public SelenideElement searchField= Selenide.$("#search");
    public SelenideElement clickableSearchArea= Selenide.$("input[name='q']");
    public SelenideElement mainMenu= Selenide.$("div.nav-main-collapse");
    public SelenideElement searchButton= Selenide.$("button.search-box__btn[type='submit']");

    public String searchQueryStringValid = "мёд";
    public String searchQueryStringInvalid = "!@&FW%^&&)(*&";

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

    @Step("Scroll to the main page header")
    public void scrollToMainPageHeader() {
        Selenide.executeJavaScript("window.scrollTo(0, 0);");
    }

    @Step("Wait for navigation elements loaded")
    public void waitForNavigationElementsLoaded() {
        searchField.shouldBe(Condition.hidden, Duration.ofSeconds(8));
        mainMenu.shouldBe(Condition.visible, Duration.ofSeconds(8));
    }

    @Step("Fill search field by valid data and click to searching")
    public void fillSearchFieldByValidDataAndClickToSearching() {
        Selenide.executeJavaScript("document.querySelector('input[name=\"q\"]').style.display = 'block';");
        Selenide.executeJavaScript("document.querySelector('input[name=\"q\"]').style.visibility = 'visible';");
        Selenide.executeJavaScript("document.querySelector('input[name=\"q\"]').style.opacity = '1';");

        if(clickableSearchArea.getCssValue("display").equals("block")) {
            Selenide.executeJavaScript("document.querySelector('input[name=\"q\"]').click();");
            Selenide.executeJavaScript("document.querySelector('input[name=\"q\"]').value = arguments[0];", searchQueryStringValid);
            Selenide.executeJavaScript("document.querySelector('button.search-box__btn[type=\"submit\"]').click();");
        }
        else{
            System.out.println(clickableSearchArea.getCssValue("display"));
            System.out.println(clickableSearchArea.getCssValue("visibility"));
            System.out.println(clickableSearchArea.getCssValue("opacity"));
        }
    }

    @Step("Fill search field by invalid data and click to searching")
    public void fillSearchFieldByInvalidDataAndClickToSearching() {

        Selenide.executeJavaScript("document.querySelector('img[src=\"/data/files/138.png\"]').scrollIntoView();");
        Selenide.executeJavaScript("document.querySelector('img[src=\"/data/files/138.png\"]').click();");

        Selenide.executeJavaScript("document.querySelector('input[name=\"q\"]').style.display = 'block';");
        Selenide.executeJavaScript("document.querySelector('input[name=\"q\"]').style.visibility = 'visible';");
        Selenide.executeJavaScript("document.querySelector('input[name=\"q\"]').style.opacity = '1';");

        if(clickableSearchArea.getCssValue("display").equals("block")) {
            Selenide.executeJavaScript("document.querySelector('input[name=\"q\"]').click();");
            Selenide.executeJavaScript("document.querySelector('input[name=\"q\"]').value = arguments[0];", searchQueryStringInvalid);
            Selenide.executeJavaScript("document.querySelector('button.search-box__btn[type=\"submit\"]').click();");
        }
        else{
            System.out.println(clickableSearchArea.getCssValue("display"));
            System.out.println(clickableSearchArea.getCssValue("visibility"));
            System.out.println(clickableSearchArea.getCssValue("opacity"));
        }
    }
}
