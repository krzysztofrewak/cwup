## Projektowanie i programowanie systemów internetowych I
### Zasady zaliczenia zajęć projektowych

#### Warunki zaliczenia

Zaliczenie zajęć projektowych kursu **Projektowanie i programowanie systemów internetowych I** odbywa się poprzez opracowanie projektu programistycznego i sprawozdania oraz prezentację pracy projektowej. Ocena końcowa $\Omega$ będzie wyliczana w następujący sposób:

$$ \Omega = 0.8k_1 + 0.1k_2 + 0.1k_3 $$

gdzie kolejne $k_n$ powinny być rozumiane następująco:

- $k_1$ - ocena za pracę projektową;
- $k_2$ - ocena za sprawozdanie z pracy projektowej;
- $k_3$ - ocena za prezentację pracy projektowej.

Oceniany jest zespół oddający pracę, zatem wszyscy członkowie zespołu otrzymują identyczną ocenę końcową. Należy to rozumieć dwojako:
- jeżeli tylko jedna osoba w zespole potrafi odpowiedzieć na pytanie prowadzącego zajęcia, zespół zostaje oceniony pozytywnie;
- jeżeli żadna osoba w zespole nie potrafi odpowiedzieć na pytanie prowadzącego zajęcia, zespół zostaje oceniony negatywnie.

Oddanie pracy projektowej wymaga obecności całego zespołu, a warunkiem koniecznym jest $k_n > 2.0$.

#### Praca projektowa

Należy zaprojektować, zaimplementować i wdrożyć system internetowy wedle własnego pomysłu lub na podstawie wybranego spośród proponowanych tematów. Warunki zaliczenia kształtują się następująco:
- projekt jest wykonywany w trójkach:
    - w przypadku niedobrania trójki, trójkę wyznacza prowadzący zajęcia, a grupa otrzyma modyfikator $-0.5$ do oceny końcowej za projekt za brak umiejętności pracy zespołowej;
    - w przypadku nieodpowiedniej liczby studentów, prowadzący może utworzyć zespół czteroosobowy;
- unikalny temat projektu musi zostać zatwierdzony przez prowadzącego zajęcia najpóźniej do trzeciego tygodnia semestru; w przeciwnym razie grupa otrzymuje:
    - wybrany przez prowadzącego temat bez możliwości zmiany tematu;
    - modyfikator $-0.5$ do oceny końcowej za projekt za niedotrzymanie terminu;
- podział prac w zespole powinien zostać zdefiniowany na początku pracy i zgłoszony wraz z tematem projektu i przewidywanym stosem technologicznym;
- link do publicznego repozytorium lub repozytoriów projektu musi zostać przesłany prowadzącemu zajęcia najpóźniej do czwartego tygodnia semestru; w przeciwnym razie grupa otrzyma modyfikator $-0.5$ do oceny końcowej za projekt; 
- projekt może być wykonany w dowolnym języku lub językach programowania, z wykorzystaniem dowolnych bibliotek, komponentów lub wtyczek;

Praca projektowa musi zawierać przynajmniej $n$ zaliczonych zagadnień kwalifikacyjnych. Ocena $k_1$ zostanie wystawiona na podstawie przedstawionego projektu, ale nie będzie wyższa niż $f(n)$ wedle tabeli poniżej:

| $n$           | $f(n)$ |
|---------------|--------|
| 18 lub więcej | 5.0    |
| 16-17         | 4.5    |
| 14-15         | 4.0    |
| 13-14         | 3.5    |
| 11-12         | 3.0    |
| 10 lub mniej  | 2.0    |

Lista zagadnień kwalifikacyjnych kształtuje się następująco:

