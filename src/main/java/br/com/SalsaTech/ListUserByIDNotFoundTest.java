package br.com.SalsaTech;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class ListUserByIDNotFoundTest {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in/";
    }
    @Test
    public void ListarUsuarioPorIDQueNaoExiste() {
        given()
                .when()
                .get("api/users/23")
                .then()
                .statusCode(404);
    }
}
