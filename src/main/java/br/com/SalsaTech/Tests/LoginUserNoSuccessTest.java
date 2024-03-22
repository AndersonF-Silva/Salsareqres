package br.com.SalsaTech.Tests;

import br.com.SalsaTech.POJO.POJOUserRegister;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
public class LoginUserNoSuccessTest {
    @BeforeClass
    public static void setup() {
        baseURI = "https://reqres.in";
    }
    @Test
    public void deveRegistrarUserValidaToken() {
        POJOUserRegister user = new POJOUserRegister("peter@klaven", "");
        given()
            .log().all()
            .contentType("application/json")
            .body(user)
        .when()
            .post("/api/login")
        .then()
            .log().all()
            .statusCode(400)
            .body("error", is("Missing password"))
        ;
    }
}
