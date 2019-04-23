package LW5_3

class CompoundFraction(intPart: Int = 0, numerator: Int = 0, denominator: Int = 1) : Rational(numerator, denominator) {

    constructor(rationalPart: Rational) : this(0, rationalPart.numerator, rationalPart.denominator)
    constructor(intPart: Int, rationalPart: Rational) : this(intPart, rationalPart.numerator, rationalPart.denominator)

    var intPart = intPart
        private set

    fun normalize() {
        if(numerator > denominator) {
            intPart += numerator / denominator
            numerator %= denominator
        }
    }

}