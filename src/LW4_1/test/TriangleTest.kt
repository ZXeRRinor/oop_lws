package LW4_1.test

import LW4_1.graphics.Exceptions.DegenerateShape
import LW4_1.graphics.LineSegment
import LW4_1.graphics.Point
import LW4_1.graphics.Shapes.Triangle
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TriangleTest {

    @Test
    fun getPerimeter() {
        val triangle = Triangle(Point(0, 0), Point(3, 0), Point(3, 4))
        assertEquals(12.0, triangle.perimeter)
    }

    @Test
    fun getArea() {
        val triangle = Triangle(Point(0, 0), Point(3, 0), Point(3, 4))
        assertEquals(6.0, triangle.area)
    }

    @Test
    fun getEdges() {
        val triangle = Triangle(Point(0, 0), Point(3, 0), Point(3, 4))
        assertEquals(
            listOf(
                LineSegment(Point(0, 0), Point(3, 0)),
                LineSegment(Point(3, 0), Point(3, 4)),
                LineSegment(Point(3, 4), Point(0, 0))
            ), triangle.edges
        )
    }

    @Test
    fun toString1() {
        val triangle = Triangle(Point(0, 0), Point(3, 0), Point(3, 4))
        assertEquals(
            "Triangle vertex1=Point(x=0.0, y=0.0) vertex2=Point(x=3.0, y=0.0) vertex3=Point(x=3.0, y=4.0)",
            triangle.toString()
        )
    }

    @Test
    internal fun vertexesAreMatchesUp() {
        assertThrows(DegenerateShape::class.java) {Triangle(Point(0,0), Point(0,0), Point(0,0))}
        }
}