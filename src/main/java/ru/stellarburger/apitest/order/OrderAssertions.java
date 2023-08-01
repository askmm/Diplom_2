package ru.stellarburger.apitest.order;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import static java.net.HttpURLConnection.*;

public class OrderAssertions {
    @Step("Order created; status 200")
    public void orderPlacedSuccessfully(ValidatableResponse response){
        response.assertThat()
                .statusCode(HTTP_OK);
    }

    @Step("Got user's orders; status 200")
    public void getOrdersSuccessfully(ValidatableResponse response){
        response.assertThat()
                .statusCode(HTTP_OK);
    }

    @Step("Got all orders; status 200")
    public void orderCreationFailedUnauth(ValidatableResponse response){
        response.assertThat()
                .statusCode(HTTP_FORBIDDEN);
    }

    @Step("Couldn't create empty order; status 300")
    public void emptyOrderCreationFailed(ValidatableResponse response){
        response.assertThat()
                .statusCode(HTTP_BAD_REQUEST);
    }

    @Step("Couldn't create order with wrong ingredient hash; status 500")
    public void wrongIngredOrderCreationFailed(ValidatableResponse response){
        response.assertThat()
                .statusCode(HTTP_INTERNAL_ERROR);
    }
}
