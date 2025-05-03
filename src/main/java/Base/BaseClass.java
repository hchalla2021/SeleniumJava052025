package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utils.WebEventListener;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver edriver;
    public static WebEventListener EventDriver;
    
    public BaseClass() {//Bas class

        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("C:\\Users\\hchalla2020\\NewWorkSpace2023\\NewWorkSpace20233\\PageObjectModel182025\\src\\main\\java\\config\\config.properties");
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startsA() throws InterruptedException {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equals("Edge")) {
            driver = new EdgeDriver();
        }
        edriver = new EventFiringWebDriver(driver);
        EventDriver = new WebEventListener();
        edriver.register(EventDriver);
        driver = edriver;
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
        Thread.sleep(5000);
    }
}
