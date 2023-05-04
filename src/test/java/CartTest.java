import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest extends BaseTest{
    @Test
    public void successAddingItem() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryPageAppears());
        inventoryPage.clickBackpackAddToCart();
        inventoryPage.clickOnCartItem();
        CartPage cartpage = new CartPage(driver);
        //cartpage.getItemsOfQuantity(); // что в корзине
        assertEquals(1,cartpage.getItemsOfQuantity());
    }
    @Test
    public void successAdding3Items(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryPageAppears());

        inventoryPage.clickBackpackAddToCart();
        inventoryPage.clickJacketToCart();
        inventoryPage.clickTshirtAddToCart();
        inventoryPage.clickOnCartItem();

        CartPage cartPage = new CartPage(driver);

        assertEquals(3,cartPage.getItemsOfQuantity());
    }

 //todo ------------------------------------- Cart is Empty - проверка ----------------------------------------

    @Test
    public void cartIsEmpty() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryPageAppears());
        inventoryPage.clickOnCartItem();
        CartPage cartpage = new CartPage(driver);
        assertEquals(0,cartpage.getItemsOfQuantity());
    }
    @Test
    public void cartIsEmpty1() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryPageAppears());
        inventoryPage.clickOnCartItem();
        CartPage cartpage = new CartPage(driver);
        assertTrue(cartpage.itemsAreNotDisplayed());

    }
}
