private const val Day = "Day04"

typealias CharMatrix = Array<CharArray>

fun main() {

    val masks: List<CharMatrix> = listOf(
        arrayOf(
            charArrayOf('X', 'M', 'A', 'S'),
        ),
        arrayOf(
            charArrayOf('S', 'A', 'M', 'X'),
        ),
        arrayOf(
            charArrayOf('X'),
            charArrayOf('M'),
            charArrayOf('A'),
            charArrayOf('S')
        ),
        arrayOf(
            charArrayOf('S'),
            charArrayOf('A'),
            charArrayOf('M'),
            charArrayOf('X')
        ),
        arrayOf(
            charArrayOf('X', ' ', ' ', ' '),
            charArrayOf(' ', 'M', ' ', ' '),
            charArrayOf(' ', ' ', 'A', ' '),
            charArrayOf(' ', ' ', ' ', 'S')
        ),
        arrayOf(
            charArrayOf('S', ' ', ' ', ' '),
            charArrayOf(' ', 'A', ' ', ' '),
            charArrayOf(' ', ' ', 'M', ' '),
            charArrayOf(' ', ' ', ' ', 'X')
        ),
        arrayOf(
            charArrayOf(' ', ' ', ' ', 'S'),
            charArrayOf(' ', ' ', 'A', ' '),
            charArrayOf(' ', 'M', ' ', ' '),
            charArrayOf('X', ' ', ' ', ' ')
        ),
        arrayOf(
            charArrayOf(' ', ' ', ' ', 'X'),
            charArrayOf(' ', ' ', 'M', ' '),
            charArrayOf(' ', 'A', ' ', ' '),
            charArrayOf('S', ' ', ' ', ' ')
        )
    )

    fun hasIntersect(source: CharMatrix, mask: CharMatrix, atOffset: Pair<Int, Int>): Boolean {
        val maskWidth = mask[0].size
        val maskHeight = mask.size

        for (y in 0 until maskHeight) {
            val sourceRow = source.getOrNull(y + atOffset.second) ?: return false
            for (x in 0 until maskWidth) {
                val sourceChar = sourceRow.getOrNull(x + atOffset.first) ?: return false
                val maskChar = mask[y][x]

                if (maskChar != ' ' && sourceChar != maskChar) {
                    return false
                }
            }
        }

        return true
    }

    fun part1(input: List<String>): Int {
        var hits = 0
        val source: CharMatrix = input.map { it.toCharArray() }.toTypedArray()
        for (y in source.indices) {
            for (x in source[0].indices) {
                for (mask in masks) {
                    if (hasIntersect(source, mask, x to y)) {
                        hits++
                    }
                }
            }
        }
        return hits
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val testInputPart1 = readInput("${Day}_part1_test")
    check(part1(testInputPart1) == 18) { "Part1 test failed" }

    val input = readInput(Day)
    part1(input).println()
    part2(input).println()
}
