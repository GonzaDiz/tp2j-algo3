TP 2 JAVA - ALGORITMOS Y PROGRAMACION III
==========

[![Build Status](https://travis-ci.org/GonzaDiz/tp2j-algo3.svg?branch=master)]()


## Grupo 3

| Padrón | Nombre y Apellido          |  Cmts   |  Nota   |
|--------|--------------------------- | ------- | ------- |
|  97893 | ALVAREZ WINDEY ARIEL JUSTO |   % 30  |    8    |
|  82399 | ANCA JORGE LUIS            |   % 13  |    5    |
|  98546 | DIZ MARTIN GONZALO         |   % 42  |    8    |
|  88055 | OCAMPO DAMIAN CARLOS       |   %  1  |    5    |

## Entrega final

### Respecto al modelo

#### Modelo

##### C1
Jugador>>capitalTotal es un int? Porqué?

##### C2
Hotel y Casa lo mencionan en el informe pero no lo pude encontrar en el código. 

##### C3
Respecto a la cantidad de parámetros [AlquilerTerrenoDoble.java#L28](https://github.com/GonzaDiz/tp2j-algo3/blob/entregafinal/src/modelo/casillero/terrenos/AlquilerTerrenoDoble.java#L28). Una lectura interesante es: Clean Code by Robert C. Martin. Chapter 3 - Function Arguments

##### C4
Casillero tiene posición. ArmadorDeTablero, existe el concepto de posición que entiendo que es necesario para poder dibujar los jugadores que caen en un casillero. Esto en principio, no debería pertenecer al modelo. Porque es algo meramente visual. Desde el punto de vista del modelo un jugador está en el casillero.

##### C5
Cuando un jugador compra un terreno con dueño:

```java
// Test de compra de las companias
@Test
public void testUnJugadorCaeEnEdesurLuegoLaCompraUnSegundoRealizandoseElIntercambio() {
    CompaniaFactory companiaFactory = new CompaniaFactory();

    Jugador presidente = new Jugador("Presidente");
    Jugador ricky = new Jugador("Ricky");

    Compania aysa = companiaFactory.crearAysa();

    int capitalPresidente = presidente.capitalTotal();
    int capitalRicky = ricky.capitalTotal();

    presidente.comprarCompania(aysa);
    ricky.comprarCompania(aysa);

    Assert.assertEquals(capitalRicky - 30000, ricky.capitalTotal());
    Assert.assertEquals(capitalPresidente + 30000, ricky.capitalTotal());
}
```

Viendo el código y escribiendo un test para entenderlo, veo que se cambia del dueño de la propiedad y el "viejo" dueño la pierde. No se le devuelve plata.

##### C6

Definieron la interface siguiente: 

```java
public interface TiroDeDados {

	int valor();
	void actualizarEstado(Jugador jugador, TiroDeDados tiroDados);
	boolean sosDoble();

}
```

En lugar de que ```sosDoble``` devuelva un ```boolean``` definir clases para que hagan lo que sea necesario.

Lo mismo ocurre con ```sosComparable``` en ```Casillero```.  

#### MVC

Ok

#### Respecto a los diagramas

*ddc_casilleros_especiales*: El diagrama tiene mucha información, distribuir el número de entidades en varios diagramas utilizando la regla 7 +/- 2.

*dds_compra_terreno_doble_y_construccion_de_Casa*: En este diagrama se evidencia la existencia de una instancia de la clase 'BuenosAiresNorte' pero no la encuentro en el código. Entiendo que esta clase no existe y Uds. quieren referir a la variable buenosAiresNorte cuyo tipo es TerrenoDoble => en el diagrama se expresa así: ```buenosAiresNorte : TerrenoDoble```.

#### Lanzar aplicación

No pude ejecutar la aplicación con ```ant ejecutar.aplicacion```.




