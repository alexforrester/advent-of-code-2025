private var counter = 0
private const val roll = '@'

private enum class Compass { North, East, South, West }

fun main() {

    val input = readInput("Day04_test")

    val grid: List<List<Char>> = input.filter { it.isNotEmpty() }.map { it.toList() }

    if (grid.isEmpty()) {
        println("Error: Grid is empty. Check input file.")
        return
    }

    findRolls(grid)

    print("Answer: $counter")
}



fun findRolls(grid: List<List<Char>>) {

    if (grid.isEmpty()) return

    grid.forEachIndexed { listIndex, listOfChar ->

        if (listOfChar.isEmpty()) return@forEachIndexed

        listOfChar.forEachIndexed { charIndex, charItem ->

            Compass.entries.map { point ->

                var localCounter = 0

                when (point) {

                    Compass.North -> {

                            val rollCountAbove =
                                (maxOf(0, listIndex - 8) until listIndex).count { rowIndex ->
                                    grid[rowIndex].getOrNull(charIndex) == roll
                                }

                            localCounter += rollCountAbove

                    }

                    Compass.East -> {

                        val rollCountRight = (charIndex + 1..minOf(
                            listOfChar.size - 1,
                            charIndex + 8
                        )).count { colIndex ->
                            grid[listIndex].getOrNull(colIndex) == roll
                        }

                        localCounter += rollCountRight

                    }

                    Compass.South -> {

                        val rollCountBelow =
                            (listIndex + 1..minOf(grid.size - 1, listIndex + 8)).count { rowIndex ->
                                grid[rowIndex].getOrNull(charIndex) == roll
                            }

                        localCounter += rollCountBelow

                    }

                    Compass.West -> {

                        val rollCountLeft =
                            (maxOf(0, charIndex - 8) until charIndex).count { colIndex ->
                                grid[listIndex].getOrNull(colIndex) == roll
                            }

                        localCounter += rollCountLeft
                    }
                }

                if (localCounter < 4) {
                    counter += localCounter
                }
            }
        }
    }
}
