## Wyjątki

### Agenda
Przewidywany plan zajęć kształtuje się następująco:
* przedstawienie idei błędów,
* przedstawienie idei rzucania i łapania wyjątków,
* analiza zadania przykładowego,
* indywidualna praca nad listą zadań.

### Błędy
W tradycyjnym programie (podobnym do tych, które zrobiliśmy na wszystkich poprzednich zajęciach) wykonywane są kolejne linijki kodu źródłowego (przepisane oczywiście pod spodem przez kompilator na kod maszynowy) od początku do jakiegoś końca. Początek zazwyczaj jest jeden, natomiast końców możemy mieć tyle, ile returnów znajdzie się w kodzie. Po drodze możemy wykorzystać różne struktury takie jak pętle, warunki logiczne czy ekstrakcję fragmentów kodu do funkcji, ale mniej więcej wygląda to zawsze podobnie. 

Czasami niestety program może zostać przerwany w nieoczekiwany sposób i w nieoczekiwanym momencie. Na przykład, gdy spróbujemy w Pythonie skonkatenować string i niestring:
```
Traceback (most recent call last):
  File "/application/./exercises/lab10/python/main.py", line 8, in <module>
    print("test" + 1)
          ~~~~~~~^~~
TypeError: can only concatenate str (not "int") to str
```

Podobnie w Javie możemy otrzymać tzw. _runtime exception_, gdy będziemy chcieli wywołać metodę na nullu:
```
Exception in thread "main" java.lang.NullPointerException
	at Temp.main(Temp.java:9)
```

Są to błędy (ang. _errors_), które można obsłużyć przede wszystkim poprzez walidację i sanityzację danych. W tych przypadku można byłoby to naprawić choćby rzutowaniem liczba na słowo: `"test" + str(1)` czy też zabezpieczeniu wywołania metody na nully `service?.do()`. Z reguły powinniśmy minimalizować liczbę wywoływania takich błędów, gdyż zwykle przerywają one program.

### Wyjątki i ich łapanie
O wiele ciekawszym zagadnieniem są wyjątki (ang. _exceptions_), które z reguły w większości języków programowania można projektować, rzucać oraz łapać.

