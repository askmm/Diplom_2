package ru.stellarburger.apitest.order;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.stellarburger.apitest.Client;
import ru.stellarburger.apitest.pojo.IngredientList;

public class OrderClient extends Client {

    static final String ORDERS_API = "/orders";
    static final String ORDERS_ALL = ORDERS_API + "/all";

    @Step("Create order")
    public ValidatableResponse createOrder(String jwt, IngredientList order){
        return spec()
                .auth().oauth2(jwt)
                .body(order)
                .post(ORDERS_API)
                .then();
    }

    @Step("Request orders of user")
    public ValidatableResponse getOrders(String jwt){
        return spec()
                .auth().oauth2(jwt)
                .get(ORDERS_API)
                .then();
    }

    @Step("Request all orders")
    public ValidatableResponse getAllOrders(){
        return spec()
                .get(ORDERS_ALL)
                .then();
    }
}
