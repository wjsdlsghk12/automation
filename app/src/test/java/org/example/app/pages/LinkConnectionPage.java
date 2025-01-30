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

public class LinkConnectionPage {

    private AndroidDriver driver;
    private WebDriverWait wait;
    private PageManager pageManager; 
    private ActionUtils actionUtils;

    public LinkConnectionPage(AndroidDriver driver, PageManager pageManager) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.pageManager = pageManager;
        this.actionUtils = new ActionUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
    public WebElement continueButton;

    public void continueClick() throws InterruptedException {
        actionUtils.click(continueButton);
    }

    public void linkClick(String string) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"" + string + "\"]")));
        WebElement confirmButton = driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + string + "\"]"));
        Thread.sleep(3000);
        confirmButton.click();
    }
    
}
