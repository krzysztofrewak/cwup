## Konstruktory

### Agenda
Przewidywany plan zajęć kształtuje się następująco:
* przedstawienie idei konstruktora,
* przedstawienie różnic w ustawianiu stanu obiektu przez konstruktor, metodę oraz publiczne pole
* analiza zadania przykładowego,
* indywidualna praca nad listą zadań na ocenę.

### Konstruktor
Oto kostka do gry:
```
class Dice
{
    public int roll() {
        return rand(1, 6)
    }
}

Dice dice = new Dice()
dice.roll()
# 3
dice.roll()
# 5
```

Tradycyjnie kostki do gry mają sześć ścian, ale w niektórych grach występują również inne warianty. Jak moglibyśmy zamodelować różnorakie wielościenne kostki? Pierwsze co mogłoby przyjść na myśl to przekazanie liczby `sides` jako parametru do metody `roll(Integer sides)` i zwrócenie `return rand(1, sides)`. Oczywiście zadziałałoby to poprawnie, ale nie miałoby sensu z punktu widzenia programowania obiektowego i modelowania rzeczywistego świata. Bo jak często kostka zmienia liczbę swoich ścian podczas gry? Raczej nigdy.

To w takim razie można byłoby dodać pole `public Integer sides`, pozbyć się parametru w `roll()` i losować liczbę między 1 a liczbą ścian określoną w polu obiektu: `return rand(1, this.sides)`? Też zadziała, ale w każdym momencie każdy może dopisać `dice.sides = 20` i znów zmienić w trakcie gry liczbę ścian.

A więc zostaje nam konstruktor, czyli specjalna metoda, która jest wywoływana podczas tworzenia instancji klasy. Domyślnie każda klasa ma konstruktor, jednakże jest on bezparametryczny i "pusty", a wywołuje się go przy tworzeniu obiektu: `new Dice()`. Spójrzmy na poniższą klasę:

```
class Dice
{
    public Integer sides
    
    public Dice(Integer sides) {
        this.sides = sides
    }
    
    public Integer roll() {
        return rand(1, this.sides)
    }
}

Dice dice = new Dice(20)
dice.roll()
# 16
```

Tutaj jest już prawie świetnie względem naszych potrzeb. Konstruktor przyjmuje liczbę określającą liczbę ścian kostki. Jedyne czego brakuje to hermetyzacja tej liczby: jeżeli ustawimy akcesor na `protected` lub `private` to kostka będzie budowana z konkretną liczbą ścian przy inicjalizacji i już nigdy z zewnątrz nie będzie mogło to być zmienione. Dokładnie tak jak to sobie wymyśliliśmy.

Konstruktor oczywiście może przyjąć dowolną liczbę parametrów i zachowuje się jak praktycznie jak każda inna metoda. Jedyną wyraźną różnicą jest to, że nic nie zwraca (i nie można określić zwracanego typu, nawet na `void`). 

### Ustawianie stanu
Wychodzi na to, że stan można ustawić na przynajmniej trzy sposoby:
1. Poprzez bezpośrednią modyfikację wartości pola, co jest teoretycznie najłatwiejsze i najszybsze, ale niesie ze sobą brak jakiejkolwiek kontroli nad wpisywanymi wartościami: 
```
Dice dice = new Dice()
dice.sides = 20
```

2. Poprzez setter, czyli zdefiniowaną przez programistę metodę, co umożliwi zastosowanie walidacji i kontrolę wprowadzanych danych (tutaj: chociażby sprawdzenie czy `sides` nie jest wartością ujemną!):
```
Dice dice = new Dice()
dice.setSides(20)
```

3. Poprzez konstruktor, co niesie za sobą wszystkie zalety korzystania ze specjalistycznej metody, a ponadto pozwala na zbudowanie obiektu w taki sposób jak to sobie zaplanowaliśmy:
```
Dice dice = new Dice(20)
```

Opcja z publicznym polem i setterem na tym przykładzie jest na tyle problematyczna, że wszyscy programiści w projekcie będą musieli wiedzieć, że trzeba ich użyć. Program by się wykrzaczył, gdyby ktoś wywołał `roll()`, a `sides` nie zostałoby uprzednio ustanowione. Dlatego warto korzystać z ustawiania stanu obiektu poprzez konstruktor, ponieważ zmniejsza to możliwość popełnienia głupiego błędu. Bez odpowiedniej hermetyzacji nawet najlepiej opisany konstruktor nie zabezpieczy nas przed najgłupszym przeoczeniem.

