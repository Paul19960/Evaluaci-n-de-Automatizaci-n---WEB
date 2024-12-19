package com.nttdata.page;

import org.openqa.selenium.By;

public class MyStorePage {

    //Localizadores de elementos
    public static By userInput = By.id("field-email");
    public static By passInput = By.id("field-password");
    public static By loginButton = By.id("submit-login");
    public static By boton = By.xpath("//div[@class=\"header-top\"]/div/div/div/h1/a/img");
    public static By IniciarSesion = By.xpath("//div[@class=\"user-info\"]/a");
}
