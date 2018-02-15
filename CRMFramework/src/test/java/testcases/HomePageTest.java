package testcases;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;

    public HomePageTest() throws IOException {
        super();
    }


    @BeforeMethod

    public void setUp() throws IOException {

        initialization();
        loginPage=new LoginPage();
        loginPage.login( prop.getProperty("username"),prop.getProperty( "password" ) );
        homePage=new HomePage();

    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest(){
        String homepageTitle=homePage.verifyHomePageTitle();
        Assert.assertEquals( homepageTitle, "CRMPRO","Home page title not matched");
    }

    @Test(priority = 2)

    public void verifyUserNameTest(){

        boolean flag=homePage.verifyCorrectUserName();

    }

    @Test(priority = 3)

    public void verifyContactsLinkTest(){

      homePage.clickOnContactsLink();
    }



}
