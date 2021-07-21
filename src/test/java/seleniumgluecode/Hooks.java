package seleniumgluecode;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private static ChromeDriver driver;
    private static int numberOfCase = 0;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\KEVIN ALVAREZ\\cucumber\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://parabank.parasoft.com/parabank/index.htm");
        driver.manage().window().maximize();
          }

    @After
    public void tearDown(){
        driver.quit();
    }

    public static ChromeDriver getDriver() {
        return driver;
    }
}
