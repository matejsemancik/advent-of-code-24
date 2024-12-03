import kotlin.math.abs

private const val Day = "Day02"

fun main() {

    fun List<Int>.steps(): List<Int> = buildList {
        for (i in 1 until this@steps.count()) {
            this.add(this@steps[i] - this@steps[i - 1])
        }
    }

    fun part1(input: List<String>): Int {
        val safety = input.map { report ->
            val levels = report.split(" ").map { it.toInt() }
            val steps = levels.steps()

            return@map (steps.all { it <= 0 } || steps.all { it >= 0 }) && steps.all { abs(it) in 1..3 }
        }
        return safety.count { it }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val testInputPart1 = readInput("${Day}_part1_test")
    check(part1(testInputPart1) == 2) { "Part1 test failed" }

    val input = readInput(Day)
    part1(input).println()
    part2(input).println()
}
