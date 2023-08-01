package ru.stellarburger.apitest.user;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.stellarburger.apitest.Client;
import ru.stellarburger.apitest.pojo.User;

public class UserClient extends Client {
    static final String USER_AUTH = "/auth";
    static final String USER_REGISTER = USER_AUTH + "/register";
    static final String USER_LOGIN = USER_AUTH + "/login";
    static final String USER_UPDATE_DELETE = USER_AUTH + "/user";

    @Step("Create user")
    public ValidatableResponse createUser(User user){
        return spec()
                .body(user)
                .post(USER_REGISTER)
                .then()
                .log().all();
    }

    @Step("Login")
    public ValidatableResponse login(User user){
        return spec()
                .body(user)
                .post(USER_LOGIN)
                .then()
                .log().all();
    }

    @Step("Delete user")
    public void deleteUser(String jwt){
        spec()
                .auth().oauth2(jwt)
                .delete(USER_UPDATE_DELETE);
    }

    @Step("Update user")
    public ValidatableResponse updateUser(String jwt, String json){
        return spec()
                .auth().oauth2(jwt)
                .body(json)
                .patch(USER_UPDATE_DELETE)
                .then()
                .log().all();
    }
}
