package pl.allegro.restapi.main.properties;
//Może pakiet nazwać config zamiast properties?

import org.aeonbits.owner.Config;

@Config.Sources("classpath:EndpointConfig.properties")
public interface EndpointConfig extends Config {

    @Key("GET_ALL_CATEGORIES_PATH")
    String getAllCategoriesPath();

    @Key("GET_CATEGORY_BY_ID_PATH")
    String getCategoryByIdPath();

    @Key("GET_PARAMETERS_BY_CATEGORY_PATH")
    String getParametersByCategoryPath();

}
