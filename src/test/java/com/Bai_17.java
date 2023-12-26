package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai_17 extends BasicTest {


    @Test()
    public void loginTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Submit
        WebElement btn_submit = driver.findElement(By.xpath("//button[@name=\"register\"]"));
        btn_submit.click();
        WebElement fail_txt = driver.findElement(By.xpath("//ul[@class=\"woocommerce-error\"]"));
        Assert.assertTrue(fail_txt.getText().contains("Vui lòng cung cấp địa chỉ email hợp lệ."));

        // 123@456
        WebElement fld_reg2 = driver.findElement(By.id("reg_email"));
        fld_reg2.clear();
        fld_reg2.sendKeys("123@456");
        WebElement btn_submit2 = driver.findElement(By.xpath("//button[@name=\"register\"]"));
        btn_submit2.click();
        WebElement fail_txt2 = driver.findElement(By.xpath("//ul[@class=\"woocommerce-error\"]"));
        Assert.assertTrue(fail_txt2.getText().contains("Vui lòng cung cấp địa chỉ email hợp lệ."));

        // qwerty@gmail.com
         WebElement fld_reg3 = driver.findElement(By.id("reg_email"));
        fld_reg3.clear();
        fld_reg3.sendKeys("qwerty@gmail.com");
        WebElement btn_submit3 = driver.findElement(By.xpath("//button[@name=\"register\"]"));
        btn_submit3.click();
        WebElement fail_txt3 = driver.findElement(By.xpath("//ul[@class=\"woocommerce-error\"]"));
        Assert.assertTrue(fail_txt3.getText().contains("Vui lòng nhập mật khẩu tài khoản."));

    }   

}
