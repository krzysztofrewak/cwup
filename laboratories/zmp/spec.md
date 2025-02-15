# Specyfikacja systemu informatycznego

## Lista części systemu
- REST API napisane w technologiach PHP + Laravel, PostgreSQL, Redis)
- aplikacja webowa napisana w technologiach TypeScript + Vue.js, Tailwind
- aplikacja mobilna napisana w technologiach Dart + Flutter
- aplikacja desktopowa napisana w technologiach C# + .NET

## Lista funkcjonalności
| OPZ    | Funkcjonalność                                                                                                          | API | web | mobile | desktop |
|--------|-------------------------------------------------------------------------------------------------------------------------|-----|-----|--------|---------|
| FLY-01 | Pierwszy administrator jest automatycznie dodany do systemu.                                                            | ✓   |     |        |         |
| FLY-02 | Administrator może zalogować się w systemie.                                                                            | *   |     |        | ✓       |
| FLY-03 | Administrator może dodawać lotniska do bazy danych.                                                                     | *   |     |        | ✓       |
| FLY-04 | Administrator może dodawać linie lotnicze do bazy danych.                                                               | *   |     |        | ✓       |
| FLY-05 | Administrator może dodawać modele samolotów do bazy danych.                                                             | *   |     |        | ✓       |
| FLY-06 | Administrator może dodawać połączenia lotnicze do bazy danych (z lotniskami, datami i godzinami oraz modelem samolotu). | *   |     |        | ✓       |
| FLY-07 | Administrator może wysyłać powiadomienia o opóźnieniach lotów.                                                          | *   |     |        | ✓       |
| FLY-08 | Administrator widzi statystyki systemowe.                                                                               | *   |     |        | ✓       |
| FLY-09 | Gość może oglądać i przeglądać opublikowane profile.                                                                    | *   | ✓   |        |         |
| FLY-10 | Gość może zarejestrować się w systemie.                                                                                 | *   | ✓   | ✓      |         |
| FLY-11 | Gość może zalogować się w systemie.                                                                                     | *   | ✓   | ✓      |         |
| FLY-12 | Gość może zresetować swoje hasło.                                                                                       | *   | ✓   | ✓      |         |
| FLY-13 | Użytkownik może dodawać swoje loty (z klasą, miejscem, powodem podróży).                                                | *   | ✓   | ✓      |         |
| FLY-14 | Użytkownik otrzymuje powiadomienia w przypadku opóźnień swoich lotów.                                                   | *   | ✓   | ✓      |         |
| FLY-15 | Użytkownik widzi podsumowanie swoich lotów z podziałem na lata, klasy, miejsca itp.                                     | *   | ✓   | ✓      |         |
| FLY-16 | Użytkownik widzi mapę swoich lotów.                                                                                     | *   | ✓   | ✓      |         |
| FLY-17 | Użytkownik może opublikować swój profil.                                                                                | *   | ✓   | ✓      | ✓       |
| FLY-18 | Użytkownik może dodawać innych użytkowników do listy znajomych.                                                         | *   | ✓   | ✓      |         |
| FLY-19 | Użytkownik widzi feed z aktywnościami znajomych.                                                                        | *   | ✓   | ✓      |         |
| FLY-20 | Użytkownik może eksportować swoje dane.                                                                                 | *   | ✓   |        |         |
| FLY-21 | Użytkownik może się wylogować.                                                                                          |     | ✓   | ✓      |         |
| FLY-22 | System obsługuje język polski, angielski i niemiecki.                                                                   | *   | ✓   | ✓      | ✓       |
