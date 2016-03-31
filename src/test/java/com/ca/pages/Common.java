package com.ca.pages;

import com.ca.runner.RunTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * edited by Derin on 26/1/16.
 */

public class Common extends RunTest{

    @FindBy(id = "lst-ib")
    public WebElement Search_field;

    @FindBy(name = "x")
    public WebElement Header;


    public Common(){
        PageFactory.initElements(driver, this);
    }

}
