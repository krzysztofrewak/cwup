## Programowanie obiektowe II
### Zasady zaliczenia zajęć laboratoryjnych

#### Warunki zaliczenia
Zaliczenie zajęć laboratoryjnych kursu **Programowanie obiektowe II** odbywa się poprzez opracowanie projektu programistycznego i sprawozdania oraz prezentację pracy projektowej. Ocena końcowa $\Omega$ będzie wyliczana w następujący sposób:

$$ \Omega = 0.6k_1 + 0.1k_2 + 0.3k_3 $$

gdzie kolejne $k_n$ powinny być rozumiane następująco:

- $k_1$ - ocena za pracę projektową;
- $k_2$ - ocena za sprawozdanie z pracy projektowej;
- $k_3$ - ocena za prezentację pracy projektowej.

Oceniany jest zespół oddający pracę, zatem wszyscy członkowie zespołu otrzymują identyczną ocenę końcową. Należy to rozumieć dwojako:
- jeżeli tylko jedna osoba w zespole potrafi odpowiedzieć na pytanie prowadzącego zajęcia, zespół zostaje oceniony pozytywnie;
- jeżeli żadna osoba w zespole nie potrafi odpowiedzieć na pytanie prowadzącego zajęcia, zespół zostaje oceniony negatywnie.

Oddanie pracy projektowej wymaga obecności całego zespołu, a warunkiem koniecznym jest $k_n > 2.0$.

#### Praca projektowa
Należy zaprojektować i zaimplementować system informatyczny. Warunki zaliczenia kształtują się następująco:
- projekt jest wykonywany w parach lub trójkach:
  - w przypadku niedobrania grupy, grupę wyznacza prowadzący zajęcia; w takim przypadku każdy niedobrany członek grupy otrzyma modyfikator $-0.5$ do oceny końcowej za projekt;
- unikalny temat projektu musi zostać **zatwierdzony** przez prowadzącego zajęcia najpóźniej do końca drugiego tygodnia semestru (w semestrze zimowym 2026/27 jest to 11 października 2026); w przeciwnym razie grupa otrzymuje:
  - wybrany przez prowadzącego temat bez możliwości zmiany tematu;
  - modyfikator $-0.5$ do oceny końcowej za projekt za niedotrzymanie terminu;
- link do publicznego repozytorium lub repozytoriów projektu, temat projektu, opis projektu, podział prac w zespole oraz wypis stosu technologicznego powinny zostać zdefiniowane na początku pracy i być zgłoszone prowadzącemu zajęcia najpóźniej do końca trzeciego tygodnia semestru (w semestrze zimowym 2026/27 jest to 18 października 2026); w przeciwnym razie każdy członek grupy otrzyma modyfikator $-0.5$ do oceny końcowej za projekt; 
- projekt może być wykonany w wybranym obiektowym języku lub językach programowania, z wykorzystaniem dowolnych bibliotek, komponentów lub wtyczek.

Praca projektowa musi zawierać przynajmniej $n$ zaliczonych zagadnień kwalifikacyjnych. Ocena $k_1$ zostanie wystawiona na podstawie przedstawionego projektu, ale nie będzie wyższa niż $f(n)$ wedle tabeli poniżej:

| $n$           | $f(n)$ |
|---------------|--------|
| 14            | 5.0    |
| 12-13         | 4.5    |
| 10-11         | 4.0    |
| 9             | 3.5    |
| 7-8           | 3.0    |
| 6 lub mniej   | 2.0    |

Lista zagadnień kwalifikacyjnych kształtuje się następująco:

