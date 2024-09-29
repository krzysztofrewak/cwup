## Refleksje

### Agenda
Przewidywany plan zajęć kształtuje się następująco:
* przedstawienie idei refleksji,
* analiza zadania przykładowego,
* indywidualna praca nad listą zadań.

### Mechanizm refleksji
Jako programiści mamy oczywiście zazwyczaj dostęp do całego kodu poprzez swoje narzędzia programistyczne: możemy przeszukiwać wszystkie klasy, oglądać jakie mają zdefiniowane metody, przeglądać metody tworzenia obiektów i tak dalej, i tym podobne. Celowo hermetyzujemy pewne części kodu, aby nie były dostępne z innych części kodu, ponieważ chcemy jak najlepiej zamodelować otaczający nas świat czy też proces biznesowy. 

Kilkukrotnie przytaczaną na zajęciach analogią był samochód. Niektóre elementy i procesy silnika nie są dostępne z poziomu kierowcy (publiczne), ale są niezbędne, aby samochód się poruszał. Raz na jakiś czas jednak trzeba zjechać tym samochodem do warsztatu, mechanik podniesie maskę i... nagle okazuje się, że może dostać się do większej liczby elementów i procesów niż zwykły użytkownik. Tenże mechanik oczywiście musi znać się na swojej pracy i niestety musi wziąć na siebie pełną odpowiedzialność za swoje prace. Takim odpowiednikiem trybu mechanika będzie w programowaniu obiektowym mechanizm refleksji.

```
ReflectionClass reflector = new ReflectionClass(Car::class)
ReflectedInstance instance = reflector.newInstance()
ReflectedMethod method = reflector.getMethod("getLambdaSensorReadings")

result = method.invoke(instance)
```

Przykład powyżej należy rozumieć kolejno:
* tworzony jest obiekt `ReflectionClass` na podstawie klasy, na której będziemy chcieli operować (`Car`); klasa ta jest przekazana do konstruktora `ReflectionClass`
* na podstawie reflektora tworzona jest instancja samochodu w trybie refleksji
* na instancji klasy w trybie refleksji można wywołać już dowolne metody, ale tutaj wywoływana jest `getMethod("getLambdaSensorReadings")`
* w ostatniej linijce wykorzystujemy mechanizm refleksji, aby w sztucznym środowisku wywołać metodę opisaną przez `method` na instancji klasy w `instance`

Powyższy przykład wygląda bardzo podobnie w Javie, PHP czy C#. W Pythonie oczywiście wygląda to nieco inaczej (prościej?), ale nie będziemy tutaj opisywać rozbieżności.

W opisywanym przykładzie wywoływaliśmy znaną nam metodę, ale możemy wybrać inne możliwości, np. sprawdzić zaimplementowane w klasie interfejsy przez `getInterfaces()`, sprawdzić stan dziedziczenia przez `isFinal()`, przejrzeć statyczne pola przez `getStaticProperties()` czy też ogólnie sprawdzić wszystkie dostępne metody przez `getMethods()`. 

Z ciekawych rzeczy warto też wspomnieć, że z trybu refleksji nie musimy się martwić hermetyzacją badanych klas, gdyż możemy dowolnie manipulować atrybutami pól i metod (chociażby przez metodę `setAccessible(true)`).

### Analiza przykładowego zadania
Zadanie składa się z kilku części: deklaracji "routingu", czyli trasowania poleceń na akcje, odczytaniu podanego przez użytkownika polecenia oraz uruchomienie akcji wedle mapy routingu. 

Router składa się z obiektów klasy `Route`, z których każdy ma faktyczny route (czyli polecenie, na które będzie reagował), nazwę klasy opisującej akcję, która ma się wydarzyć i opcjonalnie nazwę metody, która miałaby zostać uruchomiona w tej klasie:
```
Router router = new Router([
    new Route("version", VersionAction::class),
    new Route("quote", QuoteAction::class, "getRandomQuote"),
    new Route("quote:popular", QuoteAction::class, "getMostPopularQuote"),
    new Route("quote:id", QuoteAction::class, "getByIndex"),
]);
```

Zatem jeżeli użytkownik uruchomi program z parametrem:
* `program version` to otrzyma wypisaną wersję języka;
* `program quote` wywoła metodę `getRandomQuote()` w klasie `QuoteAction`, czyli wypisze losowy cytat z bazy cytatów;
* `program quote:popular` wywoła metodę `getMostPopularQuote()` w klasie `QuoteAction`, czyli wypisze "najpopularniejszy" cytat z bazy cytatów;
* `program quote:id 2` wywoła metodę `getByIndex(Integer id)` w klasie `QuoteAction`, czyli wypisze cytat o identyfikatorze `id` z bazy cytatów.

Router porównuje podane polecenie ze swoimi poleceniami i wydaje konkretny obiekt klasy `Route`. Z niego mechanizmem refleksji budowany jest obiekt akcji, następnie wywoływana jest konkretna metoda z przekazanymi parametrami.

Program realizuje zadanie w najprotszy możliwy sposób, aby przedstawić zagadnienie mechanizmu refleksji bez zbędnych rozpraszaczy. W rzeczywistości taka funkcjonalność musiałaby być o wiele bardziej zabezpieczona, gdyż teraz program się wyłoży przy braku parametrów uruchomienia, przy niewłaściwych parametrach itp. Warto też się zastanowić czy zawsze będziemy chcieli umożliwić uruchomienia naprawdę każdej metody.

