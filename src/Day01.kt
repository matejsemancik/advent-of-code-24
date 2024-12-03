import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Long {
        val pairs = input.map { line ->
            val (l, r) = line.split("   ").map(String::toLong)
            l to r
        }

        val left = pairs.map { it.first }.sorted()
        val right = pairs.map { it.second }.sorted()

        return left.zip(right).sumOf {
            abs(it.first - it.second)
        }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_part1_test")
    check(part1(testInput) == 11L) { "Test input check failed" }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
