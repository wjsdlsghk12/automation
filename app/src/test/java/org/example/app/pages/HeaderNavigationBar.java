package org.example.app.pages;

import io.appium.java_client.android.AndroidDriver;

import org.example.app.utils.ActionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class HeaderNavigationBar {
    private AndroidDriver driver;
    private WebDriverWait wait;
    private PageManager pageManager; 
    private ActionUtils actionUtils;

    public HeaderNavigationBar(AndroidDriver driver, PageManager pageManager) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.pageManager = pageManager;
        this.actionUtils = new ActionUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "action_bar_button_back")
    public WebElement backButton;

    @FindBy(id = "action_bar_button_action")
    public WebElement confirmButton;

    public void clickBack() throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(backButton));
        actionUtils.click(backButton);

        Thread.sleep(1000);
        actionUtils.click(backButton);
    }
}
