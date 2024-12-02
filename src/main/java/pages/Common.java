package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Common {

    private WebDriver driver;

    // Локаторы элементов
    private By searchInput = By.cssSelector("input[placeholder='Найти']");
    private By modalWindow = By.cssSelector("div.MuiBox-root.css-xlwy7t");
    private By modalItems = By.cssSelector("div.MuiBox-root.css-tg13jt p");

    // Конструктор
    public Common(WebDriver driver) {
        this.driver = driver;
    }

    // Методы взаимодействия
    public void enterSearchQuery(String query) {
        WebElement input = driver.findElement(searchInput);
        input.clear();
        input.sendKeys(query);
    }

    public boolean isModalWindowVisible() {
        return driver.findElements(modalWindow).size() > 0;
    }

    public List<WebElement> getModalItems() {
        return driver.findElements(modalItems);
    }
}