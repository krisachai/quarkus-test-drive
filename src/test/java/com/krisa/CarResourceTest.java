package com.krisa;

import static io.restassured.RestAssured.given;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import com.krisa.data.*;

@QuarkusTest
public class CarResourceTest {
    @Test
    public void testCarEndpoint() {
        given().when().header("Content-Type", "application/json").get("/car/0").then().statusCode(404);
    }
}
