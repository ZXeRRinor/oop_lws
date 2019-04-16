package LW4_1.test

import LW4_1.graphics.Exceptions.DegenerateShape
import LW4_1.graphics.Exceptions.InvalidArguments
import LW4_1.graphics.LineSegment
import LW4_1.graphics.Point
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class LineSegmentTest {

    @Test
    fun getLength() {
        val line = LineSegment(Point(0, 0), Point(3, 4))
        assertEquals(5.0, line.length)
    }

    @Test
    fun getArea() {
        val line = LineSegment(Point(0, 0), Point(3, 4))
        assertEquals(0.0, line.area)
    }

    @Test
    fun toStringTest() {
        val line = LineSegment(Point(0, 0), Point(3, 4))
        assertEquals("LineSegment startPoint=Point(x=0.0, y=0.0) endPoint=Point(x=3.0, y=4.0)", line.toString())
    }

    @Test
    internal fun twoPointsMatchesUp() {
        assertThrows(DegenerateShape::class.java) {
            LineSegment(Point(0, 0), Point(0, 0))
        }
    }
}