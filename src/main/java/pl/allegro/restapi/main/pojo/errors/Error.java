package pl.allegro.restapi.main.pojo.errors;

public class Error {

    // Czemu path i details są typu Object? Czy tu mogą być faktycznie instancje różnych klas? Może trzeba dla nich stworzyć interfejsy (jeśli mają ze sobą coś wspólnego), albo użyć genericów 
    private String code;
    private Object details;
    private String message;
    private Object path;
    private String userMessage;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getPath() {
        return path;
    }

    public void setPath(Object path) {
        this.path = path;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

}
