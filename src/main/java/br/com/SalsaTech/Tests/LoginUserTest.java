package br.com.SalsaTech.Tests;

import br.com.SalsaTech.POJO.POJOUserLogin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
public class LoginUserTest {
    @BeforeAll
    public static void setup() {
        baseURI = "https://reqres.in";
    }
    @Test
    public void deveLogarUserEValidarToken() {
        POJOUserLogin user = new POJOUserLogin("eve.holt@reqres.in", "cityslicka");
        String token =
            given()
                .log().all()
                .contentType("application/json")
                .body(user)
            .when()
                .post("/api/login")
            .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("token")
            ;
        Assertions.assertEquals(token, "QpwL5tke4Pnpja7X4");
    }
}
