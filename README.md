# tele-md

**tele-md** is a Health Care Informatics (Informatyka w Medycynie) end-of-term assignment.

## About

### 1. Temat projektu i autorzy

Prosty system telekonsultacyjny (2-3 osoby)
* czat oraz grupowe przeglądanie zdjęć
* komunikacja tekstowa i głosowa (głosowa dla 3 osób)
* prosta manipulacja zdjęciami (zaznaczanie, obracanie, zmiana rozmiaru)
* archiwum sesji - możliwość odtworzenia przebiegu

#### Autorzy

Jakub K. i Hubert S.

### 2. Opis projektu

Prosty system umożliwiający konsultację przypadku przez kilku lekarzy. Pozwala na udostępnianie zdjęć, wspólne ich przeglądanie, zaznaczanie elementów zdjęcia oraz czat tekstowy. System zapamiętuje historię sesji konsultacyjnej.

#### Przykładowy scenariusz

Lekarz 1 uruchamia aplikację, loguje się do systemu, a następnie zakłada nową sesję konsultacji, po czym udostępnia zdjęcie tomograficzne pacjenta.

W czacie tekstowym opisuje przypadek oraz zaprasza innych lekarzy do sesji.

Lekarz 2 wchodzi do sesji utworzonej przez Lekarza 1, zaznacza część zdjęcia oraz umieszcza swoją diagnozę w czacie tekstowym.

#### Zakładana funkcjonalność, zrealizowana w ramach projektu

* rejestracja oraz logowanie się do systemu
* tworzenie sesji
* umieszczanie zdjęć
* zaznaczanie elementów zdjęcia
* czat tekstowy
* historia sesji

#### Możliwe rozszerzenia systemu

* sesje dostępne publicznie dla wszystkich użytkowników
* czat audio/video z prostym kalendarzem nadchodzących spotkań
* interfejs dostosowany do przeglądarek mobilnych

### Planowana architektura systemu i propozycja rozwiązań algorytmicznych

Aplikacja internetowa z podziałem na:
* monolityczny serwer udostępniający zasoby,
* aplikacja działająca w przeglądarce konsumująca te zasoby.

### Wykorzystywane technologie i narzędzia

#### Backend
* Java 8
* Groovy + Spock
* Tomcat
* Hibernate 5 + JPA
* Spring Boot *(m. in. Spring Data, Spring MVC, Spring Security)*

#### Frontend
* Javascript, Typescript, HTML, CSS
* Bootstrap
* Angular 2

### Harmonogram prac oraz ich podział w ramach zespołu

#### Pierwszy punkt kontrolny
Ten dokument, stworzenie repozytorium i konfiguracja środowiska.

#### Drugi punkt kontrolny
* logowanie się
* tworzenie i historia sesji
* czat tekstowy

#### Podział pracy w ramach zespołów

Hubert - aplikacja frontendowa, interfejs, doprecyzowanie wymagań

Jakub - aplikacja backendowa, strona techniczna wymagań

### Przewidywane trudności i problemy

#### Obsługa zdjęć i grafik - upload, zaznaczanie itp.
20% wymagań zajmuje 80% czasu - to wymaganie należy do tych 20%.

#### Aplikacja przeglądarkowa - małe doświadczenie z Angularem 2
Trudności przejściowe do czasu wypracowania odpowiedniego workflow.

## Credits

#### Active contributors

* cubsoon
* nefrey
