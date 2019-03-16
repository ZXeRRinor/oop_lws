package LW2_2

fun launch() {
    val input: String? = readLine()
    if (input != null) {
        println(htmlDecode(input))
    }
}

fun main(args: Array<String>) {
    launch()
}