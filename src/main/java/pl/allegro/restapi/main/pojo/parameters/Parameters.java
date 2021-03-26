package pl.allegro.restapi.main.pojo.parameters;

import java.util.List;

//Taka sama obserwacja jak przy Errors i Categories
public class Parameters {

    private List<Parameter> parameters = null;

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

}
