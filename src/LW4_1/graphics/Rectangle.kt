package LW4_1.graphics

class Rectangle(
    val leftTop: Point, val width: Double, val height: Double, override val fillColor: RGBColor,
    override val outlineColor: RGBColor
) :
    SolidShape {

    fun getRightBottom(): Point {
        return Point(leftTop.x + width, leftTop.y + height)
    }

    override fun getArea(): Double {
        return width * height
    }

    override fun getPerimeter(): Double {
        return 2 * width * height
    }

    override fun toString(): String {
        return ""
    }
}