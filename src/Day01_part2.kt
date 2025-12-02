import kotlin.math.abs

private var counter = 0
var throughDials = 0
private var current = 50

fun main() {

    val input = readInput("Day01")

    // convert the lines to dials
    val dials = convertToDials(input)

    processDials(dials)

    // Read the input from the `src/Day01.txt` file.
    println("Counter Answer: $counter")
    println("Through Dials Answer: $throughDials")
    println("Answer: ${counter + throughDials}")
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

    println("----------------------------------")

    println("valueToIncrement: $valueToIncrement")

    var revolutions = valueToIncrement / 100

    println("revolutions: $revolutions")

    if (revolutions > 0) {
        throughDials += revolutions
    }

    val correctedValue = valueToIncrement % 100
    println("correctedValue: $correctedValue")

    val intermediate = correctedValue + current

    println("Current: $current")
    println("Intermediate: $intermediate")

    val result = if (intermediate == 0) {
        println("Returning 0 from perfect match")
        0
    } else if (intermediate > 99) {
        val check = intermediate - 100
        if (check != 0) throughDials++
        println("Answer to Value incremented: $check")
        check
    } else {
        println("Answer to Value incremented: $intermediate")
        intermediate
    }

    return result
}

private fun putDown(valueToDecrement: Int) : Int {

    println("----------------------------------")

    println("valueToDecrement: $valueToDecrement")

    var revolutions = valueToDecrement / 100
    println("revolutions: $revolutions")

    if (revolutions > 0) {
        throughDials += revolutions
    }

    val correctedValue = valueToDecrement % 100
    println("correctedValue: $correctedValue")

    val intermediate = current - correctedValue

    println("Current: $current")
    println("Intermediate: $intermediate")

    val result = if (intermediate == 0) {
        println("Returning 0 from perfect match")
        0
    }
    else if (intermediate < 0) {
        val check = (100 - (abs(intermediate)))
        if (check != 0) throughDials++
        println("Answer to Value decremented: $check")
        check
    } else {
        println("Answer to Value decremented: $intermediate")
        intermediate
    }

    return result
}