package pl.allegro.restapi.categories;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pl.allegro.restapi.testbases.TestBase;

import static io.restassured.RestAssured.given;
import static pl.allegro.restapi.properties.EndpointManager.getEndpointConfig;

public class GetCategoriesTest extends TestBase {

    // Jak na moje to ten test trochę mało sprawdza. Rozumiem, że przypadki testowe sam sobie miałeś wymyślić, tak?
    // Nie wiemy czy on zwraca coś, co ma schemat zgodny z Categories, czy wszystkie wymagane dane są uzupełnione, czy parent faktycznie istnieje, czy leaf jest true tylko daltych, które nie mają rodzica. Takie testy mi się nasuwają.
    @Test
    public void givenCategoriesWhenGetCategoriesThenReturnListOfAllCategories() {
        Response response = given()
                .when()
                    .get(getEndpointConfig().getAllCategoriesPath())
                .then()
                    .extract().response();

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
    }

}
