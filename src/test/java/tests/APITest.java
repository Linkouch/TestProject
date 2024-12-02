package tests;

import io.restassured.response.Response;
import models.ResponseData;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiClient;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class APITest {

    @Test
    public void testGetModels() {
        // Отправляем GET-запрос
        Response response = ApiClient.get("/api/strapi/models/336");

        // Проверяем статус-код
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");

        // Десериализуем JSON-ответ в объект
        ObjectMapper mapper = new ObjectMapper();
        try {
            ResponseData responseData = mapper.readValue(response.asString(), ResponseData.class);

            // Проверяем основные поля
            Assert.assertEquals(responseData.getPage(), 1, "Page is not 1");
            Assert.assertEquals(responseData.getPageSize(), 20, "Page size is not 20");
            Assert.assertEquals(responseData.getTotalCount(), 6, "Total count is not 6");

            // Проверяем имена моделей
            List<String> actualModelNames = responseData.getModels().stream().map(model -> model.getName()).toList();
            List<String> expectedModelNames = Arrays.asList(
                    "PlayStation 4 Pro",
                    "PlayStation 4 Slim",
                    "PlayStation 5",
                    "PlayStation Portal CFI-Y1001",
                    "PlayStation Vita",
                    "PlayStation Vita Slim"
            );

            Assert.assertEquals(actualModelNames, expectedModelNames, "Model names do not match.");
        } catch (Exception e) {
            Assert.fail("Failed to parse response JSON: " + e.getMessage());
        }
    }
}