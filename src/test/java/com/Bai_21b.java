package com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.DriverManager;

public class Bai_21b extends BasicTest {

    @Parameters({"baseURL"})
    @Test()//dataProvider = "testLogin")
    public void AddProduct(String webURL) {

        WebDriver driver = DriverManager.getDriver();
        String url = webURL;
        driver.get(url);

        //  Product info
            //Array length
            String[] prdName = new String[2];
            String[] prdCheckoutName = new String[2];
            String[] prdVariable = new String[2];
            int[] prdPrice = new int[2];
            int[] prdNumber = new int[2];

            //Product 1
            prdName[0] = "Bơm nước xe Mercedes SLK200, SLK300, GLK200, E260, C350-2742000207";
            prdCheckoutName[0] = "Bơm nước xe Mercedes SLK200, SLK300, GLK200, E260, C350-2742000207 - England";
            prdVariable[0] = "england";
            prdPrice[0] = 320000;
            prdNumber[0] = 1;

            //Product 2
            prdName[1] = "Lốc lạnh (máy nén) xe Mercedes E CLass, GLK Class, SLK Class";
            prdCheckoutName[1] = "Lốc lạnh (máy nén) xe Mercedes E CLass, GLK Class, SLK Class";
            prdPrice[1] = 12500000;
            prdNumber[1] = 2;
        
        //  Add Product to cart
        //  Product 1
        WaitFindElementWithXpath("//a[contains(@title,'"+prdName[0]+"')]").click();
        WaitFindElementWithXpath("//option");
        new Select(WaitFindElementWithId("pa_xuat-xu")).selectByValue(prdVariable[0]);
        WaitFindElementWithXpath("//button[@class='single_add_to_cart_button button alt']").click();
        //  Back to homepage
        WaitFindElementWithId("logo").click();
        //  Product 2
        WaitFindElementWithXpath("//a[contains(@title,'"+prdName[1]+"')]").click();
        WaitFindElementWithXpath("//button[@class=\"plus\"]").click();
        WaitFindElementWithXpath("//button[@class='single_add_to_cart_button button alt']").click();

        // Count & assert
        int sumOfProducts = 0;
        int noOfProducts = 0;

        List<WebElement> products = driver.findElements(By.xpath("//table[@class=\"shop_table shop_table_responsive cart woocommerce-cart-form__contents\"]/tbody/tr[contains(@class, 'cart_item')]"));
        for (int i=0; i < products.size(); i++) {
            //  Assert Products
            Assert.assertTrue(products.get(i).findElement(By.xpath(".//td[3]")).getText().contains(prdCheckoutName[i]));
            Assert.assertTrue(products.get(i).findElement(By.xpath(".//td[4]")).getText().contains(String.format("%,d",(prdPrice[i]))));
            Assert.assertTrue(products.get(i).findElement(By.xpath(".//td[5]/div/input")).getAttribute("value").equals(String.valueOf(prdNumber[i])));
            Assert.assertTrue(products.get(i).findElement(By.xpath(".//td[6]")).getText().contains(String.format("%,d",(prdPrice[i]*prdNumber[i]))));
            //  Save products number and total price
            noOfProducts += Integer.valueOf(products.get(i).findElement(By.xpath(".//input[@type=\"number\"]")).getAttribute("value"));
            sumOfProducts += Integer.valueOf(prdPrice[i]*prdNumber[i]);

        }

        //  Assert product number
        Assert.assertTrue(WaitFindElementWithXpath("//a[contains(@title,\"Giỏ hàng của bạn\")]/b").getText().equals(String.valueOf(noOfProducts)));

        //  Assert Total Table
        Assert.assertTrue(WaitFindElementWithXpath("//tr[@class=\"cart-subtotal\"]/td").getText().contains(String.format("%,d",sumOfProducts)));
        Assert.assertTrue(WaitFindElementWithXpath("//tr[@class=\"order-total\"]/td").getText().contains(String.format("%,d",sumOfProducts)));

    }

    public WebElement WaitFindElementWithId(String id) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
        return wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }

    public WebElement WaitFindElementWithXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }
}
