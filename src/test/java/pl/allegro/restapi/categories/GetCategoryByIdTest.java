package pl.allegro.restapi.categories;

import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pl.allegro.restapi.pojo.categories.Categories;
import pl.allegro.restapi.pojo.categories.Category;
import pl.allegro.restapi.testbases.TestBase;

import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static pl.allegro.restapi.properties.EndpointManager.getEndpointConfig;

public class GetCategoryByIdTest extends TestBase {

    // Takie trochę podstępne te testy. Napisać je porządnie to trochę czasu może zająć. 
    // Tutaj bym się przyczepił do przypadkowości testu. Jednym razem może przejść, a innym nie, w zależności od randomowej wartości.
    // Też miałbym obiekcje odnośnie opierania testów na podstawie danych pobranych z wszystkich kategorii. A jeśli tam też jest błąd?
    // Jak na moje powinna być jakaś lista kategorii do przetestowania i wprost wpisane oczekiwane wartości i z nimi dopiero można robić porównanie. Ale nigdy nie czytałem żadnego podręcznika prawidłowego testowania, więc nie wiem jakie są podejścia.
    @Test
    public void givenRandomCategoryFromCategoriesWhenGetCategoryThenReturnCategory() {
        //given
        Categories expectedCategories = given()
                .when()
                    .get(getEndpointConfig().getAllCategoriesPath())
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(Categories.class);

        List<Category> listOfExpectedCategories = expectedCategories.getCategories();

        int numerOfExpectedCategories = listOfExpectedCategories.size();

        Random random = new Random();

        Category expectedCategory = listOfExpectedCategories.get(random.nextInt(numerOfExpectedCategories));

        Assertions.assertThat(expectedCategory.getLeaf()).isFalse();

        String expectedCategoryId = expectedCategory.getId();

        //when
        Category category = given()
                .when()
                    .get(getEndpointConfig().getCategoryByIdPath(), expectedCategoryId)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(Category.class);

        //then
        Assertions.assertThat(category).usingRecursiveComparison().isEqualTo(expectedCategory);

    }

}
