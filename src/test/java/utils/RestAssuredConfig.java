package utils;

import io.restassured.RestAssured;

public class RestAssuredConfig {

    static {
        // Устанавливаем базовый URI один раз
        RestAssured.baseURI = "https://opm-website.iot-asm-test1.insitech.live";
    }

    /**
     * Метод для получения полного URL.
     *
     * @param endpoint Остаток URL (endpoint).
     * @return Полный URL.
     */
    public static String buildUrl(String endpoint) {
        return RestAssured.baseURI + endpoint;
    }
}