package com.diploma.practice;

import com.diploma.practice.pages.*;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class PearlAltaiMarketRegressTest extends BaseTestUI{
    private PearlAltaiMainPage mainPage = new PearlAltaiMainPage();

    @Test(description = "Test of successful main paige loading", priority = 1)
    public void testOfSuccessMainPageLoading() {

        mainPage.waitForPearlAltaiMainPageHeaderAndMiddlePartLoaded();

        Assertions.assertThat(mainPage.returnToMainPageButton.exists()).isTrue();

        Assertions.assertThat(mainPage.firstProductSection.exists()).isTrue();

        mainPage.scrollToMainPageFooter();

        mainPage.waitForPearlAltaiMainPageFooterLoaded();

        Assertions.assertThat(mainPage.siteDeveloperLogoLink.exists()).isTrue();
    }

    @Test(description = "Test of successful navigation elements loading", priority = 2)
    public void testOfNavigationElementsLoading() {

        mainPage.scrollToMainPageHeader();

        mainPage.waitForNavigationElementsLoaded();

        Assertions.assertThat(mainPage.searchField.exists()).isTrue();

        Assertions.assertThat(mainPage.mainMenu.exists()).isTrue();
    }

}
