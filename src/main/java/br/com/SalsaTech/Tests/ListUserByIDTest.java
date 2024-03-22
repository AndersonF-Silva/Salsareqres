package br.com.SalsaTech.Tests;

import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ListUserByIDTest {
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in/";
    }
    @Test
    public void ListarUsuarioPorID() {
        given()
                .when()
                .get("api/users/2")
                .then()
                .statusCode(200)
                .log().all()
                .rootPath("data")
                .body(".first_name", containsString("Janet"))
                .body(".last_name", containsString("Weaver"))
                .body(".id", is(2))
        ;
    }
}
