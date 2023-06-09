import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    ChromeDriver driver;
    String Base_URL = "https://www.saucedemo.com";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\EducationProg\\seleniumchromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
     //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // ожидание прежде чем загрузить страницу
        driver.get(Base_URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    String validUserNameValue = "standard_user";
    String validPasswordValue = "secret_sauce";

    User validUser = new User(validUserNameValue, validPasswordValue);
    User lockOutUser = new User("locked_out_user", "secret_sauce");
    User inValidUser = new User("Hjuyt", "secret_sauce");
}
