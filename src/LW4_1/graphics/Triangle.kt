package LW4_1.graphics

import kotlin.math.abs
import kotlin.math.sqrt

class Triangle(
    val vertex1: Point, val vertex2: Point, val vertex3: Point, override val fillColor: RGBColor,
    override val outlineColor: RGBColor
) : SolidShape {

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
            return (sqrt(sp * (sp - edges[0].length) * (sp - edges[0].length) * (sp - edges[0].length)))
        }

    val edges: List<Edge>
        get() {
            return (listOf(Edge(vertex1, vertex2), Edge(vertex2, vertex3), Edge(vertex3, vertex1)))
        }

    override fun toString(): String {
        return ""
    }
}