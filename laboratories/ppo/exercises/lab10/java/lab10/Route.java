package lab10;

public class Route {
    private final String path;
    private final Class<?> actionClass;
    private final String method;

    public Route(String path, Class<?> actionClass, String method) {
        this.path = path;
        this.actionClass = actionClass;
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public Class<?> getActionClass() {
        return actionClass;
    }

    public String getMethod() {
        return method;
    }
}
