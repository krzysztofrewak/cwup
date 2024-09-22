## Klasy i obiekty

### Agenda
Przewidywany plan zajęć kształtuje się następująco:
* przedstawienie różnic między paradygmatami strukturalnym a obiektowym,
* przedstawienie idei klas i obiektów,
* przedstawienie idei pól i metod,
* analiza zadania przykładowego,
* indywidualna praca nad listą zadań.

### Paradygmat strukturalny a obiektowy na przykładzie
W bardzo dużym uproszczeniu w strukturalny sposób wszystko można łatwo dopisać do zadeklarowanych zmiennych. Spróbujmy na przykład stworzyć studenta z imieniem i nazwiskiem, a następnie je wyświetlić:
```
String studentName = "John"
String studentSurname = "Doe"

print studentName + " " + studentSurname
```

A co jeżeli chcielibyśmy dodać ich kilku?
```
Collection<String> names = []
Collection<String> surnames = []

String studentName = "John"
String studentSurname = "Doe"

names.push(studentName)
surnames.push(studentSurname)
```

A może jeszcze inaczej?
```
Collection<String> students = []

String studentName = "John"
String studentSurname = "Doe"

students.push(studentName + " " + studentSurname)
```

Na pewno znalazłoby się więcej rozwiązań, ale te dwa mają swoje duże wady. W pierwszym musimy mocno zarządzać wieloma kolekcjami (tablicami/wektorami/listami/czymkolwiek), bo przecież studenci nie są tylko imieniem i nazwiskiem, ale także numerami indeksów, przypisanymi przedmiotami i tak dalej. Drugi przykład jest na tyle przykry, że przyjmujemy, że student to właśnie tylko imię i nazwisko. 

Co w przypadku, gdybyśmy chcieli dodać pole typu boolean (prawda/fałsz) z informacją czy student jest aktywny? W pierwszej opcji trzeba byłoby dodać `Collection<Boolean> statuses = []`, w drugiej zrobić jeszcze większe obejście.

### Klasy i obiekty
Tu z pomocą przychodzi paradygmat obiektowy. Gdybyśmy nie musieli ograniczać się do typów dawanych nam przez język (takich jak string czy boolean) to moglibyśmy stworzyć własny "typ" opisujący studenta:
```
class Student
{
    String name
    String surname
    Boolean status = false
}
```

Taki opis nazywamy klasą i łatwo go sobie wyobrazić jako przepis, na podstawie którego będą powstawały konkretne instancje reprezentujące konkretnych studentów. Te instancje nazywamy obiektami, a w większości języków programowania obiekty tworzy się za pomocą operatora `new`:
```
Student student = new Student()
```

Dzięki temu jesteśmy w stanie łatwo rozczytać z kodu, że jego autorowi w tym miejscu chodziło dokładnie o reprezentację studenta. Klasy mogą opisywać dowolne podmioty czy zjawiska zachodzące w świecie lub domenie projektowej. W "prawdziwym świecie" klasy będą często reprezentowały użytkowników, procesy biznesowe, powiadomienia czy też reakcje na inne zdarzenia, ale do tego będziemy wracać przez cały ten i następne semestry.

Grunt to zapamiętać najważniejszą rzecz: **klasa jest instrukcją (przepisem, opisem, szablonem), na podstawie której powstają obiekty**. 

### Pola i metody
Każdy obiekt będzie miał swój zestaw pól, czyli wartości atrybutów opisanych w klasie. Najlepiej to zilustruje przykład:
```
Student student = new Student()
student.name = "John"

Student student2 = new Student()
student2.name = "Jim"

print student.name
# John
print student2.name
# Jim
```

Konkretne imię przypisane do jednego studenta jest tylko jego własnością. Inny student może mieć całkiem inne imię. Klasa natomiast opisuje, że każdy student ma jakieś imię.

Klasy mogą też definiować metody, czyli funkcje, które będą wywoływane na obiektach. Wróćmy zatem do opisu studenta:
```
class Student
{
    String name
    String surname
    Boolean status = false
    
    String getFullName() {
        return this.name + " " + this.surname
    }
}
```

