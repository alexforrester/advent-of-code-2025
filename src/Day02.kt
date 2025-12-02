
private var counter = 0L

fun main() {

    val input = readInputString("Day02")
    val ids = input.split(",")

    val idEntriesMap = ids.associate { it.split("-").first() to it.split("-").last()}

    idEntriesMap.entries.forEach {

        val first = it.key.toLong()
        val second = it.value.toLong()

        for (numberEntry in first..second) {

            if (numberEntry.toString().length % 2 != 0) continue
            if (numberEntry.toString().isEmpty()) continue
            if (numberEntry.toString().length == 1) continue

            val possibleMatch = splitIntoAPair(numberEntry)

            if (possibleMatch.first == possibleMatch.second) {
                counter += "${possibleMatch.first}${possibleMatch.second}".toLong()
                println("possibleMatch.first = ${possibleMatch.first}")
                println("possibleMatch.second = ${possibleMatch.second}")
                println("counter now= $counter")
            }
        }
    }

    print("Answer: $counter")
}

private fun splitIntoAPair(number: Long) : Pair<Long, Long> {

    val digits = number.toString()
    val mid = digits.length / 2
    val firstHalf = digits.substring(0, mid).toLong()
    val secondHalf = digits.substring(mid).toLong()
    return Pair(firstHalf, secondHalf)
}