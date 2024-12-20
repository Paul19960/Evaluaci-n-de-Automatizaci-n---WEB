package com.nttdata.steps;

import com.nttdata.page.CarroPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CarroSteps {

    private WebDriver driver;

    public CarroSteps(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle(){
        return this.driver.findElement(CarroPage.cartTitle).getText();
    }

    public int getItemSize(){
        List<WebElement> items = this.driver.findElements(CarroPage.itemsCards);
        return items.size();
    }

}
