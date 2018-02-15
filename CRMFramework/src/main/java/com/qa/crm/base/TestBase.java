package com.qa.crm.base;

import com.qa.crm.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;


    public TestBase() throws IOException {
         prop=new Properties(  );

        FileInputStream ip=new FileInputStream("C:\\Users\\yepurin\\IdeaProjects\\CRMFramework\\src\\main\\java\\com\\qa\\crm\\config\\config.properties");

        prop.load( ip );

    }

    //Initialization

    public static void initialization() {

        String browserName = prop.getProperty( "browser" );

        if(browserName.equalsIgnoreCase( "chrome" )){

            System.setProperty( "webdriver.chrome.driver", "C:\\Users\\yepurin\\Downloads\\Drivers 2\\chromedriver.exe" );

            driver=new ChromeDriver(  );
        }
        else if(browserName.equalsIgnoreCase( "FF" ))
        {
            driver=new FirefoxDriver(  );
            System.setProperty( "webdriver.gecko.driver", "C:/Users/yepurin/Downloads/Drivers/geckodriver.exe");
        }
        driver.get(prop.getProperty( "url" ));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS );
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS  );
        driver.manage().deleteAllCookies();



    }

}
