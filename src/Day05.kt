

fun main() {

    val input = readInput("Day05")

    val blankLine = input.find { it.isEmpty() }

    val listOfFruitRanges = input.subList(0, input.indexOf(blankLine))
    val listOfFruits = input.subList(input.indexOf(blankLine) + 1, input.size)

    val listOfFruitsFromRanges = mutableSetOf<String>()

    listOfFruitRanges.map { fruitRange ->

        val (startFruit, endFruit) = fruitRange.split("-").map { it.toLong() }

        listOfFruits.forEach { fruit ->

            val fruitToLong = fruit.toLong()

            if (fruitToLong >= startFruit && fruitToLong <= endFruit) {
                listOfFruitsFromRanges.add(fruit)
            }
        }

    }

    println("Answer: $listOfFruitsFromRanges.size")
}