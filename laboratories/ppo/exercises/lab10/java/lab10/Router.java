package lab10;

import java.util.HashMap;
import java.util.Map;

public class Router {
    private final Map<String, Route> routes = new HashMap<>();

    public Router(Route[] routing) {
        for (Route route : routing) {
            routes.put(route.getPath(), route);
        }
    }

    public Route match(String path) {
        return routes.get(path);
    }
}
