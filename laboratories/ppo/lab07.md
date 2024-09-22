## Klasy abstrakcyjne

### Agenda
Przewidywany plan zajęć kształtuje się następująco:
* przedstawienie idei klasy abstrakcyjnej,
* przedstawienie idei metod abstrakcyjnych,
* analiza zadania przykładowego,
* indywidualna praca nad listą zadań.

### Klasy abstrakcyjne
Klasa abstrakcyjna jest pewnego rodzaju pomostem pomiędzy klasycznymi klasami a interfejsami. Zgodnie z nazwą opisuje pewnego rodzaju abstrakcję: byt, który coś znaczy, ale nie można go w żaden sposób skonkretyzować. W paradygmacie obiektowym będzie to oznaczało, że nie można utworzyć instancji klasy abstrakcyjnej.

Po co nam klasa, na podstawie której nie można utworzyć żadnego obiektu? Ano, chociażby po to, aby mogła służyć jako ogólny zbiór funkcjonalności, które otrzymają inne klasy poprzez dziedziczenie. Zresztą przykład powie najwięcej:

```
abstract class Vehicle {
    public void run() {
        if(this.checkIfCanRun()) {
            this.proceed()
        }
    }
    
    abstract protected bool checkIfCanRun()
    abstract protected void proceed()
}
```

Mamy tutaj abstrakcyjną klasę `Vehicle`, która dostarczy swoim dzieciom publiczną metodą `run()`, która jest nieco bardziej skomplikowana: sprawdza najpierw metodę `checkIfCanRun()`, a jeżeli ta zwróci `true`, wywoływana jest metoda `proceed()`. W tym przypadku wiemy, że każdy pojazd będzie mógł pojechać w ujednolicony sposób, ale każdy pojazd będzie mógł to zaimplementować po swojemu. I przykładowo: rower będzie miał całkowicie inny sposób jazdy niż samochód:

```
class Bike extends Vehicle {
    protected bool checkIfCanRun() {
        return not this.isLocked
    }
    
    protected void proceed() {
        this.waitForPedaling()
    }
}


class Car extends Vehicle {
    protected bool checkIfCanRun() {
        return this.hasEnoughFuel()
            and this.hasChargedBattery()
            and this.hasKeyTurned() 
    }
    
    protected void proceed() {
        this.activateCircuit()
        this.turnStater()
        this.injectFuel()
        this.ignite()
    }
}
```

Żeby w pełni zobrazować sobie problem, warto zastanowić się nad przykładem drogi publicznej, po której jeżdżą pojazdy. Wiemy, że jeżdżą po niej samochody i rowery oraz wiemy, że mogą one jakoś wywoływać metodę `run()`, ale bardzo łatwo nam rozróżnić jedno od drugiego. Raczej nikt nie mówi: *o, pojazd wymusił mi pierwszeństwo*, a raczej sprecyzujemy dokładniej, że *o, samochód wymusił mi pierwszeństwo*. Nie powiemy też policjantowi, że *pojazd nas potrącił*, a będziemy starali się powiedzieć coś dokładniejszego.

Siłą rzeczy klasy opisane jako `abstract` nie mogą być również opisane jako `final`.

### Metody abstrakcyjne
Metoda abstrakcyjna to nic innego niż kolejny rodzaj kontraktu, coś podobnego do interfejsu. Łatwo ją zidentyfikować poprzez słowo kluczowe `abstract` przed akcesorem oraz brak ciała funkcji, czyli znowu podobnie jak sygnatury metod w interfejsach. 

Największą i zasadniczą różnicą jest to, że metoda abstrakcyjna nie musi być publiczna, ponieważ nie jest publicznym kontraktem. Może być chroniona (`protected`), co może być przydatne, gdy chcemy już zaplanować użycie tej metody w innej metodzie, ale nie chcemy jej enkapsulować. Dokładnie taki scenariusz został przedstawiony powyżej z założeniem, że `run()` wywołuje `checkIfCanRun()` i `proceed()`, ale metod tych faktycznie w klasie `Vehicle` nie ma.

