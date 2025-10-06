### EXPLICACION

## Paso 1

Creamos las clases ```CoffeeMachine```, ```CoffeeMachineState```, ```Interface``` y ```Coffee```

Defino los valores de cada ingredente que vamos a utilizar en el cafe
```
object CoffeeMachine {
    var currentState: CoffeeMachineState = CoffeeMachineState.Idle
    var Interfaz = Interfaz()
    var Coffee = 300
    var Water = 600
    var Sugar = 200
    var Milk = 300
    var Cup = 10
    var Sticks = 10
```

Seguidamente creamos una funcion llamada ```startMachine``` y hacemos un while (true) para que el programa entre en un bucle en el cual siempre se repita constantemente.
Dentro de ese bucle haremos que checkee que hay ingredientes para hacer el cafe que queremos y haremos un checkeo de cada de cada uno para al terminar con un ```orderCoffee``` con un mensaje que ponga que todo esta correcto.

Cuando este bucle termina la maquina vuelve al Idle con un Clean 
```
is CoffeeMachineState.Clean {
                    Interfaz.mostrarMensaje("Espere porfavor...")
                    Thread.sleep(2000)
                    Coffee = 300
                    Water = 600
                    Sugar = 200
                    Milk = 300
                    Sticks = 5
                    Cup = 5
                    currentState = CoffeeMachineState.Idle
                }
```
y en caso de que haya Error en el proceso de preparacion salta el mensaje de error, volviendo al Idle nuevamente
```
is CoffeeMachineState.Error {
                    val pb = (currentState as CoffeeMachineState.Error).message
                    Interfaz.MostrarMensajeError(pb)
                    Thread.sleep(2000)
                    currentState = CoffeeMachineState.Clean
}
```

## Paso 2

En otra clase aparte que llame ```CoffeeMachineState``` hice un object de cada ckeckeo de cada ingrediente y un data class para oderCoffee y Error ya que estos recogen datos.
```
sealed class CoffeeMachineState {
    object Idle : CoffeeMachineState()
    object checkingStatus : CoffeeMachineState()
    object checkingCoffee : CoffeeMachineState()
    object checkingWater : CoffeeMachineState()
    object checkingSugar : CoffeeMachineState()
    object checkingMilk : CoffeeMachineState()
    object checkingCup : CoffeeMachineState()
    object checkingSticks : CoffeeMachineState()
    data class orderCoffee(val pw: Coffee) : CoffeeMachineState()
    object Clean : CoffeeMachineState()
    data class Error(val message: String) : CoffeeMachineState()
}
```

Cree otra clase llamada ```CoffeeMachine``` donde definiremos los valores String e Int de cada ingrediente (en el caso del vaso y el palillo solo pondremos que se delimite a uno) y en la otra parte pondremos las cantidades de dichos ingredintes en el cafe asignado
```
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
```

Por ultimo creamos la clase Interface para aque el usuario eliga el cafe que quiere pillar y dentro del else saltara el aviso de que no hemos ingresado los valores correctos y que lo volvamos a intentar
```
else {analisis = false
                    mostrarError("Ahora por favor mete un numero valido (1-3)")
                    println("Intenta de nuevo (ㆆ_ㆆ)")
```

Creamos un var analisis de tipo boolean para que dentro del while(!analisis) salga un mensaje de que se a terminado la operacion
```
while (!analisis)
        println("\nPreparando tu café...\n")
        Thread.sleep(2000)
        println("\nTu café está listo!(っ◔◡◔)っ\n")
        return typeCoffee
```

Por ultimo en caso de error se abre la funcion ```MostrarMensajeError``` 

