package LW4_1.graphics.Shapes

import LW4_1.graphics.Canvas.Canvas
import LW4_1.graphics.Drawable
import LW4_1.graphics.Exceptions.DegenerateShape
import LW4_1.graphics.Exceptions.InvalidArguments
import LW4_1.graphics.Point
import LW4_1.graphics.RGBColor
import LW4_1.graphics.SolidShape
import java.awt.Color

class Rectangle(
    val leftTop: Point, val width: Double, val height: Double,
    override val fillColor: Color = Color.BLACK,
    override val outlineColor: Color = Color.BLACK
) :
    SolidShape, Drawable {
    init{
        if (width == 0.0 || height == 0.0) {
            throw DegenerateShape("It is an one point.")
        }
        if (width < 0.0 || height < 0.0) {
            throw InvalidArguments("Width or height can't be less than zero.")
        }
    }

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

    override fun draw(c: Canvas) {
        c.drawShape(this)
    }
}