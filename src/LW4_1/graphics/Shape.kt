package LW4_1.graphics

interface Shape {
    val outlineColor: RGBColor
    val perimeter: Double
    val area: Double
    override fun toString(): String
}