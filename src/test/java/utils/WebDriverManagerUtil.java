package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverManagerUtil {

    private static WebDriver driver;

    // Метод для получения WebDriver
    public static WebDriver getDriver() {
        if (driver == null) {
            // Автоматическая настройка драйвера с помощью WebDriverManager
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            // Настройки браузера
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
        return driver;
    }

    // Метод для завершения работы WebDriver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}