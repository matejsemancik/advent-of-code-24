private const val Day = "Day04"

typealias CharMatrix = Array<CharArray>

fun main() {

    val masksPart1: List<CharMatrix> = listOf(
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

    val masksPart2Horizontal: List<CharMatrix> = listOf(
        arrayOf(
            charArrayOf('M', ' ', ' '),
            charArrayOf(' ', 'A', ' '),
            charArrayOf(' ', ' ', 'S')
        ),
        arrayOf(
            charArrayOf('S', ' ', ' '),
            charArrayOf(' ', 'A', ' '),
            charArrayOf(' ', ' ', 'M')
        ),
    )

    val masksPart2Vertical: List<CharMatrix> = listOf(
        arrayOf(
            charArrayOf(' ', ' ', 'S'),
            charArrayOf(' ', 'A', ' '),
            charArrayOf('M', ' ', ' ')
        ),
        arrayOf(
            charArrayOf(' ', ' ', 'M'),
            charArrayOf(' ', 'A', ' '),
            charArrayOf('S', ' ', ' ')
        ),
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
        val source: CharMatrix = input.map { it.toCharArray() }.toTypedArray()
        var hits = 0
        for (y in source.indices) {
            for (x in source[0].indices) {
                for (mask in masksPart1) {
                    if (hasIntersect(source, mask, x to y)) {
                        hits++
                    }
                }
            }
        }
        return hits
    }

    fun part2(input: List<String>): Int {
        val source: CharMatrix = input.map { it.toCharArray() }.toTypedArray()
        var hits = 0
        for (y in source.indices) {
            for (x in source[0].indices) {
                val hasHorizontalIntersect = masksPart2Horizontal.any { mask ->
                    hasIntersect(source, mask, x to y)
                }
                val hasVerticalIntersect = masksPart2Vertical.any { mask ->
                    hasIntersect(source, mask, x to y)
                }
                if (hasHorizontalIntersect && hasVerticalIntersect) {
                    hits++
                }
            }
        }
        return hits
    }

    val testInputPart1 = readInput("${Day}_part1_test")
    check(part1(testInputPart1) == 18) { "Part1 test failed" }

    val testInputPart2 = readInput("${Day}_part2_test")
    check(part2(testInputPart2) == 9) { "Part2 test failed" }

    val input = readInput(Day)
    part1(input).println()
    part2(input).println()
}
