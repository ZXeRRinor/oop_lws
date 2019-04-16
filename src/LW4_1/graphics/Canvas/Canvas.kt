package LW4_1.graphics.Canvas

import java.awt.Color
import java.awt.Graphics
import javax.swing.JFrame
import javax.swing.WindowConstants


class Canvas(title: String, width: Int, height: Int) : JFrame(title) {

    init {
        layout = null
        setSize(width, height)
        isVisible = true
        this.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
    }

    override fun paint(g: Graphics) {
        with(g) {
            color = Color.RED
            fillRect(50, 50, 300, 300)
        }
    }
}
