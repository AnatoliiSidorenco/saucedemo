import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }

   // WebDriver driver;

  //  public LoginPage(WebDriver driver) {
    //        this.driver = driver;
    //        PageFactory.initElements(driver, this);
    //    }

    @FindBy(id = "user-name")
    private WebElement usernameInputField; // я в него записываю адрес ссылку где находиться елементик по Id
                                            // как todo  ----  WebElement usernameInputField = driver.findElement(By.id("user-name"));

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(tagName = "h3")
    private WebElement errorMessage;

    public void enterValueToUserName(User user) {

        usernameInputField.sendKeys(user.getUserName());
    }
    public void enterValueToPassword(User user){

        passwordInputField.sendKeys(user.getPassword());
    }
    public void enterLoginButton(){

        loginButton.click();
    }
    public void errorMessageAppearsTrue(String expectedText){
      assertEquals (expectedText, errorMessage.getText());

    }
    public String getErrorMessageText(){

        return errorMessage.getText();
    }

    public void successLogin(User user){
        usernameInputField.sendKeys(user.getUserName());
        passwordInputField.sendKeys(user.getPassword());
        loginButton.click();
    }

    public boolean loginButtonIsDisplayed() {

        return loginButton.isDisplayed();
    }
}



