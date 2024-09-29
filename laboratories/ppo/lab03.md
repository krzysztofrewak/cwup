## Hermetyzacja

### Agenda
Przewidywany plan zajęć kształtuje się następująco:
* przedstawienie idei hermetyzacji i enkapsulacji,
* analiza zadania przykładowego,
* indywidualna praca nad listą zadań.

### Hermetyzacja i enkapsulacja
Proste klasy i tworzone na ich podstawie proste obiekty poznaliśmy w zeszłym tygodniu. Aby zmienić wartość pola obiektu, wystarczyło dostać się do niego w bezpośredni sposób:
```
class Player
{
    String name
    Integer healthPoints = 100
}

Player player = new Player()
player.name = "John"
```

Musimy zawsze pamiętać o tym, że paradygmat obiektowy pozwala nam modelować rzeczywisty świat, a im dokładniejsze będzie to modelowanie, tym lepiej będzie się nam programować. Stąd pojawił się pomysł, aby pewne elementy obiektów ukrywać przed światem zewnętrznym, podobnie jak nie wszystkie wartości można bezpośrednio zmieniać w prawdziwym świecie.

Wyobraźmy sobie grę, w której gracze "walczą ze sobą" i odbierają sobie punkty życia. Jeżeli liczba tych punktów spadnie do zera, gracz przegrywa. Uprośćmy sytuację najbardziej jak się da i zaproponujmy metodą ataku przyjmującą innego gracza jako argument i odbierającą mu w miarę losową liczbę punktów życia:
```
class Player
{
    String name
    Integer healthPoints = 100
    
    void attack(Player player) {
        Integer hitPoints = rand(1, 3) * 10
        player.healthPoints = player.healthPoints - hitPoints 
    }
}

Player luke = new Player()
luke.name = "Luke Skywalker"


Player vader = new Player()
vader.name = "Darth Vader"

vader.attack(luke)
```

Korzystając z dobrodziejstwa enkapsulacji, możemy zapisać samą klasę nieco inaczej:
```
class Player
{
    String name
    Integer healthPoints = 100
    
    void attack(Player player) {
        Integer hitPoints = rand(1, 3) * 10
        player.takeHit(hitPoints) 
    }
    
    void takeHit(Integer hitPoints) {
        this.healthPoints = this.healthPoints - hitPoints 
    }
}
```

Co tu się stało? Zamiast zmieniać w obiekcie bezpośrednio liczbę jego punktów życia, wystawiamy metodę, która to robi za nas. Praktycznie działa to identycznie, natomiast różnica oczywiście jest nieco bardziej zniuansowana. 

Przykład #1: samochód jedzie drogą z prędkością 90km/h. Czy jesteśmy w stanie bezpośrednio wpłynąć na jego prędkość w prawdziwym świecie? Czy zadajemy z poziomu klawiatury z jaką prędkością ma jechać? Nawet jeżeli korzystamy z tempomatu, prędkość jest wewnętrzną wartością pojazdu, która wynika z wielu innych skomplikowanych mechanizmów i czynników. Ona tam gdzieś faktycznie jest i nawet można ją pośrednio przeczytać, natomiast nie mamy do niej bezpośredniego dostępu na zasadach odczytu i zapisu. 

W programowaniu obiektowym takie zamknięcie na świat zewnętrzny nazywamy hermetyzacją, a służą do tego modyfikatory dostępu pól i metody (nazywane również akcesorami). W większości języków programowania są to `public`, `protected` i `private`, które kolejno oznaczają "dostępne dla wszystkich", "dostępne tylko wewnątrz klasy i klas dziedziczących" oraz "dostępne tylko wewnątrz klasy". 

Warto pamiętać, że w różnych językach różne akcesory są domyślne. Dlatego warto zawsze opisywać jaki mamy zamiar, aby nie robić problemów innym programistom:
```
class Player
{
    public String name
    private Integer healthPoints = 100
    
    public void attack(Player player) {
        Integer hitPoints = rand(1, 3) * 10
        player.takeHit(hitPoints) 
    }
    
    public void takeHit(Integer hitPoints) {
        this.healthPoints = this.healthPoints - hitPoints 
    }
}
```

W powyższym przykładzie `vader.healthPoints = 90` już nie zadziała, a kompilator lub interpreter zwrócą nam błąd niedozwolonego dostępu do zahermetyzowanej własności obiektu.

