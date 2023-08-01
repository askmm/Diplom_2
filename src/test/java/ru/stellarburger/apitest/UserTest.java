package ru.stellarburger.apitest;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import ru.stellarburger.apitest.pojo.User;

import static ru.stellarburger.apitest.user.UserGenerator.*;

public class UserTest extends CommonTest{
    private User user = randomUser();

    @Test
    public void createUserSuccess(){
        ValidatableResponse response =  userClient.createUser(randomUser());
        jwt = userCheck.createdSuccessfully(response);
    }

    @Test
    public void createUserDuplicateFail(){
        ValidatableResponse response = createUserAndFillJWT(user);

        response = userClient.createUser(user);
        userCheck.creationFailed(response);
    }


    @Test
    public void createUserWithEmptyNameFail(){
        user.setName("");
        ValidatableResponse response = userClient.createUser(user);
        userCheck.creationFailed(response);
    }

    @Test
    public void createUserWithEmptyEmailFail(){
        user.setEmail("");
        ValidatableResponse response = userClient.createUser(user);
        userCheck.creationFailed(response);
    }

    @Test
    public void createUserWithEmptyPasswordFail(){
        user.setPassword("");
        ValidatableResponse response = userClient.createUser(user);
        userCheck.creationFailed(response);
    }

    @Test
    public void loginSuccess(){
        createUserAndFillJWT(user);

        ValidatableResponse response = userClient.login(user);
        userCheck.loginSuccessfully(response);
    }

    @Test
    public void loginNonexistentUserFail(){
        ValidatableResponse response = userClient.login(user);
        userCheck.loginFailed(response);
    }
    @Test
    public void editUserAuthorizedSuccess(){
        createUserAndFillJWT(user);
        ValidatableResponse response = userClient.updateUser(jwt, "{\"name\" : \"Yuri Gagarin\"}");
        userCheck.userEditSuccess(response);
    }

    @Test
    public void editUserUnauthorizedFail(){
        createUserAndFillJWT(user);
        ValidatableResponse response = userClient.updateUser("", "{\"name\" : \"Yuri Gagarin\"}");
        userCheck.userEditFailedUnauthorized(response);
    }



}
