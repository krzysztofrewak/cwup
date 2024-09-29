## Interfejsy

### Agenda
Przewidywany plan zajęć kształtuje się następująco:
* przedstawienie idei interfejsu w ujęciu polimorfizmu,
* przedstawienie idei interfejsu w ujęciu kontraktu,
* analiza zadania przykładowego,
* indywidualna praca nad listą zadań.

### Interfejsy a polimorfizm
Interfejs jest odpowiedzią świata paradygmatu obiektowego na brak wielokrotnego dziedziczenia. Idea jest nieco bardziej skomplikowana niż przy dziedziczeniu, ponieważ dotyczy pewnego poziomu abstrakcji, ale spróbujmy zrozumieć to na przykładzie:
```
class Car {}
class Truck extends Car {}
class Bike {}

ParkingLot parkingLot = new ParkingLot()
parkingLot.letIn(new Car())
parkingLot.letIn(new Truck())
parkingLot.letIn(new Bike())
```

Jak musiałaby wyglądać sygnatura metody `letIn()` w klasie `ParkingLot`, aby mogła przyjąć zarówno obiekty klasy `Car`, `Truck`, jak i `Bike`? Pierwsze dwa są ze sobą związane dziedziczeniem, więc polimorfizm załatwia tutaj sprawę, ale co z rowerem? Przecież nie możemy dziedziczyć roweru po samochodzie ani samochodu po rowerze, bo są to całkowicie różne pojazdy.

W niektórych językach programowania takich jak Java można byłoby stworzyć dwie metody `letIn(Car car)` oraz `letIn(Bike bike)`, ale byłoby to rozwiązanie tymczasowe i mało odporne na rozszerzanie się funkcjonalności programu ("a co gdyby takich klas było 15?"). W nowszych wersjach PHP można byłoby zastosować union type: `letIn(Car|Bike $bike)`, ale niosłoby to dokładnie te same problemy.

Z pomocą przychodzi idea interfejsu:
```
interface Vehicle {}

class Car implements Vehicle {}
class Truck extends Car {}
class Bike implements Vehicle {}

class ParkingLot
{
    public void letIn(Vehicle vehicle) {
        // (...)
    }
}

ParkingLot parkingLot = new ParkingLot()
parkingLot.letIn(new Car())
parkingLot.letIn(new Truck())
parkingLot.letIn(new Bike())
```

Interfejs nie jest klasą (a przynajmniej nie jest nią w większości języków programowania), ale osobną strukturą w języku, która może być implementowana do innych klas. Jeżeli dana klasa implementuje dany interfejs, należy wszystkie jej obiekty rozumieć również jako - w uproszczeniu - "instancje tego interfejsu". Zatem wybrana metoda może oczekiwać obiektu klasy implementującej oczekiwany interfejs bez precyzowania co to będzie za klasa.

Takie podejście sprawdzi się szczególnie w przypadkach, gdzie z różnych powodów nie możemy wykorzystać dziedziczenia, a gdzie chcielibyśmy nadać wspólną "etykietę" kilku klasom. Dzięki interfejsom będziemy w stanie zwinniej poruszać się w świecie abstrakcji, ale to po części wyniknie też z ich drugiego zastosowanie, czyli kontraktowania.

### Interfejsy jako kontrakty
Interfejs na przykładzie powyżej był pusty, ale zdarza się to stosunkowo rzadko. O wiele częściej spotkamy się z interfejsem składającym się z sygnatur metod:
```
interface Vehicle
{
    public String identify()
}
```

Warto zwrócić uwagę, że to sama sygnatura bez ciała metody, a więc jedynie:
* akcesor (tutaj: `public`), 
* informacja o zwracanym typie (`String`), 
* nazwa metody (`identify`),
* lista parametrów (tutaj metoda jest bezparametryczna).

