package LW2_4

import kotlin.math.ceil
import kotlin.math.sqrt

fun generatePrimeNumbersSet(max: Int): Set<Int> {
    val primeNumbers: MutableSet<Int> = mutableSetOf()
    val numbers: Array<Boolean> = Array(max + 1) { true }
    var i = 4
    while (i < max) {
        numbers[i] = false
        i += 2
    }
    val sqrtOfMax = ceil(sqrt(max.toDouble())).toInt()
    for (i in 3..sqrtOfMax) {
        if (numbers[i] && sqrtOfMax >= i) {
            var j: Long = (i * i).toLong()
            while (j <= max) {
                numbers[j.toInt()] = false
                j += i * 2
            }
        }
    }
    for (i in 2..max) {
        if (numbers[i]) {
            primeNumbers.add(i)
        }
    }
    return (primeNumbers)
}