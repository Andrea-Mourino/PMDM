package CoffeeMachine

open class Interface {
    open fun mostrarMensaje(mensaje: String) {
        print(mensaje)
    }

    open fun CoffeeType(): Coffee {
        var typeCoffee: Coffee = Machiatto()
        var analisis: Boolean

        do {
            analisis = true
            mostrarMensaje("\n-----------------------------------------")
            mostrarMensaje("\n      BIENVENIDO       ")
            mostrarMensaje("\n-----------------------------------------")
            mostrarMensaje("\nCafes disponibles actualmente:\n ")
            mostrarMensaje("\n1. Machiatto \n")
            mostrarMensaje("\n2. Expresso \n")
            mostrarMensaje("\n3. Americano \n")

            var type = readLine()?.toInt()

            when (type) {

                1 {mostrarMensaje("Buena eleccion: Machiatto")
                    typeCoffee = Machiatto()
                }

                2 {mostrarMensaje("Buena eleccion: Expresso")
                    typeCoffee = Expresso()
                }

                3 {mostrarMensaje("Buena eleccion: Americano")
                    typeCoffee = Americano()
                }
                else {analisis = false
                    mostrarError("Ahora por favor mete un numero valido (1-3)")
                    println("Intenta de nuevo (ㆆ_ㆆ)")
                }
            }
        } while (!analisis)
        println("\nPreparando tu café...\n")
        Thread.sleep(2000)
        println("\nTu café está listo!(っ◔◡◔)っ\n")
        return typeCoffee
    }

    open fun MostrarMensajeError(mensaje: String) {
        mostrarMensaje("ERROR: $mensaje")
    }
}