package LW2_3

import java.io.File

fun readDictionaryFromFile(file: File): Map<String, String> {
    val words: MutableMap<String, String> = mutableMapOf()
    if (file.exists()) {
        file.forEachLine {
            val line = it.split('=')
            if (line.size > 1) {
                words[line[0]] = line[1]
            }
        }
    } else {
        createDictionaryFile(file)
    }
    return words.toMap()
}

fun createDictionaryFile(file: File): Boolean = file.createNewFile()

fun translateToRussian(word: String, wordList: Map<String, String>): String = wordList[word.toLowerCase()] ?: ""

fun translateToEnglish(word: String, wordList: Map<String, String>): String {
    if (wordList.isNotEmpty()) {
        for (index in wordList.keys) {
            if (wordList[index] == word.toLowerCase()) {
                return index
            }
        }
    }
    return ""
}

fun addNewWord(word: Map<String, String>, wordList: Map<String, String>): Map<String, String> = wordList.plus(word)

fun dictionary(filepath: String) {
    val file = File(filepath)
    val words = readDictionaryFromFile(file)
    var newWords: Map<String, String> = mapOf()
    var input: String = readLine() ?: ""
    while (input != "...") {
        if (input[0].toLowerCase() in 'a'..'z' || input[0].toLowerCase() in 'а'..'я') {
            words.plus(newWords)
            var translation = ""
            if (input[0].toLowerCase() in 'a'..'z') {
                translation = translateToRussian(input, words.plus(newWords))
            }
            if (input[0].toLowerCase() in 'а'..'я') {
                translation = translateToEnglish(input, words.plus(newWords))
            }
            if (translation != "") {
                println("$input => $translation")
            } else {
                println("Неизвестное слово \"$input\". Введите перевод или пустую строку для отказа.")
                translation = readLine() ?: ""
                if (translation != "") {
                    if (input[0].toLowerCase() in 'а'..'я') {
                        newWords = addNewWord(mapOf(translation to input), newWords)
                    }
                    if (input[0].toLowerCase() in 'a'..'z') {
                        newWords = addNewWord(mapOf(input to translation), newWords)
                    }
                    println("Слово \"$input\" сохранено в словаре как \"$translation\"")
                } else {
                    println("Слово \"$input\" проигнорировано.")
                }
            }
        }
        input = readLine() ?: ""
    }
    if (newWords.isNotEmpty()) {
        println("В словарь были внесены изменения. Хотите сохранить их перед выходом? [y/n]")
        input = ""
        while (input != "y" && input != "n") {
            input = readLine() ?: ""
            if (input == "y") {
                saveDictionaryToFile(newWords, file)
            }
            if (input != "y" && input != "n") {
                println("Please input \'y\' for yes or \'n\' for no!")
            }
        }
    }
}

fun saveDictionaryToFile(newWords: Map<String, String>, file: File) {
    if (file.exists() && newWords.isNotEmpty()) {
        for (word in newWords) {
            if (file.length() != 0L) {
                file.appendText("\n$word")
            } else {
                file.appendText("$word")
            }
        }
    }
}

fun main(args: Array<String>) {
    println("Введите имя файла (оставьте пустым для \"dictionary\"): ")
    val filename = readLine() ?: ""
    println("Введите слово для перевода: ")
    dictionary(
        "src/LW2_3/${if (filename != "") {
            filename
        } else {
            "dictionary"
        }}"
    )
}