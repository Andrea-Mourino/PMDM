package MaquinaCafe
/**
 * Clase que representa la interfaz de usuario de la máquina de café.
 *
 * Permite mostrar mensajes en la consola, mostrar errores y solicitar al usuario
 * que seleccione un tipo de café.
 */
open class Interface {

    /**
     * Muestra un mensaje en la consola.
     *
     * @param mensaje Texto que se desea mostrar al usuario.
     */
    open fun mostrarMensaje(mensaje: String) {
        print(mensaje)
    }

    /**
     * Solicita al usuario seleccionar un tipo de café disponible.
     *
     * Muestra un menú con las opciones de café (Machiatto, Expresso, Americano),
     * valida la entrada del usuario y devuelve un objeto [Coffee] correspondiente
     * al tipo seleccionado.
     *
     * El método incluye:
     * - Validación de que el número ingresado esté entre 1 y 3.
     * - Reintento si el usuario ingresa un valor inválido.
     * - Simulación de preparación del café con mensajes y pausas.
     *
     * @return Objeto [Coffee] correspondiente a la elección del usuario.
     */
    open fun CoffeeType(): Coffee {
        var typeCoffee: Coffee = Machiatto()
        var analisis: Boolean

        do {
            analisis = true
            mostrarMensaje("\n-----------------------------------------")
            mostrarMensaje("\n               BIENVENIDO                ")
            mostrarMensaje("\n-----------------------------------------")
            mostrarMensaje("\nCafes disponibles actualmente:\n ")
            mostrarMensaje("\n1. Machiatto \n")
            mostrarMensaje("\n2. Expresso \n")
            mostrarMensaje("\n3. Americano \n")

            var type = readLine()?.toInt()

            when (type) {

                1 ->{mostrarMensaje("Buena eleccion: Machiatto")
                    typeCoffee = Machiatto()
                }

                2 ->{mostrarMensaje("Buena eleccion: Expresso")
                    typeCoffee = Expresso()
                }

                3 ->{mostrarMensaje("Buena eleccion: Americano")
                    typeCoffee = Americano()
                }
                else ->{analisis = false
                    MostrarMensajeError("Ahora por favor mete un numero valido (1-3)")
                    println("\nIntenta de nuevo (ㆆ_ㆆ)")
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