package LW2_2

fun htmlDecode(in_str: String): String {
    var rangeStart = -1
    var rangeEnd: Int
    var result = in_str
    var replacement:String
    var i = 0
    while (i < result.length) {
        if (i >= result.length) {
            break
        }
        if (result[i] == '&') {
            rangeStart = i
        }
        if (result[i] == ';') {
            rangeEnd = i
            if ((rangeStart != -1) and (rangeEnd - rangeStart > 1)) {
                var lengthOfReplacement = 0
                when (result.substring(rangeStart + 1, rangeEnd)) {
                    "quot" -> {
                        replacement = "\""
                        lengthOfReplacement = 2 + 4 - 1
                    }
                    "apos" -> {
                        replacement = "\'"
                        lengthOfReplacement = 2 + 4 - 1
                    }
                    "lt" -> {
                        replacement = "<"
                        lengthOfReplacement = 2 + 2 - 1
                    }
                    "gt" -> {
                        replacement = ">"
                        lengthOfReplacement = 2 + 2 - 1
                    }
                    "amp" -> {
                        replacement = "&"
                        lengthOfReplacement = 2 + 3 - 1
                    }
                    else -> replacement = ""
                }
                result = result.replaceRange(rangeStart, rangeEnd + 1, replacement)
                i -= lengthOfReplacement

            }
            rangeStart = -1
        }
        i++
    }
    return result
}