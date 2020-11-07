package com.sedc.selenium.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;
import java.util.List;

public class Magento {
    By signIn = By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/a");
    By enterEmail = By.id("email");
    By enterPassword = By.id("pass");
    By clickSignIn = By.id("send2");
    By isLogedIn = By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[1]/span");
    By clickClothing = By.xpath("//*[@id=\"ui-id-3\"]/span[2]");
    By clickCategories = By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]");
    By clickShirts = By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[1]/a");
    By chooseShirt = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]/div/a/span/span/img");
    By addText = By.xpath("//*[@id=\"options_2_text\"]");
    By clickAddToCart = By.xpath("//*[@id=\"product-addtocart-button\"]/span");
    By clickCart = By.xpath("/html/body/div[1]/header/div[2]/div[1]/a");
    By emptyCart = By.xpath("//*[@id=\"mini-cart\"]/li");
    By clickProceedToCheckout = By.xpath("//*[@id=\"top-cart-btn-checkout\"]");
    By clickNext = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button/span");
    By clickPlaceOrder = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button/span");
    By checkOutSuccess = By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]");

    private WebDriver driver;
    private WebDriverWait wait;
    Actions action;

    public Magento(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public Magento(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void clickSignIn() {
        driver.findElement(signIn).click();
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterEmail)).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(enterPassword).sendKeys(password);
    }

    public void logIn() {
        driver.findElement(clickSignIn).click();
    }

    public void isLogedIn() throws InterruptedException {
        Thread.sleep(1000);
        if (driver.findElement(isLogedIn).isDisplayed()) {
            System.out.println("Successfully logged in the page");
        } else {
            throw new Error("Failed to log in.");
        }
    }

    public void clickClothing() {
        wait.until(ExpectedConditions.elementToBeClickable(clickClothing)).click();
    }

    public void clickCategories() {
        wait.until(ExpectedConditions.elementToBeClickable(clickCategories)).click();
    }

    public void clickShirts() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickShirts)).click();
    }

    public void chooseShirt() {
        wait.until(ExpectedConditions.elementToBeClickable(chooseShirt)).click();
    }

    public void addText(String text) {
        driver.findElement(addText).sendKeys(text);
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(clickAddToCart)).click();
    }

    public void clickCartButton() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(clickCart)).click();
    }

    public void isCartEmpty() {
        List<WebElement> products = driver.findElements(emptyCart);
        if (products.isEmpty()) {
            System.out.println("Shopping cart is empty");
        } else {
            System.out.println("Item added to cart");
        }
    }

    public void clickProceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(clickProceedToCheckout)).click();
    }
    public void clickNext() throws InterruptedException {
        action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(clickNext)).click();
    }
    public void clickPlaceOrder() throws InterruptedException {
        action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(clickPlaceOrder)).click();
    }
    public void checkCheckoutSuccess(){
        if (driver.findElement(checkOutSuccess).isDisplayed()){
            System.out.println("Order successful");
        } else {
            throw new Error("Failed to finish order");
        }
    }


}
