package ru.stellarburger.apitest.user;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static java.net.HttpURLConnection.*;
import static org.hamcrest.Matchers.notNullValue;

public class UserAssertions {
    @Step("Check user created & get JWT")
    public String createdSuccessfully(ValidatableResponse response) {
        return response
                .assertThat()
                .statusCode(HTTP_OK)
                .and()
                .body("accessToken", notNullValue())
                .extract()
                .path("accessToken");
    }

    @Step("Check user not created; status 403")
    public void creationFailed(ValidatableResponse response) {
        response
            .assertThat()
            .statusCode(HTTP_FORBIDDEN);
    }

    @Step("Check Logged in successfully; status 200")
    public void loginSuccessfully(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HTTP_OK);
    }

    @Step("Login failed; status 401")
    public void loginFailed(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HTTP_UNAUTHORIZED);
    }

    @Step("User update failed; status 401")
    public void userEditFailedUnauthorized(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HTTP_UNAUTHORIZED);
    }

    @Step("User update succeed; status 200")
    public void userEditSuccess(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HTTP_OK);
    }
}
