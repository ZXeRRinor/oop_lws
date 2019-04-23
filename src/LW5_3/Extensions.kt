package LW5_3

fun Int.toRational() = Rational(this)
operator fun Int.compareTo(other: Rational) = other.compareTo(this)
fun Int.equals(other: Rational) = other == this.toRational()