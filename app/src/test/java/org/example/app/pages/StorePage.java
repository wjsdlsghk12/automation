package org.example.app.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StorePage {
    private AndroidDriver driver;
    private WebDriverWait wait;
    private PageManager pageManager; 

    public StorePage(AndroidDriver driver, PageManager pageManager) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.pageManager = pageManager;
        PageFactory.initElements(driver, this);
    }

    public boolean isStoreOpened(String appPakage) throws InterruptedException {
        Thread.sleep(5000);
        String currentPackage = driver.getCurrentPackage();
        System.out.println(currentPackage);
        return appPakage.equals(currentPackage);
    }
}
