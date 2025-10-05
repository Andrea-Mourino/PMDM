object CoffeeMachine {
    var currentState: CoffeeMachineState = CoffeeMachineState.Idle
    var Interfaz = Interfaz()
    var Coffee = 300
    var Water = 600
    var Sugar = 200
    var Milk = 300
    var Sticks = 5
    var Cup = 5

    fun startMachine() {
        while (true) {
            when (currentState) {
                is CoffeeMachineState.Idle {
                    currentState = CoffeeMachineState.checkingStatus
                    Interfaz.mostrarMensaje("Comenzando analisis de la máquina de café")
                }

                is CoffeeMachineState.checkingStatus {
                    currentState = CoffeeMachineState.checkingCoffee
                    Interfaz.mostrarMensaje("Empezando a verificar los elementos")
                }

                is CoffeeMachineState.checkingCoffee {
                    Interfaz.mostrarMensaje("Comprobando café")
                    repeat (3) {
                        Thread.sleep(2000)
                        Interfaz.mostrarMensaje(".")
                    }

                    val CoffeePositive = true
                    if (CoffeePositive) {
                        currentState = CoffeeMachineState.checkingWater
                        Interfaz.mostrarMensaje("Café correcto")
                    }
                    else {
                        currentState = CoffeeMachineState.Error("No queda cafe")
                    }
                }

                is CoffeeMachineState.checkingWater {
                    Interfaz.mostrarMensaje("Comprobando agua")
                    repeat (3) {
                        Thread.sleep(2000)
                        Interfaz.mostrarMensaje(".")
                    }

                    val WaterPositive = true

                    if (WaterPositive){
                        currentState = CoffeeMachineState.checkingSugar
                        Interfaz.mostrarMensaje("Agua correcto")
                    }
                    else {
                        currentState = CoffeeMachineState.Error("No queda agua")
                    }
                }

                is CoffeeMachineState.checkingSugar {
                    Interfaz.mostrarMensaje("Comprobando azucar")
                    repeat (3) {
                        Thread.sleep(2000)
                        Interfaz.mostrarMensaje(".")
                    }
                    val SugarPositive = true
                    if (SugarPositive){
                        currentState = CoffeeMachineState.checkingMilk
                        Interfaz.mostrarMensaje("Azucar correcto")
                    }
                    else {
                        currentState = CoffeeMachineState.Error("No queda azucar")
                    }
                }

                is CoffeeMachineState.checkingMilk {
                    Interfaz.mostrarMensaje("Comprobando leche")
                    repeat (3) {
                        Thread.sleep(2000)
                        interfaz.mostrarMensaje(".")
                    }
                    val MilkPositive = true
                    if (MilkPositive){
                        currentState = CoffeeMachineState.checkingCup
                        Interfaz.mostrarMensaje("Leche correcto")
                    }
                    else {
                        currentState = CoffeeMachineState.Error("No queda Leche")
                    }
                }

                is CoffeeMachineState.checkingCup {
                    Interfaz.mostrarMensaje("Comprobando vaso")
                    repeat (3) {
                        Thread.sleep(2000)
                        Interfaz.mostrarMensaje(".")
                    }
                    val CupPositive = true
                    if (CupPositive){
                        currentState = CoffeeMachineState.checkingSticks
                        Interfaz.mostrarMensaje("Vaso correcto")
                    }
                    else {
                        currentState = CoffeeMachineState.Error("No queda vaso")
                    }
                }

                is CoffeeMachineState.checkingSticks {
                    Interfaz.mostrarMensaje("Comprobando palillo")
                    repeat (3) {
                        Thread.sleep(2000)
                        Interfaz.mostrarMensaje(".")
                    }
                    val SticksPositive = true
                    if (SticksPositive){
                        currentState = CoffeeMachineState.orderCoffee
                        Interfaz.mostrarMensaje("Palillo correcto")
                    }
                    else {
                        currentState = CoffeeMachineState.Error("No quedan palillos")
                    }
                }


                is CoffeeMachineState.orderCoffee {
                    Interfaz.mostrarMensaje("Todo esta correcto")
                    val CoffeeClass = (currentState as CoffeeMachineState.orderCoffee).pw
                }



                is CoffeeMachineState.Clean {
                    Interfaz.mostrarMensaje("Espere porfavor...")
                    Thread.sleep(1000)
                    Coffee = 300
                    Water = 600
                    Sugar = 200
                    Milk = 300
                    Sticks = 5
                    Cup = 5
                    currentState = CoffeeMachineState.Idle
                }

                is CoffeeMachineState.Error {
                    val pb = (currentState as CoffeeMachineState.Error).message
                    Interfaz.MostrarMensajeError(pb)
                    Thread.sleep(2000)
                    currentState = CoffeeMachineState.Clean
                }
            }
        }
    }
}