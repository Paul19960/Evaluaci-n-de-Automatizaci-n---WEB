package com.nttdata.steps;

import com.nttdata.page.MyStorePage;
import com.nttdata.page.ProdPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.screenShot;


public class ProdSteps {

    private WebDriver driver;

    //constructor
    public ProdSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Escribir el usuario
     * @param user el usuario
     */
    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(ProdPage.userInput);

        userInputElement.sendKeys(user);
        //espera implícita
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        //espera explícita
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProdPage.loginButton));


    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        this.driver.findElement(ProdPage.passInput).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login(){
        this.driver.findElement(ProdPage.loginButton).click();
    }


}
