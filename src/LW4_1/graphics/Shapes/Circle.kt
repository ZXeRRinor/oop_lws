package LW4_1.graphics.Shapes

import LW4_1.graphics.Exceptions.DegenerateShape
import LW4_1.graphics.Exceptions.InvalidArguments
import LW4_1.graphics.Point
import LW4_1.graphics.RGBColor
import LW4_1.graphics.SolidShape
import kotlin.math.pow

class Circle(
    val center: Point, val radius: Double,
    override val fillColor: RGBColor = RGBColor(0, 0, 0),
    override val outlineColor: RGBColor = RGBColor(0, 0, 0)
) : SolidShape {
    init {
        if (radius == 0.0) {
            throw DegenerateShape("It is an one point.")
        }
        if (radius < 0.0) {
            throw InvalidArguments("Radius can't be less than zero.")
        }
    }

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