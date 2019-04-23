package LW5_3

import LW5_3.test.CompoundFractionTest

class CompoundFraction(intPart: Int = 0, rationalPart: Rational = Rational(0, 1)) {

    constructor(rationalPart: Rational) : this(0, rationalPart.numerator, rationalPart.denominator)
    constructor(intPart: Int, numerator: Int, denominator: Int) : this(intPart, Rational(numerator, denominator))

    var intPart = intPart
        private set

    var rationalPart = rationalPart
        private set

    init{
        this.normalize()
    }

    fun normalize() {
        if (rationalPart.numerator >= rationalPart.denominator) {
            intPart += rationalPart.numerator / rationalPart.denominator
            rationalPart = Rational(rationalPart.numerator % rationalPart.denominator, rationalPart.denominator)
        }
    }

    fun toRational() = Rational(intPart * rationalPart.denominator + rationalPart.numerator, rationalPart.denominator)

    override operator fun equals(other: Any?): Boolean {
        if (other is CompoundFraction) {
            return (other.intPart == intPart && other.rationalPart == rationalPart)
        }
        if (other is Rational) {
            return (this.toRational() == other)
        }
        if (other is Int && this.rationalPart == Rational()) {
            return other == this.intPart
        }
        return false
    }

    override fun hashCode(): Int {
        var result = intPart
        result = 31 * result + rationalPart.hashCode()
        return result
    }

}