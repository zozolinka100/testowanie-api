package rest.api;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItem;

public class ContentApiTest {
    @BeforeAll
    public static void setup() {
        baseURI = "https://api.magicthegathering.io/";
        filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "Land",
                    "Plane",
                    "Wolf",
            }
    )
    public void typesContentTest(String type) {
        given().param("type", type).
                when().
                get("/v1/types").
                then().
                statusCode(200).
                contentType(ContentType.JSON).body("types", hasItem(type));
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "Basic",
                    "Ongoing",
                    "Snow",
            }
    )
    public void supertypesContentTest(String supertype) {
        given().param("supertype", supertype).
                when().
                get("/v1/supertypes").
                then().
                statusCode(200).
                contentType(ContentType.JSON).body("supertypes", hasItem(supertype));
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "Ally",
                    "Aura",
                    "Ral",
            }
    )
    public void subtypesContentTest(String subtype) {
        given().param("subtype", subtype).
                when().
                get("/v1/subtypes").
                then().
                statusCode(200).
                contentType(ContentType.JSON).body("subtypes", hasItem(subtype));
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "Modern",
                    "Legacy",
                    "Vintage",
            }
    )
    public void formatsContentTest(String format) {
        given().param("format", format).
                when().
                get("/v1/formats").
                then().
                statusCode(200).
                contentType(ContentType.JSON).body("formats", hasItem(format));
    }
}
