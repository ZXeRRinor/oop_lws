package LW4_1.graphics

import kotlin.math.pow

class Circle(
    val center: Point, val radius: Double, override val fillColor: RGBColor,
    override val outlineColor: RGBColor
) : SolidShape {
    override val area: Double
    get() {
        return Math.PI * radius.pow(2)
    }

    override val perimeter: Double
    get() {
        return 2 * Math.PI * radius
    }

    override fun toString(): String {
        return "Circle radius=$radius center=$center"
    }
}