Każda klasa implementująca opisany sygnaturami metod interfejs musi implementować te metody. Zatem jeżeli interfejs `Vehicle` ma sygnaturę `public String identify()`, klasa `Car implements Vehicle` będzie musiała faktycznie mieć taką metodę i zapewne zwróci markę samochodu lub jego VIN czy też numer rejestracyjny. Oczywiście inne metody mogą byc implementowane zgodnie z potrzebami.  

Stąd też wywodzi się słowo pomocnicze "kontakt", które chyba najlepiej opisuje, co tutaj tak naprawdę zachodzi. Jeżeli jeden obiekt "spotka" inny, którego klasa implementuje dany kontrakt, nie musi "wiedzieć" z kim rozmawia, a jedynie jak rozmawiać. Interfejs będzie tutaj podawał listę dostępnych publicznych metod, które zawsze będzie można wywołać w ten sam sposób, bez względu jakiej klasy byłby to obiekt. I na przykładzie: jeżeli parkingowy zapisuje w zeszycie każdy wjazd na parking to:
* samochody zapewne spisze po marce i numerze rejestracyjnym,
* ludzi zaznaczy "wchodzi człowiek",
* rowery oznaczy "wjeżdża rower".

W tak przykładzie parkingowy nie musi rozróżniać tych typów w żaden sposób. Wystarczy, że wie, że wszystko wjeżdżające na parking musi implementować konkretny interfejs/kontrakt, a ten wymusza na obiektach implementację metody "przedstaw się". Jej wynik zostanie zapisany w zeszycie.

Wydawać mogłoby się oczywistym, ale warto pamiętać, że implementowane interfejsy są dziedziczone, a więc jeżeli `Car` implementuje `Vehicle`, a `Truck` dziedziczy po `Car`, to wówczas `Truck` również będzie uznawane za `Vehicle` i będzie musiało implementować wszystkie metody z tego interfejsu. Większość języków programowania pozwala również dziedziczyć interfejsy po sobie, co realizuje składnia `interface D extends A, B, C`, a oznacza tyle, że klasa implementująca interfejs `D` będzie traktowana jako `A`, `B`, `C` oraz `D`, a także będzie musiała zaimplementować wszystkie metody z tych interfejsów.

### Analiza przykładowego zadania
Zadanie składa się z kilku części: 
* definicji interfejsu `ParkingVehicle` i trzech implementujących go klas: bezpośrednio `Bike` i `Car` oraz `Truck` poprzez dziedziczenie z `Car`:
```
interface ParkingVehicle
{
    public String identify()
}
```

```
class Bike implements ParkingVehicle
{
    public String identify() {
        return "bike"
    }
}

class Car implements ParkingVehicle
{
    public String identify() {
        return "car"
    }
}

class Truck extends Car
{
    public String identify() {
        return "truck"
    }
}
```
* klasy modelującej parking:
```
class ParkingLot
{
    protected const Integer MAX_AVAILABLE_SPACES = 3
    protected Integer occupiedSpaces = 0

    public void (ParkingVehicle vehicle)
    {
        String name = vehicle.identify()
        String now = date("Y-m-d H:M:S")

        if(this.occupiedSpaces >= static.MAX_AVAILABLE_SPACES) {
            print "{name} is returned at {now}"
            return
        }

        print "{name} is entering at {now}"
        this.occupiedSpaces++
    }
}
```
* głównej części programu:
```
Collection<ParkingVehicle> vehicles = [
    Bike(),
    Car(),
    Truck(),
    Car(),
]

ParkingLot parkingLot = new ParkingLot() 

foreach(ParkingVehicle vehicle in vehicles) {
    parkingLot.letIn(vehicle)
}
```

Zadanie powinno być zrozumiałe przez wszystkich. Kolejno:
* tworzona jest lista czterech pojazdów
* tworzona jest instancja parkingu
* każdy z pojazdów "próbuje wjechać" na parking, czyli klasa parkingu sprawdza czy jeszcze są wolne miejsce, a jeżeli są to pojzad wjeżdza na parking

