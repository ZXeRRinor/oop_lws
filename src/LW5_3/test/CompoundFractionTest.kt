package LW5_3.test

import LW5_3.CompoundFraction
import LW5_3.Rational
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

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
}