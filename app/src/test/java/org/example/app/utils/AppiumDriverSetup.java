package org.example.app.utils;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
// import io.appium.java_client.android.AndroidElement;
// import io.appium.java_client.MobileElement;

import com.google.common.collect.ImmutableMap;

import java.net.MalformedURLException;
import java.net.URL;






import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.screenrecording.CanRecordScreen;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import java.util.Base64;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AppiumDriverSetup {
    // public static AndroidDriver driver;
    private static ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();

    public static AndroidDriver initializeDriver() throws MalformedURLException {
        if (driver.get() == null) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("deviceName", "276b7a4df4217ece");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("ignoreHiddenApiPolicyError", true);
            caps.setCapability("appPackage", "com.instagram.android");
            caps.setCapability("appActivity", "com.instagram.mainactivity.InstagramMainActivity");
            caps.setCapability("noReset", true);
            caps.setCapability("autoLaunch", true);

            driver.set(new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps)); 
            // driver.get().activateApp("com.instagram.android");
            driver.get().startRecordingScreen();
            // ((CanRecordScreen) driver).startRecordingScreen();

            
        }

        try {
            // Instagram이 실행 중이라면 포그라운드로 전환
            driver.get().activateApp("com.instagram.android");
        } catch (Exception e) {
            // 앱이 실행되지 않았으면, 앱을 시작하여 포그라운드로 전환
            // driver.get().startActivity(new Activity("com.instagram.android", "com.instagram.mainactivity.InstagramMainActivity"));
            driver.get().executeScript("mobile: startActivity", ImmutableMap.of(
                "appPackage", "com.instagram.android",
                "appActivity", "com.instagram.mainactivity.InstagramMainActivity"
            ));
        }
        
        return driver.get();

        
        // DesiredCapabilities caps = new DesiredCapabilities();
        // caps.setCapability("platformName", "Android");
        // caps.setCapability("deviceName", "276b7a4df4217ece");
        // caps.setCapability("automationName", "UiAutomator2");
        // caps.setCapability("ignoreHiddenApiPolicyError", true);
        // caps.setCapability("appPackage", "com.instagram.android");
        // caps.setCapability("appActivity", "com.instagram.mainactivity.InstagramMainActivity");
        // caps.setCapability("noReset", true);
        // caps.setCapability("autoLaunch", true);

        // driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
        // driver.activateApp("com.instagram.android");
        // return driver;
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().close();
            // driver.remove();
            System.out.println("Driver quit successfully.");
        } else {
            System.out.println("No driver to quit.");
        }
        // d.quit();
    }

    public void tearDown() {
        String video = driver.get().stopRecordingScreen();
        saveRecording(video, "test-recording.mp4");
        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        // if (driver != null) {
        //     driver.quit();
        // }
    }

    private void saveRecording(String base64String, String fileName) {
        byte[] data = Base64.getDecoder().decode(base64String);
        File videoFile = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(videoFile)) {
            fos.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
