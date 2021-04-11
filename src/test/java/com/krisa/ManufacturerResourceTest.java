package com.krisa;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import com.krisa.data.Manufacturer;

@QuarkusTest
public class ManufacturerResourceTest {

    @Test
    public void testManufacturerEndpoint() {
        Manufacturer honda = new Manufacturer();
        honda.setName("Honda");
        given().when().header("Content-Type", "application/json").body(honda).post("/manufacturer").then()
                .statusCode(201);
    }

}