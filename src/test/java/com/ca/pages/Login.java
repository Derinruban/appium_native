package com.ca.pages;

import com.ca.runner.RunTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by deriruba on 3/31/16.
 */
public class Login extends RunTest{

    @FindBy(id = "username")
    public WebElement Username;

    @FindBy(id = "password")
    public WebElement Password;

    @FindBy(id = "loginButton")
    public WebElement Login_button;


    public Login(){
        PageFactory.initElements(driver, this);
    }
}
