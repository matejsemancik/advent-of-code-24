import kotlin.math.abs

fun main() {

    fun parseInput(input: List<String>): List<Pair<Int, Int>> {
        return input.map { line ->
            val (l, r) = line.split("   ").map(String::toInt)
            l to r
        }
    }

    fun part1(input: List<String>): Int {
        val pairs = parseInput(input)
        val left = pairs.map { it.first }.sorted()
        val right = pairs.map { it.second }.sorted()

        return left.zip(right).sumOf {
            abs(it.first - it.second)
        }
    }

    fun part2(input: List<String>): Int {
        val pairs = parseInput(input)
        val left = pairs.map { it.first }
        val right = pairs.map { it.second }

        return left.sumOf { id ->
            id * right.count { it == id }
        }
    }

    val testInputPart1 = readInput("Day01_part1_test")
    check(part1(testInputPart1) == 11) { "Part1 test failed" }

    val testInputPart2 = readInput("Day01_part2_test")
    check(part2(testInputPart1) == 31) { "Part2 test failed" }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
