package com.company;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.google.android.calculator");
        dc.setCapability("appActivity", ".Calculator");

        AndroidDriver<AndroidElement> ad = new AndroidDriver<AndroidElement> (new URL("http://127.0.0.1:4723/wd/hub"), dc);

        MobileElement el1 = (MobileElement) ad.findElementById("com.google.android.calculator:id/digit_2");
        el1.click();
        MobileElement el2 = (MobileElement) ad.findElementById("com.google.android.calculator:id/digit_5");
        el2.click();
        MobileElement el3 = (MobileElement) ad.findElementByAccessibilityId("plus");
        el3.click();
        MobileElement el4 = (MobileElement) ad.findElementById("com.google.android.calculator:id/digit_3");
        el4.click();
        MobileElement el5 = (MobileElement) ad.findElementById("com.google.android.calculator:id/digit_6");
        el5.click();
        MobileElement el6 = (MobileElement) ad.findElementByAccessibilityId("equals");
        el6.click();

        Assert.assertEquals(ad.findElementById("com.google.android.calculator:id/result_final").getText(), 61);

    }
}
