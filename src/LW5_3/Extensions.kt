package LW5_3

fun Int.toRational() = Rational(this)
operator fun Int.compareTo(other: Rational) = other.compareTo(this)