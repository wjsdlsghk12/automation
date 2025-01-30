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

public class ProfilePage {
    private AndroidDriver driver;
    private WebDriverWait wait;
    private PageManager pageManager; 
    private ActionUtils actionUtils;

    public ProfilePage(AndroidDriver driver, PageManager pageManager) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.pageManager = pageManager;
        this.actionUtils = new ActionUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"프로필 편집\"]")
    public WebElement pfofileUpdate;

    @FindBy(id = "links_text_cell")
    public WebElement addLink;

    @FindBy(id = "links_list")
    public WebElement addLinkSide;

    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.instagram.android:id/prism_form_field_container\"])[1]/android.widget.EditText")
    public WebElement urlField;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.instagram.android:id/text_1\"]")
    public WebElement link;

    public void updateProfileLink(String url) throws InterruptedException {
        Thread.sleep(3000);
        actionUtils.click(pfofileUpdate);

        actionUtils.click(addLink);

        actionUtils.click(addLinkSide);
        
        wait.until(ExpectedConditions.visibilityOf(urlField));
        urlField.clear();
        urlField.sendKeys(url);

        WebElement confirmButton = pageManager.getHeaderNavigationBar().confirmButton;
        wait.until(ExpectedConditions.visibilityOf(confirmButton));

        if (confirmButton.isEnabled()) {
            confirmButton.click();    
        } else {
            WebElement backButton = pageManager.getHeaderNavigationBar().backButton;
            wait.until(ExpectedConditions.visibilityOf(backButton));
            actionUtils.click(backButton);
        }
    }

    public void clickLink() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(link));
        link.click();
    }

}
