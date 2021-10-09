package com.opencart.accounttests;

import com.dataprovide.SignUpDataProvider;
import com.opencart.Base;
import com.pageobjects.MainPage;
import com.pageobjects.SignUpFormPage;
import com.pageobjects.SignUpSuccesPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class SignUp extends Base {
    private MainPage mainPage;
    private SignUpFormPage signUpFormPage;
    private SignUpSuccesPage signUpSuccesPage;

    @BeforeTest
    public void initialize(){
        driver=initializedDriver();
        mainPage= new MainPage(driver);
        signUpFormPage=new SignUpFormPage(driver);
        signUpSuccesPage=new SignUpSuccesPage(driver);
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get(mainPage.getUrl());
        mainPage.clickBtnRegister();
    }

    @Test(dataProvider = "valid data",dataProviderClass = SignUpDataProvider.class)
    public void testUserRegistrationValidData(String firstName,String lastName, String email, String phone,
                                              String password, String passwordConfirmed){
        signUpSuccesPage = new SignUpSuccesPage(driver);
        signUpFormPage.fillForm(firstName,lastName,email,phone,password,passwordConfirmed);
        Assert.assertTrue(signUpSuccesPage.lblSuccessIsDisplayed());
    }

    @Test(dataProvider = "missing fields",dataProviderClass = SignUpDataProvider.class)
    public void testUserRegistrationMissingFields(String firstName,String lastName, String email, String phone,
                                              String password, String passwordConfirmed){
        signUpFormPage.fillForm(firstName,lastName,email,phone,password,passwordConfirmed);
        Assert.assertTrue(signUpFormPage.lblErrorGeneralIsDisplayed());
    }

    @Test(dataProvider = "email missing at",dataProviderClass = SignUpDataProvider.class)
    public void testUserRegistrationInvalidEmailMissingAt(String firstName,String lastName, String email, String phone,
                                                  String password, String passwordConfirmed){
        signUpFormPage.fillForm(firstName,lastName,email,phone,password,passwordConfirmed);
        //Message displayed : Missing @
    }

    @Test(dataProvider = "email missing dot com",dataProviderClass = SignUpDataProvider.class)
    public void testUserRegistrationInvalidEmailMissingDotCom(String firstName,String lastName, String email,
                                                            String phone,
                                                   String password, String passwordConfirmed){
        signUpFormPage.fillForm(firstName,lastName,email,phone,password,passwordConfirmed);
        Assert.assertTrue(signUpFormPage.lblErrorWrongEmailIsDisplayed());
    }

    @Test(dataProvider = "different password",dataProviderClass = SignUpDataProvider.class)
    public void testUserRegistrationDifferentPassword(String firstName,String lastName, String email,
                                                              String phone,
                                                              String password, String passwordConfirmed){
        signUpFormPage.fillForm(firstName,lastName,email,phone,password,passwordConfirmed);
        Assert.assertTrue(signUpFormPage.lblErrorMismatchPasswordIsDisplayed());
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
















