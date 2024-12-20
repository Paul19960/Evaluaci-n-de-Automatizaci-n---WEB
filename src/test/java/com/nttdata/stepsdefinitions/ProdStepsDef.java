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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        prodSteps  = new ProdSteps(driver);
        prodSteps.typeUser(user);
        prodSteps.typePassword(password);
        prodSteps.login();
        screenShot();

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

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        driver = getDriver();
        String cartCount = driver.findElement(ProdPage.ConfirmaProd).getText();
        Assert.assertEquals("Hay 2 artículos en su carrito.", cartCount);
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {

        driver = getDriver();
        String MontoTotalObt = driver.findElement(ProdPage.Total1).getText();
        String MontoTotalEsp = driver.findElement(ProdPage.ExpectedTotal1).getText();
        Assert.assertEquals(MontoTotalEsp, MontoTotalObt);
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        driver.findElement(ProdPage.botonFinaliza).click();
        try{
            Thread.sleep(1000);
        }catch (Exception e){
        }
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {

        String title =  carroSteps(driver).getTitle();
        String expectedTitle =  carroSteps(driver).getTitle();

        Assertions.assertEquals(expectedTitle, title);

    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        driver = getDriver();
        String MontoTotalObt = driver.findElement(ProdPage.Total).getText();
        String MontoTotalEsp = driver.findElement(ProdPage.ExpectedTotal).getText();
        Assert.assertEquals(MontoTotalEsp, MontoTotalObt);
    }
}
