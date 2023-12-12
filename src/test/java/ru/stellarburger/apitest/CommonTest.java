package ru.stellarburger.apitest;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import ru.stellarburger.apitest.pojo.User;
import ru.stellarburger.apitest.user.UserAssertions;
import ru.stellarburger.apitest.user.UserClient;

abstract public class CommonTest {
    String jwt;
    UserClient userClient = new UserClient();
    UserAssertions userCheck = new UserAssertions();
    @After
    public void CleanUp(){
        if (jwt != null && !jwt.isEmpty()) {
            userClient.deleteUser(jwt);
        }
    }

    @Step("Create user and use JWT for auth")
    ValidatableResponse createUserAndFillJWT(User user){
        ValidatableResponse response = userClient.createUser(user);
        jwt = userCheck.createdSuccessfully(response).split(" ")[1];
        return response;
    }
}
