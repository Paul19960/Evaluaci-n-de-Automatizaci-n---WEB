package com.nttdata.steps;

import com.nttdata.page.CarroPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CarroSteps {

    private WebDriver driver;

    //contrsuctor
    public CarroSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Obtener el título de la pantalla de productos
     * @return el valor del título de la pantalla de productos
     */
    public String getTitle(By xpath){
        return this.driver.findElement(CarroPage.productsTitle).getText();
    }

    /**
     * Retorna la cantidad de items
     * @return la cantidad de items
     */
    public int getItemSize(){
        List<WebElement> items = this.driver.findElements(CarroPage.itemsCards);
        return items.size();
    }
}
