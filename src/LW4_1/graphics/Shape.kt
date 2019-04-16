package LW4_1.graphics

interface Shape {
    val outlineColor: RGBColor
    fun getArea(): Double
    fun getPerimeter(): Double
    override fun toString(): String
}