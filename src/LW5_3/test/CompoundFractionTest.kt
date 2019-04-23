package LW5_3.test

import LW5_3.CompoundFraction
import LW5_3.Rational
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assert

internal class CompoundFractionTest {
    @Test
    internal fun testSecondaryConstructors() {
        val compFraction1 = CompoundFraction(Rational(3, 5))
        assertEquals(CompoundFraction(0, 3, 5), compFraction1)
        val compFraction2 = CompoundFraction(10, Rational(3, 5))
        assertEquals(CompoundFraction(10, 3, 5), compFraction2)
    }

    @Test
    internal fun normalize() {
        val compFraction = CompoundFraction(Rational(11, 5))
        compFraction.normalize()
        assertEquals(CompoundFraction(2, 1, 5), compFraction)
    }

    @Test
    internal fun toRationalTest() {
        val rat1 = Rational(17, 14)
        val compFract = CompoundFraction(1, 3, 14)
        assert(compFract.equals(rat1))
    }

    @Test
    internal fun equalsTest() {
        val rat1 = Rational(17, 14)
        val compFract1 = CompoundFraction(1, 3, 14)
        val compFract2 = CompoundFraction(2, 14, 14)
        val compFract3 = CompoundFraction(3)
        assert(compFract1.equals(rat1))
        assert(compFract2.equals(3))
        assert(compFract2 == compFract3)
    }
}