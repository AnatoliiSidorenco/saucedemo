public class Explenation {
    /**

                        -- BasePage --

     я наследую от него Web Driver -- для классов где описываю локаторы и методы пример LoginPage


     public SideBar(WebDriver driver) {
     super(driver);
     }

                        -- BaseTest --
     описал для метода  succesLogin в LoginPage поля и сам обьект который передаю
     String validUserNameValue = "standard_user";
     String validPasswordValue = "secret_sauce";
     User validUser = new User(validUserNameValue, validPasswordValue);

    Описал ссылку на Вебсайт
      в @Befor -- связка Webdriver с компа в программу
     а потом driver.get(Base_URL); перейди по данной ссылке

     @After
     public void tearDown() {
     driver.quit();             метод поле выполнения теста выйди из браузера
     }

                         -- User --

     Клас в котором описаны поля и какимы должны быть переменные и какого типа для входа и что б доступ был только у меня



                       -- LoginPage ---
     Описан метод успешной регистрации
     описан метод ошибки при не верных данных


     InventoryPage --> BasePge
     InventoryTest --> BaseTest

     SideBar --> BasePage
     SideTest --> BaseTest

     * */




}
