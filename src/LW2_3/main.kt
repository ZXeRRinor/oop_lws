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

fun translateToRussian(word: String, wordList: Map<String, String>): String = wordList[word] ?: ""

fun translateToEnglish(word: String, wordList: Map<String, String>): String {
    for (index in wordList.keys) {
        if (wordList[index] == word) {
            return index
        }
    }
    return ""
}

fun addNewWord(word: Map<String, String>, wordList: Map<String, String>): Map<String, String> = wordList.plus(word)

fun dictionary(filepath: String) {
    val words = readDictionaryFromFile(filepath)
    var newWords: Map<String, String> = mapOf()
    var input: String? = readLine()
    while (input != "...") {
        if (input != null) {
            words.plus(newWords)
            var translation = translateToRussian(input, words.plus(newWords))
            if (translation != "") {
                println("$input => $translation")
            } else {
                println("Неизвестное слово $input. Введите перевод или пустую строку для отказа.")
                translation = readLine() ?: ""
                if (translation != "") {
                    newWords = addNewWord(mapOf(input to translation), newWords)
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
    if (!newWords.isEmpty()) {
        println("В словарь были внесены изменения. Хотите сохранить их перед выходом? [y/n]")
        var input: String? = null
        while (input != "y" && input != "n") {
            input = readLine()
            if (input == "y") {
                val file = File(filepath)
                for (word in newWords) {
                    if (file.length() != 0L) {
                        file.appendText("\n$word")
                    } else {
                        file.appendText("$word")
                    }
                }
            }
            if (input != "y" && input != "n") {
                println("Please input \'y\' for yes or \'n\' for no!")
            }
        }
    }
}

fun main(args: Array<String>) {
    println("Введите имя файла (оставьте пустым для \'dictionary\'): ")
    val filename = readLine() ?: ""
    dictionary(
        "src/LW2_3/${if (filename != "") {
            filename
        } else {
            "dictionary"
        }}"
    )
}