package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.screenShot;


public class LoginSteps {

    private WebDriver driver;

    //constructor
    public LoginSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Escribir el usuario
     * @param user el usuario
     */
    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(LoginPage.userInput);

        userInputElement.sendKeys(user);
        //espera implícita
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        //espera explícita
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginButton));


    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        this.driver.findElement(LoginPage.passInput).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login(){
        this.driver.findElement(LoginPage.loginButton).click();
    }

    public void validarItems(InventorySteps inventorySteps) {
        int itemsListSize = inventorySteps.getItemSize();
        //prueba: validar que al menos exista un item
        screenShot();
        Assertions.assertTrue(itemsListSize > 0, "El tamaño de la lista es: " + itemsListSize);

        /*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
    }
}