Tutaj ważna rzecz do zapamiętania: jeżeli klasa posiada przynajmniej jedną metodę abstrakcyjną, wówczas sama musi też być oznaczona jako abstrakcyjna. Oczywiście nie wyklucza to sytuacji, w której może istnieć klasa abstrakcyjna bez żadnych metod abstrakcyjnych. Wymuszenie abstrakcji klasy raczej zostanie nam podpowiedziane przez każde sensowne IDE.

### Analiza przykładowego zadania
Zadanie składa się z kilku części: klasy abstrakcyjnej `Vehicle`, klas `Bike` i `Car` dziedziczących po niej oraz głównej części programu, gdzie kolejne obiekty rowerów i samochodów identyfikują się.

Zadanie powinno być zrozumiałe przez wszystkich. Kolejno:
* tworzona jest lista obiektów klasy `Vehicle` czyli `Bike` i `Car`, gdyż samo `Vehicle` jest klasą abstrakcyjną, więc nie można utworzyć jej obiektu per se,
* każdy obiekt z listy przedstawia się metodą `identify()`.

`identify()` jest publiczną metodą klasy `Vehicle`, której nie można rozszerzać, a która wywołuje `getAnonymousIdentifier()` lub `getIdentifier()` w zależności od stanu zmiennej `isAnonymous`. `getAnonymousIdentifier()` jest domyślnie zaimplementowane w klasie `Vehicle` (choć `Car` je nadpisuje), natomiast `getIdentifier()` każda klasa musi zaimplementować sama.

Wynik uruchomienia programu powinien wyglądać następująco:
```
anonymous by car [DL00001]
John Doe by bike
anonymous by bike
Jane Doe by car [DL00002]
anonymous by car [DLU0001]
```

### Zadanie do wykonania
Należy rozszerzyć program o następujące funkcjonalności:
* należy zaprojektować parking, na który mogą wchodzić lub wjeżdżać następujące obiekty:
* * psy
* * piesi anonimowi
* * piesi znani z nazwiska
* * rowerzyści anonimowi
* * rowerzyści znani z nazwiska
* * hulajnogiści anonimowi
* * hulajnogiści znani z nazwiska
* * motocykliści z tablicami rejestracyjnymi
* * motocykliści z tablicami rejestracyjnymi i nazwiskiem kierowcy
* * samochody z tablicami rejestracyjnymi, marką pojazdu i opcjonalnym kolorem
* * samochody z tablicami rejestracyjnymi, nazwiskiem kierowcy, marką pojazdu i opcjonalnym kolorem
* * samochody pracowników z tablicami rejestracyjnymi, nazwiskiem kierowcy, marką pojazdu i opcjonalnym kolorem
* * karetki z tablicami rejestracyjnymi
* * samochody dostawcze z tablicami rejestracyjnymi i nazwą firmy
* * czołgi z tablicami rejestracyjnymi
* program powinien posiadać generator kolejki chętnych do wejścia/wjazdu na parking; jako minimum taki generator musiałby umieć wyprodukować $n$ obiektów; idealnie generowałby $n_k$ obiektów każdego typu z zadanymi proporcjami lub liczbami
* parkingowy nie powinien wpuszczać psów ani czołgów (czyli powinien zawrócić je przed bramą)
* parkingowy nie powinien wpuszczać więcej rowerzystów niż ma wolnych miejsc parkingowych dla rowerów oraz więcej motocyklistów niż ma wolnych miejsc parkingowych dla motocykli
* parkingowy nie powinien wpuszczać więcej samochodów niż ma wolnych miejsc dla samochodów; karetki i dostawczaki nie powinny zajmować żadnych miejsc
* parkingowy powinien pobrać opłatę zgodnie z cennikiem (motocykliści - 2zł, samochody - 5zł, samochody pracowników - 5zł, samochody pracowników z abonamentem - 0zł, karetki - 0zł, dostawczaki - 0zł)
* parkingowy nie powinien wpuszczać żadnych pojazdów z rejestracją, która znajduje się na czarnej liście tablic rejestracyjnych; nie dotyczy to karetek
* parkingowy powinien odnotować wejście każdego zgodnie z szablonem poniżej:

