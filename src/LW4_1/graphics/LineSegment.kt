package LW4_1.graphics

import LW4_1.graphics.Canvas.Canvas
import LW4_1.graphics.Exceptions.DegenerateShape
import java.awt.Color
import java.lang.Math.pow
import javax.sound.sampled.Line
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

class LineSegment(
    val startPoint: Point,
    val endPoint: Point,
    override val outlineColor: Color = Color.BLACK
) : Shape, Drawable {
    init {
        if (startPoint == endPoint) {
            throw DegenerateShape("It is an one point.")
        }
    }

    val length: Double
        get() {
            return (sqrt(abs(startPoint.x - endPoint.x).pow(2) + abs(startPoint.y - endPoint.y).pow(2)))
        }

    override val perimeter = length
    override val area = 0.0

    override fun toString(): String {
        return "LineSegment startPoint=$startPoint endPoint=$endPoint"
    }

    fun equals(other: LineSegment): Boolean {
        return this.startPoint == other.startPoint && this.endPoint == other.endPoint ||
                this.startPoint == other.endPoint && this.endPoint == other.startPoint
    }

    override fun draw(c: Canvas) {
        c.drawShape(this)
    }
}