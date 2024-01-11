package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "UserLogin")
    public WebElement tk;

    @FindBy(xpath = "//ul[contains(@class, 'dropdown-menu')]//btn[text() = 'Đăng nhập']")
    public WebElement dn;
    
    @FindBy(xpath = "//input[@name='EmailPhoneDN']")
    public WebElement email;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement pass;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginBtn;


    public LoginPage clickTkbtn() {
        WaitFind(tk);
        tk.click();
        return this;
    }

    public LoginPage clickDnbtn() {
        WaitFind(dn);
        dn.click();
        return this;
    }

    public LoginPage sendEmail(String value) {
        WaitFind(email);
        email.clear();
        email.sendKeys(value);
        return this;
    }

    public LoginPage enterPass(String value) {
        WaitFind(pass);
        pass.clear();
        pass.sendKeys(value);
        return this;
    }

    public LoginPage clickLoginbtn() {
        WaitFind(loginBtn);
        loginBtn.click();
        return this;
    }
}
