package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public abstract class BasicTest {
    
    public static final Logger logger = LogManager.getLogger();
    protected static WebDriver driver;
    // private String driverPath;

    @BeforeMethod
    @Parameters({"baseURL"})
    public void preCondition(String webURL) {
        // Chromedriver path
        // driverPath = "src/main/resources/WebDrivers/chromedriver.exe";
        // ChromeOptions options = new ChromeOptions();
        // System.setProperty("webdriver.chrome.driver", driverPath);
        // driver = new ChromeDriver(options);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Maximize the browser
        driver.manage().window().maximize();
        String url = webURL;
        driver.get(url);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @DataProvider(name="testLogin")
    public Object[][] TestDataFeed(){
        //Create object array with 2 row & 2 col - 1st parameter is row, 2nd is col
        Object [][] logindata = new Object[3][2];

        //Data
        logindata[0][0] = "admin";
        logindata[0][1] = "admin";

        logindata[1][0] = "manager";
        logindata[1][1] = "demouserpwd";

        logindata[2][0] = "user1";
        logindata[2][1] = "demouserpwd";

        //return arrayobject to @Test
        return logindata;
    }

    @AfterMethod
    public void postCondition(){
        // Quit the Browser
        driver.quit();
    }
}