package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginPage {

    //Localizadores de elementos
    public static By userInput = By.id("user-name");
    public static By passInput = By.id("password");
    public static By loginButton = By.id("login-button");
    public static By titulo = By.xpath("//div[@id=\"root\"]/div/div[@class=\"login_logo\"]");
    public static By productsLogo = By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/span");

}
