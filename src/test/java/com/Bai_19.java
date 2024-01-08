package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai_19 extends BasicTest {


    @Test(dataProvider = "testLogin")
    public void loginTest(String tcID, String uname, String pwd) throws Exception {      
        //  Login
        try{
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("username")).sendKeys(uname);
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys(pwd);
            driver.findElement(By.xpath("//button[contains(text(),\"Log in\")]")).click();
            WebElement loggedin = driver.findElement(By.xpath("//a[contains(text(),\"Logged\")]"));
            
            if (loggedin.isDisplayed()) {
                excel.setCellData("Passed", 0, tcID, 3);
            }
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),\"Logged\")]")).isDisplayed());
        }
            catch(Exception e) {
                excel.setCellData(e.getMessage(), 0, tcID, 3);
                Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),\"Logged\")]")).isDisplayed());
        }
    }   

}
