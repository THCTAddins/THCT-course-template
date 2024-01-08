package com;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai_19 extends BasicTest {


    @Test(dataProvider = "testLogin")
    public void loginTest(String uname, String pwd) throws Exception {      
        //  Login
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(uname);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(pwd);
        driver.findElement(By.xpath("//button[contains(text(),\"Log in\")]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),\"Logged\")]")).isDisplayed());

    }   

}