Niesie to ze sobą dodatkowe konsekwencje. Jeżeli liczba punktów życia byłaby dostępna publicznie, można byłoby ją zmienić w każdym momencie życia każdego obiektu. A co jeżeli chcielibyśmy wprowadzić jakąś walidację? Albo umożliwić obronę? W grach RPG często na rzut kością można odpowiedzieć drugim rzutem i można to zaimplementować w metodzie `takeHit()` i mieć pewność, że obrażenia zostaną zadane zawsze zgodnie z zasadami:
```
public void takeHit(Integer hitPoints) {
    if(rand(1, 20) >= 16) {
        hitPoints = hitPoints / 2
    }

    this.healthPoints = this.healthPoints - hitPoints 
}
```

Z reguły w projektach bardziej świadomych programistów praktycznie nie występują publiczne pola jako takie. Albo są hermetyzowane przez akcesory i enkapsulowane przez gettery i/lub settery, albo są oznaczane jako możliwe tylko do odczytu (jeżeli dany język ma zdefiniowany modyfikator `readonly`). 

### Analiza przykładowego zadania
Zadanie składa się z trzech części: klasy opisującej gracza, funkcji losującej gracza spośród innych graczy oraz procesu dodania graczy i "pojedynkowania się" między nimi:
```
class Player 
{
    public String name
    protected Integer healthPoints = 100

    public Integer attack(Player player)
    {
        Integer hitPoints = rand(1, 3) * 10
        player.takeHit(hitPoints)

        return hitPoints
    }

    public void takeHit(Integer hitPoints)
    {
        this.healthPoints = this.healthPoints - hitPoints
    }

    public Boolean isDead()
    {
        return this.healthPoints <= 0
    }
}

function Player getRandomPlayer(Collection<Player> players) {
    return players.random()
}

luke = new Player()
luke.name = "Luke Skywalker"

vader = new Player()
vader.name = "Darth Vader"

Collection<Player> players = []
players.push(luke)
players.push(vader)

Integer round = 1
Boolean ongoing = true

while (ongoing) {
    Player player = getRandomPlayer(players)
    Player target = getRandomPlayer(players)
    Integer hitPoints = player.attack(target)

    print "Round round: {player.name} attacked {target.name} with hitPoints points."

    foreach (Player player in players) {
        if (player.isDead()) {
            print "{player.name} died."
            ongoing = false
        }
    }

    round++
}
```

Zadanie powinno być zrozumiałe przez wszystkich. Kolejno:
* tworzonych jest dwóch graczy klasy `Player`, którzy są dodani do kontenera `players`;
* następnie w pętli losowany jest gracz atakujący oraz gracz atakowany i ten pierwszy atakuje drugiego;
* pętla zostaje przerwana, gdy liczba punktów życia któregoś z graczy spadnie do zera punktów. 

W każdym języku będzie to wyglądało nieco inaczej, ale warto zwrócić uwagę na pewne niuanse:
* Python w bardzo liberalny sposób podchodzi do hermetyzacji i traktuje ją bardziej jako podpowiedź niż wymuszenie dostępności
* liczba punktów życia na początku istnienia obiektu zawsze wynosi 100
* sprawdzanie czy dany gracz jeszcze żyje również została wpisana do osobnej metody; o wiele łatwiej jest sematycznie czytać `player.isDead()` niż porównywać na zewnątrz `player.healthPoints <= 0`; łatwiej będzie tym też później zarządzać w razie zmian zasad gry
* generator liczb pseudolosowych powoduje, że rozgrywka czasami trwa cztery rundy, a czasami nawet 12

### Zadanie do wykonania
Należy rozszerzyć program o następujące funkcjonalności:
* rozgrywka powinna przyjąć min. 10 graczy; sugerowane jest stworzenie generatora postaci, żeby nie musieć tworzyć ich ręcznie;
* gracz nie powinien móc zaatakować siebie; jest na to przynajmniej kilka rozwiązań, a podpowiedzią może być pytanie jak identyfikować czy dwa obiekty są takie same?
* przy każdej rundzie program powinien wyświetlić tabelę z graczami i ich punktami życia; dla chętnych: dobrze żeby była posortowana względem liczby punktów malejąco;
* gra powinna się skończyć dopiero gdy na arenie zostanie ostatni żywy gracz;
* dla chętnych: gracz powinien mieć szansę na obronę podczas ataku; można to zrealizować jako losowe obniżenie losowego procenta punktów ataku.

Wykonane zadanie należy dodać do swojego repozytorium w katalogu `lab03`.

### Uruchamianie zadań
Wszystkie narzędzia są skonteneryzowane i gotowe do użycia bezpośrednio poprzez Dockera. Chętni studenci mogą oczywiście uruchamiać zadania w środowiskach lokalnych.

#### Java
```
docker compose run java javac ./exercises/lab03/*.java
docker compose run java java -cp ./exercises/lab03 lab03
```

#### PHP
```
docker compose run php php ./exercises/lab03/lab03.php
```

#### Python
```
docker compose run python python ./exercises/lab03/lab03.py
```
