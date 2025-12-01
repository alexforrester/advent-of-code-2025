import current
import kotlin.math.abs

var counter = 0
var current = 50
enum class Direction{L, R}
data class Dial(val direction: Direction, val valueToChange: Int)

fun main() {

    val input = readInput("Day01")

    // convert the lines to dials
    val dials = convertToDials(input)

    processDials(dials)

    // Read the input from the `src/Day01.txt` file.
    print("Answer: $counter")
    print("")
}


fun convertToDials(inputLines: List<String>) : List<Dial> {
    return inputLines.map { line ->
        val direction = (Direction.valueOf(line.substring(0, 1)))
        val valueToChange = line.substring(1, line.length).toInt()
        Dial(direction, valueToChange)
    }
}

fun processDials(dials: List<Dial>) {

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

fun putUp(valueToIncrement: Int): Int {

    println("----------------------------------")

    println("valueToIncrement: $valueToIncrement")
    val correctedValue = valueToIncrement % 100
    println("correctedValue: $correctedValue")

    val intermediate = correctedValue + current

    println("Current: $current")
    println("Intermediate: $intermediate")

    val result = if (intermediate == 0) {
        0
    } else if (intermediate > 99) {
        val check = intermediate - 100
        println("Answer to Value incremented: $check")
        check
    } else {
        println("Answer to Value incremented: $intermediate")
        intermediate
    }

    return result
}

fun putDown(valueToDecrement: Int) : Int {

    println("----------------------------------")

    println("valueToDecrement: $valueToDecrement")
    val correctedValue = valueToDecrement % 100
    println("correctedValue: $correctedValue")

    val intermediate = current - correctedValue

    println("Current: $current")
    println("Intermediate: $intermediate")

    val result = if (intermediate == 0) {
        println(0)
            0
    }
    else if (intermediate < 0) {
        val check = (100 - (abs(intermediate)))
        println("Answer to Value decremented: $check")
        check
    } else {
        println("Answer to Value decremented: $intermediate")
        intermediate
    }

    return result
}

