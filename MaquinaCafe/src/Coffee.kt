package MaquinaCafe

abstract class Coffee(
    val name: String,
    val amountOfWater: Int,
    val amountOfCoffee: Int,
    val amountOfSugar: Int,
    val amountOfMilk: Int,
    val amountOfSticks: Int = 1,
    val amountOfCup: Int = 1,
)

class Machiatto : Coffee("Machiatto", 0, 100, 10, 100)
class Expresso : Coffee("Expresso", 0, 200, 30, 0)
class Americano : Coffee("Americano", 200, 100, 10, 0)