import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InventoryPage extends BasePage{  // наследует BasePage где я вынес все повторяющиеся элементы


    public InventoryPage(WebDriver driver) {
      super(driver);
    } // super метод передачи параметров родителю из BasePage


    @FindBy(className = "inventory_list")
    private WebElement inventoryList;

    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;
    @FindBy(className = "inventory_item_name")
    private List<WebElement> inventoryItemsname;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuButton;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuBtn;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpackAddToCart;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement jacket;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement tShirt;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

// todo ---------------- Д\з проверка что страница с фотографиями отображаеться -----------------
    public boolean inventoryPageAppears() {
        return inventoryList.isDisplayed();
    }

    public boolean allItemsAreDisplayed() {
        for (WebElement item : inventoryItems) { // проверка всех
            if (!item.isDisplayed()) {
                return false;
            }
        }
        return true;
    }
    //    public boolean everyItemAreDisplayed() {
    //    boolean displayed = true;
//        for (WebElement item: inventoryItems){ // проверка всех
//            if (item.isDisplayed() != true) {
//                displayed =  false;
//            }
//        }
//        return displayed;
//    }


    public boolean checkElementIsDisplayed(int index) { // проверка одного элеиента
        return inventoryItems.get(index).isDisplayed();
    }


    public int getItemQuantity() { // проверка количества экземпляров в списке
        return inventoryItems.size();
    }


//todo ---------------------- Одновременно isDisplayed и isEmpty ----------------------
    public boolean allItemsNamesAreDisplayedNotEmpty() {
        for (WebElement item : inventoryItemsname) { // проверка всех
            if (!item.isDisplayed() || item.getText().isEmpty()) { // лучше делать два разных метода проверки
                return false;
            }
        }
        return true;
    }
    //todo ----------------------  isEmpty ----------------------
    public boolean allItemsNamesAreNotEmpty() {
        for (WebElement item : inventoryItemsname) { // проверка всех
            if (item.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }
    //todo ----------------------  isDisplayed ----------------------
    public boolean allItemsNamesAreDisplayed() {
        for (WebElement item : inventoryItemsname) { // проверка всех
            if (!item.isDisplayed()) {
                return false;
            }
        }
        return true;
    }
//todo ---------------------------------- 3 способа проверки или все элементы содержать слово в названии --------
    public boolean checkItemsTextTitle() {
        boolean allContains = true;
        int index = 1;
        for (WebElement item : inventoryItemsname) { // проверка всех
            if (!item.getText().contains("Sauce Labs")) { // todo  сторока contains("Sauce Labs")
                allContains=false;
                System.out.println("Item with product ["+ index +"] is not contains Sause Labs");
            }
            index++;
        }
        return allContains;
    }
// Добавляю index = 0 или 1, и index++ что б я мог вывести конкретный элемент
    public boolean checkItemsTextTitle2() {
        boolean allContains = true;
        int index = 1;  // если единичка, то считаю по фоткам как в жизни, если 0 так начинаеться индекс
        for (WebElement item : inventoryItemsname) { // проверка всех
            if (!item.getText().startsWith("Sauce Labs")) { // todo  сторока startsWith ("Sauce Labs")
                allContains=false;
                System.out.println("Item with product ["+ index +"] is not Starts Sause Labs");
            }
            index++;
        }
        return allContains;
    }

    public boolean checkItemsTextTitle3() {
        boolean allContains = true;

        for (WebElement item : inventoryItemsname) { // проверка всех
            if (!item.getText().startsWith("Sauce Labs")) {
                allContains=false;
                System.out.println("Item with product ["+ (inventoryItemsname.indexOf(item)+1)+"] is not Starts Sause Labs");
            }

        }
        return allContains;
    }
    //todo -------------------------------------------------------------------------------------------------------------
    public void pushOnBurgerMenuButton(){  // без ожидания
        burgerMenuButton.click();
    }
    public void clickOnBurgerMenuBtn(){ // с ожиданием, но разница между sleep и wait, что
                                        // wait ждет не все время, а как только условие произошло,
                                        // ожидание прекращается, а значит затраты на время меньше
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(burgerMenuBtn));
        burgerMenuBtn.click();
    }
    public void clickBackpackAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(backpackAddToCart));
        backpackAddToCart.click();
    }
    public void clickJacketToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(jacket));
        jacket.click();
    }
    public void clickTshirtAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(tShirt));
        tShirt.click();
    }

    public void clickOnCartItem(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        cartIcon.click();
    }
}


