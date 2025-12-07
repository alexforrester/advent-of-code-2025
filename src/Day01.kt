import kotlin.math.abs

private var counter = 0
private var current = 50

enum class Direction{L, R}
data class Dial(val direction: Direction, val valueToChange: Int)

fun main() {

    val input = readInput("Day01")

    // convert the lines to dials
    val dials = convertToDials(input)

    processDials(dials)

    print("Answer: $counter")
}


private fun convertToDials(inputLines: List<String>) : List<Dial> {
    return inputLines.map { line ->
        val direction = (Direction.valueOf(line.substring(0, 1)))
        val valueToChange = line.substring(1, line.length).toInt()
        Dial(direction, valueToChange)
    }
}

private fun processDials(dials: List<Dial>) {

    dials.forEach { dial ->
        when (dial.direction) {
            Direction.L -> putDown(dial.valueToChange).also {
                if (it == 0) ++counter
                current = it
            }

            Direction.R -> putUp( dial.valueToChange).also {
                if (it == 0) ++counter
                current = it
            }
        }
    }
}

private fun putUp(valueToIncrement: Int): Int {

    val correctedValue = valueToIncrement % 100

    val intermediate = correctedValue + current

    val result = if (intermediate == 0) {
        0
    } else if (intermediate > 99) {
        val check = intermediate - 100
        check
    } else {
        intermediate
    }

    return result
}

private fun putDown(valueToDecrement: Int) : Int {

    val correctedValue = valueToDecrement % 100
    val intermediate = current - correctedValue

    val result = if (intermediate == 0) {
        println(0)
            0
    }
    else if (intermediate < 0) {
        val check = (100 - (abs(intermediate)))
        check
    } else {
        intermediate
    }

    return result
}

