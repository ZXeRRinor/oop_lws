package LW4_1.graphics.Shapes

import LW4_1.graphics.Point
import LW4_1.graphics.RGBColor
import LW4_1.graphics.SolidShape

class Rectangle(
    val leftTop: Point, val width: Double, val height: Double,
    override val fillColor: RGBColor = RGBColor(0, 0, 0),
    override val outlineColor: RGBColor = RGBColor(0, 0, 0)
) :
    SolidShape {

    override val area: Double
        get() {
            return width * height
        }

    override val perimeter: Double
        get() {
            return 2 * (width + height)
        }

    val rightBottom: Point
        get() {
            return Point(leftTop.x + width, leftTop.y - height)
        }

    override fun toString(): String {
        return "Rectangle leftTop=$leftTop rightBottom=$rightBottom"
    }
}