package com.nttdata.stepsdefinitions;

import com.nttdata.page.MyStorePage;
import com.nttdata.page.ProdPage;
import com.nttdata.steps.CarroSteps;
import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.MyStoreSteps;
import com.nttdata.steps.ProdSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

        driver.findElement(By.xpath("//div[@class=\"user-info\"]/a")).click();

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
        driver.findElement(By.xpath("//div[@class=\"header-top-right col-md-10 col-sm-12 position-static\"]/div/ul/li/a[@href=\"https://qalab.bensg.com/store/pe/3-clothes\"]")).click();
        driver.findElement(By.xpath("//div[@class=\"subcategory-image\"]/a[@title=\"Men\"]")).click();
        //WebElement textoBoton;

        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        textoBoton = driver.findElement(MyStorePage.IniciarSesion);
        wait.until(ExpectedConditions.visibilityOf(textoBoton));

        System.out.println("Texto: " + textoBoton.getText());*/

        try{
            Thread.sleep(1000);
        }catch (Exception e){

        }
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int arg0) {
        driver.findElement(By.xpath("//div[@class=\"products row\"]/div/article/div/div/a[@class=\"thumbnail product-thumbnail\"]")).click();
        driver.findElement(By.xpath("//div[@class=\"qty\"]/div/span/button[@class=\"btn btn-touchspin js-touchspin bootstrap-touchspin-up\"]")).click();
        driver.findElement(By.xpath("//div[@class=\"add\"]/button[@class=\"btn btn-primary add-to-cart\"]")).click();

        //WebElement textoBoton;

        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        textoBoton = driver.findElement(MyStorePage.IniciarSesion);
        wait.until(ExpectedConditions.visibilityOf(textoBoton));

        System.out.println("Texto: " + textoBoton.getText());*/

        try{
            Thread.sleep(10000);
        }catch (Exception e){

        }
    }


    @Then("valido en el popup la confirmación del producto agregado {string}")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado(String title) {
        //prueba: validamos el título del producto
        Assertions.assertEquals("Producto añadido correctamente a su carrito de compra", title);
    }
}
