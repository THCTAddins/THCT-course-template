package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.DriverManager;

public class Bai_21 extends BasicTest {

    @Parameters({"baseURL"})
    @Test()//dataProvider = "testLogin")
    public void loginTest(String webURL) {      
        //  Login

        WebDriver driver = DriverManager.getDriver();
        String url = webURL;
        driver.get(url);

        Actions action = new Actions(driver);

        action.moveToElement(WaitFindElementWithId("menu-item-347")).perform();
        action.moveToElement(WaitFindElementWithId("menu-item-459")).perform();
        WaitFindElementWithId("menu-item-464").click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://bantheme.xyz/hathanhauto/van-chia-hoi-nang-gam/");
    }

    public WebElement WaitFindElementWithId(String id) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    public WebElement WaitFindElementWithXpath(String xpath) {
        //WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(xpath)));
    }
}
