package br.com.SalsaTech.Tests;

import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasItems;

public class ListPage1DelayedTest {
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in/";
    }
    @Test
    public void deveVerificarLista() {
        given()
                .when()
                .get("api/users?delay=3")
                .then()
                .statusCode(200)
                .time(lessThan(4131l))
                .body("page", is(1))
                .rootPath("data")
                .body(".id", is(notNullValue()))
                .body(".id.max()", is(6))
                .body("id", hasItems(1, 2, 3, 4, 5, 6))
                .body(".first_name", hasItem("Charles"))
                .body(".findAll{it.first_name.toString().contains('e')}.first_name", hasItems("George", "Janet", "Eve", "Charles", "Tracey"))
                .body(".last_name", hasItems("Bluth", "Weaver", "Wong", "Holt", "Morris", "Ramos"))
        ;

    }

}
