import java.lang.reflect.Method;
import java.util.Arrays;
import lab10.Actions.QuoteAction;
import lab10.Actions.VersionAction;
import lab10.Route;
import lab10.Router;

public class Main {
    public static void main(String[] args) throws Exception {
        Router router = new Router(new Route[]{
            new Route("version", VersionAction.class, "invoke"),
            new Route("quote", QuoteAction.class, "getRandomQuote"),
            new Route("quote:popular", QuoteAction.class, "getMostPopularQuote"),
            new Route("quote:id", QuoteAction.class, "getByIndex"),
        });

        Route route = router.match(args[0]);
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);

        Object instance = route.getActionClass().getDeclaredConstructor().newInstance();
        Method method = route.getActionClass().getMethod(route.getMethod(), String[].class);
        String result = (String) method.invoke(instance, (Object) parameters);

        System.out.println(result);
    }
}