Projektowanie wyjątków nie różni się za bardzo od projektowania innych klas. Klasy wyjątków muszą implementować interfejs `Throwable` (Java, PHP) lub dziedziczyć po klasie `Exception` (Python, C#, ale też Java i PHP). Wyjątek z reguły powinien nieść ze sobą takie informacje:
```
interface Throwable {
    public String getMessage()
    public Integer getCode()
    public String getFile()
    public Integer getLine()
    public String[] getTrace()
    public String getTraceAsString()
    public ?Throwable getPrevious()
    public String __toString()
}
```

Najważniejszym elementem wyjątku jest przesyłana przez niego wiadomość. Możemy ją zazwyczaj przekazać przez konstruktor (`throw new Expcetion("You are not allowed to be here.)`), ale można ją też zaszyć bezpośrednio w klasie wyjątku (`throw new UnauthorizedException()`). Wyjątki zazwyczaj niosą ze sobą też informacje na temat miejsca, w którym zostały wywołane.

Rzucanie wyjątków (ang. _throwing exceptions_) to korzystanie z odpowiedniego konstruktu języka: `throw` lub `raise`. Rzucony wyjątek przerywa działanie programu i warstwami wywołań obecnej metody wraca do samej "góry" aplikacji. Tutaj pojawia się najważniejsza różnica między błędami i wyjątkami: błąd oznacza faktyczny błąd, natomiast wyjątek może oznaczać zaplanowane zdarzenie, które po prostu powinno zmienić flow programu.

Wyobraźmy sobie kontroler aplikacji internetowej, który musi zwrócić produkt sklepu internetowego na podstawie podanego przez użytkownika adresu. Mogłoby to wyglądać następująco:
```
class ProductPageController extends Controller
{
    public HttpResponse get(HttpRequest request)
    {
        Product product = this.repository.getById(request.get("id"))
        
        return this.renderHtml("products/page.html", product)
    }
}
```

Z repozytorium pobieramy produkt na podstawie id z żądania HTTP, a następnie przekazujemy ten produkt do wyrenderowania na stronie. Wygląda to elegancko, ale przecież może się zdarzyć, że zapomnimy przekazać id, że będzie ono czymś innym niż oczekiwaną liczbą albo że produktu o zadanym id nie będzie w bazie. Można byłoby to opisać tak:
```
class ProductPageController extends Controller
{
    public HttpResponse get(HttpRequest request)
    {
        if (Null.isNull(request.get("id")) || !Number.isNumber(request.get("id")) {
            return this.redirect("errors/400.html)
        }
        
        Product product = this.repository.getById(request.get("id"))
        
        if (Null.isNull(product)) {
            return this.redirect("errors/404.html)
        }
        
        return this.renderHtml("products/page.html", product)
    }
}
```

W przykładzie powyżej tracimy bardzo dużo na czytelności. Programista musi zrozumieć wszystkie ścieżki, chociaż bazowo interesować go powinno tylko pobieranie produktu. Można byłoby oprogramować tylko _happy path_, a obsługę wszystkich błędów przekazać do wyjątków. Takie podejście wymagałoby dodania tzw. handlera wyjątków do aplikacji:
```
class ProductPageController extends Controller
{
    public HttpResponse get(ValidatedProductPageHttpRequest request)
    {        
        Product product = this.repository.getByIdOrFail(request.get("id"))
                
        return this.renderHtml("products/page.html", product)
    }
}
```

Taki handler mógłby zbierać konkretne wyjątki i na ich podstawie generować strony błędów. W ten sposób dochodzimy do łapania wyjątków (ang. _catching exceptions_), ponieważ każdy rzucony wyjątek można przechwycić i zablokować wyłączenie się programu. Zazwyczaj realizuje się to konstruktem `try catch`:
```
class ProductPageController extends Controller
{
    public HttpResponse get(ValidatedProductPageHttpRequest request)
    {        
        try {
            Product product = this.repository.getByIdOrFail(request.get("id"))
        } catch(ModelNotFoundException exception) {
            return this.redirect("errors/404.html)
        }
        
        return this.renderHtml("products/page.html", product)
    }
}
```

Świetnym miejscem na zastosowanie `try/catch` będzie właśnie handler wyjątków. Zwróćmy uwagę, że możemy wskazać typ wyjątku, który łapiemy, ale możemy też budować drzewko łapania:
```
class ProductPageController extends Controller
{
    public HttpResponse get(ValidatedProductPageHttpRequest request)
    {        
        try {
            Product product = this.repository.getByIdOrFail(request.get("id"))
        } catch(ProductArchivedException exception) {
            return this.redirect("errors/410.html)
        } catch(ModelNotFoundException exception) {
            return this.redirect("errors/404.html)
        } catch(Throwable exception) {
            return this.redirect("errors/500.html)
        }
        
        return this.renderHtml("products/page.html", product)
    }
}
```

Z reguły lepiej tworzyć własne wyjątki opisujące zdarzenia niż wykorzystywać bazową klasę `Exception`.

### Analiza przykładowego zadania
Zadanie składa się z kilku części: 
* klasy handlera wyjątków,
* klasy odczytującej klawiaturę użytkownika,
* klas wyjątków,
* głównego programu, gdzie handler i reader są zainicjalizowane i uruchomione w oczekiwaniu na interakcję z użytkownikiem.

Zadanie powinno być zrozumiałe przez wszystkich. Kolejno:
* inicjalizowane są klasy `Handler` i `InputReader`
* a następnie, póki zmienna `on` nie zostanie ustawiona na `false`, klasa odczytująca czeka na interakcję z użytkownikiem;
* jeżeli użytkownik nic nie wpisze, wyrzucany jest wyjątek `EmptyStringException` i program czeka dalej na użytkownika;
* jeżeli użytkownik wpisze `:q`, wyrzucany jest wyjątek `ExitCalledException` i program się wyłącza;
* jeżeli użytkownik wpisze `:w`, wyrzucany jest wyjątek `WriteCalledException` i program się wyłącza z wypisanie wyniku;
* jeżeli użytkownik wpisze więcej niż jedną literę, wyrzucany jest wyjątek `MultipleCharactersException` i program czeka dalej na użytkownika;
* jeżeli użytkownik wpisze polski znak, wyrzucany jest wyjątek `ForbiddenCharacterException` i program czeka dalej na użytkownika.

Najważniejsze do zrozumienia jest tutaj to, że cała logika poruszania się po aplikacji została przeniesiona na płaszczyznę wyjątków. To w nich definiowane są wiadomości, które są wyświetlane na interfejsie oraz informacje czy program powinien być kontynuowany po rzuceniu danego wyjątku.

### Zadanie do wykonania
Należy przekształcić program zgodnie z następującym opisem:
* program powinien przyjmować żądania HTTP; mogą być to bardzo uproszczone modele składające się z metody, adresu, tablicy nagłówków (np. `new HttpRequest("get", "/users", ["Authorization": "token123"])`)
* program powinien przechowywać listę użytkowników
* program na żądanie `GET /users` bez nagłówka `Authorization` powinien zwrócić błąd uwierzytelniania oraz status 401
* program na żądanie `GET /users` powinien zwrócić listę użytkowików oraz status 200
* program na żądanie `GET /users/1` bez nagłówka `Authorization` powinien zwrócić błąd uwierzytelniania oraz status 401
* program na żądanie `GET /users/1` (jeżeli użytkownik o id 1 istnieje) powinien zwrócić użytkownika o id 1 oraz status 200
* program na żądanie `GET /users/1` (jeżeli użytkownik o id 1 nie istnieje) powinien zwrócić błąd odnalezienia użytkownika oraz status 404
* program na żądanie `DELETE /users/1` bez nagłówka `Authorization` powinien zwrócić błąd uwierzytelniania oraz status 401
* program na żądanie `DELETE /users/1` (jeżeli użytkownik o id 1 istnieje) powinien usunąć użytkownika o id 1 oraz status 200
* program na żądanie `DELETE /users/1` (jeżeli użytkownik o id 1 nie istnieje) powinien zwrócić błąd odnalezienia użytkownika oraz status 404
* program na żądanie `GET /whatever` (czyli jakikolwiek inny adres niż `/users`) powinien zwrócić błąd odnalezienia strony oraz status 404

W pseudokodzie mogłoby wyglądać to tak:
```
Application application = new Application()

HttpRequest request = new HttpRequest("get", "/users")
application.handle(request)
# Error 401
# Unauthorized access.

HttpRequest request = new HttpRequest("get", "/users", ["Authorization": "token123"])
application.handle(request)
# Status 200
# | 1 | anowak |
# | 2 | bnowak |
# | 3 | cnowak |
# | 4 | dnowak |

HttpRequest request = new HttpRequest("get", "/users/1")
application.handle(request)
# Error 401
# Unauthorized access.

HttpRequest request = new HttpRequest("get", "/users/1", ["Authorization": "token123"])
application.handle(request)
# Status 200
# | 1 | anowak |

HttpRequest request = new HttpRequest("get", "/users/5", ["Authorization": "token123"])
application.handle(request)
# Error 404
# Model not found.

HttpRequest request = new HttpRequest("delete", "/users/1")
application.handle(request)
# Error 401
# Unauthorized access.

HttpRequest request = new HttpRequest("delete", "/users/1", ["Authorization": "token123"])
application.handle(request)
# Status 200
# User has been deleted

HttpRequest request = new HttpRequest("delete", "/users/1", ["Authorization": "token123"])
application.handle(request)
# Error 404
# Model not found.

HttpRequest request = new HttpRequest("get", "/whatever")
application.handle(request)
# Error 404
# Route not found.
```

Warto zastanowić się jak oprogramować powyższe polecenia, tak aby tzw. _happy path_ wykonywał się w aplikacji, a obsługa błędów była ujednolicona dla wszystkich metod.

Wykonane zadanie należy dodać do swojego repozytorium w katalogu `lab09`.

### Uruchamianie zadań
Wszystkie narzędzia są skonteneryzowane i gotowe do użycia bezpośrednio poprzez Dockera. Chętni studenci mogą oczywiście uruchamiać zadania w środowiskach lokalnych.

#### Java
```
docker compose run java javac ./exercises/lab09/java/Main.java ./exercises/lab09/java/lab09/*.java ./exercises/lab09/java/lab09/**/*.java
docker compose run java java -cp ./exercises/lab09/java Main
```

#### PHP
```
docker compose run php composer install --working-dir=./exercises/lab09/php
docker compose run php php ./exercises/lab09/php/index.php
```

#### Python
```
docker compose run python python ./exercises/lab09/python/main.py
```
