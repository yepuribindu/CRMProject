package com.qa.crm.pages;

import com.qa.crm.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends TestBase {


    @FindBy(name = "username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath ="//button[contains(text(),\"Sign Up\")]" )
    WebElement signupBtn;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    WebElement loginBtn;

    @FindBy(xpath="//img[contains(@class,'img-responsive')]")
    WebElement crmLogo;




    public LoginPage() throws IOException {

        PageFactory.initElements( driver,this );
    }
    //Actions

    public void login(String un,String pw){
        username.sendKeys( un );
        password.sendKeys( pw );
        loginBtn.submit();

    }

     public String validateLoginPage()
     {

        return driver.getTitle();

     }

        public boolean validateCRMImage(){

            return crmLogo.isDisplayed();
        }

}
