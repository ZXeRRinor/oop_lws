package LW4_1.test

import LW4_1.graphics.Point
import LW4_1.graphics.Shapes.Circle
import org.junit.jupiter.api.Test
import kotlin.math.pow

import org.junit.jupiter.api.Assertions.*

internal class CircleTest {

    @Test
    fun getArea() {
        val circle = Circle(Point(0, 0), 5.0)
        assertEquals(Math.PI * 5.0.pow(2), circle.area)
    }

    @Test
    fun getPerimeter() {
        val circle = Circle(Point(0, 0), 5.0)
        assertEquals(Math.PI * 10, circle.perimeter)
    }

    @Test
    fun toString1() {
        val circle = Circle(Point(0, 0), 5.0)
        assertEquals("Circle radius=5.0 center=Point(x=0.0, y=0.0)", circle.toString())
    }
}