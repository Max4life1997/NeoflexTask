package settings;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public static void setup(){
        String browserType;
        driver = new ChromeDriver();
//        System.out.println("driver " + Init.BROWSER_TYPE);
//        switch (Init.BROWSER_TYPE){
//            case "Chrome": driver = new ChromeDriver(); break;
//            case "FireFox": driver = new FirefoxDriver(); break;
//        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
    }

    @AfterClass
    public static void close() throws InterruptedException {
        wait.wait(50);
        if (driver != null){
            driver.quit();
        }
    }
}
