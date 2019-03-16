package LW2_2.test

import LW2_2.htmlDecode
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class HTMLDecodeKtTest {

    @Test
    fun htmlDecode_blankLine_test() {
        assertEquals("", htmlDecode(""))
    }

    @Test
    fun htmlDecode_onlySymbols_test() {
        assertEquals("&<>", htmlDecode("&amp;&lt;&gt;"))
    }

    @Test
    fun htmlDecode_oneSymbol_test() {
        assertEquals("&", htmlDecode("&amp;"))
    }

    @Test
    fun htmlDecode_noSymbols_test() {
        assertEquals("hello world", htmlDecode("hello world"))
    }

    @Test
    fun htmlDecode_symbolAtStartOfString_test() {
        assertEquals("&hello world", htmlDecode("&amp;hello world"))
    }

    @Test
    fun htmlDecode_symbolAtEndOfString_test() {
        assertEquals("hello world&", htmlDecode("hello world&amp;"))
    }

    @Test
    fun htmlDecode_someSymbolsAtEnd_test() {
        assertEquals("hello world&&&&", htmlDecode("hello world&amp;&amp;&amp;&amp;"))
    }
}