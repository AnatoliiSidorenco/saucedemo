import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "cart_item")
    private List<WebElement> items;

    public int getItemsOfQuantity() {
        return items.size();
    }


    public boolean itemsAreNotDisplayed() {
        boolean empty = true;
            for (WebElement item : items) {
                if (item.isDisplayed()) {
                    empty = false;
                }
            }
            return empty;
        }
    }


