package MaquinaCafe

import CoffeeMachineState

fun main() {
    CoffeeMachine.startMachine()

}
/**
 * Objeto singleton que representa la máquina de café.
 *
 * Esta clase controla el flujo principal de la máquina de café:
 * - Verifica los recursos (café, agua, azúcar, leche, vasos y palillos).
 * - Permite seleccionar el tipo de café.
 * - Maneja errores y limpieza de la máquina.
 *
 * @property currentState Estado actual de la máquina de café.
 * @property Interfaz Interfaz de usuario para mostrar mensajes y seleccionar café.
 */
object CoffeeMachine {
    /** Estado actual de la máquina de café. */
    var currentState: CoffeeMachineState = CoffeeMachineState.Idle

    /** Interfaz de usuario para mostrar mensajes y opciones al usuario. */
    var Interfaz = Interface()

    /**
     * Método principal que inicia el ciclo de la máquina de café.
     *
     * Este método ejecuta un bucle infinito que:
     * 1. Comprueba el estado de la máquina.
     * 2. Verifica los recursos disponibles.
     * 3. Solicita al usuario el tipo de café que desea.
     * 4. Maneja errores y realiza la limpieza de la máquina si es necesario.
     *
     * El flujo de estados es el siguiente:
     * - Idle -> checkingStatus -> checkingCoffee -> checkingWater -> checkingSugar
     * -> checkingMilk -> checkingCup -> checkingSticks -> orderCoffee -> Idle
     *
     * En caso de error en cualquier recurso, la máquina pasa al estado Error,
     * muestra el mensaje correspondiente y luego se limpia automáticamente.
     */
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