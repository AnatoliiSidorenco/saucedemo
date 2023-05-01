import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class LogOutTest extends BaseTest {


    @Test
    public void checkLogOutLink() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);                                  // сначала логинюсь (метод ранее описан в loginPage --> метод successLogin(validUser)

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assertions.assertTrue(inventoryPage.inventoryPageAppears());     // результат удачного логина появление InventoryPage (метод ранее описан в inventoryPage --> метод inventoryPageAppears())

        inventoryPage.clickOnBurgerMenuBtn();                           // нажать на BurgerMenu (метод ранее описан в inventoryPage --> метод clickOnBurgerMenuBtn())

        SideBar sideBar = new SideBar(driver);
        assertTrue(sideBar.inventoryBurgerMenu2());                   // проверка или отображается ссылка LogOut (метод ранее описан в sideBar --> метод inventoryBurgerMenu2())

        sideBar.clickOnLogOutLink();                                   //  нажать на ссылку Logout (метод ранее придуман мною  в sideBar --> метод clickOnLogOutLink())

        assertTrue(loginPage.loginButtonIsDisplayed());                // проверка или отображается кнопка Log in после Logout (метод ранее придуман мною в loginPage --> loginButtonIsDisplayed()


    }

}
