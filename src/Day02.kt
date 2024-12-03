import kotlin.math.abs

private const val Day = "Day02"
private val SafeRange = 1..3

fun main() {

    fun List<Int>.steps(): List<Int> = buildList {
        for (i in 1 until this@steps.count()) {
            this.add(this@steps[i] - this@steps[i - 1])
        }
    }

    fun List<Int>.checkSafety(): Boolean {
        val steps = steps()
        return (steps.all { it <= 0 } || steps.all { it >= 0 }) && steps.all { abs(it) in SafeRange }
    }

    fun part1(input: List<String>): Int {
        val safety = input.map { report ->
            val levels = report.split(" ").map { it.toInt() }
            levels.checkSafety()
        }
        return safety.count { it }
    }

    fun part2(input: List<String>): Int {
        val safety = input.map { report ->
            val levels = report.split(" ").map { it.toInt() }
            val isSafe = levels.checkSafety()

            if (isSafe) {
                return@map true
            }

            // Let's bruteforce this, lol (the dataset is so small that it does not matter, and it's late, and I'm half asleep)
            val isSafeAfterCorrection = (0 until levels.count()).map { iteration ->
                levels.slice(levels.indices.minus(iteration)).checkSafety()
            }.any { it }

            return@map isSafeAfterCorrection
        }
        return safety.count { it }
    }

    val testInputPart1 = readInput("${Day}_part1_test")
    check(part1(testInputPart1) == 2) { "Part1 test failed" }

    val testInputPart2 = readInput("${Day}_part2_test")
    check(part2(testInputPart2) == 4) { "Part2 test failed" }

    val input = readInput(Day)
    part1(input).println()
    part2(input).println()
}
