package MaquinaCafe

/**
 * Clase abstracta que representa un tipo de café genérico.
 *
 * Cada tipo de café tiene cantidades específicas de ingredientes y utensilios
 * necesarios para prepararlo.
 *
 * @property name Nombre del café.
 * @property amountOfWater Cantidad de agua requerida en mililitros (ml).
 * @property amountOfCoffee Cantidad de café requerida en gramos (g).
 * @property amountOfSugar Cantidad de azúcar requerida en gramos (g).
 * @property amountOfMilk Cantidad de leche requerida en mililitros (ml).
 * @property amountOfSticks Cantidad de palillos necesarios (por defecto 1).
 * @property amountOfCup Cantidad de vasos necesarios (por defecto 1).
 */
abstract class Coffee(
    val name: String,
    val amountOfWater: Int,
    val amountOfCoffee: Int,
    val amountOfSugar: Int,
    val amountOfMilk: Int,
    val amountOfSticks: Int = 1,
    val amountOfCup: Int = 1,
)
/**
 * Clase que representa un café Machiatto.
 *
 * Contiene 0 ml de agua, 100 g de café, 10 g de azúcar y 100 ml de leche.
 */
class Machiatto : Coffee("Machiatto", 0, 100, 10, 100)

/**
 * Clase que representa un café Expresso.
 *
 * Contiene 0 ml de agua, 200 g de café, 30 g de azúcar y 0 ml de leche.
 */
class Expresso : Coffee("Expresso", 0, 200, 30, 0)

/**
 * Clase que representa un café Americano.
 *
 * Contiene 200 ml de agua, 100 g de café, 10 g de azúcar y 0 ml de leche.
 */
class Americano : Coffee("Americano", 200, 100, 10, 0)