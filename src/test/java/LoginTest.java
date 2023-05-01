import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {
  //todo------------------------ Уже ненадо, так как наследуем клас в котором это описали-----------------
    //  ChromeDriver driver;
    //
    //    @Before
    //    public void setUp() {
    //        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\EducationProg\\seleniumchromedriver\\chromedriver.exe");
    //        ChromeOptions options = new ChromeOptions();
    //        options.addArguments("--remote-allow-origins=*");
    //        driver = new ChromeDriver(options);
    //        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    //        driver.get("https://www.saucedemo.com/");
    //    }
    //
    //    @After
    //    public void tearDown() {
    //        driver.quit();
    //    }


    //todo ----------------- Тест как ненадо писать----------------------------------
    @Test
    public void loginWithValidData() {
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("standard_user");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement inventoryList = driver.findElement(By.className("inventory_list"));
        assertTrue(inventoryList.isDisplayed());


    }
//todo -------------------------------------------------------------------------------------

//todo ----------------------------убераю в Base клас, что б здесь остались только тесты-------------------------

//    String validUserNameValue = "standard_user";
//    String validPasswordValue = "secret_sauce";
//
//    User validUser = new User(validUserNameValue, validPasswordValue); // так как я в классе User уже инициализировал все поля с помощью конструкторв, и их у меня 2
//    User lockOutUser = new User("locked_out_user", "secret_sauce");
//    User inValidUser = new User("Hjuyt", "secret_sauce");

    @Test
    public void LoginWithValidDataPO() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);  // todo -- создаю экземпляр класса, им я обращаюсь к методу а в скобках передаю значение или нет как в click
       // User validUser = new User("standard_user", "secret_sauce");
      //  validUser.getUserName(); также вынес в отдельный класс
        loginPage.enterValueToUserName(validUser);
        loginPage.enterValueToPassword(validUser);
        loginPage.enterLoginButton();
        sleep(2000);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryPageAppears());
    }

    @Test
    public void loginWithLockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);
        //User validUser = new User("locked_out_user", "secret_sauce");
        loginPage.enterValueToUserName(lockOutUser);
        loginPage.enterValueToPassword(lockOutUser);
        loginPage.enterLoginButton();
        //   loginPage.errorMessageAppearsTrue("Epic sadface: Sorry, this user has been locked out.");

        assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPage.getErrorMessageText());

        assertTrue(loginPage.getErrorMessageText().contains(" this user has been locked out"));

    }

    @Test
    public void loginWithInvalidData() {
        LoginPage loginPage = new LoginPage(driver);
      //  User validUser = new User("Hjuyt", "secret_sauce");
        loginPage.enterValueToUserName(inValidUser);
        loginPage.enterValueToPassword(inValidUser);
        loginPage.enterLoginButton();
        assertTrue(loginPage.getErrorMessageText().contains("Username and password do not match any user in this service"));
    }

}
