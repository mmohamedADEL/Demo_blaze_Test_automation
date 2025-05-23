package Listeners;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import utilities.LogUtility;
import utilities.Utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


import static java.sql.DriverManager.getDriver;
import static utilities.Utility.takeScreenshot;

public class InvokedMethodListenersClass implements IInvokedMethodListener {
    private final String LOGS_PATH = "Test-output/logs/";
    @Override
    public void afterInvocation(org.testng.IInvokedMethod method, ITestResult testResult , ITestContext context) {

        if(testResult.getStatus() == ITestResult.FAILURE) {
            LogUtility.error("Test failed: " + testResult.getName());
        }
    }

}
