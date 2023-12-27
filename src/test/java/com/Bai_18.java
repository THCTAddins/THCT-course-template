package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai_18 extends BasicTest {


    @Test()
    public void loginTest() throws Exception {
        // Launch logined website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // New tab, go website
        // Close old tab
        // 'Đăng nhập' click, verify redirect to account management
        
    }   

}
