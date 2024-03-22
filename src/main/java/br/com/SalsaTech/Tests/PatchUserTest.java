package br.com.SalsaTech.Tests;

import br.com.SalsaTech.POJO.POJOUser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
public class PatchUserTest {
    @BeforeAll
    public static void setup() {
        baseURI = "https://reqres.in";
    }
    @Test
    public void deveAlterarUsuario() {
        POJOUser user = new POJOUser("morpheus", "zion residents");
        given()
            .log().all()
            .contentType("application/json")
            .body(user)
        .when()
            .patch("/api/users/2")
        .then()
            .log().all()
            .statusCode(200)
            .body("name", is("morpheus"))
            .body("job", is("zion residents"))
        ;
    }
}
