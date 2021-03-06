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
        Categories expectedCategories = given()
                .when().get(endpointConfig.getAllCategoriesPath())
                .then().statusCode(HttpStatus.SC_OK).extract().as(Categories.class);

        List<Category> listOfExpectedCategories = expectedCategories.getCategories();

        int numerOfExpectedCategories = listOfExpectedCategories.size();

        Random random = new Random();

        Category expectedCategory = listOfExpectedCategories.get(random.nextInt(numerOfExpectedCategories));

        Assertions.assertThat(expectedCategory.getLeaf()).isFalse();

        String expectedCategoryId = expectedCategory.getId();


        Category category = given()
                .when().get(endpointConfig.getCategoryByIdPath(), expectedCategoryId)
                .then().statusCode(HttpStatus.SC_OK).extract().as(Category.class);


        Assertions.assertThat(category).usingRecursiveComparison().isEqualTo(expectedCategory);

    }

}
