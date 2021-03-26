package pl.allegro.restapi.main.pojo.errors;

import java.util.List;

// Tutaj podobnie jak w kategoriach nie wiem gdzie klasa Errors jest używana, ale być może jest niepotrzebna i lepiej używać List<Error>. Jeśli chciałbyś ją usunąć to chyba usunąłbym też cały pakiet errors i klasę Error przeniósł bezpośrednio do pojo. Jeśli ją zostawisz, to nazwę pakietu zmieniłnym na error
public class Errors {

    private List<Error> errors = null;

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

}
