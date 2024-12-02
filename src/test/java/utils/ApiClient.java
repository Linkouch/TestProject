package utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ApiClient {

    /**
     * Выполняет GET-запрос.
     *
     * @param endpoint Остаток URL (endpoint).
     * @return Ответ запроса (Response).
     */
    public static Response get(String endpoint) {
        return given()
                .get(RestAssuredConfig.buildUrl(endpoint))
                .then()
                .extract()
                .response();
    }
}