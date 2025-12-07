
data class Bound(val lower: Long, val upper: Long)

fun main() {

    val input = readInput("Day05")

    val blankLine = input.find { it.isEmpty() }

    val listOfFruitRanges = input.subList(0, input.indexOf(blankLine))

    val boundList = mutableListOf<Bound>()

    listOfFruitRanges.map { fruitRange ->

        val (startFruit, endFruit) = fruitRange.split("-").map { it.toLong() }
        boundList.add(Bound(startFruit, endFruit))
    }

    val sortedBounds = boundList.sortedBy { it.lower }

    val mergedBounds = mutableListOf<Bound>()

    sortedBounds.forEach { current ->
        if (mergedBounds.isEmpty()) {
            mergedBounds.add(current)
        } else {
            val last = mergedBounds.last()

            if (current.lower <= last.upper + 1) {
                // Merge by extending the upper bound
                mergedBounds[mergedBounds.lastIndex] = Bound(
                    last.lower,
                    maxOf(last.upper, current.upper)
                )
            } else {
                mergedBounds.add(current)
            }
        }
    }

    val totalCount = mergedBounds.sumOf { bound ->
        bound.upper - bound.lower + 1
    }

    println("Total count: $totalCount")
}