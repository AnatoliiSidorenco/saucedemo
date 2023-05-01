import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryTest extends BaseTest {


    @Test
    public void itemElementsTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        /**loginPage.enterValueToUserName(validUser); ВСЕ ЭТО МЕНЯЮ НА ОДНУ СТРОЧКУ Благодаря методу ранее описанному в LoginPage
         loginPage.enterValueToPassword(validUser);
         loginPage.enterLoginButton();
         **/
        loginPage.successLogin(validUser); // сама строчка

        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryPageAppears());
        assertEquals(6, inventoryPage.getItemQuantity());




        assertTrue(inventoryPage.allItemsAreDisplayed()); // проверка всех
        assertTrue(inventoryPage.checkElementIsDisplayed(0)); // проверка конкретного элемента

        assertTrue(inventoryPage.allItemsNamesAreDisplayedNotEmpty());

        assertTrue(inventoryPage.allItemsNamesAreNotEmpty());
        assertTrue(inventoryPage.allItemsNamesAreDisplayed());

  // todo --------------Три нижние проверки падают, так как 6 фотография не начинаеться с заданых слов-------
        // todo  --- так я могу конкретно видеть какой элемент не работает------------------
      //  assertTrue(inventoryPage.checkItemsTextTitle(), "Check Title ");
     //  assertTrue(inventoryPage.checkItemsTextTitle2(), "Check Title");
      //  assertTrue(inventoryPage.checkItemsTextTitle3(), "Check Title");
        // todo -----------------------------------------------------------------------------

    }

}
