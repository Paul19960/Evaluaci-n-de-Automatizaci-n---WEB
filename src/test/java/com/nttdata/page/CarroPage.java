package com.nttdata.page;

import org.openqa.selenium.By;

public class CarroPage {

    public static By productsTitle = By.cssSelector("span.title");
    public static By itemsCards = By.cssSelector("div.inventory_item");
    public static By cartTitle = By.xpath("//div[@class=\"card-block\"]/h1");
}
