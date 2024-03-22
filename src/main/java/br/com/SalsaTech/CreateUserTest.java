package br.com.SalsaTech;


import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class CreateUserTest {
    private static final int SUCESS_STATUS_CODE = 201;
    @BeforeClass
    public static void setup() {
        baseURI = "https://reqres.in/";
    }

    @Test
    public void deveSalvarUser() {
        POJOUser user = new POJOUser("morpheus", "leader");
        given()
                .log().all()
                .contentType("application/json")
                .body(user)
                .when()
                .post("/api/users")
                .then()
                .log().all()
                .statusCode(201)
                .body("id", is(notNullValue()))
                .body("name", is("morpheus"))
                .body("job", is("leader"))
        ;
    }
}
