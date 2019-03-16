package LW2_2

fun launch() {
    val input: String = readLine() ?: ""
    println(htmlDecode(input))
}

fun main(args: Array<String>) {
    launch()
}