package br.com.SalsaTech.Tests;

import br.com.SalsaTech.POJO.POJOUserLogin;
import br.com.SalsaTech.POJO.POJOUserRegister;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class LoginUserTest {
    @BeforeClass
    public static void setup() {
        baseURI = "https://reqres.in/";
    }

    @Test
    public void deveLogarUserValidaToken() {
        POJOUserLogin user = new POJOUserLogin("eve.holt@reqres.in", "cityslicka");
        String token = given()
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

        Assert.assertEquals(token,"QpwL5tke4Pnpja7X4");
    }
}
