package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class Bai_21b extends BasicTest {
    
    @Test()//dataProvider = "testLogin")
    public void loginTest() {      
        //  Login
        
        WaitFindElementWithXpath("//a[contains(@title,\"Mercedes SLK200, SLK300, GLK200, E260, C350-2742000207\")]").click();
        WaitFindElementWithXpath("//*[@value=\"england\"]");
        new Select(WaitFindElementWithId("pa_xuat-xu")).selectByValue("england");
        WaitFindElementWithXpath("//button[@class='single_add_to_cart_button button alt']").click();
        WaitFindElementWithId("logo").click();

        WaitFindElementWithXpath("//a[contains(@title,\"Lốc lạnh (máy nén) xe Mercedes E CLass, GLK Class, SLK Class\")]").click();
        WaitFindElementWithXpath("//button[@class=\"plus\"]").click();
        WaitFindElementWithXpath("//button[@class='single_add_to_cart_button button alt']").click();

        Assert.assertTrue(WaitFindElementWithXpath("//a[contains(@title,\"Giỏ hàng của bạn\")]/b").getText().equals("3"));

        Assert.assertTrue(WaitFindElementWithXpath("//*/tbody/tr[1]/td[3]").getText().contains("Bơm nước xe Mercedes SLK200, SLK300, GLK200, E260, C350-2742000207 - England"));
        Assert.assertTrue(WaitFindElementWithXpath("//*/tbody/tr[1]/td[4]").getText().contains("320,000"));
        Assert.assertTrue(WaitFindElementWithXpath("//*/tbody/tr[1]/td[5]/div/input").getAttribute("value").equals("1"));
        Assert.assertTrue(WaitFindElementWithXpath("//*/tbody/tr[1]/td[6]").getText().contains(String.format("%,d",320000*1)));

        Assert.assertTrue(WaitFindElementWithXpath("//*/tbody/tr[2]/td[3]").getText().contains("Lốc lạnh (máy nén) xe Mercedes E CLass, GLK Class, SLK Class"));
        Assert.assertTrue(WaitFindElementWithXpath("//*/tbody/tr[2]/td[4]").getText().contains("12,500,000"));
        Assert.assertTrue(WaitFindElementWithXpath("//*/tbody/tr[2]/td[5]/div/input").getAttribute("value").equals("2"));
        Assert.assertTrue(WaitFindElementWithXpath("//*/tbody/tr[2]/td[6]").getText().contains(String.format("%,d",12500000*2)));

        Assert.assertTrue(WaitFindElementWithXpath("//tr[@class=\"cart-subtotal\"]/td/span/bdi").getText().contains(String.format("%,d",12500000*2+320000)));
        Assert.assertTrue(WaitFindElementWithXpath("//tr[@class=\"order-total\"]/td/strong/span/bdi").getText().contains(String.format("%,d",12500000*2+320000)));


        Utils.hardWait();
    }

    public WebElement WaitFindElementWithId(String id) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    public WebElement WaitFindElementWithXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }
}
