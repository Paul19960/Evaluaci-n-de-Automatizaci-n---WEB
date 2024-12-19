#language: es
@testfeature
Característica: Login
  Yo, como usuario
  Quiero, tener una opción para iniciar sesión
  Para ver todos los items

  @test
  Escenario: Iniciar sesión
    Dado que me encuentro en la página de login de Saucedemo
    Cuando inicio sesión con las credenciales usuario: "standard_user" y contraseña: "secret_sauce"
    Entonces valido que debería aparecer el título de "Products"
    Y también valido que al menos exista un item


  #AgregarItem
  #@AddCart
  #Escenario: Agregar un producto al carrito de compras
    #Dado que estoy en la página de productos de Saucedemo
    #Cuando agrego el producto "Sauce Labs Backpack" al carrito
    #Entonces valido que el icono del carrito muestra "1" producto agregado
