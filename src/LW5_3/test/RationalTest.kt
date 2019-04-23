package LW5_3.test

import LW5_3.CompoundFraction
import LW5_3.Rational
import LW5_3.toRational
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RationalTest {

    @Test
    fun toDouble() {
        assertEquals(0.8, Rational(4, 5).toDouble())
    }

    @Test
    fun unaryMinus() {
        val rat1 = Rational(12, 14)
        assertEquals(Rational(-12, 14), -rat1)
        assertEquals(Rational(-6, 7), -rat1)
    }

    @Test
    fun unaryPlus() {
        val rat1 = Rational(12, 14)
        assertEquals(Rational(12, 14), +rat1)
        assertEquals(Rational(6, 7), +rat1)
    }

    @Test
    fun plus() {
        val rat1 = Rational(8, 5)
        assertEquals(Rational(15, 5), rat1 + Rational(7, 5))
        assertEquals(Rational(3, 1), rat1 + Rational(7, 5))
        assertEquals(3.toRational(), rat1 + Rational(7, 5))
    }

    @Test
    fun plus1() {
        val rat1 = Rational(8, 5)
        assertEquals(Rational(18, 5), rat1 + 2)
    }

    @Test
    fun minus() {
        val rat1 = Rational(8, 5)
        assertEquals(Rational(4, 5), rat1 - Rational(4, 5))
        assertEquals(Rational(-6, 5), rat1 - Rational(14, 5))
    }

    @Test
    fun minus1() {
        val rat1 = Rational(8, 5)
        assertEquals(Rational(-2, 5), rat1 - 2)
        assertEquals(Rational(3, 5), rat1 - 1)
    }

    @Test
    fun times() {
        val rat1 = Rational(2, 5)
        assertEquals(Rational(2, 15), rat1 * Rational(2, 6))
        assertEquals(Rational(-2, 15), rat1 * Rational(-2, 6))
    }

    @Test
    fun times1() {
        val rat1 = Rational(2, 5)
        assertEquals(Rational(4, 5), rat1 * 2)
        assertEquals(Rational(-4, 5), rat1 * -2)
    }

    @Test
    fun div() {
        val rat1 = Rational(2, 5)
        assertEquals(Rational(2, 15), rat1 / Rational(6, 2))
        assertEquals(Rational(-2, 15), rat1 / Rational(-6, 2))
    }

    @Test
    fun div1() {
        val rat1 = Rational(12, 14)
        assertEquals(Rational(3, 7), rat1 / 2)
    }

    @Test
    fun equals1() {
        val rat1 = Rational(12, 14)
        val rat2 = Rational(5, 3)
        val rat3 = Rational(28, 14)
        assertEquals(true, Rational(6, 7) == rat1)
        assertEquals(true, Rational(5, 3) == rat2)
        assertEquals(true, rat3.equals(2))
        assertEquals(true, rat3 == rat3)
    }

    @Test
    fun compareTo() {
        val rat1 = Rational(11, 14)
        val rat2 = Rational(9, 14)
        assert(rat2 < rat1)
        assert(!(rat1 < rat1))
        assert(rat2 <= rat1)
        assert(!(rat1 <= rat2))
        assert(rat1 >= rat2)
        assert(!(rat2 >= rat1))
        assert(rat1 > rat2)
        assert(!(rat2 > rat2))
    }

    @Test
    fun plusAssign() {
        var rat1 = Rational(11, 14)
        rat1 += Rational(1, 14)
        assertEquals(Rational(6, 7), rat1)
    }

    @Test
    fun minusAssign() {
        var rat1 = Rational(11, 14)
        rat1 -= Rational(1, 14)
        assertEquals(Rational(5, 7), rat1)
    }

    @Test
    fun timesAssign() {
        var rat1 = Rational(2, 5)
        rat1 *= Rational(2, 6)
        assertEquals(Rational(2, 15), rat1)
    }

    @Test
    fun divAssign() {
        var rat1 = Rational(2, 5)
        rat1 /= Rational(6, 2)
        assertEquals(Rational(2, 15), rat1)
    }

    @Test
    fun toCompoundFraction() {
        val rat1 = Rational(17, 14)
        assert(CompoundFraction(1, 3, 14) == rat1.toCompoundFraction())
    }

    @Test
    fun toString1() {
        val rat1 = Rational(11, 14)
        assertEquals("11/14", rat1.toString())
    }

    @Test
    fun parseFromCorrectString() {
        val rat1 = Rational(11, 14)
        val rat2 = Rational()
        rat2.parseFromString("11/14")
        assertEquals(rat1, rat2)
    }

    @Test
    fun parseFromStringWithSlashesMoreThanOne() {
        val rat1 = Rational(11, 14)
        val rat3 = Rational()
        rat3.parseFromString("11/14/15/16/17")
        assertNotEquals(rat1, rat3)
    }

    @Test
    fun parseFromStringWithoutSlashesAndNumbers() {
        val rat1 = Rational(11, 14)
        val rat4 = Rational()
        rat4.parseFromString("hello")
        assertNotEquals(rat1, rat4)
    }

    @Test
    fun parseFromEmptyString() {
        val rat1 = Rational(11, 14)
        val rat4 = Rational()
        rat4.parseFromString("")
        assertNotEquals(rat1, rat4)
    }

    @Test
    fun parseFromStringWithAlphaCharsDividedBySlash() {
        val rat1 = Rational(11, 14)
        val rat4 = Rational()
        assertThrows(java.lang.NumberFormatException::class.java) { rat4.parseFromString("hello/world") }
    }
}