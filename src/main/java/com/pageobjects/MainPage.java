package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver;

    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement btnMyAccount;

    @FindBy(xpath = "//a[contains(.,'login')]")
    private WebElement btnLogin;

    @FindBy(xpath = "//a[contains(.,'Register')]")//el punto es para cualquier atributo
    private WebElement btnRegister;

    public final String url="https://demo.opencart.com";

    public MainPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String getUrl(){
        return url;
    }

    public void clickBtnRegister(){
        btnMyAccount.click();
        btnRegister.click();
    }
}
