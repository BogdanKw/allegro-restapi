package pl.allegro.restapi.main.request.configuration;
//Nie wiedziałem gdzie to napisać. Czemu pakiet nazywa się restapi.main. Nie może zostać poprostu restapi?
//Pakiet request nic nie zawiera klas, tylko jeden pakiet. Niepotrzebne zagnieżdżenie. Może nazwać go tylko request lub requestbuilder?
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.specification.RequestSpecification;
import pl.allegro.restapi.main.authentication.Authentication;

import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;

public class RequestConfigurationBuilder {

    //Ta metoda to chyba może być statyczna, a wówczas trzeba zastosować uwagi które miałem do klas, w których wszystkie metody są statyczne.
    public RequestSpecBuilder getRequestSpecBuilder() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        return requestSpecBuilder
                .setConfig(RestAssuredConfig.config().objectMapperConfig(objectMapperConfig().defaultObjectMapperType(ObjectMapperType.GSON)))
                .setAccept("application/vnd.allegro.public.v1+json")
                .addHeader("Authorization", "Bearer " + Authentication.getAccessToken());
    }

    public static RequestSpecification getDefaultRequestSpecification(){
        RequestConfigurationBuilder requestConfigurationBuilder = new RequestConfigurationBuilder();
        return requestConfigurationBuilder
                .getRequestSpecBuilder().build();
    }
}