### Analiza przykładowego zadania
Zadanie składa się z dwóch części: klas opisujących kostkę, gracza i samą grę oraz procesu inicjalizacji i uruchomienia gry:
```
class Dice
{
    public int roll() {
        return rand(1, 6)
    }
}

class Player
{
    public String name
    
    public Player(String name) {
        this.name = name
    }
}

class Game
{
    public HashMap<Integer, Integer> fields = []
    public Collection<Player> = []
    public Dice dice
    
    public void prepareGame() {
        foreach(Player player, int index in players) {
            this.fields.add(index, 0)
        }
    }
    
    public void run() {
        Player winner = null
        
        while(winner === null) {
            foreach(Player player, int index in players) {
                Integer result = this.dice.roll()
                Integer position = this.fields[index] += result
                
                if(position >= 40) {
                    position = 40
                }
                
                print "{player.name} rolled {result}. Now is on position {position}."
                
                if(position >= 40) {
                    print "{player.name} won!"
                    winner = player
                    break
                }
            }
        }
    }
}

Game game = new Game()
game.dice = new Dice()
game.players = [
    new Player("Anakin Skywalker"),
    new Player("Obi-Wan Kenobi"),
]

game.prepareGame()
game.run()
```

Zadanie powinno być zrozumiałe przez wszystkich. Kolejno:
* tworzona jest instancja gry
* dopisywana jest do niej nowa instancja kostki
* dopisywani są do niej dwaj gracze
* wywołana jest metoda przygotowująca grę, która przypisuje wszystkim graczom pole startowe
* uruchamiana jest właściwa rozgrywka, która w pętli rzuca za każdego gracza kostką i następnie przesuwa go o tyle pól, ile wypadło oczek na kostce; wygrywa ten, który pierwszy dojdzie do pola numer 40

W każdym języku będzie to wyglądało nieco inaczej, ale warto zwrócić uwagę na pewne niuanse:
* w Javie konstruktor zapisuje się metodą o nazwie klasy, w PHP jest to magiczna metoda `__construct()`, a w Pythonie - `__init__()`
* zamiast przetrzymywać informację o pozycji gracza wewnątrz obiektu, stworzona jest dodatkowa struktura danych, która do każdego indeksu ma przypisany numer pola; ma to sens, bo sam pionek "nie powinien" wiedzieć gdzie się znajduje, ponieważ to odpowiedzialność samej gry
* przedstawiony przykład ma jeden zasadniczy błąd w dziedzinie projektowania obiektowego: autor klasy zmusza nas do pełnej znajomości wszystkich klas, aby uruchomić grę; żeby gra poprawnie funkcjonowała należy wywołać metodę `prepareGame()` przez wywołaniem metody `run()`, co samo w sobie jest oczywiście proste, ale gdyby każda klasa narzucała takie wymagania to programowanie byłoby bardzo trudne

### Zadanie do wykonania
Należy poprawić program:
* zastanowić się które wartości powinny być inicjalizowane poprzez publiczny akcesor, które poprzez wydzielony setter, a które poprzez konstruktor
* zastanowić się które pola i metody powinny być publiczne, a które chronione lub prywatne
* zastanowić się jak pozbyć się niepotrzebnego wymuszenia wywołania `prepareGame()` przed wywołaniem metody `run()` 

Należy również rozszerzyć program o następujące funkcjonalności:
* kostka powinna mieć definiowaną raz liczbę ścian (załóżmy, że maksymalnie do 20)
* gracz powinien mieć definiowane raz imię oraz zdefiniowaną wewnętrznie liczbę punktów życia równą 50
* gra powinna mieć możliwość jednokrotnego dodania jednej kostki oraz zamkniętego zestawu graczy; po rozpoczęciu gry już nikt nie powinien móc do niej dołączyć ani zmienić zasad
* gra powinna mieć możliwość jednokrotnego, ale opcjonalnego ustawienia maksymalnej liczby pól; jeżeli nie zostałaby ona ustawiona, wówczas gra powinna przyjąć domyślnie 100 pól
* gra powinna mieć możliwość jednokrotnego, ale opcjonalnego ustawienia maksymalnej liczby tur; jeżeli nie zostałaby ona ustawiona, gra toczyłaby się do osiągnięcia przez pierwszego gracza ostatniego pola; w przeciwnym wypadku wygrałby gracz, który jako pierwszy dotarł najdalej po zakończeniu ostatniej tury
* gra powinna implementować dodatkową zasadę: jeżeli gracz stanie na polu podzielonym przez 7, powinien rzucić kostką i stracić tyle punktów życia, ile wypadło oczek; gracz, którego liczba punktów życia spadnie do zera przegrywa

Chętni mogą zaimplementować większą dynamikę gry:
* jeżeli gracz pojawi się na polu okupowanym przez innych graczy, wówczas powinien móc otrzymać obrażenia od pozostałych na podstawie dodatkowych rzutów kostką  

Wykonane zadanie należy dodać do swojego repozytorium w katalogu `lab04`.

### Uruchamianie zadań
Wszystkie narzędzia są skonteneryzowane i gotowe do użycia bezpośrednio poprzez Dockera. Chętni studenci mogą oczywiście uruchamiać zadania w środowiskach lokalnych.

#### Java
```
docker compose run java javac ./exercises/lab04/*.java
docker compose run java java -cp ./exercises/lab04 lab04
```

#### PHP
```
docker compose run php php ./exercises/lab04/lab04.php
```

#### Python
```
docker compose run python python ./exercises/lab04/lab04.py
```
