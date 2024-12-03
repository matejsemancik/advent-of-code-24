private const val Day = "Day02"

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val testInputPart1 = readInput("${Day}_part1_test")
    check(part1(testInputPart1) == 1)  { "Part1 test failed" }

    val input = readInput(Day)
    part1(input).println()
    part2(input).println()
}
