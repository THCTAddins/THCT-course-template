package com;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai_17 extends BasicTest {


    @Test()
    public void loginTest() throws Exception {
        //fto24137@omeie.com
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //  Login
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("fto24137@omeie.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("fto24137@omeie.com");
        driver.findElement(By.xpath("//button[@name='login']")).click();

        // 'Tài khoản' hyperlink click
        driver.findElement(By.xpath("//a[contains(text(),'Tài khoản')]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://bantheme.xyz/hathanhauto/tai-khoan/edit-account/");

        // 'Thoát' hyperlink click
        driver.findElement(By.xpath("//a[contains(text(),'Thoát')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//button[@name='login']")).isDisplayed());

        // Back click - Verify người dùng không chuyển đến quản lý tài khoản
        driver.navigate().back();
        Assert.assertTrue(driver.findElement(By.xpath("//button[@name='save_account_details']")).isDisplayed());

        
    }   

}
