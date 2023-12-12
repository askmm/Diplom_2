package ru.stellarburger.apitest;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import ru.stellarburger.apitest.order.OrderAssertions;
import ru.stellarburger.apitest.order.OrderClient;
import ru.stellarburger.apitest.pojo.IngredientList;

import java.util.List;

import static ru.stellarburger.apitest.user.UserGenerator.randomUser;

public class OrderTest extends CommonTest {
    OrderClient orderClient = new OrderClient();
    OrderAssertions orderCheck = new OrderAssertions();

    @Test
    public void createOrderAuthSuccessfully(){
        createUserAndFillJWT(randomUser());
        IngredientList ingredientList = new IngredientList(List.of("61c0c5a71d1f82001bdaaa6d",
                "61c0c5a71d1f82001bdaaa6f",
                "61c0c5a71d1f82001bdaaa71"));
        ValidatableResponse response = orderClient.createOrder(jwt, ingredientList);
        orderCheck.orderPlacedSuccessfully(response);

    }

    @Test
    public void createOrderUnAuthFail(){
        IngredientList ingredientList = new IngredientList(List.of("61c0c5a71d1f82001bdaaa6d",
                "61c0c5a71d1f82001bdaaa6f",
                "61c0c5a71d1f82001bdaaa71"));
        ValidatableResponse response = orderClient.createOrder("", ingredientList);
        orderCheck.orderPlacedSuccessfully(response);
    }

    @Test
    public void createEmptyOrderFail(){
        createUserAndFillJWT(randomUser());
        IngredientList ingredientList = new IngredientList();
        ValidatableResponse response = orderClient.createOrder(jwt, ingredientList);
        orderCheck.emptyOrderCreationFailed(response);
    }

    @Test
    public void createOrderWithWrongIngredHashFail(){
        createUserAndFillJWT(randomUser());
        IngredientList ingredientList = new IngredientList(List.of(String.valueOf(this.hashCode())));
        ValidatableResponse response = orderClient.createOrder(jwt, ingredientList);
        orderCheck.wrongIngredOrderCreationFailed(response);
    }

    @Test
    public void getOrderListAuthSuccessfully(){
        createUserAndFillJWT(randomUser());
        orderClient.createOrder(jwt, new IngredientList(List.of("61c0c5a71d1f82001bdaaa6d")));
        orderClient.createOrder(jwt, new IngredientList(List.of("61c0c5a71d1f82001bdaaa6f", "61c0c5a71d1f82001bdaaa71")));
        ValidatableResponse response = orderClient.getOrders(jwt);
        orderCheck.getOrdersSuccessfully(response);
    }

    @Test
    public void getOrderListNotAuthSuccessfully(){
        ValidatableResponse response = orderClient.getAllOrders();
        orderCheck.getOrdersSuccessfully(response);
    }

}
