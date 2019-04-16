package LW4_1

fun launch() {
    var inputLine: String = readLine() ?: ""
    while (inputLine != "quit") {
        try {
            val input = inputLine.split(' ')
            val command = input[0]
            val args = input.minus(input[0])
            when (command) {
                "rectangle" -> {
                    if (args.size != 6) {
                        val leftTopX = args[0]
                        val leftTopY = args[1]
                        val width = args[2]
                        val height = args[3]
                        val outlineColor = args[4]
                        val fillColor = args[5]
                    } else {

                    }
                }
                "triangle" -> {
                    if (args.size != 8) {
                        val v1X = args[0]
                        val v1Y = args[1]
                        val v2X = args[2]
                        val v2Y = args[3]
                        val v3X = args[4]
                        val v3Y = args[5]
                        val outlineColor = args[6]
                        val fillColor = args[7]
                    } else {

                    }
                }
                "circle" -> {
                    if (args.size != 5) {
                        val centerX = args[0]
                        val centerY = args[1]
                        val radius = args[2]
                        val outlineColor = args[3]
                        val fillColor = args[4]
                    } else {

                    }
                }
                "line" -> {
                    if (args.size != 5) {
                        val startX = args[0]
                        val startY = args[1]
                        val endX = args[2]
                        val endY = args[3]
                        val outlineColor = args[4]
                        val fillColor = args[5]
                    } else {

                    }
                }
                else -> {

                }

            }
        } catch (e: Exception) {
            println("ERROR! ${e.message}")
        }
        inputLine = readLine() ?: ""
    }
}

fun main() {
    launch()
}