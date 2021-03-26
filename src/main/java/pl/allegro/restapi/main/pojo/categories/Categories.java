package pl.allegro.restapi.main.pojo.categories;

import java.util.List;

//Jeśli tutaj nie robisz żadnych operacji na kategoriach i to faktycznie ma być pojo, to nie wiem czy ta klasa jest potrzebna. Czy nie lepiej posługiwać się List<Category>. ALe nie wiem do czego tego używasz.
// W nazwie pakietu dałbym liczbę pojedyńczą category.
public class Categories {

    private List<Category> categories = null;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
