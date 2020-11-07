package com.sedc.selenium.magento.util;


import com.sedc.selenium.magento.pages.Magento;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.util.concurrent.TimeUnit;

public class Global {
    public static final int TIMEOUT = 20;
    public WebDriver driver;
    public WebDriverWait wait;
    public Magento magento;

    public void navigateTo(String url) {
        driver.get(url);
    }

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/recources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, TIMEOUT);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        magento = new Magento(driver, wait);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
