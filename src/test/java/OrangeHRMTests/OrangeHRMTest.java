package OrangeHRMTests;

import Base.BaseClass;
import OrangeHRMPages.OrangeHRMPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseClass {
    OrangeHRMPage orangeHRMPage;

    public OrangeHRMTest() {
        super();
    }

    @BeforeMethod
    public void startingPoint() throws InterruptedException {
        startsA();
        orangeHRMPage = new OrangeHRMPage();

    }

    @Test(priority = 1)
    public void loginTest() {
        orangeHRMPage = orangeHRMPage.Login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 2)
    public void AdminSection() throws InterruptedException {
        orangeHRMPage = orangeHRMPage.AdminOperation();
    }

   @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
