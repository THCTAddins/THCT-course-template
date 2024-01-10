package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai_20 extends BasicTest {
    private WebDriverWait wait = new WebDriverWait(driver, 10);

    @Test(dataProvider = "testLogin")
    public void loginTest(String tcID, String uname, String pwd) throws Exception {      
        //  Login
        try{
            FindWaitElementWithXpath("username").clear();
            FindWaitElementWithXpath("username").sendKeys(uname);
            FindWaitElementWithXpath("password").clear();
            FindWaitElementWithXpath("password").sendKeys(pwd);
            FindWaitElementWithXpath("//button[contains(text(),\"Log in\")]").click();
            WebElement loggedin = FindWaitElementWithXpath("//a[contains(text(),\"Logged\")]");
            
            if (loggedin.isDisplayed()) {
                excel.setCellData("Passed", 0, tcID, 3);
            }
            Assert.assertTrue(loggedin.isDisplayed());
        }
            catch(Exception e) {
                excel.setCellData(e.getMessage(), 0, tcID, 3);
                Assert.assertTrue(FindWaitElementWithXpath("//a[contains(text(),\"Logged\")]").isDisplayed());
        }
    }

    public WebElement FindWaitElementWithXpath(String xpath) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(xpath)));
        return element;
    }   

}
