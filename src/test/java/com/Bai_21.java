package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai_21 extends BasicTest {
    
    @Test()//dataProvider = "testLogin")
    public void loginTest() {      
        //  Login
        Actions action = new Actions(driver);

        action.moveToElement(WaitFindElementWithId("menu-item-347")).perform();
        action.moveToElement(WaitFindElementWithId("menu-item-459")).perform();
        WaitFindElementWithId("menu-item-464").click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://bantheme.xyz/hathanhauto/van-chia-hoi-nang-gam/");
    }

    public WebElement WaitFindElementWithId(String id) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    public WebElement WaitFindElementWithXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(xpath)));
    }
}
