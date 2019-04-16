package LW4_1.graphics

import java.awt.Color

interface Shape {
    val outlineColor: Color
    val perimeter: Double
    val area: Double
    override fun toString(): String
}