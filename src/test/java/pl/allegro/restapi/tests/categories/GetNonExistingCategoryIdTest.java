package pl.allegro.restapi.tests.categories;

import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pl.allegro.restapi.main.pojo.categories.Categories;
import pl.allegro.restapi.main.pojo.categories.Category;
import pl.allegro.restapi.main.pojo.errors.Error;
import pl.allegro.restapi.tests.testbases.TestBase;
import pl.allegro.restapi.main.pojo.errors.Errors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class GetNonExistingCategoryIdTest extends TestBase {

    @Test
    public void givenNonExistingCategoryWhenGetCategoryThenNotFoundReturn(){
        Categories categories = given()
                .when().get(endpointConfig.getAllCategoriesPath())
                .then().statusCode(HttpStatus.SC_OK).extract().as(Categories.class);

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
                .when().get(endpointConfig.getCategoryByIdPath(), nonExistingCategoryId)
                .then().statusCode(HttpStatus.SC_NOT_FOUND).extract().as(Errors.class);

        List<Error> errorsList = errors.getErrors();
        Error error = errorsList.get(0);

        Assertions.assertThat(error.getCode()).isEqualTo("ERROR");
        Assertions.assertThat(error.getMessage()).isEqualTo("Category '" + nonExistingCategoryId + "' not found");

    }

}