```
anonymous dog is returned at 2023-11-17 12:00:00
anonymous pedestrian is entering at 2023-11-17 12:00:00
John Doe is entering at 2023-11-17 12:00:00
anonymous bike is entering at 2023-11-17 12:00:00
John Doe by bike is entering at 2023-11-17 12:00:00
anonymous escooter is entering at 2023-11-17 12:00:00
John Doe by escooter is entering at 2023-11-17 12:00:00
anonymous motocycle (DL 001) is entering at 2023-11-17 12:00:00
John Doe by motocycle (DL 001) is entering at 2023-11-17 12:00:00
Audi (DL 00001) is entering at 2023-11-17 12:00:00
black Audi (DL 00001) is entering at 2023-11-17 12:00:00
John Doe by Audi (DL 00001) is entering at 2023-11-17 12:00:00
John Doe by black Audi (DL 00001) is entering at 2023-11-17 12:00:00
ambulance (DL 00001) is entering at 2023-11-17 12:00:00
DHL delivery truck (DL 00001) is entering at 2023-11-17 12:00:00
tank is returned at 2023-11-17 12:00:00
blacklisted John Doe by black Audi (DL 00001) is returned at 2023-11-17 12:00:00
```
* na "koniec dnia" parkingowy powinien zebrać informację na temat stanu parkingu, który powinien być zgodny z szablonem poniżej:
```
money collected: 87zł
entrances count: 48

car spaces occupied: 17/20 (85%)
motocycle spaces occupied: 1/10 (10%)
bicycle spaces occupied: 10/10 (100%)

cars returned: 0
motocycles returned: 0
bicycles returned: 3

blacklisted cars entrance attempted: 1
```

Nad czym warto się zastanowić?
* przede wszystkim jak zamodelować wszystkie wchodzące/wjeżdżające obiekty oraz jak sensownie wykorzystać przy tym konstruktory, dziedziczenie, interfejsy i klasy abstrakcyjne
* czy obiekty takie jak czarna lista tablic rejestracyjnych powinny być osobną klasą, czy tylko funkcjonalnością głównej klasy?
* czy zebrana kwota może być po prostu liczą zaparkowanych samochodów razy cenę biletu plus liczbą motocykli raz cenę biletu; a może jednak lepiej zliczać ją obok?
* jak sensownie zamodelować kolejkę wchodzących/wjeżdżających obiektów; czy `queueGenerator.generate(100)` jest wystarczające, a może jednak trzeba to rozszerzyć do `queueGenerator.generate(cars: 10, motocycles: 10)` lub czegoś jeszcze innego? Tutaj warto to mądrze rozegrać, bo taki generator byłby fajną podstawę do testów jednostkowych!

Chętni mogą zaimplementować właśnie automatyzację testowania. Podczas gdy w głównym programie stworzony zostanie po prostu obiekt na podstawie klasy `ParkingLot`, można utworzyć drugą klasę, która będzie przygotowywała gotowe scenariusze (np. na parking o pojemności 10 i bez czarnej listy wjeżdza 12 samochodów) i sprawdzała poprawność operacji (kontynuując przykład: powinniśmy zebrać 50zł, parking samochodów powinien być wypełniony w całości, a dwa samochody powinny zostać cofnięte).

Wykonane zadanie należy dodać do swojego repozytorium w katalogu `lab07`.

### Uruchamianie zadań
Wszystkie narzędzia są skonteneryzowane i gotowe do użycia bezpośrednio poprzez Dockera. Chętni studenci mogą oczywiście uruchamiać zadania w środowiskach lokalnych.

#### Java
```
docker compose run java javac ./exercises/lab07/java/Main.java ./exercises/lab07/java/lab07/**/*.java
docker compose run java java -cp ./exercises/lab07/java Main
```

#### PHP
```
docker compose run php composer install --working-dir=./exercises/lab07/php
docker compose run php php ./exercises/lab07/php/index.php
```

#### Python
```
docker compose run python python ./exercises/lab07/python/main.py
```
