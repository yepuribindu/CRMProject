package com.qa.crm.pages;

import com.qa.crm.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends TestBase {

   @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    WebElement contactsLink;

   @FindBy(xpath = "//a[contains(text(),'Deals')]")
   WebElement dealsLink;

   @FindBy(xpath = "//a[contains(text(),'Tasks')]")
   WebElement tasksLink;

   @FindBy(xpath="//td[contains(text(),\"Nishanth Yepuri\")]")
   WebElement userNameLabel;

    @FindBy(xpath = "//a[contains(text(),'New Contact')]")
    WebElement newContactLink;



    public HomePage() throws IOException {

        PageFactory.initElements( driver,this );
    }

    public String verifyHomePageTitle(){

        return driver.getTitle();
    }

    public boolean verifyCorrectUserName(){

        return userNameLabel.isDisplayed();
    }

    public void clickOnContactsLink()
    {
        contactsLink.click();

    }

    public void clickOnDeals()
    {
        dealsLink.click();
    }

    public void clickOnTasks()
    {
        tasksLink.click();
    }

    public void clickOnNewContactLink()
    {
        Actions action=new Actions( driver );
        action.moveToElement( contactsLink ).build().perform();
        newContactLink.click();
    }



}
