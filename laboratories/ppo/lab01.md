## Wprowadzenie do pracowni programowania obiektowego

### Agenda
Przewidywany plan zajęć kształtuje się następująco:
* przedstawienie zasad zaliczenia przedmiotu,
* przedstawienie planu tematów i zajęć na cały semestr,
* przedstawienie sugerowanej literatury przedmiotu,
* wprowadzenie do systemu kontroli wersji Git oraz środowiska Github.

### Zasady zaliczenia przedmiotu
Zajęcia i obecność:
* w trakcie semestru zostanie zrealizowanych 15 zajęć laboratoryjnych,
* obecność na nich jest obowiązkowa,
* prowadzący akceptuje dwie nieusprawiedliwione nieobecności,
* prowadzący nagradza lub karze studentów za ich aktywność na zajęciach "plusami".

Listy zadań:
* laboratoria 1-10 to dziesięć tematów, z którego każdy kończy się listą zadań,
* każde zadanie musi zostać wykonane indywidualnie oraz przesłane na wskazane repozytorium,
* listy 4., 7. oraz 10. będą oceniane jako podsumowania modułów.

Projekt:
* projekt zespołowy kończy semestr,
* praca musi być wykonana w dwu- lub trzyosobowych grupach.

Ocena końcowa:
* ocena końcowa wyliczana jest na podstawie wzoru:
```math
k_\Omega = \frac{k_{L4} + k_{L7} + k_{L10} + 2 \times k_P}{5} + p \times 0.025 - n \times 0.1
```
* gdzie $k_n$ to oceny z modułów, $k_P$ to ocena z projektu, $p$ to liczba otrzymanych plusów, a $n$ to liczba nienadesłanych list zadań;
* poprawione oceny niedostateczne również wliczają się do oceny końcowej; wówczas suma ocen dzielona jest przez liczbę ocen;
* aby zaliczyć kurs, przynajmniej połowa ocena musi być pozytywna.

### Przegląd tematów w semestrze
1. Wprowadzenie do pracowni programowania obiektowego
1. Klasy i obiekty
1. Hermetyzacja
1. Konstruktory
1. Dziedziczenie
1. Interfejsy
1. Klasy abstrakcyjne
1. Funkcje anonimowe
1. Wyjątki
1. Refleksje
1. Praktyczne wykorzystanie programowania obiektowego, cz. I
1. Praktyczne wykorzystanie programowania obiektowego, cz. II
1. Praktyczne wykorzystanie programowania obiektowego, cz. III
1. Praktyczne wykorzystanie programowania obiektowego, cz. IV
1. Podsumowanie semestru

### Literatura
* Jerzy Grębosz, *Symfonia C++ Standard*, Wydawnictwo Edition 2000, 2008
* Robert C. Martin, *Czysty kod. Podręcznik dobrego programisty*, Wydawnictwo Helion, 2010 

### System kontroli wersji
Należy utworzyć konto użytkownika na platformie [Github](http://github.com/) pod adresem studenckim. Jeżeli student już posiada konto, w ustawieniach profilu można dodać drugi adres. Prowadzący doda studentów do [organizacji uczelnianej](https://github.com/collegiumwitelona), przez którą będzie się odbywała realizacja zajęć i oddawanie list.

Należy sprawdzić czy Git jest zainstalowany w systemie: najlepiej uruchomić wybraną konsolę i wpisać:
```bash
git --version
```

Jeżeli nie jest zainstalowany, należy go zainstalować. Dla użytkowników Windowsa wygodny będzie pakiet Laragon, który również przyda się na następnych zajęciach [dostępny tutaj](https://laragon.org/download/).

#### Inicjalizacja katalogu repozytorium:
Należy utworzyć katalog repozytorium:
```bash
cd /
mkdir ppo
cd ppo
mkdir 123456
cd 123456
```

Kolejne polecenia oznaczają:
```
przejdź do głównego katalogu
utwórz katalog o nazwie ppo
przejdź do katalogu o nazwie ppo
utwórz katalog o nazwie 123456 (tutaj dobrze wpisać swój numer indeksu)
przejdź do katalogu o nazwie 123456 (ponownie: indeks)
```

#### Inicjalizacja repozytorium:
Znając adres repozytorium (np. https://github.com/collegiumwitelona/2023-ppo1-twojanazwauzytkownika) należy wykonać następujące polecenia:

```bash
git init
git remote add origin https://github.com/collegiumwitelona/2023-ppo1-twojanazwauzytkownika
git pull origin master
git status
```

Kolejne polecenia oznaczają:
```
oznacz folder jako repozytorium git
ustaw połączenie z serwerem
ściąga dane z serwera
pokazuje stan repozytorium
```

#### Wprowadzanie zmian do repozytorium
Prawdopodobnie przy pierwszych zmianach będzie trzeba dodać poświadczenia uwierzytelniające:
```
git config user.name "Imię Nazwisko"
git config user.email "imie.nazwisko@student.collegiumwitelona.pl"
```

Warto podać swoje prawdziwe dane, aby Github później przyjął żądanie. Po jakiejkolwiek zmianie, dodaniu lub usunięciu pliku, należy zapisać swoje zmiany:
```bash
git add .
git status
git commit -am "zmiany"
git push origin master
```

Kolejne polecenia oznaczają:
```
dodaje wszystkich niedodanych plików z katalogu "." do repozytorium
pokazuje stan repozytorium
tworzy commit o nazwie "zmiany"
przesyła commity na serwer
```

W momencie, gdy zostaniemy poproszeni o login oraz hasło, poprzez hasło Github rozumie token, który należy sobie wygenerować.
Aby wygenerować taki token, należy, będąc zalogowanym, przejść na adres:
https://github.com/settings/tokens

Następnie należy wybrać `Generate new token (classic)`, wypełnić niezbędne pola i wygenerowany token zapisać w bezpiecznym miejscu i korzystać z niego podczas komunikacji z Githubem.

Z poziomu narzędzi takich jak produkty JetBrains, SourceTree, GitHub Desktop czy GitKraken te same polecenia można wykonać przez graficzny interfejs użytkownika. 

### Zadanie do wykonania
W repozytorium proszę dodać:
* plik `readme.md` z podanym numerem indeksu, adresem mejlowym oraz imieniem i nazwiskiem studenta;
* katalog o nazwie `lab01` z plikiem `lab01.md`; plik powinien zawierać listę komend potrzebnych do zainicjowania repozytorium, pobrania zmian z serwera oraz wgrania nowych zmian.
