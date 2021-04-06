package pl.allegro.restapi.categories;

import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pl.allegro.restapi.pojo.categories.Categories;
import pl.allegro.restapi.pojo.categories.Category;
import pl.allegro.restapi.pojo.errors.Error;
import pl.allegro.restapi.testbases.TestBase;
import pl.allegro.restapi.pojo.errors.Errors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static pl.allegro.restapi.properties.EndpointManager.getEndpointConfig;

public class GetNonExistingCategoryIdTest extends TestBase {

    // Tu mi się też nie podoba poszukiwania id które nie istnieje. Chyba powinniśmy mieć zdefiniowane takie id, np. w pliku konfiguracyjnym, i po takim id wołać.
    // Tutaj mogę sobie wyobrazić różne błędy, np. zły format id niezgodny z UUID może zwrócić jakiś błąd parsowania, albo jakiś bardzo długi numer.
    // Jak na moje to w jednym pliku spokojnie może być wiele powiązanych testów
    @Test
    public void givenNonExistingCategoryWhenGetCategoryThenNotFoundReturn(){
        Categories categories = given()
                .when()
                    .get(getEndpointConfig().getAllCategoriesPath())
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(Categories.class);

        List<Category> listOfCategories = categories.getCategories();

        List<String> listOfCategoryIds = new ArrayList<String>() {
        };

        for (Category category : listOfCategories){
            String categoryId = category.getId();
            listOfCategoryIds.add(categoryId);
        }

        Random random = new Random();
        String nonExistingCategoryId;

        do {
            nonExistingCategoryId = Integer.toString(random.nextInt());
        } while (listOfCategoryIds.contains(nonExistingCategoryId));

        Errors errors = given()
                .when()
                    .get(getEndpointConfig().getCategoryByIdPath(), nonExistingCategoryId)
                .then()
                    .statusCode(HttpStatus.SC_NOT_FOUND)
                    .extract().as(Errors.class);

        List<Error> errorsList = errors.getErrors();
        Error error = errorsList.get(0);

        Assertions.assertThat(error.getCode()).isEqualTo("ERROR");
        Assertions.assertThat(error.getMessage()).isEqualTo("Category '" + nonExistingCategoryId + "' not found");
    }

}
