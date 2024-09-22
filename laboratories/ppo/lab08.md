## Klasy abstrakcyjne

### Agenda
Przewidywany plan zajęć kształtuje się następująco:
* przedstawienie idei funkcji anonimowych,
* analiza zadania przykładowego,
* indywidualna praca nad listą zadań.

### Funkcja jako argument innej funkcji
Myślę, żę przyzwyczailiśmy się wszyscy do tego, że do funkcji można jako argumenty przekazać wartości prymitywnych typów lub obiekty zbudowane na podstawie klas:
```
this.rearrangePermissions(users, permissions, true)
```

W większości języków programowania można jako parametru oczekiwać tak zwanej funkcji anonimowej, zwanej też często funkcją lambda. Jest to funkcja nieprzypisana do żadnej nazwy, którą można wywołać ad hoc w innej części programu. Brzmi nieco zawile, ale spróbujmy to rozgryźć na przykładach.

Wyobraźmy sobie klasę `Collection`, która przyjmuje w swoim konstruktorze tablicę stringów, czyli słów:
```
class Collection {
    protected array<String> words

    public Collection(array<String> words) {
        this.words = words
    }
}
```

Stworzenie funkcji, która będzie filtrowała części składowe kolekcji (słowa), wydaje się bardzo proste. Wyobraźmy sobie, że musimy je filtrować względem długości słowa, zawierania w sobie innego słowa oraz rozpoczynania się wielką literą:
```
class Collection {
    protected array<String> words

    public Collection(array<String> words) {
        this.words = words
    }

    public void filterByWordsLongerThan(int length) {
        let words = []
        foreach(String word in this.words) {
            if(word.length >= length) {
                words[] = word
            }
        }
        
        this.words = words
    }

    public void filterByContainedString(String string) {
        let words = []
        foreach(String word in this.words) {
            if(word.includes(string)) {
                words[] = word
            }
        }
        
        this.words = words
    }

    public void filterByFirstLetterCasing() {
        let words = []
        foreach(String word in this.words) {
            if(word.get(0).isUppercase()) {
                words[] = word
            }
        }
        
        this.words = words
    }
}
```

To tylko trzy funkcje, które teoretycznie robią to samo, ale musieliśmy je powtórzyć, bo trudno je sparametryzować w klasyczny sposób. Metoda `filterByWordsLongerThan` wygląda najgorzej: w najbardziej pesymistycznym wypadku musielibyśmy stworzyć cztery analogiczne: dla słów równej długości, krótszych, krótszych lub równych oraz dłuższych lub równych. Sprawa skomplikowałaby się jeszcze bardziej, gdybyśmy chcieli do kolekcji przyjmować inne typy niż tylko string.

A gdybyśmy przekazali pomysł na funkcję sortującą, a metoda `filter()` sama by ją sobie wywołała?
```
class Collection {
    protected array<String> words

    public Collection(array<String> words) {
        this.words = words
    }

    public void filter(lambda function) {
        let words = []
        foreach(String word in this.words) {
            if(function(word)) {
                words[] = word
            }
        }
        
        this.words = words
    }
```

Żeby znaleźć wszystkie słowa dłuższe niż trzy litery, zaczynające się na wielką literą oraz mające w sobie literę $a$, należałoby wywołać taki ciąg funkcji:
```
let collection = new Collection(words)
collection.filterByWordsLongerThan(3)
collection.filterByContainedString("a")
collection.filterByFirstLetterCasing()
```

Z wykorzystaniem funkcji anonimowych wyglądałoby to tak:
```
let collection = new Collection(words)
collection.filter(function(String word) => word.length >= 3)
collection.filter(function(String word) => word.includes(string))
collection.filter(function(String word) => word.get(0).isUppercase())
```

Metoda `filter` przyjmuje teraz wyrażenie lambda, które następnie wywołuje z przekazanym parametrem. Dzięki temu nie musimy tworzyć 17 różnych metod filtrujących, a wystarczy jedna definicja przyjmująca model filtrowania.

