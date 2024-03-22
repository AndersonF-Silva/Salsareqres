package br.com.SalsaTech.Tests;

import br.com.SalsaTech.POJO.POJOUser;
import br.com.SalsaTech.POJO.POJOUserRegister;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;


public class RegisterUserTest {
    @BeforeClass
    public static void setup() {
        baseURI = "https://reqres.in/";
    }

    @Test
    public void deveRegistrarUserValidaToken() {
        POJOUserRegister user = new POJOUserRegister("eve.holt@reqres.in", "pistol");
        String token = given()
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

        Assert.assertEquals(token,"QpwL5tke4Pnpja7X4");
    }

}
