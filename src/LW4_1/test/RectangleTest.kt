package LW4_1.test

import LW4_1.graphics.Point
import LW4_1.graphics.Shapes.Rectangle
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RectangleTest {

    @Test
    fun getArea() {
        val rectangle = Rectangle(Point(0, 0), 3.0, 4.0)
        assertEquals(12.0, rectangle.area)
    }

    @Test
    fun getPerimeter() {
        val rectangle = Rectangle(Point(0, 0), 3.0, 4.0)
        assertEquals(14.0, rectangle.perimeter)
    }

    @Test
    fun getRightBottom() {
        val rectangle = Rectangle(Point(0, 0), 3.0, 4.0)
        assertEquals(Point(3, -4), rectangle.rightBottom)
    }

    @Test
    fun toString1() {
        val rectangle = Rectangle(Point(0, 0), 3.0, 4.0)
        assertEquals("Rectangle leftTop=Point(x=0.0, y=0.0) rightBottom=Point(x=3.0, y=-4.0)", rectangle.toString())
    }
}