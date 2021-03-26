package pl.allegro.restapi.main.pojo.parameters;
//Może usunąć pakiet parameters i wszystkie klasy przenieść do pojo?

import java.util.List;

public class Options {

    private Boolean variantsAllowed;
    private Boolean variantsEqual;
    private Object ambiguousValueId;
    private String dependsOnParameterId;
    private List<String> requiredDependsOnValueIds = null;
    private List<String> displayDependsOnValueIds = null;
    private Boolean describesProduct;
    private Boolean customValuesEnabled;

    public Boolean getVariantsAllowed() {
        return variantsAllowed;
    }

    public void setVariantsAllowed(Boolean variantsAllowed) {
        this.variantsAllowed = variantsAllowed;
    }

    public Boolean getVariantsEqual() {
        return variantsEqual;
    }

    public void setVariantsEqual(Boolean variantsEqual) {
        this.variantsEqual = variantsEqual;
    }

    public Object getAmbiguousValueId() {
        return ambiguousValueId;
    }

    public void setAmbiguousValueId(Object ambiguousValueId) {
        this.ambiguousValueId = ambiguousValueId;
    }

    public String getDependsOnParameterId() {
        return dependsOnParameterId;
    }

    public void setDependsOnParameterId(String dependsOnParameterId) {
        this.dependsOnParameterId = dependsOnParameterId;
    }

    public List<String> getRequiredDependsOnValueIds() {
        return requiredDependsOnValueIds;
    }

    public void setRequiredDependsOnValueIds(List<String> requiredDependsOnValueIds) {
        this.requiredDependsOnValueIds = requiredDependsOnValueIds;
    }

    public List<String> getDisplayDependsOnValueIds() {
        return displayDependsOnValueIds;
    }

    public void setDisplayDependsOnValueIds(List<String> displayDependsOnValueIds) {
        this.displayDependsOnValueIds = displayDependsOnValueIds;
    }

    public Boolean getDescribesProduct() {
        return describesProduct;
    }

    public void setDescribesProduct(Boolean describesProduct) {
        this.describesProduct = describesProduct;
    }

    public Boolean getCustomValuesEnabled() {
        return customValuesEnabled;
    }

    public void setCustomValuesEnabled(Boolean customValuesEnabled) {
        this.customValuesEnabled = customValuesEnabled;
    }

}
