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

        usernameInputField.sendKeys(user.getUserName()); // usernameInputField. -- переменная в которую записан путь  sendKeys - метод что б задать значение в поле
    }
    public void enterValueToPassword(User user){

        passwordInputField.sendKeys(user.getPassword());
    }
    public void enterLoginButton(){

        loginButton.click();
    }
    public void errorMessageAppearsTrue(String expectedText){
      assertEquals (expectedText, errorMessage.getText());     // ошибка случее неверного логина

    }
    public String getErrorMessageText(){  // ошибка случее неверного логина

        return errorMessage.getText();
    }

    public void successLogin(User user){                  //(User user) данные описаны в BaseTest --> обьяснение в explenation
        usernameInputField.sendKeys(user.getUserName()); // user.getUserName -- забери значение у User user и подставь в get.UserName
        passwordInputField.sendKeys(user.getPassword()); // usernameInputField. по этому адресу находиться поле для заполнения
        loginButton.click();
    }

    public boolean loginButtonIsDisplayed() {   // метод написаный для LogOutTest

        return loginButton.isDisplayed();
    }
}



