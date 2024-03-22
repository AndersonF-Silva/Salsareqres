package br.com.SalsaTech;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class ListUsersTest {
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in/";
    }

    @Test
    public void ValidarSePage2Test() {
        given()
                .when()
                .get("api/users?page=2")
                .then()
                .statusCode(200)
                .body("page", is(2))
                .log().all()
        ;
    }
    @Test
    public void ListarTodosUsuariosTest () {
        given()
                .when()
                .get("api/users?page=2")
                .then()
                .statusCode(200)
                .log().all()
        ;
    }

    @Test
    public void ListarTodosUsuariosValidarURLResponseTest() {
        given()
                .when()
                .get("api/users?page=2")
                .then()
                .statusCode(200)
                .body("support.url", is("https://reqres.in/#support-heading"))
                .log().all()
        ;
    }

    @Test
    public void ListarTodosUsuariosValidarTextResponseTest() {
        given()
                .when()
                .get("api/users?page=2")
                .then()
                .statusCode(200)
                .body("support.text", is("To keep ReqRes free, contributions towards server costs are appreciated!"))
                .log().all()
        ;
    }

    @Test
    public void ListarTodosUsuariosValidarQuantidadeRegistrosResponseTest() {
      given()
                .when()
                .get("api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id", hasSize(6))
                .body("data.id", contains(7, 8, 9, 10, 11, 12))
                .log().all();
    }


}
