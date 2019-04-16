package LW4_1.graphics.Shapes

import LW4_1.graphics.*
import LW4_1.graphics.Canvas.Canvas
import LW4_1.graphics.Exceptions.DegenerateShape
import java.awt.Color
import kotlin.math.sqrt

class Triangle(
    val vertex1: Point, val vertex2: Point, val vertex3: Point,
    override val fillColor: Color = Color.BLACK,
    override val outlineColor: Color = Color.BLACK
) : SolidShape, Drawable {
    init {
        if (vertex1 == vertex2 || vertex2 == vertex3 || vertex3 == vertex1) {
            throw DegenerateShape("It is an one point.")
        }
    }

    override val perimeter: Double
        get() {
            var p = 0.0
            for (edge in edges) {
                p += edge.length
            }
            return p
        }

    override val area: Double
        get() {
            val sp = perimeter / 2
            return (sqrt(sp * (sp - edges[0].length) * (sp - edges[1].length) * (sp - edges[2].length)))
        }

    val edges: List<LineSegment>
        get() {
            return (listOf(
                LineSegment(vertex1, vertex2),
                LineSegment(vertex2, vertex3),
                LineSegment(vertex3, vertex1)
            ))
        }

    override fun toString(): String {
        return "Triangle vertex1=$vertex1 vertex2=$vertex2 vertex3=$vertex3"
    }

    override fun draw(c: Canvas) {
        c.drawShape(this)
    }
}