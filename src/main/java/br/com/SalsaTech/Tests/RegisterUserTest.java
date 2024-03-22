package br.com.SalsaTech.Tests;

import br.com.SalsaTech.POJO.POJOUserRegister;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
public class RegisterUserTest {
    @BeforeAll
    public static void setup() {
        baseURI = "https://reqres.in";
    }
    @Test
    public void deveRegistrarUserValidaToken() {
        POJOUserRegister user = new POJOUserRegister("eve.holt@reqres.in", "pistol");
        String token =
            given()
                .log().all()
                .contentType("application/json")
                .body(user)
            .when()
                .post("/api/register")
            .then()
                .log().all()
                .statusCode(200)
                .body("id", is(notNullValue()))
                .extract()
                .path("token")
        ;
        Assertions.assertEquals(token, "QpwL5tke4Pnpja7X4");
    }
}
