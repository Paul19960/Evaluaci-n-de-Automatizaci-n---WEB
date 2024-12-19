package com.nttdata.stepsdefinitions;

import com.nttdata.page.LoginPage;
import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
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


public class LoginStepsDef {

    private WebDriver driver;

    LoginSteps loginSteps;

    private InventorySteps inventorySteps(WebDriver driver){
        return new InventorySteps(driver);
    }

    @Dado("que me encuentro en la página de login de Saucedemo")
    public void que_me_encuentro_en_la_página_de_login_de_sacedemo() {
        driver = getDriver();
        driver.get("https://www.saucedemo.com/");
        screenShot();

        WebElement textoLogo;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        textoLogo = driver.findElement(LoginPage.titulo);
        wait.until(ExpectedConditions.visibilityOf(textoLogo));

        System.out.println("Texto: " + textoLogo.getText());

        try{
            Thread.sleep(10000);
        }catch (Exception e){

        }

    }
    @Cuando("inicio sesión con las credenciales usuario: {string} y contraseña: {string}")
    public void inicio_sesión_con_las_credenciales_usuario_y_contraseña(String user, String password) {
        loginSteps  = new LoginSteps(driver);
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        loginSteps.login();
        screenShot();
    }
    @Entonces("valido que debería aparecer el título de {string}")
    public void valido_que_debería_aparecer_el_título_de(String expectedTitle) {
        String title =  inventorySteps(driver).getTitle();
        //prueba: validamos el título del producto
        Assertions.assertEquals(expectedTitle, title);
    }
    @Y("también valido que al menos exista un item")
    public void también_valido_que_al_menos_exista_un_item() {
        loginSteps.validarItems(inventorySteps(driver));
    }

    @Dado("que estoy en la página de productos de Saucedemo")
    public void queEstoyEnLaPaginaDeProductosDeSaucedemo() {
        String pageTitle = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals("Products", pageTitle);
    }

    @Cuando("agrego el producto {string} al carrito")
    public void agregoElProductoAlCarrito(String arg0) {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Entonces("valido que el icono del carrito muestra {string} producto agregado")
    public void validoQueElIconoDelCarritoMuestraProductoAgregado(String arg0) {
        driver = getDriver();
        String cartCount = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals("1", cartCount);
    }

}