Jest to na tyle wygodne, że ułatwi nam współpracę z bardziej rozbudowanymi obiektami: 
```
Student student = new Student()
student.name = "John"
student.surname = "Doe"

print student.getFullName()
# John Doe
```

Tutaj warto zwrócić uwagę jak działa słowo kluczowe `this` użyte wewnątrz metody. Jest to w dużym uproszczeniu wskaźnik na obiekt, na którym dana metoda zostanie wywołana.

### Interludium: Pola i metody statyczne
Część języków programowania pozwala na definiowanie pól i metod statycznych:
```
class Student
{
    String name
    String surname
    Boolean status = false
    static String university = "Collegium Witelona"
}
```

Jest to na tyle ciekawa sprawa, że pola statyczne są dowiązane do klasy, a nie do obiektów. Jeżeli zmienimy coś statycznego w jednym obiekcie, zostanie zmienione we wszystkich. Metody statyczne natomiast mogą korzystać tylko ze statycznych pól. Dzięki temu do statycznych pól i metod można dostać się bez tworzenia obiektów!
```
print Student::university
# Collegium Witelona
```

### Analiza przykładowego zadania
Zadanie składa się z trzech części: klasy opisującej gracza, funkcji losującej imię oraz procesu dodania gracza do listy graczy:
```
class Player
{
    String name
    Integer healthPoints = 100
    
    String identify() {
        return "[{this.healthPoints}] {this.name}"
    }
}

function String getRandomName() {
    Collection<String> names = ["John", "Jim", "Jack", "George", "Kevin"]
    return names[rand(0, names.size() - 1)]
}

Collection<Player> players = []

Player player = new Player()
player.name = getRandomName()
players.push(player)

foreach(Player player in players) {
    print player.identify()
}
```

Zadanie powinno być zrozumiałe przez wszystkich. Kolejno:
* tworzona jest pusta kolekcja graczy;
* następnie tworzony jest obiekt klasy `Player`;
* następnie tenże gracz zyskuje losowane imię;
* następnie tenże gracz dodawany jest do kolekcji;
* na koniec lista wszystkich graczy jest wypisywana na ekranie.

W każdym języku będzie to wyglądało nieco inaczej, ale warto zwrócić uwagę na pewne niuanse:
* większość języków programowania posiada wygodne kontenery: w C++ jest to `std::vector`, w Javie `java.util.ArrayList`, w PHP `array` itd.
* funkcja losująca imię jest poza klasą; mogłaby się w niej znaleźć, ale warto sobie zadać pytanie: czy gracz sam sobie nadaje imię, czy może po prostu je nosi i *nie wie*, w jaki sposób je dostaje? 
* większość języków programowania posiada pętle `foreach` które w łatwy sposób iterują po kontenerze
* zaprezentowany program najpewniej się wykrzaczy w momencie, gdy ktoś stworzy gracza bez nazwiska (dojdziemy do tego jak to naprawić przy okazji laboratorium 4)

### Zadanie do wykonania
Należy rozszerzyć program o następujące funkcjonalności:
* program powinien generować listę 30 graczy z losowanymi imionami i tytułami raz statusem:
  * tytuł powinien być losowany z dowolnej puli, ale nie powinien być wymagany; wręcz dobrze byłoby oprogramować, aby tylko część graczy otrzymywała tytuł
  * status gracza powinien przyjąć wartość `true` lub `false` i będzie oznaczał czy dany gracz jest "online"
* następnie program powinien wypisać tylko aktywnych graczy w formacie:
```
[liczba punktów życia] | tytuł imię
```
* czyli przykładowo:
```
[100] | Darth Vader
[100] | adm. Thrawn
[100] | cpt. Gilad_Pellaeon
```

Wykonane zadanie należy dodać do swojego repozytorium w katalogu `lab02`.

### Uruchamianie zadań
Wszystkie narzędzia są skonteneryzowane i gotowe do użycia bezpośrednio poprzez Dockera. Chętni studenci mogą oczywiście uruchamiać zadania w środowiskach lokalnych.

#### Java
```
docker compose run java javac ./exercises/lab02/*.java
docker compose run java java -cp ./exercises/lab02 lab02
```

#### PHP
```
docker compose run php php ./exercises/lab02/lab02.php
```

#### Python
```
docker compose run python python ./exercises/lab02/lab02.py
```
