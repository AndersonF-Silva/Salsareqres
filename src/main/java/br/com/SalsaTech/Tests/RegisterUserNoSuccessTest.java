package br.com.SalsaTech.Tests;

import br.com.SalsaTech.POJO.POJOUserRegister;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class RegisterUserNoSuccessTest {

    @BeforeClass
    public static void setup() {
        baseURI = "https://reqres.in/";
    }

    @Test
    public void deveRegistrarUserValidaToken() {
        POJOUserRegister user = new POJOUserRegister("sydney@fife", "");
        given()
                .log().all()
                .contentType("application/json")
                .body(user)
                .when()
                .post("/api/register")
                .then()
                .log().all()
                .statusCode(400)
                .body("error", is("Missing password"))
                ;

    }
}
