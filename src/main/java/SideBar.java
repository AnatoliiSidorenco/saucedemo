import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SideBar extends BasePage{


    public SideBar(WebDriver driver) {
       super(driver);
    }

    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItems;

    @FindBy(id = "about_sidebar_link")
    private WebElement about;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logOut;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetAppState;

    @FindBy(xpath = "bm-item-list")  //    Элементы Burger Menu
    private List<WebElement> burgerMenuItems;



    public boolean checkAllItemsBurgerMenuDisplayed() { // метод проверки элементов на отображение в меню

            for (WebElement item : burgerMenuItems) {
                if (!item.isDisplayed()) {
                    return false;
                }
            }
            return true;
        }

    public boolean inventoryBurgerMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(allItems)); // как только элемент становиться активным
        return allItems.isDisplayed();
    }
    public boolean inventoryBurgerMenu4() {
        return about.isDisplayed();
    }
    public boolean inventoryBurgerMenu2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // можно использовать для LogOut
        wait.until(ExpectedConditions.visibilityOf(logOut));
        return logOut.isDisplayed();
    }
    public boolean inventoryBurgerMenu3() {
        return resetAppState.isDisplayed();
    }

    //todo ---------------------- Метод для клика на ссылку Logout из BurgerMenu -- > Inventory Page

    public void clickOnLogOutLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logOut));
       logOut.click();
    }

}
