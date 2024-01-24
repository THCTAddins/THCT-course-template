package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;



public abstract class BasicTest {
    
    public static final Logger logger = LogManager.getLogger();
    protected static ExcelUtils excel;
    protected static WebDriver driver_org;
    // private String driverPath;

    // @BeforeSuite
    // @Parameters({"xlsxPath", "xlsxName"})
    // public void beforeSuite(String xlpath, String xlname) throws Exception{
    //     excel = new ExcelUtils(xlpath, xlname);
    // }

    @BeforeMethod
    // @Parameters({"baseURL"})
    public void preCondition() throws Exception{

        // //Remote
        // DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setCapability("browserName", "Chrome");
        // capabilities.setCapability("browserVersion", "121.0");
        // HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        // ltOptions.put("username", "jateb46958");
        // ltOptions.put("accessKey", "PC2TKN3gpgIcdbx36YJNz9I0bW8L46Pm9CMJEAY4V7Ob9FHKQ2");
        // ltOptions.put("platformName", "Windows 10");
        // ltOptions.put("project", "Untitled");
        // capabilities.setCapability("LT:Options", ltOptions);

        // Chromedriver path
        // driverPath = "src/main/resources/WebDrivers/chromedriver.exe";
        // ChromeOptions options = new ChromeOptions();
        // System.setProperty("webdriver.chrome.driver", driverPath);
        // driver = new ChromeDriver(options);
        WebDriverManager.chromedriver().setup();
        driver_org = new ChromeDriver();
        // driver_org = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), capabilities);

        DriverManager.setDriver(driver_org);
        
        // Maximize the browser
        DriverManager.getDriver().manage().window().maximize();

    }

    // @DataProvider(name="testLogin")
    // public Object[][] TestDataFeed() throws Exception{
    //     //Create object array with n row & 3 col - 1st parameter is row, 2nd is col
    //     ExcelUtils excel = new ExcelUtils("src\\test\\resources\\", "test_data.xlsx");
    //     int noOfRows = excel.getRowCount(0)-1;
    //     System.out.println("No of Rows:" + noOfRows);

    //     Object [][] logindata = new Object[noOfRows][3];

    //     //Data
    //     for (int i=1;i<=noOfRows;i++) {
    //         logindata[i-1][0] = excel.getData(0, i, 0);
    //         System.out.println("ID:" + i);
    //         logindata[i-1][1] = excel.getData(0,i,1);
    //         System.out.println("Username:" + logindata[i-1][1]);
    //         logindata[i-1][2] = excel.getData(0,i,2);
    //         System.out.println("Password:" + logindata[i-1][2]);
    //     }
    //     //return arrayobject to @Test
    //     return logindata;
    // }

    @AfterMethod
    public void postCondition(){
        // Quit the Browser
        DriverManager.quit();
    }

    // @AfterSuite
    // @Parameters({"xlsxPath", "xlsxName"})
    // public void afterSuite(String xlpath, String xlname) throws Exception{
    //     excel.saveData(xlpath, xlname);
    // }
}