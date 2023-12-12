package ru.stellarburger.apitest.user;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import ru.stellarburger.apitest.pojo.User;

public class UserGenerator {
    @Step("Generate random user")
    public static User randomUser() {
        return new User(
                randomEmail(),
                randomPassword(),
                randomName());
    }

    public static String randomPassword() {
        return RandomStringUtils.randomAlphanumeric(5, 10);
    }

    public static String randomEmail() {
        return RandomStringUtils.randomAlphanumeric(5, 10)
                + "@" + RandomStringUtils.randomAlphanumeric(5, 10) + ".com";
    }

    public static String randomName() {
        return RandomStringUtils.randomAlphanumeric(5, 10);
    }
}
