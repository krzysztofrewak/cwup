## Zaawansowane metody programowania
### Zasady zaliczenia zajęć laboratoryjnych

#### Warunki zaliczenia
Zaliczenie zajęć laboratoryjnych kursu **Zaawansowane metody programowania** odbywa się poprzez opracowanie projektu programistycznego i sprawozdania oraz prezentację pracy projektowej. Ocena końcowa $\Omega$ będzie wyliczana jako średnia ważona następujących ocen:

| **ocena** | **opis**                    | **typ**      | **waga** |
|-----------|-----------------------------|--------------|----------|
| $p_4$     | postęp w 4. tygodniu zajęć  | indywidualna | 1        |
| $p_8$     | postęp w 8. tygodniu zajęć  | indywidualna | 1        |
| $p_{12}$  | postęp w 12. tygodniu zajęć | indywidualna | 1        |
| $s_s$     | zgodność ze specyfikacją*   | indywidualna | 5        |
| $s_c$     | czysty kod                  | indywidualna | 5        |
| $s_p$     | wzorce projektowe           | indywidualna | 5        |
| $s_t$     | testy                       | indywidualna | 3        |
| $s_d$     | wdrożenie                   | indywidualna | 3        |
| $t_s$     | ocena systemu*              | zespołowa    | 4        |
| $t_t$     | praca zespołowa             | zespołowa    | 2        |
| $t_r$     | sprawozdanie*               | zespołowa    | 1        |
| $t_p$     | prezentacja projektu*       | zespołowa    | 1        |

Oddanie pracy projektowej wymaga obecności całego zespołu. Wszystkie oceny oznaczone gwiazdką muszą spełniać warunek $e > 2.0$.

#### Praca projektowa
Należy zaprojektować, zaimplementować i wdrożyć system informatyczny. Warunki zaliczenia kształtują się następująco:
- projekt jest wykonywany w trójkach lub czwórkach:
  - w przypadku niedobrania grupy, grupę wyznacza prowadzący zajęcia; w takim przypadku każdy niedobrany członek grupy otrzyma modyfikator $-0.5$ do oceny końcowej za projekt;
- unikalny temat projektu musi zostać zatwierdzony przez prowadzącego zajęcia najpóźniej do końca drugiego tygodnia semestru; w przeciwnym razie grupa otrzymuje:
  - wybrany przez prowadzącego temat bez możliwości zmiany tematu;
  - modyfikator $-0.5$ do oceny końcowej za projekt za niedotrzymanie terminu;
- link do publicznego repozytorium lub repozytoriów projektu, temat projektu, **pełna specyfikacja**, podział prac w zespole oraz wypis stosu technologicznego powinny zostać zdefiniowane na początku pracy i być zgłoszone prowadzącemu zajęcia najpóźniej do końca trzeciego tygodnia semestru; w przeciwnym razie każdy członek grupy otrzyma modyfikator $-0.5$ do oceny końcowej za projekt; 
- projekt może być wykonany w przedstawionym przez prowadzącego języku lub językach programowania, z wykorzystaniem dowolnych bibliotek, komponentów lub wtyczek.

#### Części systemu
Każdy system musi składać się z:
- natywnej aplikacji mobilnej (Java, Kotlin, Swift, Dart, C#),
- aplikacji desktopowej (C#, C++, Python, Java),
- aplikacji webowej (TypeScript + React, Angular, Vue.js),
- API obsługującego wszystkie aplikacje (PHP, C#, Python, TypeScript, Java, Go, Ruby).

Zalecany jest dobór różnych technologii w różnych częściach systemu. Tzn. w przypadku javowego API aplikacja mobilna powinna powstać w innym języku.

W czteroosobowym zespole każdy student jest odpowiedzialny za swoją część systemu i tylko za nią otrzyma ocenę. W trzyosobowym zespole każdy student jest odpowiedzialny za własną część kliencką (mobilną, desktopową, webową), a API musi powstać jako wspólna praca, która nie zostanie oceniona.

Specyfikacja systemu powinna zawierać wszystkie funkcjonalności z uwzględnieniem wszystkich części systemu. Projektowo należy ją rozumieć jako dokument opisujący przedmiot zamówienia. Grupa będzie oceniana z realizacji jej poszczególnych punktów. Przykładowa specyfikacja znajduje się [tutaj](./zmp/spec.md). W przypadku zbyt skąpej specyfikacji, prowadzący może prosić o jej rozszerzenie.

Nie każda część systemu musi realizować te same funkcjonalności. Na przykład:
- web i mobile mogą mieć podobny zestaw funkcjonalny, a desktop może służyć jako panel administracyjny;
- web, mobile i desktop mogą być podobne, a panel może się znajdować jako część API;
- każda jest osobną aplikację obsługującą większy proces.

Przykładowe tematy znajdują się [tutaj](./zmp/systems.md).

##### Aplikacje klienckie
Każda aplikacja kliencka powinna realizować następujące funkcjonalności:
- połączenie z centralnym API
- powiadomienia w czasie rzeczywistym
- obsługa braku internetu (desktop, mobile)
- responsywność (web)
- ujednolicony design

##### API
API powinno realizować następujące funkcjonalności:
- implementacja architektury REST lub GraphQL
- dostępna dokumentacja wszystkich endpointów

#### Sprawozdanie
Należy opracować sprawozdanie z pracy projektowej. Warunki zaliczenia kształtują się następująco:
- zgodnie z ogólnoprzyjętymi standardami naukowymi, sprawozdanie jest skonstruowane w technologii $\LaTeX$ i oddane w formacie PDF;
- sprawozdanie jest dostarczone najpóźniej w dniu oddania całego projektu w formie elektronicznej (najlepiej dodane do repozytorium oraz wgrane w Classroomie);
- sprawozdanie zawiera jako rozdziały lub sekcje:
    - opis funkcjonalny systemu
    - opis technologiczny
    - podział obowiązków i odpowiedzialności w zespole
    - instrukcję lokalnego i zdalnego uruchomienia systemu
    - wnioski projektowe od każdego z członków zespołu

#### Prezentacja pracy projektowej
Należy przestawić całym zespołem efekty swojej pracy. Prezentacja musi odbyć się w formie przedstawienia działającego i wdrożonego systemu.
