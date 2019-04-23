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

    private fun lcm(num1: Int, num2: Int): Int = num1 / gcd(num1, num2) * num2

    private fun getCommonDenominator(other: Rational): Int = lcm(other.denominator, denominator)

    private fun getInverted() = Rational(denominator, numerator)

    private fun inverse() {
        val swap = numerator
        numerator = denominator
        denominator = swap
    }

    fun toDouble() = numerator.toDouble() / denominator.toDouble()

    fun toInt() = toDouble().toInt()

    private fun toDenominator(denominator: Int) {
        if (denominator >= this.denominator && denominator % this.denominator == 0) {
            numerator *= denominator / this.denominator
            this.denominator = denominator
        } else {
            TODO("throw exception if denominator is not satisfying")
        }
    }

    fun reduce() {
        val thisReduced = this.getReduced()
        this.numerator = thisReduced.numerator
        this.denominator = thisReduced.denominator
    }

    private fun getReduced(): Rational {
        val divisor = gcd(numerator, denominator)
        val resultNumerator = numerator / divisor
        val resultDenominator = denominator / divisor
        return Rational(resultNumerator, resultDenominator)
    }

    operator fun unaryMinus(): Rational {
        this.reduce()
        return Rational(-numerator, denominator)
    }

    operator fun unaryPlus(): Rational {
        this.reduce()
        return Rational(numerator, denominator)
    }

    operator fun plus(other: Rational): Rational {
        other.reduce()
        this.reduce()
        val commonDenominator = getCommonDenominator(other)
        val summaryNumerator =
            other.numerator * (commonDenominator / other.denominator) + numerator * (commonDenominator / denominator)
        return Rational(summaryNumerator, commonDenominator)
    }

    operator fun plus(other: Int) = this + other.toRational()

    operator fun inc() = Rational(numerator + denominator, denominator)

    operator fun dec() = Rational(numerator - denominator, denominator)

    operator fun minus(other: Rational): Rational {
        return this + (-other)
    }

    operator fun minus(other: Int) = this - other.toRational()

    operator fun times(other: Rational): Rational {
        this.reduce()
        other.reduce()
        val result = Rational(numerator * other.numerator, denominator * other.denominator)
        result.reduce()
        return result
    }

    operator fun times(other: Int) = this * other.toRational()

    operator fun div(other: Rational) = this * other.getInverted()

    operator fun div(other: Int) = this / other.toRational()

    override fun equals(other: Any?): Boolean {
        if (other is Rational) {
            return (this - other).numerator == 0
        }
        if (other is Int && numerator % denominator == 0) {
            return other == numerator / denominator
        }
        return false
    }

    operator fun compareTo(other: Rational) = (this - other).numerator
}