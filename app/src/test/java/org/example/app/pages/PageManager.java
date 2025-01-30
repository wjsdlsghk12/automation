package org.example.app.pages;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class PageManager {
    public AndroidDriver driver;
    public WebDriverWait wait;
    public StorePage storePage;
    public HeaderNavigationBar headerNavigationBar;
    public FooterNavigationBar footerNavigationBar;
    public ProfilePage profilePage;
    public LinkConnectionPage linkConnectionPage;

    public PageManager(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.storePage = new StorePage(driver, this);
        this.headerNavigationBar = new HeaderNavigationBar(driver, this);
        this.footerNavigationBar = new FooterNavigationBar(driver, this);
        this.profilePage = new ProfilePage(driver, this);
        this.linkConnectionPage = new LinkConnectionPage(driver, this);
    }

    public StorePage getStorePage() {
        return storePage;
    }

    // 다른 페이지들도 마찬가지로 getter 메소드로 접근
    public HeaderNavigationBar getHeaderNavigationBar() {
        return headerNavigationBar;
    }
    
    public FooterNavigationBar getFooterNavigationBar() {
        return footerNavigationBar;
    }
    
    // Getter 메소드로 ProfilePage, StorePage 등 다른 페이지 객체에 접근
    public ProfilePage getProfilePage() {
        return profilePage;
    }

    public LinkConnectionPage getLinkConnectionPage() {
        return linkConnectionPage;
    }

}
