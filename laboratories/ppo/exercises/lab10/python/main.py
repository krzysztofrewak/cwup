import sys
from src.actions.QuoteAction import QuoteAction
from src.actions.VersionAction import VersionAction
from src.Route import Route
from src.Router import Router


router = Router([
    Route("version", VersionAction),
    Route("quote", QuoteAction, "get_random_quote"),
    Route("quote:popular", QuoteAction, "get_most_popular_quote"),
    Route("quote:id", QuoteAction, "get_by_index"),
])

route = router.match(sys.argv[1])

instance = route.action()
method = getattr(instance, route.method)
result = method(*sys.argv[2:])

print(result)