Będzie to też bardziej poręczne w przypadku generycznych typów w klasach. Dzięki temu nie uzależniamy już implementacji metod `filter*` od tego, że obiektami kolekcji będą słowa; teraz mogą być to obiekty dowolnego typu:
```
class Collection<T> {
    protected array<T> words

    public Collection(array<T> words) {
        this.words = words
    }

    public void filter(lambda function) {
        let words = []
        foreach(T word in this.words) {
            if(function(word)) {
                words[] = word
            }
        }
        
        this.words = words
    }
```

### Analiza przykładowego zadania
Zadanie składa się z kilku części: 
* klasy opisującej kolekcję stringów, którą można sortować, filtrować, ucinać oraz wypisywać
* głównej funkcji, w której kolekcja jest zapełniona słowami oraz przeprowadzane są na niej kolejne operacje 

Zadanie powinno być zrozumiałe przez wszystkich. Kolejno:
* zestaw słów jest wgrany do kolekcji
* następnie kolekcja jest przefiltrowana tak, aby pozostały w niej słowa, która mają mniej niż cztery litery
* następnie jest przesortowana alfabetycznie
* następnie jest ucięta do dwóch pierwszych elementów
* a na koniec jest wypisana.

Wynik powinien być następujący:
```
in: Lorem, ipsum, dolor, sit, amet, consectetur, adipiscing, elit, sed, do, eiusmod, tempor, incididunt, ut, labore, et, dolore, magna, aliqua

out: do, et
 ```

### Zadanie do wykonania
Należy rozszerzyć program o następujące funkcjonalności:
* przerobić tak, aby przyjmował obiekty dowolnego typu per instancja kolekcji (czyli, żeby móc zbudować na przykład kolekcję użytkowników klasy `User`, a obok kolekcję kwiatów klasy `Flower`) (to będzie raczej zagadnienie dla Javowców, jako że PHP i Python nie obsługują generyków)
* rozszerzyć klasę kolekcji o metodę `map`, która będzie przekształcała obiekty tablicy w inne; na przykład `collection.map(function(String word) => word.length)` powinno stworzyć tablicę liczb reprezentujących długość wyrazów
* rozszerzyć klasę kolekcji o metodę `reject` odwrotną do `filter`; metoda powinna pozostawić tylko te elementy, które nie spełniają przekazanego wyrażenia lambda
* rozszerzyć klasę kolekcji o metodę `count` wypisującą liczbę elementów kolekcji
* zbudować kolekcję pojazdów składającą się z 25 samochodów, następnie odfiltrować z nich marki Audi i BMW, posortować wedle przebiegu od najwyższego i wypisać pięć pierwszych jako VIN
* zbudować kolekcję 25 graczy, sprawdzić ilu z nich jeszcze żyje i wypisać tę liczbę

Sugerowane wejście powinno wyglądać następująco:
```
let collection = new Collection<Car>(cars)
collection.reject(function(Car car) => car.getMake().isOneOf(["Audi", "BMW"]))
collection.sort(function(Car a, Car b) => b.getMileage() - a.getMileage())
collection.map(function(Car car) => car.getVIN())
collection.limit(5)

print collection.get()
```

oraz 

```
let collection = new Collection<Player>(players)
collection.filter(function(Player player) => player.isAlive())

print collection.count()
```

Nad czym warto się zastanowić?
* czy metoda `map` powinna tworzyć pod spodem nową instancję kolekcji?
* co się stanie, jeżeli zmienimy słowo `et` na `Et` w przykładowym programie?

Wykonane zadanie należy dodać do swojego repozytorium w katalogu `lab08`.

### Uruchamianie zadań
Wszystkie narzędzia są skonteneryzowane i gotowe do użycia bezpośrednio poprzez Dockera. Chętni studenci mogą oczywiście uruchamiać zadania w środowiskach lokalnych.

#### Java
```
docker compose run java javac ./exercises/lab08/java/Main.java ./exercises/lab08/java/lab08/*.java
docker compose run java java -cp ./exercises/lab08/java Main
```

#### PHP
```
docker compose run php composer install --working-dir=./exercises/lab08/php
docker compose run php php ./exercises/lab08/php/index.php
```

#### Python
```
docker compose run python python ./exercises/lab08/python/main.py
```
