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

fun determinateLanguage(word: String): String {
    if (word[0].toLowerCase() in 'a'..'z') {
        return "en"
    }
    if (word[0].toLowerCase() in 'а'..'я') {
        return "ru"
    }
    return ""
}

fun dictionary(filepath: String) {
    val file = File(filepath)
    val words = readDictionaryFromFile(file)
    var newWords: Map<String, String> = mapOf()
    var input: String = readLine() ?: ""

    while (input != "...") {
        if (input[0].toLowerCase() in 'a'..'z' || input[0].toLowerCase() in 'а'..'я') {
            words.plus(newWords)
            var translation: String
            translation = when (determinateLanguage(input)) {
                "en" -> {
                    translateToRussian(input, words.plus(newWords))
                }

                "ru" -> {
                    translateToEnglish(input, words.plus(newWords))
                }
                else -> ""
            }
            if (translation != "") {
                println("$input => $translation")
            } else {
                println("Неизвестное слово \"$input\". Введите перевод или пустую строку для отказа.")
                translation = readLine() ?: ""
                if (translation != "") {
                    newWords = when (determinateLanguage(input)) {
                        "en" -> {
                            addNewWord(mapOf(translation to input), newWords)
                        }

                        "ru" -> {
                            addNewWord(mapOf(input to translation), newWords)
                        }
                        else -> newWords
                    }
                    println("Слово \"$input\" сохранено в словаре как \"$translation\"")
                } else {
                    println("Слово \"$input\" проигнорировано.")
                }
            }
        }
        input = readLine() ?: ""
    }
    askForSave(newWords, file)
}

fun askForSave(newWords: Map<String, String>, file: File) {
    if (newWords.isNotEmpty()) {
        println("В словарь были внесены изменения. Хотите сохранить их перед выходом? [y/n]")
        var input = ""
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