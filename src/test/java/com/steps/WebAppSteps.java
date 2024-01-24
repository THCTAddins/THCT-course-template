package com.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebAppSteps {
    WebDriver driver;

    @Given("browser is opened")
    public void browser_is_opened(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.ivivu.com/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @When("enter mail {string}")
    public void enter_mail(String s) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
            .clickTkbtn()
            .clickDnbtn()
            .sendEmail(s);
    }
   

    @When("enter pass {string}")
    public void enter_pass(String s) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
            .enterPass(s);
    }

    @When("click submit")
    public void click_submit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
            .clickLoginbtn();
    }

    @Then("verify login success")
    public void verify_login_success() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Đăng xuất')]")).isEnabled());
        driver.quit();
    }
}