### Zadanie do wykonania
Należy zaprojektować i zaimplementować program realizujący następujące funkcjonalności:
* program powinien umożliwiać ewidencjonowanie zwierząt w zoo;
* program na starcie powinien załadować plik z indeksem zwierząt, który powinien mieć formatowanie jak poniżej (imię zwierzęcia, gatunek, płeć, wiek); plik docelowy powinien składać się z setki zwierząt spośród przynajmniej 15 gatunków:
```
Sandy;giraffe;f;12
Eenie;zebra;f;5
Meenie;zebra;f;4
Miney;zebra;f;6
Moe;zebra;m;6
Musafa;lion;m;14
Nala;lion;f;6
Simba;lion;m;5
Kong;gorilla;m;24
Abra;dolphin;m;4
Kadabra;dolphin;m;5
Ala;dolphin;f;6
Kazam;dolphin;f;6
```
* program powinien przetworzyć plik wsadowy na wewnętrzne struktury danych, które będą agregowane i poddawane późniejszej obróbce
* program powinien być zabezpieczony przed wszelkiej maści błędami, włączając w to wpisanie przez użytkownika niepoprawnych lub nieistniejących poleceń, błędnie podane parametry lub ich typy czy też błędy importu danych
* program po uruchomieniu powinien czekać na wejście od użytkownika; powinien rozumieć i realizować następujące polecenia:

| polecenie          | opis                                       | parametry                                       |
|--------------------|--------------------------------------------|-------------------------------------------------|
| `quit`             | wychodzi z programu                        |                                                 |
| `list`             | wypisuje wszystkie zwierzęta z listy       |                                                 |
| `list x`           | wypisuje `x` pierwszych zwierząt z listy   | liczba dodatnia                                 |
| `count`            | wypisuje liczbę zwierząt na liście         |                                                 |
| `sort x`           | sortuje listę zwierząt według filtra `x`   | `name`, `-name`, `age`, `-age`, `id` lub `-id`  |
| `filter:group x`   | filtruje listę zwierząt według gromady `x` | `mammal`, `-mammal`, `reptile`, `-reptile` itd. |
| `filter:species x` | filtruje listę zwierząt według gatunku `x` | `giraffe`, `-giraffe`, `zebra`, `-zebra` itd.   |
| `filter:gender x`  | filtruje listę zwierząt według płci `x`    | `m`, `f` lub `h`                                |
| `filter:age x`     | filtruje listę zwierząt według wieku       | liczba dodatnia lub ujemna*                     |
| `random`           | wypisuje losowe zwierzę z listy            |                                                 |
| `clear`            | resetuje filtry i sortowania               |                                                 |

* *`filter:age 10` zawęzi liczbę do zwierząt mających 10 lat lub więcej; `filter:age -10` mający 10 lat lub mniej

Przykładowo kolejne polecenia:
```
filter:gender m
filter:age -10
sort -name
count
list 3
```

powinny przykładową listę powyżej przebudować jako posortowane imionami nie starsze niż 10 lat samce i wypisać jako liczbę oraz postać tabelaryczną:
```
# table --filter:gender m --filter:age -10 --sort -name count
3

# table --filter:gender m --filter:age -10 --sort -name --list 3
|  8 | Simba   | lion    | mammal | male | 5 |
|  5 | Moe     | zebra   | mammal | male | 6 |
| 11 | Kadabra | dolphin | mammal | male | 5 |
```

Nad czym warto się zastanowić?
* może warto stworzyć dodatkowy (konfigurowalny?) podprogram generujący plik wejściowy?
* jak sensownie rozróżniać, które zwierzęta należą do jakiej gromady?
* jak sensownie nadawać id zwierzętom?

Chętni mogą zaprojekować program w taki sposób, aby można było korzystać z niego na przynajmniej trzy sposoby: 
* klasyczny, czyli przez oczekiwanie na input użytkownika w konsoli uruchamiając program bez parametrów (`program`)
* parametryzowany, czyli bez interakcji z użytkownikiem, a przyjmując argumenty w pipelinie, np.: `program --filter:gender m --filter:age -10 --sort -name --list 3`
* importowany, czyli bez interakcji w ogóle, a podając plik z poleceniami: `program --file commands.txt`, gdzie `commands.txt` mogłoby wyglądać następująco:
```txt
filter:gender m
filter:age -10
sort -name
list 3
```

Wykonane zadanie należy dodać do swojego repozytorium w katalogu `lab10`.

### Uruchamianie zadań
Wszystkie narzędzia są skonteneryzowane i gotowe do użycia bezpośrednio poprzez Dockera. Chętni studenci mogą oczywiście uruchamiać zadania w środowiskach lokalnych.

#### Java
```
docker compose run java javac ./exercises/lab10/java/Main.java  ./exercises/lab10/java/lab10/*.java ./exercises/lab10/java/lab10/**/*.java

docker compose run java java -cp ./exercises/lab10/java Main version
docker compose run java java -cp ./exercises/lab10/java Main quote
docker compose run java java -cp ./exercises/lab10/java Main quote:popular
docker compose run java java -cp ./exercises/lab10/java Main quote:id 2
```

#### PHP
```
docker compose run php composer install --working-dir=./exercises/lab10/php

docker compose run php php ./exercises/lab10/php/index.php version
docker compose run php php ./exercises/lab10/php/index.php quote
docker compose run php php ./exercises/lab10/php/index.php quote:popular
docker compose run php php ./exercises/lab10/php/index.php quote:id 2
```

#### Python
```
docker compose run python python ./exercises/lab10/python/main.py version
docker compose run python python ./exercises/lab10/python/main.py quote
docker compose run python python ./exercises/lab10/python/main.py quote:popular
docker compose run python python ./exercises/lab10/python/main.py quote:id 2
```
