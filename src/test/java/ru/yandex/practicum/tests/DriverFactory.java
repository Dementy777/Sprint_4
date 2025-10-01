package ru.yandex.practicum.tests;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.practicum.page.util.EnvConfig;
import java.time.Duration;

public class DriverFactory extends ExternalResource {
    public WebDriver getDriver() {
        return driver;
    }
    private WebDriver driver;

    public void initDriver(){
        if ("firefox".equals(System.getProperty("browser"))){
            startFireFox();
        }else {
            startChrome();
        }
    }

    private void startChrome() {
        //инициализируем поле driver в методе starChrome на фабрике
        driver = new ChromeDriver();
        //ожидание 15 сек
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EnvConfig.IMPLICITY_TIMEOUT));
        driver.manage().window().maximize();

    }
    private void startFireFox() {
        //инициализируем поле driver в методе startFireFox на фабрике
        driver = new FirefoxDriver();
        //ожидание 15 сек
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EnvConfig.IMPLICITY_TIMEOUT));
        driver.manage().window().maximize();
    }

    public void before(){
        initDriver();
    }

    public void after(){
        driver.quit();
    }
}
