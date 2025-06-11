## Opis projektu

Projekt to aplikacja desktopowa napisana w języku **Java** z wykorzystaniem biblioteki graficznej **Swing**, której celem jest rozpoznawanie języka na podstawie wprowadzonego tekstu.

Program potrafi wykryć jeden z sześciu języków:
- **polski**
- **angielski**
- **niemiecki**
- **włoski**
- **szwedzki**
- **portugalski**

Do klasyfikacji języka wykorzystywana jest **jednowarstwowa sieć neuronowa**, zbudowana z sześciu niezależnych **perceptronów** — każdy z nich odpowiada za jeden język.

Wejściem do sieci jest wektor opisujący **proporcje występowania wszystkich małych liter alfabetu łacińskiego** (od 'a' do 'z') w analizowanym tekście. Na tej podstawie sieć dokonuje klasyfikacji, wskazując język najbardziej odpowiadający profilowi tekstu.

Aplikacja udostępnia graficzny interfejs użytkownika, w którym można wprowadzić tekst i natychmiast uzyskać wynik rozpoznania języka. Wszystkie mechanizmy sieci neuronowej zostały zaimplementowane ręcznie, bez użycia zewnętrznych bibliotek do uczenia maszynowego.

## Jak uruchomić projekt z konsoli (CMD)

1. Otwórz konsolę (CMD) w katalogu głównym projektu (tam, gdzie znajduje się folder `src`).
2. Przejdź do folderu `src`:

   ```
   cd src
   ```

3. Skompiluj wszystkie pliki `.java`:

   ```
   javac *.java
   ```

4. Uruchom program, podając nazwę klasy z metodą `main`:

   ```
   java Main
   ```

5. Program uruchomi się w nowym oknie jako aplikacja graficzna (Swing).

## Wymagania

- Zainstalowane **Java Development Kit (JDK)**
- Komendy `javac` i `java` dostępne w systemie (sprawdź w CMD: `javac -version`)
- System operacyjny: Windows, Linux lub macOS

## Autor

Jędrzej Nowakowski
