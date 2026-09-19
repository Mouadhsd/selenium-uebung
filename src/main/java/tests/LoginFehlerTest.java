package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFehlerTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");

        // Absichtlich FALSCHES Passwort eingeben
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("falschesPasswort123");
        driver.findElement(By.className("radius")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

        String meldung = driver.findElement(By.id("flash")).getText();
        System.out.println("Meldung: " + meldung);

        // Diesmal erwarten wir eine FEHLERMELDUNG als korrektes Ergebnis
        if (meldung.contains("Your password is invalid")) {
            System.out.println("TEST BESTANDEN: Fehlermeldung wurde korrekt angezeigt.");
        } else {
            System.out.println("TEST FEHLGESCHLAGEN: Erwartete Fehlermeldung fehlt.");
        }

        driver.quit();
    }
}