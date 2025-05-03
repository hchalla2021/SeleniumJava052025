package OrangeHRMPages;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestUtil;

import java.util.List;

public class OrangeHRMPage extends BaseClass {
    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameField;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")
    WebElement AdminMenu;

    public OrangeHRMPage() {
        PageFactory.initElements(driver, this);
    }
    public OrangeHRMPage Login(String username, String password) {
        //usernameField.sendKeys(username);
       // passwordField.sendKeys(password);
        TestUtil.sendKeysToElement(usernameField, username);
        TestUtil.sendKeysToElement(passwordField, username);
        //loginButton.click();
        TestUtil.clickOnElement(loginButton);
        return new OrangeHRMPage();
    }
    public OrangeHRMPage AdminOperation() throws InterruptedException {
        AdminMenu.click();
        Thread.sleep(3000);

        return new OrangeHRMPage();
    }
}
