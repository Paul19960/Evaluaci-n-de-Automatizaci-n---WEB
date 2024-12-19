package com.nttdata.stepsdefinitions;

import com.nttdata.page.LoginPage;
import com.nttdata.page.MyStorePage;
import com.nttdata.steps.LoginSteps;
import com.nttdata.steps.MyStoreSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class MyStoreStepsDef {

    private WebDriver driver;

    MyStoreSteps myStoreSteps;

    private MyStoreSteps loginMyStoreSteps(WebDriver driver){
        return new MyStoreSteps(driver);
    }

    @And("da clck en Iniciar Sesion")
    public void daClckEnIniciarSesion() {
        driver.findElement(By.xpath("//div[@class=\"user-info\"]/a")).click();

        WebElement textoBoton;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        textoBoton = driver.findElement(MyStorePage.IniciarSesion);
        wait.until(ExpectedConditions.visibilityOf(textoBoton));

        System.out.println("Texto: " + textoBoton.getText());

        try{
            Thread.sleep(1000);
        }catch (Exception e){

        }
    }

    @Given("que me encuentro en la página de login de qalab")
    public void queMeEncuentroEnLaPaginaDeLoginDeQalab() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/");
        screenShot();

        WebElement textoLogo;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        textoLogo = driver.findElement(MyStorePage.boton);
        wait.until(ExpectedConditions.visibilityOf(textoLogo));

        System.out.println("Texto: " + textoLogo.getText());

        try{
            Thread.sleep(1000);
        }catch (Exception e){

        }
    }

    @When("ingresa su usuario {string} y password {string}")
    public void ingresaSuUsuarioYPassword(String user, String password) {
        myStoreSteps  = new MyStoreSteps(driver);
        myStoreSteps.typeUser(user);
        myStoreSteps.typePassword(password);
        myStoreSteps.login();
        screenShot();

        try{
            Thread.sleep(10000);
        }catch (Exception e){

        }
    }
}
