package br.com.SalsaTech;

import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ListAllResourceTest {
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in/";
    }

    @Test
    public void ValidarSePage1Test() {
        given()
                .when()
                .get("/api/unknown")
                .then()
                .statusCode(200)
                .body("page", is(1))
                .log().all()
        ;
    }
    @Test
    public void ListarTodasCoresTest () {
        given()
                .when()
                .get("/api/unknown")
                .then()
                .statusCode(200)
                .log().all()
        ;
    }

    @Test
    public void ListarTodasCoresValidarURLResponseTest() {
        given()
                .when()
                .get("/api/unknown")
                .then()
                .statusCode(200)
                .body("support.url", is("https://reqres.in/#support-heading"))
                .log().all()
        ;
    }

    @Test
    public void ListarTodasCoresValidarTextResponseTest() {
        given()
                .when()
                .get("/api/unknown")
                .then()
                .statusCode(200)
                .body("support.text", is("To keep ReqRes free, contributions towards server costs are appreciated!"))
                .log().all()
        ;
    }

    @Test
    public void ListarTodasCoresValidarQuantidadeRegistrosResponseTest() {
        given()
                .when()
                .get("/api/unknown")
                .then()
                .statusCode(200)
                .body("data.id", hasSize(6))
                .body("data.id", contains(1, 2, 3, 4, 5, 6))
                .log().all();
    }

    @Test
    public void ValidarListaNomesCoresTest() {
        given()
                .when()
                .get("/api/unknown")
                .then()
                .statusCode(200)
                .body("data.name", hasItems("cerulean", "fuchsia rose", "true red", "aqua sky", "tigerlily", "blue turquoise"))
                .log().all();
    }

    @Test
    public void ValidarAnoCoresTest() {
        given()
                .when()
                .get("/api/unknown")
                .then()
                .statusCode(200)
                .body("data.year", contains(2000, 2001, 2002, 2003, 2004, 2005))
                .log().all();
    }

    @Test
    public void ValidarRGBCorTrueRedTest() {

        given()
                .when()
                .get("/api/unknown")
                .then()
                .statusCode(200)
                .body("data.color[3]", is("#7BC4C4"))
                .log().all();
    }

    @Test
    public void ValidarNomeBlueTurquoiseTest() {
        ArrayList<String> nomes =
                given()
                        .when()
                        .get("/api/unknown")
                        .then()
                        .statusCode(200)
                        .extract().path("data.name.findAll{it.startsWith('blue')}")
                ;
        Assert.assertEquals(1, nomes.size());
        Assert.assertTrue(nomes.get(0).equalsIgnoreCase("blUe TurQuOisE"));
        Assert.assertEquals(nomes.get(0).toUpperCase(), "blue turquoise".toUpperCase());
    }


}
