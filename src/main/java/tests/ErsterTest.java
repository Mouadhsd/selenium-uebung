package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErsterTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Übungsseite speziell für Selenium mit einem einfachen Login-Formular
        driver.get("https://the-internet.herokuapp.com/login");

        // Gültige Test-Zugangsdaten (offiziell von dieser Übungsseite bereitgestellt)
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click(); // der Login-Button

        // Warten, bis die Erfolgsmeldung erscheint
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

        String meldung = driver.findElement(By.id("flash")).getText();
        System.out.println("Meldung: " + meldung);

        if (meldung.contains("You logged into a secure area")) {
            System.out.println("TEST BESTANDEN: Login war erfolgreich.");
        } else {
            System.out.println("TEST FEHLGESCHLAGEN: Login-Meldung stimmt nicht.");
        }

        driver.quit();
    }
}