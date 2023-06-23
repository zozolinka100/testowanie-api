package rest.api;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

public class Error404ApiTest {
    @BeforeAll
    public static void setup() {
        baseURI = "https://api.magicthegathering.io/v1/";
        filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test
    public void getCardByIdTest_NonExisting() {
        String nonExistingCardId = "99999";

        given()
                .pathParam("id", nonExistingCardId)
                .when()
                .get("/cards/{id}")
                .then()
                .statusCode(404);

    }

    @Test
    public void getSetsByIdTest_NonExisting() {
        String nonExistingSetId = "hello";

        given()
                .pathParam("id", nonExistingSetId)
                .when()
                .get("/sets/{id}")
                .then()
                .statusCode(404);

    }

    @Test
    public void getFlowerTest_NonExisting() {
        String nonExistingPath = "flower";

        given()
                .pathParam("flower", nonExistingPath)
                .when()
                .get("/{flower}")
                .then()
                .statusCode(404);

    }

    @Test
    public void getSetsIdBooster_NonExisting() {
        String nonExistingBooster = "tree";

        given()
                .pathParam("tree", nonExistingBooster)
                .when()
                .get("/sets/ktk/{tree}")
                .then()
                .statusCode(404);

    }

}
