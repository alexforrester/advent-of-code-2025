data class Calculation(val numbers: List<Int>, val operation: Operation)
enum class Operation { Add, Multiply }

var total = 0L

val columnMap = mutableMapOf<Int, MutableList<Any>>()

fun main() {

    val input = readInput("Day06")

    input.forEach { line ->
        val normalizedLine = line.replace("\\s+".toRegex(), " ").trim()
        val values = normalizedLine.split(" ")
        values.forEachIndexed { index, value ->
            columnMap.getOrPut(index) { mutableListOf() }.add(value)
        }
    }

    for ((columnIndex, columnValues) in columnMap) {

        var localTotal = 0L

        val operation = columnValues.last()
        val calculationNumbers = columnValues.subList(0, columnValues.size - 1).map {it.toString().toLong()}

        if (operation == "+") {
            localTotal = calculationNumbers.reduce { acc, num -> acc + num }
        } else if (operation == "*") {
            localTotal = calculationNumbers.reduce { acc, num -> acc * num }
        }

        total += localTotal
        println("Local Total: $localTotal")
    }

    println("Total: $total")

}


