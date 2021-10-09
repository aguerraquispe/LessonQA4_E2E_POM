package com.dataprovide;

import com.opencart.utilities.StringFunctions;
import org.testng.annotations.DataProvider;

public class SignUpDataProvider {
    int n = 15;
@DataProvider(name="valid data")
    public Object[][] validData(){
    return new Object[][]{
            {"henry","jimenez", StringFunctions.randomEmail(n),"123456","password123","password123"}
    };
    }

@DataProvider(name="missing fields")
public Object[][] missingField(){
    return new Object[][]{
            {null,"jimenez", StringFunctions.randomEmail(n),"123456","password123","password123"},
            {"henry",null, StringFunctions.randomEmail(n),"123456","password123","password123"},
            {"henry","jimenez", null,"123456","password123","password123"},
            {"henry","jimenez", StringFunctions.randomEmail(n),null,"password123","password123"},
            {"henry","jimenez", StringFunctions.randomEmail(n),"123456",null,"password123"},
            {"henry","jimenez", StringFunctions.randomEmail(n),"123456","password123",null}
    };
}
@DataProvider(name="email missing at")
    public Object[][] emailMissingAt(){
        return new Object[][]{
                {"henry","jimenez", "hola_hola.com","123456","password123","password123"},
                {"henry","jimenez", "hola_mundo.com","123456","password123","password123"},
                {"henry","jimenez", "hola_wordss.com","123456","password123","password123"},
                };
    }
    @DataProvider(name="email missing dot com")
    public Object[][] missingDotCom(){
        return new Object[][]{
                {"henry","jimenez", "hol@hola","123456","password123","password123"},
                {"henry","jimenez", "hol@mundo","123456","password123","password123"},
                {"henry","jimenez", "hola@wordss.35","123456","password123","password123"},
        };
    }
    @DataProvider(name="different password")
    public Object[][] differentPassword(){
        return new Object[][]{
                {"henry","jimenez", StringFunctions.randomEmail(n),"123456","password123","password1234"},
                {"henry","jimenez", StringFunctions.randomEmail(n),"123456","password123","password1235"},
                {"henry","jimenez", StringFunctions.randomEmail(n),"123456","password1223","password123"},
        };
    }
}
