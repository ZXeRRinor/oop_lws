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
            if (translation == null) {
                translation = newWords[input]
            }
            if (translation != null) {
                println("$input => $translation")
            } else {
                println("Неизвестное слово $input. Введите перевод или пустую строку для отказа.")
                translation = readLine()
                if (translation != null && translation != "") {
                    newWords[input] = translation
                    println("Слово $input сохранено в словаре как $translation")
                } else {
                    println("Слово $input проигнорировано.")
                }
            }
        }
        input = readLine()
    }
    println("В словарь были внесены изменения. Хотите сохранить их перед выходом? [y/n]")
    input = null
    while (input != "y" && input != "n") {
        input = readLine()
        if (input == "y") {
            for (word in newWords) {
                File("src/LW2_3/dictionary").appendText("\n$word")
            }
        }
        if (input != "y" && input != "n") {
            println("Please input \'y\' for yes or \'n\' for no!")
        }
    }
}