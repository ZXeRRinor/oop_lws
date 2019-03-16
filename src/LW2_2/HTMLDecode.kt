package LW2_2

fun htmlDecode(in_str: String): String {
    var result = in_str
    val replacements: Map<String, Char> = mapOf(
        "apos" to '\'',
        "amp" to '&',
        "lt" to '<',
        "gt" to '>',
        "quot" to '\"'
    )
    for (i in replacements.keys) {
        result = result.replace("&$i;", replacements[i]!!.toString())
    }
    return result
}