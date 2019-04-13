package LW3_1

fun main() {
    var inputLine: String = readLine() ?: ""
    val car = Car()
    while (inputLine != "quit") {
        try {
            when (inputLine) {
                "Info" -> car.printInfo()
                "EngineOn" -> car.turnOnEngine()
                "EngineOff" -> car.turnOffEngine()
                else -> {
                    val command = inputLine.split(' ')[0]
                    val value = inputLine.split(' ')[1].toInt()
                    when (command) {
                        "SetGear" -> {
                            car.setGear(
                                when (value) {
                                    -1 -> Car.Gear.REVERSE
                                    0 -> Car.Gear.NEUTRAL
                                    1 -> Car.Gear.FIRST
                                    2 -> Car.Gear.SECOND
                                    3 -> Car.Gear.THIRD
                                    4 -> Car.Gear.FOURTH
                                    5 -> Car.Gear.FIFTH
                                    else -> Car.Gear.NEUTRAL
                                }
                            )
                        }
                        "SetSpeed" -> car.setSpeed(value)
                    }
                }
            }
        } catch (e: Exception) {
            println("ERROR! ${e.message}")
        }
        inputLine = readLine() ?: ""
    }
}