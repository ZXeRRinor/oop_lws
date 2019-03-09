package LW2_3

import java.io.File

fun readDictionaryFromFile(filepath: String): Map<String, String> {
    val words: MutableMap<String, String> = mutableMapOf()
    val file = File(filepath)
    file.createNewFile()
    file.forEachLine {
        val line = it.split('=')
        words[line[0]] = line[1]
    }
    return words.toMap()
}

fun dictionary(filepath: String) {
    val words = readDictionaryFromFile(filepath)
    val newWords: MutableMap<String, String> = mutableMapOf()
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
    exitWithDictionarySavingSelect(newWords, filepath)
}

fun exitWithDictionarySavingSelect(newWords: Map<String, String>, filepath: String) {
    println("В словарь были внесены изменения. Хотите сохранить их перед выходом? [y/n]")
    var input: String? = null
    while (input != "y" && input != "n") {
        input = readLine()
        if (input == "y") {
            for (word in newWords) {
                File(filepath).appendText("\n$word")
            }
        }
        if (input != "y" && input != "n") {
            println("Please input \'y\' for yes or \'n\' for no!")
        }
    }
}

fun main(args: Array<String>) {
  dictionary("src/LW2_3/dictionary")
}