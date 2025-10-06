import MaquinaCafe.Coffee
/**
 * Representa los posibles estados de la máquina de café.
 *
 * Esta clase sellada define todos los estados por los que puede pasar la máquina,
 * desde estar inactiva hasta manejar errores y limpiar los recursos.
 */
sealed class CoffeeMachineState {
    /** Estado inicial de la máquina, sin hacer nada. */
    object Idle : CoffeeMachineState()
    object checkingStatus : CoffeeMachineState()
    object checkingCoffee : CoffeeMachineState()
    object checkingWater : CoffeeMachineState()
    object checkingSugar : CoffeeMachineState()
    object checkingMilk : CoffeeMachineState()
    object checkingCup : CoffeeMachineState()
    object checkingSticks : CoffeeMachineState()
    object orderCoffee : CoffeeMachineState()

    /** Estado en el que la máquina realiza la limpieza de sus recursos. */
    object Clean : CoffeeMachineState()

    /**
     * Estado que representa un error en la máquina.
     *
     * @property message Mensaje de error que describe el problema detectado.
     */
    data class Error(val message: String) : CoffeeMachineState()
}