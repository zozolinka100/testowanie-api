package rest.api;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static io.restassured.RestAssured.*;
import static java.util.function.Predicate.not;
import static org.hamcrest.Matchers.hasItem;

public class Error400ApiTest {
    @BeforeAll
    public static void setup() {
        baseURI = "https://api.magicthegathering.io/v1/";
        filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test
    public  void getCardsTest_Error400() {
        int statusCode = RestAssured
                .get("/cards")
                .getStatusCode();

        Assertions.assertNotEquals(400, statusCode);
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "78",
                    "4",
                    "101",
                    "285",
            }
    )
    public void getCardsByIdTest_Error400(int id) {
        int statusCode = RestAssured
                .given()
                .pathParam("id",id)
                .get("/cards/{id}")
                .getStatusCode();

        Assertions.assertNotEquals(400, statusCode);

    }

    @Test
    public  void getSetsTest_Error400() {
        int statusCode = RestAssured
                .get("/sets")
                .getStatusCode();

        Assertions.assertNotEquals(400, statusCode);
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "ktk",
                    "5ED",
            }
    )
    public void getSetsByIdTest_Error400(String id) {
        int statusCode = RestAssured
                .given()
                .pathParam("id",id)
                .get("/sets/{id}")
                .getStatusCode();

        Assertions.assertNotEquals(400, statusCode);

    }

    @Test
    public  void getTypesTest_Error400() {
        int statusCode = RestAssured
                .get("/types")
                .getStatusCode();

        Assertions.assertNotEquals(400, statusCode);
    }

    @Test
    public  void getSubtypesTest_Error400() {
        int statusCode = RestAssured
                .get("/subtypes")
                .getStatusCode();

        Assertions.assertNotEquals(400, statusCode);
    }

    @Test
    public  void getSupertypesTest_Error400() {
        int statusCode = RestAssured
                .get("/supertypes")
                .getStatusCode();

        Assertions.assertNotEquals(400, statusCode);
    }

    @Test
    public  void getFormatsTest_Error400() {
        int statusCode = RestAssured
                .get("/formats")
                .getStatusCode();

        Assertions.assertNotEquals(400, statusCode);
    }
}
