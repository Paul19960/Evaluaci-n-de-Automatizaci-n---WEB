package com.nttdata.stepsdefinitions;

import com.nttdata.page.ProdPage;
import com.nttdata.steps.CarroSteps;
import com.nttdata.steps.ProdSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class ProdStepsDef {
    private WebDriver driver;

    ProdSteps prodSteps;

    private ProdSteps loginMyStoreSteps(WebDriver driver){
        return new ProdSteps(driver);
    }

    private  CarroSteps carroSteps(WebDriver driver) {
        return new CarroSteps(driver);
    }

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");
        screenShot();

        WebElement textoLogo;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        textoLogo = driver.findElement(ProdPage.boton);
        wait.until(ExpectedConditions.visibilityOf(textoLogo));

        System.out.println("Texto: " + textoLogo.getText());

        try{
            Thread.sleep(1000);
        }catch (Exception e){

        }

        driver.findElement(ProdPage.IniciarSesion).click();

        WebElement textoBoton;

        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));

        textoBoton = driver.findElement(ProdPage.IniciarSesion);
        wait.until(ExpectedConditions.visibilityOf(textoBoton));

        System.out.println("Texto: " + textoBoton.getText());

        try{
            Thread.sleep(1000);
        }catch (Exception e){

        }
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String user, String password) {
        prodSteps  = new ProdSteps(driver);
        prodSteps.typeUser(user);
        prodSteps.typePassword(password);
        prodSteps.login();
        screenShot();

        try{
            Thread.sleep(1000);
        }catch (Exception e){

        }
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String arg0, String arg1) {
        driver.findElement(ProdPage.botonCategory).click();
        driver.findElement(ProdPage.CategoryMen).click();

        try{
            Thread.sleep(1000);
        }catch (Exception e){

        }
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int arg0) {
        driver.findElement(ProdPage.SelectProd).click();
        driver.findElement(ProdPage.SumCantidad).click();
        driver.findElement(ProdPage.AddCart).click();


        try{
            Thread.sleep(10000);
        }catch (Exception e){

        }
    }


    /*@Then("valido en el popup la confirmación del producto agregado {string}")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado(String title) {
        //prueba: validamos el título del producto
        Assertions.assertEquals("Producto añadido correctamente a su carrito de compra", title);
    }*/

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        driver = getDriver();
        String cartCount = driver.findElement(By.xpath("//div[@class=\"col-md-7\"]/div/p[@class=\"cart-products-count\"]")).getText();
        Assert.assertEquals("Hay 2 artículos en su carrito.", cartCount);
    }
}