| #  | Zagadnienie               | Opis                                                     | Wykład |
|----|---------------------------|----------------------------------------------------------|--------|
| 1  | framework MVC             | wykorzystanie frameworka na backendzie                   | VI     |
| 2  | framework CSS             | wykorzystanie frameworka na frontendzie                  | II     |
| 3  | baza danych               | dołączenie do projektu bazy danych                       | VIII   |
| 4  | cache                     | dołączenie do projektu systemu cache                     | XIII   |
| 5  | _dependency manager_      | dołączenie do projektu systemu zarządzania zależnościami | III    |
| 6  | HTML                      | szkielet aplikacji internetowej                          | II     |
| 7  | CSS                       | ostylowanie aplikacji internetowej                       | II     |
| 8  | JavaScript                | uinteraktywnienie aplikacji internetowej                 | XI     |
| 9  | routing                   | wykorzystany routing i tzw. _pretty URLs_                | V      |
| 10 | ORM                       | wykorzystane mapowanie obiektowo-relacyjne               | IX     |
| 11 | uwierzytelnianie          | zaimplementowane mechanizmy uwierzytelnienia             | X      |
| 12 | lokalizacja               | możliwość przełączania języka aplikacji                  | XV     |
| 13 | mailing                   | wysyłanie mejli z aplikacji                              | XVII   |
| 14 | formularze                | przesyłanie danych do aplikacji przez formularze         | II     |
| 15 | asynchroniczne interakcje | zaimplementowane asynchroniczne interkacje z serwerem    | XI     |
| 16 | konsumpcja API            | wykorzystanie zewnętrznego API                           | XIII   |
| 17 | publikacja API            | wystawienie własnego API                                 | XI     |
| 18 | RWD                       | responsywny frontend                                     | XII    |
| 19 | logger                    | logowanie akcji w systemie                               | XV     |
| 20 | deployment                | wdrożenie aplikacji internetowej                         | IV     |

Za zaliczone zagadnienie uznaje się takie, za które grupa otrzymała ocenę przynajmniej dostateczną.

#### Sprawozdanie
Należy opracować sprawozdanie z pracy projektowej. Warunki zaliczenia kształtują się następująco:
- zgodnie z ogólnoprzyjętymi standardami naukowymi, sprawozdanie jest skonstruowane w technologii $\LaTeX$ i oddane w formacie PDF;
- sprawozdanie jest dostarczone najpóźniej w dniu oddania całego projektu w formie elektronicznej (najlepiej dodane do repozytorium);
- sprawozdanie zawiera jako rozdziały lub sekcje:
    - opis funkcjonalny systemu
    - opis technologiczny
    - wyszczególnione wdrożone zagadnienia kwalifikacyjne
    - instrukcję lokalnego i zdalnego uruchomienia systemu
    - wnioski projektowe

#### Prezentacja pracy projektowej
Należy przestawić całym zespołem efekty swojej pracy. Prezentacja musi odbyć się w formie przedstawienia działającej aplikacji.

#### Przykładowe tematy prac projektowych
- system z ogłoszeniami, gdzie każdy może wystawiać i odpowiadać na ogłoszenia z ujęciem kategorii i lokalizacji
- sklep internetowy, gdzie można kupować przedmioty lub usługi online
- kalendarz urodzin z przypomnieniami, gdzie każdy użytkownik może tworzyć własny katalog znajomych
- portal informacyjny, gdzie chętni użytkownicy mogą subskrybować wybrane kategorie niusów lub tagi
- forum internetowe, gdzie użytkownicy wymieniają się postami, a moderacja panuje nad porządkiem i kulturą
- e-dziennik, gdzie nauczyciel może wpisywać studentom oceny
- platforma, na której można planować wycieczki poprzez zaznaczanie ciekawych miejsc na mapie
- klony lub adaptacje popularnych systemów internetowych:
    - Strava
    - Instagram
    - Tinder i pochodne
    - lubimyczytac.pl lub Goodreads

#### Terminarz (semestr letni 2023/24)
- 1. tydzień (17 lutego) - zajęcia wprowadzające
- 3. tydzień (9 marca) - termin deklaracji zespołów i tematów
- 4. tydzień (16 marca) - ostateczny termin dostarczenia adresu repozytorium
- 8. tydzień (13 kwietnia) - połowa semestru
- 17. tydzień (15 czerwca) - koniec semestru
