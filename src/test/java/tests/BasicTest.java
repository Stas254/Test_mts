package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class BasicTest {
    WebDriver wdm;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        wdm = new ChromeDriver();
        wdm.get("https://www.mts.by/");
        wdm.manage().window().maximize();
        wdm.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterEach
    public void tearDown() {
        wdm.quit();
    }

}