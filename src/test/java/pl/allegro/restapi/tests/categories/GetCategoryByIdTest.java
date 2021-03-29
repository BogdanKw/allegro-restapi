package pl.allegro.restapi.tests.categories;

import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pl.allegro.restapi.main.pojo.categories.Categories;
import pl.allegro.restapi.main.pojo.categories.Category;
import pl.allegro.restapi.tests.testbases.TestBase;

import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class GetCategoryByIdTest extends TestBase {

    @Test
    public void givenRandomCategoryFromCategoriesWhenGetCategoryThenReturnCategory() {
        //Nie znam tego narzędzia do testowania, ale wydaje mi się, że cały kod powinien się znaleźć w sekcjach given, when, then.
        // W when masz to, co testujesz (czyli np. wywołanie jakiejś metody), w given wszystko co potrzebujesz do wywołania when, a w then wszystkie assercje i wszystko co jest po when
        Categories expectedCategories = given()
                .when().get(endpointConfig.getAllCategoriesPath())
                .then().statusCode(HttpStatus.SC_OK).extract().as(Categories.class);

        List<Category> listOfExpectedCategories = expectedCategories.getCategories();

        int numerOfExpectedCategories = listOfExpectedCategories.size();

        Random random = new Random();

        Category expectedCategory = listOfExpectedCategories.get(random.nextInt(numerOfExpectedCategories));

        Assertions.assertThat(expectedCategory.getLeaf()).isFalse();

        String expectedCategoryId = expectedCategory.getId();

        // W jednym teście tesujesz ylko jedną rzecz. Jeśli widzisz potrzebę drugiego testu, to robisz oddzielny o w sekcji given przygotowujesz wszystko, co jest Ci do tego testu potrzebne.
        Category category = given()
                .when().get(endpointConfig.getCategoryByIdPath(), expectedCategoryId)
                .then().statusCode(HttpStatus.SC_OK).extract().as(Category.class);


        Assertions.assertThat(category).usingRecursiveComparison().isEqualTo(expectedCategory);

    }

}
