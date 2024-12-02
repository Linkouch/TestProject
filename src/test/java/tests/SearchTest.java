package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Common;

import java.util.List;

public class SearchTest extends BaseTest {

    @Test
    public void testSearchFunctionality() {
        Common SearchField = new Common(driver);

        // Ввод текста в поле поиска
        String searchQuery = "Телефон";
        SearchField.enterSearchQuery(searchQuery);

        // Проверка отображения модального окна
        Assert.assertTrue(SearchField.isModalWindowVisible(), "Модальное окно не отображается.");

        // Проверка элементов модального окна
        List<WebElement> items = SearchField.getModalItems();
        for (WebElement item : items) {
            Assert.assertTrue(item.getText().contains(searchQuery),
                    "Элемент не содержит поисковый запрос: " + item.getText());
        }
    }
}