| #  | Zagadnienie                       | Opis                                                                                                                |
|----|-----------------------------------|---------------------------------------------------------------------------------------------------------------------|
| 1  | hermetyzacja i enkapsulacja       | ukrywanie wewnętrznego stanu obiektów oraz udostępnianie kontrolowanego dostępu do danych i zachowania              |
| 2  | konstruktory                      | inicjalizacja obiektów za pomocą konstruktorów, w tym konstruktorów przyjmujących parametry                         |
| 3  | dziedziczenie pojedyncze          | utworzenie hierarchii klas wykorzystującej dziedziczenie pojedyncze                                                 |
| 4  | dziedziczenie wielokrotne         | wykorzystanie dziedziczenia wielokrotnego                                                                           |
| 5  | interfejsy                        | definiowanie kontraktów klas za pomocą interfejsów, protokołów lub analogicznego mechanizmu                         |
| 6  | klasy i metody abstrakcyjne       | wykorzystanie klas abstrakcyjnych oraz metod wymagających implementacji w klasach potomnych                         |
| 7  | polimorfizm i przesłanianie metod | przesłanianie metod w klasach potomnych oraz obsługa obiektów różnych klas poprzez wspólny typ bazowy lub interfejs |
| 8  | kompozycja i agregacja            | budowanie bardziej złożonych obiektów z wykorzystaniem innych obiektów                                              |
| 9  | funkcje anonimowe                 | wykorzystanie funkcji anonimowych, wyrażeń lambda lub obiektów funkcyjnych                                          |
| 10 | wyjątki                           | zgłaszanie, przechwytywanie i obsługa wyjątków, w tym własnych typów wyjątków                                       |
| 11 | refleksja                         | wykorzystanie mechanizmów pozwalających na analizę typów lub obiektów podczas działania programu                    |
| 12 | przeciążanie operatorów           | zdefiniowanie zachowania wybranych operatorów dla własnych typów danych                                             |
| 13 | elementy statyczne                | wykorzystanie pól, metod lub innych elementów należących do klasy, a nie do konkretnej instancji                    |
| 14 | typy generyczne                   | wykorzystanie klas, interfejsów lub metod generycznych albo szablonów                                               |

Za zaliczone zagadnienie uznaje się takie, za które grupa otrzymała ocenę przynajmniej dostateczną. Każde zagadnienie kwalifikacyjne musi mieć odpowiednie odniesienie w sprawozdaniu, wskazujące miejsce i sposób jego realizacji w projekcie. Jeżeli wykorzystywana technologia lub język programowania nie udostępnia danego mechanizmu, należy explicite wskazać ten fakt w sprawozdaniu oraz go uzasadnić. 

Samo wystąpienie danego mechanizmu w kodzie nie oznacza automatycznie zaliczenia zagadnienia. Mechanizm powinien być zastosowany poprawnie i mieć uzasadnienie w strukturze projektu.

##### Przykładowe tematy projektów
1. System biblioteczny
1. Wypożyczalnia pojazdów
1. System walki do gry RPG
1. System zamówień w restauracji
1. Symulator systemu bankowego
1. System rezerwacji miejsc
1. System inteligentnego domu
1. System obsługi parkingu
1. System obsługi kina
1. System obsługi firmy kurierskiej
1. System zarządzania zoo
1. System turnieju sportowego
1. Symulator gry karcianej
1. System obsługi lotniska
1. System zarządzania ubezpieczeniami
1. System organizacji konferencji
1. System zarządzania schroniskiem dla zwierząt
1. Symulator komunikacji miejskiej
1. System obsługi aukcji
1. System zarządzania drużyną sportową

#### Sprawozdanie
Należy opracować sprawozdanie z pracy projektowej. Warunki zaliczenia kształtują się następująco:
- zgodnie z ogólnoprzyjętymi standardami naukowymi, sprawozdanie jest skonstruowane w technologii $\LaTeX$ i oddane w formacie PDF;
- sprawozdanie jest dostarczone najpóźniej w dniu oddania całego projektu w formie elektronicznej (najlepiej dodane do repozytorium oraz wgrane w Classroomie);
- sprawozdanie zawiera jako rozdziały lub sekcje:
    - opis funkcjonalny systemu
    - opis technologiczny
    - podział obowiązków i odpowiedzialności w zespole
    - opis wszystkich zagadnień kwalifikacyjnych
    - instrukcję lokalnego i zdalnego uruchomienia systemu
    - wnioski projektowe od każdego z członków zespołu

#### Prezentacja pracy projektowej
Należy przestawić całym zespołem efekty swojej pracy. Prezentacja musi odbyć się w formie przedstawienia działającego i wdrożonego systemu.
