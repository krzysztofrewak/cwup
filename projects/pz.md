## Projekt zespołowy
### Zasady zaliczenia zajęć projektowych

#### Warunki zaliczenia

Zaliczenie zajęć projektowych kursu **Projekt zespołowy** odbywa się poprzez opracowanie projektu programistycznego i sprawozdania oraz prezentację pracy projektowej. Ocena końcowa $\Omega$ będzie wyliczana w następujący sposób:

$$ \Omega = 0.3k_1 + 0.5k_2 + 0.2k_3 $$

gdzie kolejne $k_n$ powinny być rozumiane następująco:

- $k_1$ - ocena za pracę projektową;
- $k_2$ - ocena za sprawozdanie z pracy projektowej;
- $k_3$ - ocena za prezentację pracy projektowej.

Oddanie pracy projektowej wymaga obecności całego zespołu, a warunkiem koniecznym jest $k_n > 2.0$.

#### Praca projektowa

Należy zaplanować prace, zaprojektować, zaimplementować i wdrożyć system wedle tematu wybranego przez prowadzącego. Warunki zaliczenia kształtują się następująco:
- projekt powiązany jest merytorycznie z zajęciami **Programowanie urządzeń mobilnych**, gdzie studenci muszą opracować aplikację mobilną; w ramach tego projektu, zbudowane mają zostać API oraz webowy panel administracyjny do zarządzania danymi dla aplikacji mobilnej;
- projekt jest wykonywany w tych samych grupach, co na zajęciach **Programowanie urządzeń mobilnych**;
- skład grup oraz link do publicznego repozytorium lub repozytoriów projektu powinny zostać zdefiniowane na początku semestru i być zgłoszone prowadzącemu zajęcia najpóźniej do drugich zajęć projektowych; w razie niedotrzymania terminu, grupa otrzyma modyfikator $-0.5$ do oceny końcowej za projekt;
- lista zadań rozpisanych na platformie GitHub Issues powinna być ukończona przed czwartymi zajęciami; powinna ona zawierać opisane szczegółówo wszystkie wymagania funkcjonalne oraz mieć przypisane osoby, które będą nad nimi pracować; w razie niedotrzymania terminu, grupa otrzyma modyfikator $-0.5$ do oceny końcowej za projekt;
- zadania powinny być wykonywane w metodzie GitHub flow, a więc:
  - zmiany na głównym branchu powinny odbywać się tylko poprzez pull requesty;
  - każdy pull request powinien otrzymać code review od pozostałych członków zespołu;
  - dopiero po code review (i przejściu testów i linterów na CI) pull request może być dołączony do głównego brancha (należy stosować squashowanie commitów i podpisywanie PR-ów numerami zadań z Issues); w razie niestosowania Github flow, grupa otrzyma modyfikator $-0.5$ do oceny końcowej za projekt;
- część projektowa może być wykonany w dowolnym języku lub językach programowania, z wykorzystaniem dowolnych bibliotek, komponentów lub wtyczek. 

#### Sprawozdanie
Należy opracować sprawozdanie z pracy projektowej. Warunki zaliczenia kształtują się następująco:
- zgodnie z ogólnoprzyjętymi standardami naukowymi, część opisowa sprawozdania jest skonstruowane w technologii $\LaTeX$ i oddane w formacie PDF;
- sprawozdanie jest dostarczone najpóźniej w dniu oddania całego projektu w formie elektronicznej (najlepiej dodane do repozytorium);
- sprawozdanie zawiera jako rozdziały lub sekcje:
    - opis przedmiotu zamówienia dostarczony przez prowadzącego
    - opis technologiczny zaproponowanego rozwiązania
    - podział obowiązków i odpowiedzialności w zespole
    - rozpisane przez zespół zadania wraz z przedstawioną czasochłonnością
    - instrukcję lokalnego i zdalnego uruchomienia systemu
- ponadto projekt jest wyposażony w dokumentację OpenAPI dołączoną do wyhostowanej aplikacji.

#### Prezentacja pracy projektowej
Należy przestawić całym zespołem efekty swojej pracy. Prezentacja musi odbyć się w formie przedstawienia działającej i wdrożonej aplikacji.
