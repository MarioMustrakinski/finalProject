package com.sedc.selenium.magento.test;

import com.sedc.selenium.magento.pages.Magento;
import com.sedc.selenium.magento.util.Global;
import org.testng.annotations.Test;

public class MagentoTest extends Global {
    String url = "http://138.201.197.35:81/magento1/";
    String email = "dzogani@gmail.com";
    String password = "Test123456";
    String text = "mario";

    @Test
    public void placingOrder() throws InterruptedException {
        magento.navigateTo(url);
        magento.clickSignIn();
        magento.enterEmail(email);
        magento.enterPassword(password);
        magento.logIn();
        magento.isLogedIn();
        magento.clickClothing();
        magento.clickCategories();
        magento.clickShirts();
        magento.chooseShirt();
        magento.addText(text);
        magento.clickAddToCart();
        magento.clickCartButton();
        magento.isCartEmpty();
        magento.clickProceedToCheckout();
        magento.clickNext();
        magento.clickPlaceOrder();
        magento.checkCheckoutSuccess();

    }
}

