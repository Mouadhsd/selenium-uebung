package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeeresFormularTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");

        // Nichts eingeben, direkt auf Login klicken
        driver.findElement(By.className("radius")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

        String meldung = driver.findElement(By.id("flash")).getText();
        System.out.println("Meldung: " + meldung);

        // Bei leerem Formular erwarten wir ebenfalls eine Fehlermeldung zum Usernamen
        if (meldung.contains("Your username is invalid")) {
            System.out.println("TEST BESTANDEN: Fehlermeldung bei leerem Formular korrekt.");
        } else {
            System.out.println("TEST FEHLGESCHLAGEN: Erwartete Fehlermeldung fehlt.");
        }

        driver.quit();
    }
}