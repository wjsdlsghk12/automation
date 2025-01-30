package org.example.app.pages;

import java.time.Duration;

import org.example.app.utils.ActionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class FooterNavigationBar {
    private AndroidDriver driver;
    private WebDriverWait wait;
    private PageManager pageManager; 
    private ActionUtils actionUtils;

    public FooterNavigationBar(AndroidDriver driver, PageManager pageManager) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.pageManager = pageManager;
        this.actionUtils = new ActionUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "profile_tab")
    public WebElement profileTab;

    public void openProfile() {
        actionUtils.click(profileTab);
    }
}
