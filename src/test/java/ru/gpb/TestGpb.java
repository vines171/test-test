package ru.gpb;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;


import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

class TestGpb  {

    @Test
    @DisplayName("Ололо мой тест")
    void test() {
        given()
                .log()
                .all()
                .get("https://reqres.in/api/users")
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("page", equalTo(1));
//                .body("data[0].id", equalTo(0))
//                .body("data[1].id", equalTo(1));

    }

    @TestTemplate
    @ExtendWith(UserProvider.class)
    void testNewUserNameJobNumbers(User request, String webServicePath) {
        given()
                .log()
                .all()
                .body(request)
                .post(webServicePath)
                .then()
                .log()
                .all()
                .statusCode(201)
                .body("id", notNullValue());
    }

}
