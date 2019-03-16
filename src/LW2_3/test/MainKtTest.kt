package LW2_3.test

import LW2_3.*
import org.junit.After
import org.junit.Ignore
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class MainKtTest {

    @Test
    fun determinateLanguageTest() {
        assertEquals("en", determinateLanguage("hello"))
        assertEquals("en", determinateLanguage("Hello"))
        assertEquals("ru", determinateLanguage("привет"))
        assertEquals("ru", determinateLanguage("Привет"))
        assertEquals("", determinateLanguage("123"))
    }

    @Test
    fun createDictionaryFileTest() {
        val file = File("src/LW2_3/test/test_dict")
        createDictionaryFile(file)
        assert(file.exists())
        file.deleteOnExit()
    }

    @Test
    fun saveDictionaryToFileTest() {
        val file = File("src/LW2_3/test/test_dict")
        val dict: Map<String, String> = mapOf("hello" to "привет", "day" to "день")
        createDictionaryFile(file)
        saveDictionaryToFile(dict, file)
        val reader = file.bufferedReader()
        assertEquals("hello=привет", reader.readLine())
        file.deleteOnExit()
    }

    @After
    fun deleteTestFile() {
        val file = File("src/LW2_3/test/test_dict")
        val file2 = File("src/LW2_3/test/test_dictionary.txt")
        file.delete()
        file2.delete()
    }

    @Test
    fun readDictionaryFromFileTest() {
        val emptyMap: Map<String, String> = mapOf()
        assertEquals(
            mapOf("hello" to "привет", "day" to "день"),
            readDictionaryFromFile(File("src/LW2_3/test/test_dictionary"))
        )
        assertEquals(readDictionaryFromFile(File("src/LW2_3/test/test_dictionary.txt")), emptyMap)
        File("src/LW2_3/test/test_dictionary.txt").deleteOnExit()
    }

    @Test
    fun translateToRussianTest() {
        val dict: Map<String, String> = mapOf("hello" to "привет", "day" to "день")
        val emptyDict: Map<String, String> = mapOf()
        assertEquals("привет", translateToRussian("hello", dict))
        assertEquals("", translateToRussian("hello", emptyDict))
    }

    @Test
    fun translateToEnglishTest() {
        assertEquals("", translateToEnglish("ночь", mapOf("hello" to "привет", "day" to "день")))
        assertEquals("day", translateToEnglish("день", mapOf("hello" to "привет", "day" to "день")))
    }

    @Test
    fun addNewWordTest() {
        assertEquals(
            mapOf("horse" to "лошадь", "hello" to "привет", "day" to "день"),
            addNewWord(mapOf("hello" to "привет"), mapOf("horse" to "лошадь", "day" to "день"))
        )
    }
}