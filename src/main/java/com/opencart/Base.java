package com.opencart;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
    public WebDriver driver;

    public WebDriver initializedDriver(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();//aparece maximiizado
        return driver;
    }
}
