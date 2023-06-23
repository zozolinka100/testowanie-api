package rest.api;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItem;


public class GetApiTest {

    @BeforeAll
    public static void setup() {
        baseURI = "https://api.magicthegathering.io/";
        filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test
    public void getCardByIdTest() {
        when().
                get("/v1/cards/4");

    }

    @Test
    public void getSetsTest() {
        when().
                get("/v1/sets");

    }
    @Test
    public void getTypesTest() {
        when().
                get("/v1/types");

    }

    @Test
    public void getSubTypesTest() {
        when().
                get("/v1/subtypes");

    }

    @Test
    public void getSuperTypesTest() {
        when().
                get("/v1/supertypes");

    }
    @Test
    public void getFormatsTest() {
        when().
                get("/v1/formats");

    }
}
