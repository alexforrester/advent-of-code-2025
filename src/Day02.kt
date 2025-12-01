
fun main() {

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Test if implementation meets criteria from the description, like:
    check(part2(listOf("test_input")) == 1)

    val input = readInput("Day02")
    //readInput("Day01_test")

    // Or read a large test input from the `src/Day01_test.txt` file:
    // val testInput = readInput("Day01_test")
    check(part2(input) == 1)

    // Read the input from the `src/Day01.txt` file.
    part2(input).println()
}
