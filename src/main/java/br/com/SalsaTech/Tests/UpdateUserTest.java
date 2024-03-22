package br.com.SalsaTech.Tests;

import br.com.SalsaTech.POJO.POJOUser;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
public class UpdateUserTest {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }
    @Test
    public void deveAlterarUsuario() {
        POJOUser user = new POJOUser("morpheus", "zion resident");
        given()
            .log().all()
            .contentType("application/json")
            .body(user)
        .when()
            .put("/api/users/2")
        .then()
            .log().all()
            .statusCode(200)
            .body("name", is("morpheus"))
            .body("job", is("zion resident"))
        ;
    }
}
