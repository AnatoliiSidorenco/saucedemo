import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement usernameInputField; // я в него записываю адрес ссылку где находиться елементик по Id
                                            // как todo  ----  WebElement usernameInputField = driver.findElement(By.id("user-name"));

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void enterValueToUserName(String userNameValue) {
        usernameInputField.sendKeys(userNameValue);
    }
    public void enterValueToPassword(String passwordValue){ // пишу метод с помощьюкоторого я смогу наполнить поле ввода конкретным значением
        passwordInputField.sendKeys(passwordValue);
    }
    public void enterLoginButton(){
        loginButton.click();
    }
}



