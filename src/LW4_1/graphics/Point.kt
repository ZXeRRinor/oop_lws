package LW4_1.graphics

data class Point(val x: Double, val y: Double) {
    constructor(x: Int, y: Int) : this(x.toDouble(), y.toDouble())
}