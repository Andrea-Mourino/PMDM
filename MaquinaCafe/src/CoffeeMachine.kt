package MaquinaCafe

import CoffeeMachineState

fun main() {
    CoffeeMachine.startMachine()

}

object CoffeeMachine {
    var currentState: CoffeeMachineState = CoffeeMachineState.Idle
    var Interfaz = Interface()


    fun startMachine() {
        while (true) {
            when (currentState) {
                is CoffeeMachineState.Idle ->{
                    currentState = CoffeeMachineState.checkingStatus
                    Interfaz.mostrarMensaje("\nComenzando analisis de la máquina de café")
                }

                is CoffeeMachineState.checkingStatus ->{
                    currentState = CoffeeMachineState.checkingCoffee
                    Interfaz.mostrarMensaje("\nEmpezando a verificar los elementos")
                }

                is CoffeeMachineState.checkingCoffee ->{
                    Interfaz.mostrarMensaje("\nComprobando café")
                    repeat (3) {
                        Thread.sleep(2000)
                        Interfaz.mostrarMensaje(".")
                    }

                    val CoffeePositive = true
                    if (CoffeePositive) {
                        currentState = CoffeeMachineState.checkingWater
                        Interfaz.mostrarMensaje("\nCafé correcto")
                    }
                    else {
                        currentState = CoffeeMachineState.Error("\nNo queda cafe")
                    }
                }

                is CoffeeMachineState.checkingWater ->{
                    Interfaz.mostrarMensaje("\nComprobando agua")
                    repeat (3) {
                        Thread.sleep(2000)
                        Interfaz.mostrarMensaje(".")
                    }

                    val WaterPositive = true

                    if (WaterPositive){
                        currentState = CoffeeMachineState.checkingSugar
                        Interfaz.mostrarMensaje("\nAgua correcto")
                    }
                    else {
                        currentState = CoffeeMachineState.Error("No queda agua")
                    }
                }

                is CoffeeMachineState.checkingSugar ->{
                    Interfaz.mostrarMensaje("\nComprobando azucar")
                    repeat (3) {
                        Thread.sleep(2000)
                        Interfaz.mostrarMensaje(".")
                    }
                    val SugarPositive = true
                    if (SugarPositive){
                        currentState = CoffeeMachineState.checkingMilk
                        Interfaz.mostrarMensaje("\nAzucar correcto")
                    }
                    else {
                        currentState = CoffeeMachineState.Error("\nNo queda azucar")
                    }
                }

                is CoffeeMachineState.checkingMilk ->{
                    Interfaz.mostrarMensaje("\nComprobando leche")
                    repeat (3) {
                        Thread.sleep(2000)
                        Interfaz.mostrarMensaje(".")
                    }
                    val MilkPositive = true
                    if (MilkPositive){
                        currentState = CoffeeMachineState.checkingCup
                        Interfaz.mostrarMensaje("\nLeche correcto")
                    }
                    else {
                        currentState = CoffeeMachineState.Error("\nNo queda Leche")
                    }
                }

                is CoffeeMachineState.checkingCup ->{
                    Interfaz.mostrarMensaje("\nComprobando vaso")
                    repeat (3) {
                        Thread.sleep(2000)
                        Interfaz.mostrarMensaje(".")
                    }
                    val CupPositive = true
                    if (CupPositive){
                        currentState = CoffeeMachineState.checkingSticks
                        Interfaz.mostrarMensaje("\nVaso correcto")
                    }
                    else {
                        currentState = CoffeeMachineState.Error("\nNo queda vaso")
                    }
                }

                is CoffeeMachineState.checkingSticks ->{
                    Interfaz.mostrarMensaje("\nComprobando palillo")
                    repeat (3) {
                        Thread.sleep(2000)
                        Interfaz.mostrarMensaje(".")
                    }
                    val SticksPositive = true
                    if (SticksPositive){
                        currentState = CoffeeMachineState.orderCoffee
                        Interfaz.mostrarMensaje("\nPalillo correcto")
                    }
                    else {
                        currentState = CoffeeMachineState.Error("\nNo quedan palillos")
                    }
                }


                is CoffeeMachineState.orderCoffee ->{
                    Interfaz.mostrarMensaje("\nTodo esta correcto")
                    Interfaz.CoffeeType()
                }



                is CoffeeMachineState.Clean ->{
                    Interfaz.mostrarMensaje("\nEspere porfavor...")
                    Thread.sleep(2000)
                    currentState = CoffeeMachineState.Idle
                }

                is CoffeeMachineState.Error ->{
                    val pb = (currentState as CoffeeMachineState.Error).message
                    Interfaz.MostrarMensajeError(pb)
                    Thread.sleep(2000)
                    currentState = CoffeeMachineState.Clean
                }
            }
        }
    }


}