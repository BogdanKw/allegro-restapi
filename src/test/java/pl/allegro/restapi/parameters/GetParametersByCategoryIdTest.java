package pl.allegro.restapi.parameters;

import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pl.allegro.restapi.pojo.categories.Categories;
import pl.allegro.restapi.pojo.categories.Category;
import pl.allegro.restapi.pojo.parameters.Parameter;
import pl.allegro.restapi.pojo.parameters.Parameters;
import pl.allegro.restapi.testbases.TestBase;

import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static pl.allegro.restapi.properties.EndpointManager.getEndpointConfig;


public class GetParametersByCategoryIdTest extends TestBase {

    // Tutaj podobnie jak w innych miejscach nie opierałbym się na liczbie randomowej, tylko szukał po konkretnych id-kach wcześniej zdefiniowanych. Nie wiem jak testng, ale spock czy junit potrafią powtarzać ten sam test wielokrotnie dla różnych parametrów, czyli można mieć zdefiniowaną listę id-ków i oczekiwanych parametrów i wykonać ten test wielokrotnie.
    // Tak mi przyszło do głowy, że ja może przyjąłem złe założenia. Bo ja zakładam że test robiony jest przez allegro i z dokumentacji wiemy, co powinno się znaleźć w różnych kategoriach. A jeśli im chodziło, że my testujemy to api jako klient i nie wiemy co będzie zwrócone? Nie wiem za bardzo jaka była koncepcja.
    @Test
    public void givenCategoryIdWhenGetParametersThenReturnListOfParameters() {
        Categories categories = given()
                .when()
                    .get(getEndpointConfig().getAllCategoriesPath())
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(Categories.class);

        List<Category> listOfCategories = categories.getCategories();

        int sizeOfCategories = listOfCategories.size();

        Random random = new Random();
        Category category = listOfCategories.get(random.nextInt(sizeOfCategories));

        String categoryId = category.getId();

        Parameters parameters = given()
                .when()
                    .get(getEndpointConfig().getParametersByCategoryPath(), categoryId)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(Parameters.class);

        List<Parameter> listOfParameters = parameters.getParameters();

        int sizeOfParameters = listOfParameters.size();

        for (int i = 0; i < sizeOfParameters; i++) {
            String parameterType = listOfParameters.get(i).getType();
            Assertions.assertThat(parameterType).isNotEmpty();
        }

    }

}
