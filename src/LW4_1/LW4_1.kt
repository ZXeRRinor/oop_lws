package LW4_1

import java.awt.*
import javax.swing.*

class Painter(title: String, width: Int, height: Int) : JFrame(title) {

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

fun main() {
    Painter("LW4_1", 400, 400)
}