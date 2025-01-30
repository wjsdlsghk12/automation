package org.example.app.steps;

import java.io.IOException;
import java.net.MalformedURLException;

import org.example.app.pages.PageManager;
import org.example.app.pages.*;
import org.example.app.utils.AppiumDriverSetup;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    private AndroidDriver driver;
    private PageManager pageManager;

    @Before
    public void setup() throws MalformedURLException {
        driver = AppiumDriverSetup.initializeDriver();
        pageManager = new PageManager(driver);
    }

    // @Given("Instagram open")
    // public void instagramOpen() throws Exception {
    //     driver = AppiumDriverSetup.initializeDriver();
    //     pageManager = new PageManager(driver);
    // }

    @When("Add {string} link to your profile")
    public void addLink(String string) throws InterruptedException {
        // Thread.sleep(10000);
        pageManager.footerNavigationBar.openProfile();
        pageManager.profilePage.updateProfileLink(string);
    }

    @When("Click on link")
    public void clickOnLink() throws InterruptedException {
        pageManager.headerNavigationBar.clickBack();
        pageManager.profilePage.clickLink();
    }

    @When("Go to external app Continue Click")
    public void continueClick() throws InterruptedException {
        pageManager.linkConnectionPage.continueClick();
    }

    @Then("Go to the App Store and make sure you are directed to the ablog installation page.")
    public void theUserShouldBeLoggedInSuccessfully() {
        try {
            if (pageManager.storePage.isStoreOpened("com.android.vending")) {
                System.out.println("Store is open!");
            } else {
                throw new Error("Store page did not open.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt(); // 현재 스레드 상태를 인터럽트 상태로 설정
        }
    }

    @When("{string} link click")
    public void continueClick(String string) throws InterruptedException {
        pageManager.linkConnectionPage.linkClick(string);
    }

    @Then("ttt")
    public void ttt() {
        try {
            if (pageManager.storePage.isStoreOpened("product.dp.io.ab180blog")) {
                System.out.println("AB180 is open!");
            } else {
                throw new Error("AB180 page did not open.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt(); // 현재 스레드 상태를 인터럽트 상태로 설정
        }
    }

    @After
    public void tearDown() {
        System.out.println("Executing @After teardown...");
        AppiumDriverSetup setup = new AppiumDriverSetup();
        setup.tearDown();
        
        // ADB로 앱 강제 종료
        try {
            Runtime.getRuntime().exec("adb shell am force-stop com.instagram.android"); // 실제 패키지 이름 사용
            // driver = AppiumDriverSetup.initializeDriver(); // 새로운 세션 시작
            System.out.println("New driver session initialized.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Executing @After teardown...2222");
    }
}
