package testcases;

import com.google.common.base.Verify;
import com.qa.crm.base.TestBase;
import com.qa.crm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class loginPageTest extends TestBase
{

    LoginPage loginPage;

    public loginPageTest() throws IOException {
        super();


    }

    @BeforeMethod

    public void setUp() throws IOException {

        initialization();
        loginPage=new LoginPage();
    }

    @Test(priority = 1)

    public void loginPageTitleTest(){
        String title=loginPage.validateLoginPage();
        Assert.assertEquals( title,"#1 Free CRM for Any Business: Online Customer Relationship Software" );

    }
    @Test(priority=2)
    public void CRMLogoTest(){

        boolean flag=loginPage.validateCRMImage();
        Assert.assertTrue( flag );


    }

    @Test(priority = 3)

    public void loginTest(){

        loginPage.login( prop.getProperty("username"),prop.getProperty( "password" ) );
    }


    @AfterMethod

    public void tearDown(){

        driver.quit();
    }


}
