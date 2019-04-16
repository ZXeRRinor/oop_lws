package LW4_1.graphics

import java.lang.Math.pow
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

data class Edge(val startPoint: Point, val endPoint: Point) {
    val length: Double
        get() {
            return (sqrt(abs(startPoint.x - endPoint.x).pow(2) + abs(startPoint.y - endPoint.y).pow(2)))
        }
}