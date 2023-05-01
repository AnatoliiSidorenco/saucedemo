import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SideBarTest extends BaseTest{


@Test
    public void checkAllLinksAreDisplayed() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryPageAppears());


    inventoryPage.clickOnBurgerMenuBtn();


        SideBar sideBar = new SideBar(driver);


          assertTrue(sideBar.inventoryBurgerMenu());
          assertTrue(sideBar.inventoryBurgerMenu2());
          assertTrue(sideBar.inventoryBurgerMenu3());
          assertTrue(sideBar.inventoryBurgerMenu4());


    /**
     *    assertTrue(sideBar.checkAllItemsBurgerMenuDisplayed(0));
     *         assertTrue(sideBar.checkAllItemsBurgerMenuDisplayed(1));
     *         assertTrue(sideBar.checkAllItemsBurgerMenuDisplayed(2));
     *         assertTrue(sideBar.checkAllItemsBurgerMenuDisplayed(3));
      **/



}

}
