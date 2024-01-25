package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.DriverManager;

public class Bai_23 extends BasicTest {

    // @Parameters({"baseURL"})
    @Test()
    public void loginTest(){//String webURL) {      

        WebDriver driver = DriverManager.getDriver();
        String url = "https://www.ivivu.com/";
        driver.get(url);

        //  Login lfl26900@zslsz.com
        String uname = "lfl26900@zslsz.com";
        String pwd = "lfl26900@zslsz.com";

        LoginPage loginPage = new LoginPage(driver);

        loginPage
            .clickTkbtn()
            .clickDnbtn()
            .sendEmail(uname)
            .clickLoginbtn();
        Assert.assertTrue(getHtml5ValidationMessage(loginPage.pass).contains("Please fill out this field"));
        
        loginPage
            .enterPass(pwd)
            .clickLoginbtn();
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Đăng xuất')]")).isEnabled());

    }

    public String getHtml5ValidationMessage(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
    }

}
