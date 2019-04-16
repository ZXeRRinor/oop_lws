package LW4_1

import LW4_1.graphics.Canvas.Canvas
import LW4_1.graphics.LineSegment
import LW4_1.graphics.Point
import LW4_1.graphics.Shapes.Circle
import LW4_1.graphics.Shapes.Rectangle
import LW4_1.graphics.Shapes.Triangle
import java.awt.Color
import java.awt.Graphics
import javax.swing.JFrame
import javax.swing.WindowConstants

fun launch() {
    val canvas = Canvas("Laboratory Work No. 4", 800, 800)
    var inputLine: String = readLine() ?: ""
    while (inputLine != "quit") {
        try {
            val input = inputLine.split(' ')
            val command = input[0]
            val args = input.minus(input[0])
            when (command) {
                "rectangle" -> {
                    if (args.size == 6) {
                        val leftTopX = args[0].toDouble()
                        val leftTopY = args[1].toDouble()
                        val width = args[2].toDouble()
                        val height = args[3].toDouble()
                        val outlineColor = Color.decode("#${args[4]}")
                        val fillColor = Color.decode("#${args[5]}")
                        println(args)
                        Rectangle(Point(leftTopX, leftTopY), width, height, fillColor, outlineColor).draw(canvas)
                    } else {
                        throw NotEnoughArguments()
                    }
                }
                "triangle" -> {
                    if (args.size == 8) {
                        val v1X = args[0].toInt()
                        val v1Y = args[1].toInt()
                        val v2X = args[2].toInt()
                        val v2Y = args[3].toInt()
                        val v3X = args[4].toInt()
                        val v3Y = args[5].toInt()
                        val outlineColor = Color.decode("#${args[6]}")
                        val fillColor = Color.decode("#${args[7]}")
                        Triangle(Point(v1X, v1Y), Point(v2X, v2Y), Point(v3X, v3Y), fillColor, outlineColor)
                    } else {
                        throw NotEnoughArguments()
                    }
                }
                "circle" -> {
                    if (args.size == 5) {
                        val centerX = args[0].toInt()
                        val centerY = args[1].toInt()
                        val radius = args[2].toDouble()
                        val outlineColor = Color.decode("#${args[3]}")
                        val fillColor = Color.decode("#${args[4]}")
                        Circle(Point(centerX, centerY), radius, fillColor, outlineColor)
                    } else {
                        throw NotEnoughArguments()
                    }
                }
                "line" -> {
                    if (args.size == 5) {
                        val startX = args[0].toInt()
                        val startY = args[1].toInt()
                        val endX = args[2].toInt()
                        val endY = args[3].toInt()
                        val outlineColor = Color.decode("#${args[4]}")
                        LineSegment(Point(startX, startY), Point(endX, endY), outlineColor)
                    } else {
                        throw NotEnoughArguments()
                    }
                }
                "render" -> {
                    canvas.render()
                }
                else -> {

                }

            }
        } catch (e: Exception) {
            println("ERROR! ${e.message}")
        }
        inputLine = readLine() ?: ""
    }
}

fun main() {
    launch()
}