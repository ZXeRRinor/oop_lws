package LW5_3

class Rational(numerator: Int = 0, denominator: Int = 1) {
    init {
        if (denominator == 0) {
            throw ArithmeticException("Denominator of fraction can't be equals to zero")
        }
    }

    var numerator = numerator
        private set

    var denominator = denominator
        private set

    private fun gcd(num1: Int, num2: Int): Int {
        var a = num1
        var b = num2
        while (b != 0) {
            val temp = b
            b = a % b
            a = temp
        }
        return a
    }

    private fun lcm(num1: Int, num2: Int): Int {
        return num1 / gcd(num1, num2) * num2
    }

    fun reduce() {
        val divisor = gcd(this.numerator, this.denominator)
        this.numerator /= divisor
        this.denominator /= divisor
    }

    operator fun unaryMinus(): Rational {
        this.reduce()
        return Rational(-this.numerator, this.denominator)
    }

    operator fun unaryPlus(): Rational {
        this.reduce()
        return Rational(this.numerator, this.denominator)
    }

    operator fun plus(other: Rational): Rational {
        other.reduce()
        this.reduce()
        val commonDenominator = lcm(other.denominator, this.denominator)
        val summaryNumerator =
            other.numerator * (denominator / other.denominator) + this.numerator * (denominator / this.denominator)
        return Rational(summaryNumerator, commonDenominator)
    }

    operator fun minus(other: Rational): Rational {
        return this + (-other)
    }

//    operator fun times(other: Rational): Rational {
//
//    }
}