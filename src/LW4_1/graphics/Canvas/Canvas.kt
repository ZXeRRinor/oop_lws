package LW4_1.graphics.Canvas

import LW4_1.graphics.*
import LW4_1.graphics.Shapes.*
import java.awt.Color
import java.awt.Graphics
import java.util.*
import javax.swing.JFrame
import javax.swing.WindowConstants
import kotlin.math.round


class Canvas(val title: String, val width: Int, val height: Int) {

    private val drawQueue: Queue<Shape> = ArrayDeque<Shape>()

    inner class Painter(title: String, width: Int, height: Int) : JFrame(title) {

        init {
            layout = null
            setSize(width, height)
            isVisible = true
            this.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        }

        override fun paint(g: Graphics) {
            while (drawQueue.size > 0) {
                val shape = drawQueue.remove()
                with(g) {
                    color = if (shape is SolidShape) {
                        shape.fillColor
                    } else {
                        Color.BLACK
                    }
                    if (shape is Rectangle) {
                        fillRect(
                            round(shape.leftTop.x).toInt(),
                            round(shape.leftTop.y).toInt(),
                            round(shape.width).toInt(),
                            round(shape.height).toInt()
                        )
                    }
                    if (shape is LineSegment) {
                        drawLine(
                            round(shape.startPoint.x).toInt(),
                            round(shape.startPoint.y).toInt(),
                            round(shape.endPoint.x).toInt(),
                            round(shape.endPoint.y).toInt()
                        )
                    }
                    if (shape is Circle) {
                        drawOval(
                            round(shape.center.x).toInt(),
                            round(shape.center.y).toInt(),
                            round(shape.radius).toInt(),
                            round(shape.radius).toInt()
                        )
                    }
                    if (shape is Triangle) {
                        fillPolygon(
                            intArrayOf(
                                round(shape.vertex1.x).toInt(),
                                round(shape.vertex2.x).toInt(),
                                round(shape.vertex2.x).toInt()
                            ),
                            intArrayOf(
                                round(shape.vertex1.y).toInt(),
                                round(shape.vertex2.y).toInt(),
                                round(shape.vertex2.y).toInt()
                            ),
                            3
                        )
                    }
                }
            }
        }
    }

    fun render() {
        Painter(title, width, height)
    }

    fun drawShape(sh: Shape) {
        drawQueue.add(sh)
    }
}
