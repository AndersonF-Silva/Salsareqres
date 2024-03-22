package br.com.SalsaTech.Tests;


import br.com.SalsaTech.POJO.POJOUser;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class CreateUserTest {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in";
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
