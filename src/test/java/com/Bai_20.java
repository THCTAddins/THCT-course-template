package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai_20 extends BasicTest {
    
    @Test(dataProvider = "testLogin")
    public void loginTest(String tcID, String uname, String pwd) throws Exception {      
        //  Login
        try{
            FindWaitElementWithId("username").clear();
            FindWaitElementWithId("username").sendKeys(uname);
            FindWaitElementWithId("password").clear();
            FindWaitElementWithId("password").sendKeys(pwd);
            FindWaitElementWithXpath("//button[contains(text(),\"Log in\")]").click();
            WebElement loggedin = FindWaitElementWithXpath("//a[contains(text(),\"Logged\")]");
            
            if (loggedin.isDisplayed()) {
                excel.setCellData("Passed", 0, tcID, 3);
            }
            Assert.assertTrue(loggedin.isDisplayed());
        }
            catch(Exception e) {
                excel.setCellData(e.getMessage(), 0, tcID, 3);
                Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),\"Logged\")]")).isDisplayed());
        }
    }

    public WebElement FindWaitElementWithId(String id) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        return element;
    }

    public WebElement FindWaitElementWithXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }     

}
