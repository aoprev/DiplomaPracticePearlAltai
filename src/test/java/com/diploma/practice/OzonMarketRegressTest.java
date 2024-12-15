package com.diploma.practice;

import com.diploma.practice.pages.*;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class OzonMarketRegressTest extends BaseTestUI{
    private OzonMainPage mainPage = new OzonMainPage();
    private SearchResultsPage searchResultsPage =new SearchResultsPage();
    private CartPage cartPage = new CartPage();
    private PlacingOrderPage placingOrderPage = new PlacingOrderPage();

    @Test(description = "Test of successful item search", priority = 1)
    public void testOfSuccessfulItemSearch() {
        mainPage.waitForOzonMainPageLoaded();
        mainPage.clickAndSetSearchString();
        mainPage.clickSearchButton();

        Assertions.assertThat((searchResultsPage.searchItem).exists()).isFalse();
    }

    @Test(description = "Test of adding item to the cart", priority = 2)
    public void testAddToCart(){
        searchResultsPage.waitItem();
        searchResultsPage.addItemToTheCart();
        cartPage.openCart();
        cartPage.checkBookPresence();

        Assertions.assertThat((cartPage.bookElement).exists()).isTrue();
    }

    @Test(description = "Test of placing order", priority = 3)
    public void testOrderPlacing(){
        cartPage.placeOrder();
        placingOrderPage.reloadPlacingOrderPage();

        Assertions.assertThat((placingOrderPage.enterButton).exists()).isFalse();
    }
}