W każdym języku będzie to wyglądało inaczej, ale warto zwrócić uwagę na większe różnice:
* Python w ogóle nie ma struktur podobnych do interfejsów, natomiast podobną funkcję spełnia w nim wielokrotne dziedziczenie; można to zabezpieczyć rzucaniem wyjątków, ale pewnie nie każdy programista Pythona byłby z takiego rozwiązania zadowolony
* pobieranie daty z systemu wygląda inaczej w każdym języku, ale koniec końców wynik powinno dać się zapisać jako string

### Zadanie do wykonania
Należy rozszerzyć program o następujące funkcjonalności:
* utworzyć klasę reprezentującą przechodnia; ludzie będą mogli mieć imię i nazwisko lub być anonimowi;
* przypisać samochodom numery rejestracyjne, marki pojazdów oraz nieobligatoryjny kolor;
* utworzyć klasy reprezentujące: samochód nauczycielski (nazwisko nauczyciela, numer rejestracyjny, marka i kolor), karetkę (numery rejestracyjne), hulajnogę elektryczną, czołg; tutaj warto zastanowić się, co powinno dziedziczyć po czym;
* parkingowy powinien wpuszczać tylko te samochody, których nie ma na czarnej liście;
* parkingowy powinien liczyć limity miejsc i nie wpuszczać więcej samochodów i rowerów niż może;
* należy zastąpić obecną listę czterech pojazdów generatorem losowego ciągu pojazdów i przechodniów

Wynik na wyjściu powinien wyglądać następująco:
```
anonymous pedestrian is entering at 2023-10-21 12:00:00
anonymous bike is entering at 2023-10-21 12:00:00
black Audi (DLX00001) is entering at 2023-10-21 12:00:00
anonymous pedestrian is entering at 2023-10-21 12:00:00
anonymous scooter is entering at 2023-10-21 12:00:00
Volkswagen Passat (DLX00002) is entering at 2023-10-21 12:00:00
yellow Chevrolet Camaro (DLX00003) is entering at 2023-10-21 12:00:00
anonymous pedestrian is entering at 2023-10-21 12:00:00
John Doe is entering at 2023-10-21 12:00:00
Jane Doe (red Audi A3, DLX00004) is entering at 2023-10-21 12:00:00
anonymous pedestrian is entering at 2023-10-21 12:00:00
tank is returned at 2023-10-21 12:00:00
ambulance (DLX00005) is entering at 2023-10-21 12:00:00
Octavia (DLX00006) is entering at 2023-10-21 12:00:00
```

Nad czym warto się zastanowić?
* człowiek już nie jest raczej pojazdem, więc warto byłoby zmienić nazwę interfejsu `ParkingVehicle` na coś bliższego rzeczywistości;
* limity miejsc na parkingach dla samochodów i rowerów oraz czarna lista tablic rejestracyjnych brzmią jak fajne argumenty konstruktora parkingu;
* zakaz wjazdu można zrealizować na kilka sposobów, ale dodatkowy interfejs `NotAllowed` brzmi rozsądnie;
* podobnie rzecz się ma z tablicami rejestracyjnymi; teoretycznie wszystko dziedzczące po klasie `Car` będzie je miało, więc można byłoby to wykorzystać, ale na przykład w Finlandii hulajnogi muszą mieć swoje małe blachy i tam to podejście mogłoby już nie zadziałać.

Wykonane zadanie należy dodać do swojego repozytorium w katalogu `lab06`.

### Uruchamianie zadań
Wszystkie narzędzia są skonteneryzowane i gotowe do użycia bezpośrednio poprzez Dockera. Chętni studenci mogą oczywiście uruchamiać zadania w środowiskach lokalnych.

#### Java
```
docker compose run java javac ./exercises/lab06/java/Main.java  ./exercises/lab06/java/lab06/*.java ./exercises/lab06/java/lab06/**/*.java
docker compose run java java -cp ./exercises/lab06/java Main
```

#### PHP
```
docker compose run php composer install --working-dir=./exercises/lab06/php
docker compose run php php ./exercises/lab06/php/index.php
```

#### Python
```
docker compose run python python ./exercises/lab06/python/main.py
```
