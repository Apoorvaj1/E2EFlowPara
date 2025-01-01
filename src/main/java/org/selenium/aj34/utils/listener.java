package org.selenium.aj34.utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class listener implements ITestListener {

    WebDriver driver;
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test starts "+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test success "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failure "+result.getName());
        try {
            takingScreenshot.screenshot(driver,"screenshots");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped "+result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("I am starting now");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("I am finished");
    }
}
