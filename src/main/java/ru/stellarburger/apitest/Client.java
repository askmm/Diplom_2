package ru.stellarburger.apitest;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Client {
    static final String BASE_URI = "https://stellarburgers.nomoreparties.site/";
    static final String API = "api";

    static final String INGREDIENTS_API = "/ingredients";


    protected static RequestSpecification spec() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .basePath(API);
    }
}
