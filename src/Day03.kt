private const val Day = "Day03"

fun main() {

    val regexPart1 = "mul\\((\\d+),(\\d+)\\)".toRegex()
    val regexPart2 = "mul\\((\\d+),(\\d+)\\)|(do\\(\\))|(don't\\(\\))".toRegex()

    fun part1(input: String): Long {
        val sum = regexPart1.findAll(input).sumOf { mr ->
            mr.groupValues[1].toLong() * mr.groupValues[2].toLong()
        }
        return sum
    }

    fun part2(input: String): Long {
        val matchResults = regexPart2.findAll(input)
        var enabled = true
        var sum = 0L
        for (mr in matchResults) {
            if (mr.groupValues[0] == "do()") {
                enabled = true
                continue
            }

            if (mr.groupValues[0] == "don't()") {
                enabled = false
                continue
            }

            if (enabled) {
                sum += mr.groupValues[1].toLong() * mr.groupValues[2].toLong()
            }
        }

        return sum
    }

    val testInputPart1 = readInput("${Day}_part1_test").joinToString(separator = "")
    check(part1(testInputPart1) == 161L) { "Part1 test failed" }

    val testInputPart2 = readInput("${Day}_part2_test").joinToString(separator = "")
    check(part2(testInputPart2) == 48L) { "Part2 test failed" }

    val input = readInput(Day).joinToString(separator = "")
    part1(input).println()
    part2(input).println()
}
