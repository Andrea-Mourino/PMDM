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