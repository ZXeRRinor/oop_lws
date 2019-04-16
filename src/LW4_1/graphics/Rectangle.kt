package LW4_1.graphics

class Rectangle(
    val leftTop: Point, val width: Double, val height: Double, override val fillColor: RGBColor,
    override val outlineColor: RGBColor
) :
    SolidShape {

    override val area: Double
        get() {
            return width * height
        }

    override val perimeter: Double
        get() {
            return 2 * width * height
        }

    fun getRightBottom(): Point {
        return Point(leftTop.x + width, leftTop.y + height)
    }

    override fun toString(): String {
        return ""
    }
}