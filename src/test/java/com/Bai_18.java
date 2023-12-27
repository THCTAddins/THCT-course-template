package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai_18 extends BasicTest {


    @Test()
    public void loginTest() throws Exception {
        //fto24137@omeie.com
        // Launch logined website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        
        //  Login
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("fto24137@omeie.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("fto24137@omeie.com");
        driver.findElement(By.xpath("//button[@name='login']")).click();

        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();

        // New tab, go website
        ((JavascriptExecutor) driver).executeScript("window.open('https://bantheme.xyz/hathanhauto/tai-khoan/')");
        
        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        String newWindow = driver.getWindowHandle();

        // Close old tab
        driver.switchTo().window(originalWindow);
        driver.close();
        driver.switchTo().window(newWindow);


        // 'Đăng nhập' click, verify redirect to account management
        driver.findElement(By.xpath("//strong[@class='block']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Thoát')]")).isDisplayed());

    }   

}
