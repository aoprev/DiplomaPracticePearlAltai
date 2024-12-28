package com.diploma.practice;

import com.diploma.practice.pages.*;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class PearlAltaiMarketRegressTest extends BaseTestUI{
    private final PearlAltaiMainPage mainPage = new PearlAltaiMainPage();
    private final SearchResultsPage searchResultsPage = new SearchResultsPage();
    private final CataloguePage cataloguePage = new CataloguePage();
    private final HornProductsPage hornProductsPage = new HornProductsPage();
    private final HornItemPage hornItemPage = new HornItemPage();
    private final CartPage cartPage = new CartPage();
    private final SubmitOrderPage submitOrderPage = new SubmitOrderPage();
    private String plusPrice = "394р.";
    private String minusPrice = "197р.";

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

    @Test(description = "Test of an item searching", priority = 3)
    public void testOfItemSearching() {
        mainPage.fillSearchFieldByValidDataAndClickToSearching();
        searchResultsPage.waitForSuccessSearchResultsPageLoaded();
        Assertions.assertThat(searchResultsPage.firstSuccessItem.exists()).isTrue();
        Assertions.assertThat(searchResultsPage.firstSuccessItem.getText()).containsIgnoringCase("мёд");
        mainPage.fillSearchFieldByInvalidDataAndClickToSearching();
        searchResultsPage.waitForFailSearchResultsPageLoaded();
        Assertions.assertThat(searchResultsPage.emptyItem.exists()).isTrue();
        Assertions.assertThat(searchResultsPage.emptyItem.getText()).containsIgnoringCase("По вашему запросу ничего не найдено");
    }

    @Test(description = "Test of an product page display", priority = 4)
    public void testOfProductPageDisplay() {
        mainPage.openCatalogue();
        cataloguePage.openACatalogueSection();
        hornProductsPage.openHornItemPage();
        hornItemPage.waitPresenceOfItemElements();
        Assertions.assertThat(hornItemPage.addItemToCartButton.exists()).isTrue();
        Assertions.assertThat(hornItemPage.itemDescriptionSection.exists()).isTrue();
        Assertions.assertThat(hornItemPage.itemPriceSection.exists()).isTrue();
        Assertions.assertThat(hornItemPage.itemImage.exists()).isTrue();
    }

    @Test(description = "Test of placing a product to the cart", priority = 5)
    public void testOfPlacingProductToTheCart(){
        hornItemPage.addItemToCart();
        hornItemPage.openTheCartModal();
        cartPage.openTheCartPage();
        cartPage.waitAddedProductIcon();
        Assertions.assertThat(cartPage.addedProductIcon.exists()).isTrue();
        cartPage.clickPlusButton();
        Assertions.assertThat(cartPage.getProductAmount()).isEqualTo("2");
        cartPage.setVisibilityOfTotalPrice();
        Assertions.assertThat(cartPage.getTotalPrice()).isEqualTo(plusPrice);
        cartPage.clickMinusButton();
        Assertions.assertThat(cartPage.getProductAmount()).isEqualTo("1");
        Assertions.assertThat(cartPage.getTotalPrice()).isEqualTo(minusPrice);

        cartPage.clickSubmitOrderButton();

        submitOrderPage.waitSubmitOrderPageLoaded();
    }

}
