package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtils {

    public static WebDriver getDriver() {
        WebDriver driver;
        String driverPath = "drivers/";
        String driverProperty = "webdriver.chrome.driver";
        String driverBin = "chromedriver";

        if (System.getProperty("browser") != null && !System.getProperty("browser").isEmpty()) {
            if (System.getProperty("browser").equals("firefox")) {
                driverBin = "geckodriver";
                driverProperty = "webdriver.gecko.driver";
            }
        }

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            driverBin = driverBin + ".exe";
        }

        System.setProperty(driverProperty, driverPath + driverBin);
        if (driverBin.contains("chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }

        return driver;
    }

}
