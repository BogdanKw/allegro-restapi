package pl.allegro.restapi.main.pojo.parameters;

public class Parameter {

    private String id;
    private String name;
    private String type;
    private Boolean required;
    private Boolean requiredForProduct;
    private Object unit; //Raczej nie powinieneś nigdzie używać klasy Object. Już nie będę na to zwracał uwagi, ale to generalna zasada.
    private Options options;
    private Restrictions restrictions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Boolean getRequiredForProduct() {
        return requiredForProduct;
    }

    public void setRequiredForProduct(Boolean requiredForProduct) {
        this.requiredForProduct = requiredForProduct;
    }

    public Object getUnit() {
        return unit;
    }

    public void setUnit(Object unit) {
        this.unit = unit;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public Restrictions getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }

}
