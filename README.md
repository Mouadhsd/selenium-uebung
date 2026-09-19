# Selenium-Übung: Automatisierte UI-Tests mit Java

Ein kleines Übungsprojekt zur Testautomatisierung, entstanden im Rahmen meiner Vorbereitung
auf eine Werkstudentenstelle im Bereich Softwareentwicklung/Testautomatisierung.

## Über das Projekt

Dieses Projekt enthält drei automatisierte Testfälle, die den Login-Prozess einer Beispiel-Webanwendung
([the-internet.herokuapp.com](https://the-internet.herokuapp.com/login)) prüfen:

1. **Erfolgreicher Login** – prüft, dass gültige Zugangsdaten zur richtigen Erfolgsmeldung führen
2. **Fehlgeschlagener Login** – prüft, dass ein falsches Passwort korrekt abgelehnt wird
3. **Leeres Formular** – prüft, dass beim Abschicken ohne Eingaben eine passende Fehlermeldung erscheint

Jeder Test öffnet automatisch einen Chrome-Browser, führt die entsprechende Aktion aus und
überprüft (assert), ob das tatsächliche Ergebnis mit dem erwarteten Ergebnis übereinstimmt.

## Verwendete Technologien

- **Java** (Version 23)
- **Selenium WebDriver 4.24.0** – Browser-Automatisierung
- **WebDriverManager 5.9.2** – automatische Verwaltung des ChromeDrivers
- **Maven** – Dependency-Management und Build-Tool
- **Eclipse** als Entwicklungsumgebung

## Was ich dabei gelernt habe

- Grundlagen von Selenium: Elemente finden (`By.id`, `By.name`, `By.className`), Aktionen ausführen (`sendKeys`, `click`)
- Umgang mit **Explicit Waits** (`WebDriverWait`, `ExpectedConditions`) statt unzuverlässiger fester Wartezeiten
- Positive und negative Testfälle sauber unterscheiden
- Maven-Projektstruktur und Dependency-Verwaltung über `pom.xml`

## Projektstruktur

src/main/java/tests/
├── ErsterTest.java → Erfolgreicher Login
├── LoginFehlerTest.java → Login mit falschem Passwort
└── LeeresFormularTest.java → Login-Versuch mit leerem Formular


## Ausführen

Jede Testklasse kann einzeln über Eclipse (Rechtsklick → Run As → Java Application) ausgeführt werden.
