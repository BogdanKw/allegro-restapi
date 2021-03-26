package pl.allegro.restapi.main.authentication;

import org.aeonbits.owner.ConfigFactory;
import pl.allegro.restapi.main.properties.EnvironmentConfig;

import static io.restassured.RestAssured.given;
import static pl.allegro.restapi.main.authentication.ClientCredentials.CLIENT_ID;
import static pl.allegro.restapi.main.authentication.ClientCredentials.CLIENT_SECRET;

// skoro jest tylko metoda statyczna, to nie powinniśmy móc tworzyć instancji klasy
public class Authentication {

    public static String getAccessToken() {
        EnvironmentConfig environmentConfig = ConfigFactory.create(EnvironmentConfig.class);

        //jakoś inaczej wcięcia bym porobił. Nie wiem czy akurat tak jest dobrze, bo nie wiem do czego np. contentType się odnosi, czy do auth, czy do given
        return 
            given()
                .formParam("grant_type", "client_credentials")
                .auth()
                    .preemptive()
                    .basic(CLIENT_ID, CLIENT_SECRET)
                .contentType("application/x-www-form-urlencoded")
            .when()
                .post(environmentConfig.tokenUri())
            .then()
                .extract()
                .jsonPath()
                .getString("access_token");
        //tworzenie zmiennej accessToken wydaje się niepotrzebne, od razu można zwrócić wartość.
        //return accessToken;
    }

}
