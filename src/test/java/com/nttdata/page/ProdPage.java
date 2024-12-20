package com.nttdata.page;

import org.openqa.selenium.By;

public class ProdPage {

    //Localizadores para realizar las pruebas funcionales
    public static By userInput = By.id("field-email");
    public static By passInput = By.id("field-password");
    public static By loginButton = By.id("submit-login");
    public static By boton = By.xpath("//div[@class=\"header-top\"]/div/div/div/h1/a/img");
    public static By IniciarSesion = By.xpath("//div[@class=\"user-info\"]/a");
    public static By botonCategory = By.xpath("//div[@class=\"header-top-right col-md-10 col-sm-12 position-static\"]/div/ul/li/a[@href=\"https://qalab.bensg.com/store/pe/3-clothes\"]");
    public static By CategoryMen = By.xpath("//div[@class=\"subcategory-image\"]/a[@title=\"Men\"]");
    public static By SelectProd = By.xpath("//div[@class=\"products row\"]/div/article/div/div/a[@class=\"thumbnail product-thumbnail\"]");
    public static By SumCantidad = By.xpath("//div[@class=\"qty\"]/div/span/button[@class=\"btn btn-touchspin js-touchspin bootstrap-touchspin-up\"]");
    public static By AddCart = By.xpath("//div[@class=\"add\"]/button[@class=\"btn btn-primary add-to-cart\"]");
    public static By ValProdCart = By.xpath("//*[@id=\"myModalLabel\"]");
    public static By ConfirmaProd = By.xpath("//div[@class=\"col-md-7\"]/div/p[@class=\"cart-products-count\"]");
    public static By botonFinaliza = By.xpath("//div[@class=\"cart-content-btn\"]/a[@class=\"btn btn-primary\"]");
    public static By Total1 = By.xpath("//p[@class=\"product-total\"]/span[@class=\"value\"]");
    public static By ExpectedTotal1 = By.xpath("//p[@class=\"product-total\"]/span[@class=\"value\"]");
    public static By Total = By.xpath("//div[@class=\"cart-summary-line cart-total\"]/span[@class=\"value\"]");
    public static By ExpectedTotal = By.xpath("//div[@class=\"cart-summary-line cart-total\"]/span[@class=\"value\"]");

}
