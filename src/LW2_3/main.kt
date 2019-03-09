package LW2_3

import java.io.File

fun main(args: Array<String>) {
    val words: MutableMap<String, String> = mutableMapOf()
    val newWords: MutableMap<String, String> = mutableMapOf()
    File("src/LW2_3/dictionary").forEachLine {
        val line = it.split('=')
        words[line[0]] = line[1]
    }
    var input: String? = readLine()
    while (input != "...") {
        if (input != null) {
            var translation: String? = words[input]
            if (translation != null) {
                translation = newWords[input]
            }
            if (translation != null) {
                println("$input => $translation")
            } else {
                println("Неизвестное слово $input. Введите перевод или пустую строку для отказа.")
                translation = readLine()
                if (translation != null && translation != "") {
                    File("src/LW2_3/dictionary").appendText("\n$input=$translation")
                    newWords[input] = translation
                }
            }
        }
        input = readLine()
    }

}