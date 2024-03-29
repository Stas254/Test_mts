package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class BasicTest {
    WebDriver wdm;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        wdm = new ChromeDriver();
        wdm.manage().window().maximize();
        wdm.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @After
    public void tearDown() {
        wdm.close();
        wdm.quit();
    }

}