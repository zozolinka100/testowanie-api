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
import static org.hamcrest.Matchers.hasItem;

public class ParamApiTest {
    @BeforeAll
    public static void setup() {
        baseURI = "https://api.magicthegathering.io/";
        filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }



    @Test
    public void nameByIdTest_Positive() {
        String name = get("/v1/cards/4").
                then().extract().body().path("card.name");

        Assertions.assertEquals("Black Vise", name);
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "ktk, 2014-09-26",
                    "5ED, 1997-03-24",
                    "MVOW, 2021-11-19"
            }
    )
    public void chceckSetsDateByCardCode(String code, String date) {

        String releaseDate = given().pathParam("cardCode", code).
                when().
                get("/v1/sets/{cardCode}").
                then().extract().body().path("set.releaseDate");

        Assertions.assertEquals(date,releaseDate);

    }

    @Test
    public void getSubtypesTest() {
        String subtype = get("/v1/subtypes").
                then().extract().body().path("subtypes[20]");

        Assertions.assertEquals("Art", subtype);
    }
}
